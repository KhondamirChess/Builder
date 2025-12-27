package khondamir.dev.builderpattern;

import java.util.List;

public class PollAnalyzer {
    private AnalyzeStrategy strategy;

    public PollAnalyzer(AnalyzeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(AnalyzeStrategy strategy) {
        this.strategy = strategy;
    }

    public void changeStrategy(AnalyzeStrategy strategy) {
        this.strategy = strategy;
    }

    public List<QuestionStatistics> analyzePoll(List<PollFillingData> pollFillingDataList) {
        if (strategy == null) {
            throw new IllegalStateException("AnalyzeStrategy is not set");
        }
        return strategy.makeAnalyze(pollFillingDataList);
    }
}
