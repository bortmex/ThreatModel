package ru.javaproject.threatmodel.web.question;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.javaproject.threatmodel.model.Question;
import ru.javaproject.threatmodel.model.QuestionPOJO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static ru.javaproject.threatmodel.util.GetLowMediumHigh.getArrFromDao;
import static ru.javaproject.threatmodel.util.GetLowMediumHigh.getArrFromDaoUser;
import static ru.javaproject.threatmodel.util.GetLowMediumHigh.getProcent;

@RestController
@RequestMapping(QuestionRestController.REST_URL)
public class QuestionRestController extends AbstractQuestionController{
    static final String REST_URL = "/rest/question";

    @RequestMapping(value = "/answerthreat/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String setAnswer(@RequestBody QuestionPOJO questionpojo) throws IOException {
        Set<String> answer = new HashSet<>(Arrays.asList(questionpojo.getQuestion1(),
                questionpojo.getQuestion4(),
                questionpojo.getQuestion5(),
                questionpojo.getQuestion6(),
                questionpojo.getQuestion7(),
                questionpojo.getQuestion8(),
                questionpojo.getQuestion10(),
                questionpojo.getQuestion12(),
                questionpojo.getQuestion13(),
                questionpojo.getQuestion14(),
                questionpojo.getQuestion15()
                ));
        answer.add(getArrStr(questionpojo.getQuestion2()));
        answer.add(getArrStr(questionpojo.getQuestion3()));
        answer.add(getArrStr(questionpojo.getQuestion9()));
        answer.add(getArrStr(questionpojo.getQuestion11()));

        List<String[]> arr = new ArrayList<>();
        for (String req : answer) {
            arr.add(req.split(","));
        }

        Map<Integer, List<Integer>> dooblemaps = new HashMap<>();
        for (String[] array : arr) {
            for (String answerwithformat : array) {
                answerwithformat = answerwithformat.replaceAll("answers", "");
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
        Integer[][] listanswerUser = new Integer[getAnswerOnQuestionAll().length][];
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
            setanswerUserAll(listanswerUser);
        return "answerofquestion";
    }

    public static String getArrStr(List<String> list){
        StringBuilder text = new StringBuilder();
        for (String getText: list) {
            text.append(getText).append(",");
        }
        return text.toString();
    }

/*    @RequestMapping(value = "/answerofquestion", method = RequestMethod.GET)
    public ModelAndView getTableANswer() {
        ModelAndView model = new ModelAndView();
        model.addObject("threats", getAll());
        Integer[][] arrayAnswer = getAnswerOnQuestionAll(); //все ответы
        Integer[][] arrayAnswerUser = getanswerUserAll();  //ответы юзер
        List<Question> listquestr = getAll();              //все вопросы из анкеты
        model.addObject("userResponses", arrayAnswer);
        model.addObject("answerForQuestion", arrayAnswerUser);
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
        model.addObject("Y1P", text);

        String[] question11 = new String[arrayAnswerUser[10].length];

        String[] arrStrAll10 = listquestr.get(10).getVariantsOfAnswers();
        for (int i = 0; i < arrayAnswerUser[10].length; i++) {
            question11[i]= arrStrAll10[arrayAnswerUser[10][i]];
        }
        model.addObject("allvariablequest10", question11);
        model.addObject("listQuest", listquestr);

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
            String text2 = y2[0][i] == 0 ? "Внешний": ar_y2[0][i] == 1 ?  "Внутренний" : "Внешний, Внутренний";
            y2str+= " " + text1 + "<br>";
            typeViolator+= " " + text2 + "<br>";
        }

        model.addObject("typeViolator", typeViolator);
        model.addObject("Y2", y2str);

        Integer[][] ar_yj = getArrFromDao(arrayAnswer, 14, 3);
        yj = new Integer[y2[0].length];
        for (int i = 0; i < y2[0].length; i++) {
            yj[i] = ar_yj[y2[0][i]][y1p];
        }

        String text11= "";
        for (int i = 0; i < yj.length; i++) {
            text11 += yj[i]==0 ? "Низкий": yj[ar_y2[0][i]] == 1 ? "Средний" : "Высокий";
            text11 += "<br>";
        }

        model.addObject("YJ", text11);
        model.addObject("excelgo", arrayAnswerUser[14][0] != 1);
        return model;
    }*/
}
