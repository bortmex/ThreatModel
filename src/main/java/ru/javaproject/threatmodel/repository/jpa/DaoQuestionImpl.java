package ru.javaproject.threatmodel.repository.jpa;

import org.springframework.stereotype.Repository;
import ru.javaproject.threatmodel.model.Question;
import ru.javaproject.threatmodel.repository.DaoQuestion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DaoQuestionImpl implements DaoQuestion {

    private List<Question> daoQuestion = new ArrayList<>();
    private Integer[][] daoAnswerAssessmentQuestion = new Integer[][]{
            {2, 1, 0},                      //1
            {0, 0, 0, 0, 0, 1},
            {2, 1, 0, 0, 0, 1, 1, 1},
            {0, 1},
            {0, 1, 2},                      //5
            {2, 1, 0},
            {0, 2},
            {0, 1},
            {0, 1, 1, 1},
            {0, 1},                         //10
            {0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 2}, //тут типа нарушитель
            //"Внешние субъекты (физические лица)", "Бывшие работники",
            //                "Административный, обслуживающий персонал, охрана", "Лица, привлекаемые для установки, наладки, монтажа, пуско-наладочных и иных работ",
            //                "Пользователи информационной системы", "Администраторы информационной системы и администраторы безопасности",
            //                "Террористические, экстремистские группировки", "Преступные группы (криминальные структуры)",
            //                "Конкурирующие организации", "Разработчики, производители, поставщики ПО и технических средств",
            //                "Специальные службы иностранных государств (блоков государств)"
            {0, 1, 2},   //13
            {0, 1, 2},   //14
            {0, 1, 2},   //15
            {2, 1, 0},      //referc tabl№4 страница 26 3 на 3        //15
            {2, 2, 1},
            {2, 2, 2},
            {0, 0, 1},      //actial tabl№8 страница 31 3 на 3
            {0, 1, 1},
            {1, 1, 1},                                                 //20
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 2} //Внешний = 0, внутренний = 1, оба = 2
            };  //оценка каждого вопроса
    private Integer[][] daoAnswerUser;                //ответы юзера

    public DaoQuestionImpl() {
        daoQuestion.add(new Question(1, true, "Какой структуре соответствует информационная система",
                new String[]{"Автономное автоматизированное рабочее место","Локальная информационная система",
                "Распределенная информационная система"}));
        daoQuestion.add(new Question(2, false, "Отметьте технологии, применяемые в составе системы",
                new String[]{"Системы на основе виртуализации","Системы, реализующие облачные вычисления",
                        "Система с мобильными устройсвами", "Системы с технологиями беспроводного доступа",
                "Грид-системы", "Суперкомпьютерные системы"}));
        daoQuestion.add(new Question(3, false, "Отметьте свойства архитектуры, подходящие для вашей системы",
                new String[]{"Система на основе тонкого клиента","Система на основе одноранговой сети",
                        "Файл-серверная система", "ЦОД", "Система с удаленным доступом пользователей",
                "Система с разными типами операционных систем", "Система с прикладными программами, независимыми от ОС",
                "Система, использующая выделенные каналы связи"}));
        daoQuestion.add(new Question(4, true, "Взаимодействует ли система с внешними системами",
                new String[]{"Взаимодействует", "Не взаимодействует"}));
        daoQuestion.add(new Question(5, true, "Подключена ли система к сетям общего пользования",
                new String[]{"Подключена", "Подключена через выделенную инфраструктуру (gov.ru или иную)",
                "Не подключена"}));
        daoQuestion.add(new Question(6, true, "Как размещены компоненты системы по отношению к контролируемой зоне",
                new String[]{"В пределах одной контролируемой зоны", "В пределах нескольких контролируемых зон",
                "Вне контролируемой зоны"}));
        daoQuestion.add(new Question(7, true, "Режим обработки информации в системе",
                new String[]{"Многопользовательский", "Однопользовательский"}));
        daoQuestion.add(new Question(8, true, "Разграничиваются ли права доступа к системе",
                new String[]{"Не разграничиваются", "Разграничиваются"}));
        daoQuestion.add(new Question(9, false, "Как разделены функции по управлению информационной системой",
                new String[]{"Не разделены", "Рабочие места для администрирования выделены в отдельный домен",
                "Для администрирования используются отдельные сетевые адреса", "Для администрирования используются выделенные каналы связи"}));
        daoQuestion.add(new Question(10, true, "Сегментирована ли информационная система",
                new String[]{"Не сегментирована", "Сегментирована"}));
        daoQuestion.add(new Question(11, false, "Источники угроз<br> " +
                "Выберите нарушителей, обладающих, на ваш взгляд, мотивацией для атаки системы",
                new String[]{"Внешние субъекты (физические лица)", "Бывшие работники",
                "Административный, обслуживающий персонал, охрана", "Лица, привлекаемые для установки, наладки, монтажа, пуско-наладочных и иных работ",
                "Пользователи информационной системы", "Администраторы информационной системы и администраторы безопасности",
                "Террористические, экстремистские группировки", "Преступные группы (криминальные структуры)",
                "Конкурирующие организации", "Разработчики, производители, поставщики ПО и технических средств",
                "Специальные службы иностранных государств (блоков государств)"}));
        //0, 0, 2, 0, 0, 1, 1, 1, 1, 1, 2
        daoQuestion.add(new Question(12, true, "Оценка уровня ущерба<br>" +
                "Оцените уровень ущерба от возможного нарушения конфиденциальности информации",
                new String[]{"Низкий", "Средний","Высокий"}));
        daoQuestion.add(new Question(13, true, "Оценка уровня ущерба<br>" +
                "Оцените уровень ущерба от возможного нарушения целостности информации",
                new String[]{"Низкий", "Средний","Высокий"}));
        daoQuestion.add(new Question(14, true, "Оценка уровня ущерба<br>" +
                "Оцените уровень ущерба от возможного нарушения доступности информации",
                new String[]{"Низкий", "Средний","Высокий"}));
        daoQuestion.add(new Question(15, true, "Сделать вывод в Excel?",
                new String[]{"Да", "Нет"}));
    }

    public Integer[][] getDaoAnswerAssessmentQuestion() {
        return daoAnswerAssessmentQuestion;
    }

    public void setDaoAnswerAssessmentQuestion(Integer[][] daoAnswerAssessmentQuestion) {
        this.daoAnswerAssessmentQuestion = daoAnswerAssessmentQuestion;
    }

    public Integer[][] getDaoAnswerUser() {
        return daoAnswerUser;
    }

    public void setDaoAnswerUser(Integer[][] daoAnswerUser) {
        this.daoAnswerUser = daoAnswerUser;
    }

    public List<Question> getDaoQuestion() {
        return daoQuestion;
    }

    public void setDaoQuestion(List<Question> daoQuestion) {
        this.daoQuestion = daoQuestion;
    }

    @Override
    public List<Question> getAll() {
        return daoQuestion;
    }

    @Override
    public Integer[] getAnswerOnQuestionAll(Integer numberQuestion) {
        return daoAnswerAssessmentQuestion[numberQuestion-1];
    }

    @Override
    public Integer[][] getanswerAll() {
        return daoAnswerAssessmentQuestion;
    }

    @Override
    public Integer[][] getanswerUserAll() {
        return daoAnswerUser;
    }

    @Override
    public void setanswerUserAll(Integer[][] list) {
        daoAnswerUser = new Integer[list.length][];
        for (int i = 0; i < list.length; i++) {
            if(list[i]==null) continue;
            daoAnswerUser[i]= new Integer[list[i].length];
            for (int j = 0; j < list[i].length; j++) {
                daoAnswerUser[i][j] = list[i][j];
            }
        }

        System.out.println();
    }
}
