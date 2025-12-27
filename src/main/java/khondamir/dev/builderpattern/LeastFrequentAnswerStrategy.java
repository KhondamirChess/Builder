package khondamir.dev.builderpattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeastFrequentAnswerStrategy implements AnalyzeStrategy{

    @Override
    public List<QuestionStatistics> makeAnalyze(List<PollFillingData> pollFillingDataList) {
        FullCountStrategy fullCount = new FullCountStrategy();
        List<QuestionStatistics> fullStats = fullCount.makeAnalyze(pollFillingDataList);

        // Оставляем только наименее частые ответы
        return fullStats.stream().map(stat -> {
            Map<String, Integer> minMap = new HashMap<>();
            int min = stat.getSelectedVariantsCount().values().stream().min(Integer::compareTo).orElse(0);
            stat.getSelectedVariantsCount().forEach((k, v) -> {
                if (v == min) minMap.put(k, v);
            });
            return new QuestionStatistics(stat.getQuestionTitle(), minMap, stat.getUserSelectedVariantsCount());
        }).collect(Collectors.toList());
    }
}
