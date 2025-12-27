package khondamir.dev.builderpattern;

import java.util.List;

public class PollQuestion {
    private String question;
    private int minAnswers;
    private int maxAnswers;
    private List<String> answers;

    public PollQuestion(String question, int minAnswers, int maxAnswers, List<String> answers) {
        this.question = question;
        this.minAnswers = minAnswers;
        this.maxAnswers = maxAnswers;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getMinAnswers() {
        return minAnswers;
    }

    public void setMinAnswers(int minAnswers) {
        this.minAnswers = minAnswers;
    }

    public int getMaxAnswers() {
        return maxAnswers;
    }

    public void setMaxAnswers(int maxAnswers) {
        this.maxAnswers = maxAnswers;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
