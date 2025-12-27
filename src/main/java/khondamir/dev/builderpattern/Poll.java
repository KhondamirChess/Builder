package khondamir.dev.builderpattern;

import java.util.List;

public class Poll {
    private String name;
    private List<PollQuestion> pollQuestionList;

    public Poll(String pollName, List<PollQuestion> questions) {
        this.name = pollName;
        this.pollQuestionList = questions;
    }

    public static PollBuilder builder() {
        return new PollBuilder();
    }

    public List<PollQuestion> getPollQuestionList() {
        return pollQuestionList;
    }

    public void setPollQuestionList(List<PollQuestion> pollQuestionList) {
        this.pollQuestionList = pollQuestionList;
    }
}
