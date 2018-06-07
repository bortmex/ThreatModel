package ru.javaproject.threatmodel.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class Question {
    private int id;
    private boolean radio;
    private String question;
    private String[] variantsOfAnswers;

    public Question() {
    }

    public Question(int id, boolean radio, String question, String[] variantsOfAnswers) {
        this.id = id;
        this.radio = radio;
        this.question = question;
        this.variantsOfAnswers = variantsOfAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return id == question1.id &&
                radio == question1.radio &&
                Objects.equals(question, question1.question) &&
                Arrays.equals(variantsOfAnswers, question1.variantsOfAnswers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, radio, question, variantsOfAnswers);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getVariantsOfAnswers() {
        return variantsOfAnswers;
    }

    public void setVariantsOfAnswers(String[] variantsOfAnswers) {
        this.variantsOfAnswers = variantsOfAnswers;
    }
}
