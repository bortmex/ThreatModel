package ru.javaproject.threatmodel.repository;

import ru.javaproject.threatmodel.model.Question;

import java.util.List;

public interface DaoQuestion {
    List<Question> getAll();

    Integer[] getAnswerOnQuestionAll(Integer numberQuestion);

    Integer[][] getanswerAll();

    Integer[][] getanswerUserAll();

    void setanswerUserAll(Integer[][] list);
}
