package ru.javaproject.threatmodel.web.question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javaproject.threatmodel.model.Question;
import ru.javaproject.threatmodel.service.QuestionService;

import java.util.List;

public abstract class AbstractQuestionController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private QuestionService service;

    public Integer[][] getAnswerOnQuestionAll() {
        LOG.info("getAnswerOnQuestionAll");
        return service.getAnswerOnQuestionAll();
    }

    public Integer[][] getanswerUserAll() {
        LOG.info("getAnswerOnQuestionAll");
        return service.getanswerUserAll();
    }

    public void setanswerUserAll(Integer[][] list) {
        LOG.info("getAnswerOnQuestionAll");
        service.setanswerUserAll(list);
    }

    public List<Question> getAll() {
        LOG.info("getAll ");
        return service.getAll();
    }
}
