package cn.edu.nuc.exam.exam;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Inno Fang
 * Time: 2017/8/17 18:58
 * Description:
 */


public class Question implements Serializable {

    private List<SubjectBean> subject;

    public List<SubjectBean> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectBean> subject) {
        this.subject = subject;
    }

    public static class SubjectBean implements Serializable {
        /**
         * question : 1、党的十七大，是我们党在（）关键阶段召开的一次十分重要代表大会。
         * A : A、改革发展
         * B : B、改革调整
         * C : C、开放巩固
         * answer : A、改革发展
         * D : D、社会和谐
         */

        private String question;
        private String A;
        private String B;
        private String C;
        private String answer;
        private String D;

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getA() {
            return A;
        }

        public void setA(String A) {
            this.A = A;
        }

        public String getB() {
            return B;
        }

        public void setB(String B) {
            this.B = B;
        }

        public String getC() {
            return C;
        }

        public void setC(String C) {
            this.C = C;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getD() {
            return D;
        }

        public void setD(String D) {
            this.D = D;
        }
    }
}
