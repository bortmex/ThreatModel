package ru.javaproject.threatmodel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.javaproject.threatmodel.model.Question;
import ru.javaproject.threatmodel.model.User;
import ru.javaproject.threatmodel.service.QuestionService;
import ru.javaproject.threatmodel.service.ThreatService;
import ru.javaproject.threatmodel.util.Qwerasdf;

import java.util.List;

import static ru.javaproject.threatmodel.util.GetLowMediumHigh.*;

@Controller
public class RootController {

    @Autowired
    private ThreatService threatService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/startpage")
    public String rootwithback() {
        return "index";
    }

    @GetMapping("/threats")
    public String threats(Model model) {
        model.addAttribute("threats", threatService.getAll());
        return "threats";
    }

    @GetMapping("/threat/{id}")
    public String getThreat(Model model, @PathVariable("id") int id) {
        /*model.addAttribute("threat", threatService.get(id));*/
        return "";
    }
//-----------------------------
    @RequestMapping(value="/threatyes",method=RequestMethod.POST)
    public String getThreatYes(@ModelAttribute("user") final User user, ModelMap model) throws Exception {
        /*model.addAttribute("threat", threatService.get(id));*/

        model.addAttribute("pass", Qwerasdf.getHash(user.getPassword()));
        model.addAttribute("pass1", "bf3d3cfc2fb07a172e1a22f53ca5af07");
        return "threat";
    }
//-----------------------------
    @GetMapping("/questionnaire")
    public String questionnaire(Model model) {
        model.addAttribute("questions", questionService.getAll());
        return "questionnaire";
    }

    @GetMapping("/answerofquestion")
    public String getTableANswer(Model model) {
        model.addAttribute("threats", threatService.getAll());
        Integer[][] arrayAnswer = questionService.getAnswerOnQuestionAll(); //все ответы
        Integer[][] arrayAnswerUser = questionService.getanswerUserAll();  //ответы юзер
        List<Question> listquestr = questionService.getAll();              //все вопросы из анкеты
        model.addAttribute("userResponses", arrayAnswer);
        model.addAttribute("answerForQuestion", arrayAnswerUser);
        String text = getProcent(arrayAnswer, arrayAnswerUser);
        Integer high = Integer.parseInt(text.split("%")[0].trim());
        Integer mid = Integer.parseInt(text.split("%")[1].trim());
        Integer low = Integer.parseInt(text.split("%")[2].trim());
        Integer mid_sum = Integer.parseInt(text.split("%")[3].trim());
        int y1p;
        Integer[][] y2;
        Integer[] yj;
        if(high>=80 && low==0) {text+= " Высокий"; y1p=2;}
        else if(mid_sum>=90) {text+= " Средний";y1p=1;} else {text+= " Низкий"; y1p=0;}
        model.addAttribute("Y1P", text);

        String[] question11 = new String[arrayAnswerUser[10].length];

        String[] arrStrAll10 = listquestr.get(10).getVariantsOfAnswers();
        for (int i = 0; i < arrayAnswerUser[10].length; i++) {
            question11[i]= arrStrAll10[arrayAnswerUser[10][i]];
        }
        model.addAttribute("allvariablequest10", question11);
        model.addAttribute("listQuest", listquestr);

        Integer[][] ar_y1pUser = new Integer[1][1];
        ar_y1pUser[0] = arrayAnswerUser[10];
        Integer[][] ar_y2 = getArrFromDaoUser(getArrFromDao(arrayAnswer, 10,
                                                        1), ar_y1pUser);

        y2  = getArrFromDaoUser(getArrFromDao(arrayAnswer, 20,
                1), ar_y1pUser);
        String y2str = "";
        String typeViolator = "";

        for (int i = 0; i < ar_y2[0].length; i++) {
            String text1 = ar_y2[0][i] == 0 ? "Низкий": ar_y2[0][i] == 1 ?  "Средний" : "Высокий";
            String text2 = y2[0][i] == 0 ? "Внешний": /*ar_y2*/y2[0][i] == 1 ?  "Внутренний" : "Внешний, Внутренний";
            y2str+= " " + text1 + "<br>";
            typeViolator+= " " + text2 + "<br>";
        }

        model.addAttribute("typeViolator", typeViolator);
        model.addAttribute("Y2", y2str);

        Integer[][] ar_yj = getArrFromDao(arrayAnswer, 14, 3);
        yj = new Integer[y2[0].length];
        for (int i = 0; i < y2[0].length; i++) {
            yj[i] = ar_yj[y2[0][i]][y1p];
        }

        String text11= "";
        for (int i = 0; i < yj.length; i++) {
            text11 += yj[i]==0 ? "Низкий": yj[/*ar_y2[0][i]*/i] == 1 ? "Средний" : "Высокий";
            text11 += "<br>";
        }

        model.addAttribute("YJ", text11);
        model.addAttribute("excelgo", arrayAnswerUser[14][0] != 1);
        return "answerofquestion";
    }
}







/*
@PostMapping("/answerthreat")
public String setAnswer(HttpServletRequest request) {
    Set<String> answer = request.getParameterMap().keySet();
    List<String[]> arr = new ArrayList<>();
    int i = 0;
    for (String req : answer) {
        arr.add(request.getParameterMap().get(req));
    }

        Map<Integer, List<Integer>> dooblemaps = new HashMap<>();
        for (String[] array : arr) {
            for (String answerwithformat : array) {
                answerwithformat = answerwithformat.replaceAll("question", "");
                String[] arranswer = answerwithformat.split("\\[");
                if (dooblemaps.entrySet().stream().filter(e -> e.getKey() == Integer.parseInt(arranswer[0])).collect(Collectors.toList()).size() != 0) {
                    for (Map.Entry<Integer, List<Integer>> mapa : dooblemaps.entrySet()) {
                        if (mapa.getKey() == Integer.parseInt(arranswer[0])) {
                            List<Integer> list = new ArrayList<>(mapa.getValue());
                            list.add(Integer.parseInt(arranswer[1]));
                            dooblemaps.put(Integer.parseInt(arranswer[0]), list);
                            break;
                        }
                    }
                } else
                    dooblemaps.put(Integer.parseInt(arranswer[0]), Collections.singletonList(Integer.parseInt(arranswer[1])));
            }
        }
        Integer[][] listanswerUser = new Integer[questionService.getAnswerOnQuestionAll().length][];
        for (Map.Entry<Integer, List<Integer>> mapa : dooblemaps.entrySet()) {
            Integer[] array = new Integer[mapa.getValue().size()];
            int j = 0;
            for (Integer num : mapa.getValue()) {
                array[j++] = num;
            }

            listanswerUser[mapa.getKey()-1] = new Integer[array.length];
            for (int k = 0; k < array.length; k++) {
                listanswerUser[mapa.getKey()-1][k] = array[k];
            }
        }
        questionService.setanswerUserAll(listanswerUser);
        *//*List<Question> listthreat = questionService.getAll();
        String text = "";
        for (Question question : listthreat) {
            if (dooblemaps.containsKey(question.getId()))
                text += "<p>" + question.getQuestion() + "</p> <br>";
            else continue;
            for (int j = 0; j < question.getVariantsOfAnswers().length; j++) {
                if (dooblemaps.get(question.getId()).contains(j))
                    text += "<p>" + (j + 1) + ". " + question.getVariantsOfAnswers()[j] + "</p> <br>";
            }
            text += "<hr>";
        }
        model.addAttribute("answers", text);*//*


        return "redirect:/answerofquestion";
    }*/
