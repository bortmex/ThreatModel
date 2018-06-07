package ru.javaproject.threatmodel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javaproject.threatmodel.model.Question;
import ru.javaproject.threatmodel.repository.DaoQuestion;
import ru.javaproject.threatmodel.util.ValidationUtil;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private DaoQuestion daoQuestion;

    @Override
    public List<Question> getAll() {
        return daoQuestion.getAll();
    }

    @Override
    public Integer[] getAnswerOnQuestionAll(Integer answerForNumber) {
        return ValidationUtil.checkNotFound(daoQuestion.getAnswerOnQuestionAll(answerForNumber),"not found");
    }

    @Override
    public Integer[][] getAnswerOnQuestionAll() {
        return daoQuestion.getanswerAll();
    }

    @Override
    public Integer[][] getanswerUserAll() {
        return daoQuestion.getanswerUserAll();
    }

    @Override
    public void setanswerUserAll(Integer[][] list) {
        daoQuestion.setanswerUserAll(list);
    }

}
