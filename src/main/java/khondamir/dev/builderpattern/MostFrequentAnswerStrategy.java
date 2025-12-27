package khondamir.dev.builderpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequentAnswerStrategy implements AnalyzeStrategy{

    @Override
    public List<QuestionStatistics> makeAnalyze(List<PollFillingData> pollFillingDataList){
        FullCountStrategy fullCountStrategy = new FullCountStrategy();
        List<QuestionStatistics> fullStatisticsList = fullCountStrategy.makeAnalyze(pollFillingDataList);

        return fullStatisticsList.stream().map(stat -> {
            Map<String, Integer> maxMap = new HashMap<>();
            int max = stat.getSelectedVariantsCount().values().stream().max(Integer::compareTo).orElse(0);
            stat.getSelectedVariantsCount().forEach((k, v) -> {
                if (v == max) maxMap.put(k, v);
            });
            return new QuestionStatistics(stat.getQuestionTitle(), maxMap, stat.getUserSelectedVariantsCount());
        }).collect(Collectors.toList());
    }

}
