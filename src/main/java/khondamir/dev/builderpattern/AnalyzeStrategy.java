package khondamir.dev.builderpattern;

import java.util.List;

public interface AnalyzeStrategy {
    List<QuestionStatistics> makeAnalyze(List<PollFillingData> pollFillingDataList);

}
