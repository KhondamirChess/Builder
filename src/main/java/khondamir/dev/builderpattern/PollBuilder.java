package khondamir.dev.builderpattern;

import java.util.ArrayList;
import java.util.List;

public class PollBuilder {
    private String pollName;
    private final List<PollQuestion> questions;

    public PollBuilder() {
        this.questions = new ArrayList<>();
    }

    public Poll build() {
        return new Poll(pollName, questions);
    }

    public PollBuilder withPollName(String pollName) {
        this.pollName = pollName;
        return this;
    }

    public PollQuestionBuilder pollQuestion(String title) {
        return new PollQuestionBuilder(this).withTitle(title);
    }

    PollQuestionBuilder oneVariantPollQuestion(String title) {
        return new PollQuestionBuilder(this)
                .withTitle(title)
                .withMinAnswers(1)
                .withMaxAnswers(1);
    }

    public PollBuilder yesNoPollQuestion(String title) {
        return new PollQuestionBuilder(this)
                .withTitle(title)
                .withMinAnswers(1)
                .withMaxAnswers(1)
                .withAnswerVariant("Yes")
                .withAnswerVariant("No")
                .and();
    }

    public PollQuestionBuilder notMandatoryQuestion(String title) {
        return new PollQuestionBuilder(this)
                .withTitle(title)
                .withMinAnswers(0);
    }

    public PollBuilder addQuestion(PollQuestion pollQuestion) {
        questions.add(pollQuestion);
        return this;
    }
}