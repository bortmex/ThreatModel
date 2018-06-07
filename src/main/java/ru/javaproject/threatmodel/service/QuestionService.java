package ru.javaproject.threatmodel.service;

import ru.javaproject.threatmodel.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAll();

    Integer[] getAnswerOnQuestionAll(Integer answerForNumber);

    Integer[][] getAnswerOnQuestionAll();

    Integer[][] getanswerUserAll();

    void setanswerUserAll(Integer[][] list);
}
