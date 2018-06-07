package ru.javaproject.threatmodel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class QuestionPOJO implements Serializable {

    private static final long serialVersionUID = 1L;
    private  String question1;
    private  ArrayList<String> question2;
    private  ArrayList<String> question3;
    private  String question4;
    private  String question5;
    private  String question6;
    private  String question7;
    private  String question8;
    private  ArrayList<String> question9;
    private  String question10;
    private  ArrayList<String> question11;
    private  String question12;
    private  String question13;
    private  String question14;
    private  String question15;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionPOJO that = (QuestionPOJO) o;
        return Objects.equals(question1, that.question1) &&
                Objects.equals(question2, that.question2) &&
                Objects.equals(question3, that.question3) &&
                Objects.equals(question4, that.question4) &&
                Objects.equals(question5, that.question5) &&
                Objects.equals(question6, that.question6) &&
                Objects.equals(question7, that.question7) &&
                Objects.equals(question8, that.question8) &&
                Objects.equals(question9, that.question9) &&
                Objects.equals(question10, that.question10) &&
                Objects.equals(question11, that.question11) &&
                Objects.equals(question12, that.question12) &&
                Objects.equals(question13, that.question13) &&
                Objects.equals(question14, that.question14) &&
                Objects.equals(question15, that.question15);
    }

    @Override
    public int hashCode() {

        return Objects.hash(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13, question14, question15);
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public ArrayList<String> getQuestion2() {
        return question2;
    }

    public void setQuestion2(ArrayList<String> question2) {
        this.question2 = question2;
    }

    public ArrayList<String> getQuestion3() {
        return question3;
    }

    public void setQuestion3(ArrayList<String> question3) {
        this.question3 = question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public String getQuestion5() {
        return question5;
    }

    public void setQuestion5(String question5) {
        this.question5 = question5;
    }

    public String getQuestion6() {
        return question6;
    }

    public void setQuestion6(String question6) {
        this.question6 = question6;
    }

    public String getQuestion7() {
        return question7;
    }

    public void setQuestion7(String question7) {
        this.question7 = question7;
    }

    public String getQuestion8() {
        return question8;
    }

    public void setQuestion8(String question8) {
        this.question8 = question8;
    }

    public ArrayList<String> getQuestion9() {
        return question9;
    }

    public void setQuestion9(ArrayList<String> question9) {
        this.question9 = question9;
    }

    public String getQuestion10() {
        return question10;
    }

    public void setQuestion10(String question10) {
        this.question10 = question10;
    }

    public ArrayList<String> getQuestion11() {
        return question11;
    }

    public void setQuestion11(ArrayList<String> question11) {
        this.question11 = question11;
    }

    public String getQuestion12() {
        return question12;
    }

    public void setQuestion12(String question12) {
        this.question12 = question12;
    }

    public String getQuestion13() {
        return question13;
    }

    public void setQuestion13(String question13) {
        this.question13 = question13;
    }

    public String getQuestion14() {
        return question14;
    }

    public void setQuestion14(String question14) {
        this.question14 = question14;
    }

    public String getQuestion15() {
        return question15;
    }

    public void setQuestion15(String question15) {
        this.question15 = question15;
    }

    @Override
    public String toString() {
        return "QuestionPOJO{" +
                "question1='" + question1 + '\'' +
                ", question2='" + question2 + '\'' +
                ", question3='" + question3 + '\'' +
                ", question4='" + question4 + '\'' +
                ", question5='" + question5 + '\'' +
                ", question6='" + question6 + '\'' +
                ", question7='" + question7 + '\'' +
                ", question8='" + question8 + '\'' +
                ", question9='" + question9 + '\'' +
                ", question10='" + question10 + '\'' +
                ", question11='" + question11 + '\'' +
                ", question12='" + question12 + '\'' +
                ", question13='" + question13 + '\'' +
                ", question14='" + question14 + '\'' +
                ", question15='" + question15 + '\'' +
                '}';
    }
}
