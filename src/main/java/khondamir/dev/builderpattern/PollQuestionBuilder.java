package khondamir.dev.builderpattern;

import java.util.ArrayList;
import java.util.List;

public class PollQuestionBuilder {
    private final PollBuilder pollBuilder;
    private String title;
    private int minAnswers;
    private int maxAnswers;
    private final List<String> answerVariants = new ArrayList<>();

    public PollQuestionBuilder(PollBuilder pollBuilder) {
        this.pollBuilder = pollBuilder;
    }

    public PollQuestionBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public PollQuestionBuilder withMinAnswers(int minAnswers) {
        this.minAnswers = minAnswers;
        return this;
    }

    public PollQuestionBuilder withMaxAnswers(int maxAnswers) {
        this.maxAnswers = maxAnswers;
        return this;
    }

    public PollQuestionBuilder withAnswerVariant(String answerVariant) {
        answerVariants.add(answerVariant);
        return this;
    }

    public PollBuilder and() {
        PollQuestion pollQuestion = this.buildQuestion();
        return pollBuilder.addQuestion(pollQuestion);
    }

    private PollQuestion buildQuestion() {
        return new PollQuestion(title, minAnswers, maxAnswers, answerVariants);
    }
}