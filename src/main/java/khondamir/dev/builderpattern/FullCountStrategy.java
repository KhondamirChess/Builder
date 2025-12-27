package khondamir.dev.builderpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullCountStrategy implements AnalyzeStrategy{

    @Override
    public List<QuestionStatistics> makeAnalyze(List<PollFillingData> pollFillingDataList) {
        Map<String, Map<String, Integer>> questionVariantCount = new HashMap<>();
        Map<String, Map<String, Integer>> questionUserCount = new HashMap<>();

        for (PollFillingData pollFillingData : pollFillingDataList) {
            String user = pollFillingData.userLogin();
            for (PollQuestionResponse response : pollFillingData.pollQuestionResponseList()) {
                String questionTitle = response.pollQuestion().getQuestion();

                Map<String, Integer> variantCount =
                        questionVariantCount.computeIfAbsent(questionTitle, q -> new HashMap<>());
                for (String answer : response.pollQuestion().getAnswers()) {
                    variantCount.merge(answer, 1, Integer::sum);
                }

                Map<String, Integer> userCount =
                        questionUserCount.computeIfAbsent(questionTitle, q -> new HashMap<>());
                userCount.merge(user, response.selectedVariants().size(), Integer::sum);
            }
        }
        List<QuestionStatistics> result = new ArrayList<>();
        for (String question : questionVariantCount.keySet()) {
            result.add(new QuestionStatistics(
                    question,
                    questionVariantCount.get(question),
                    questionUserCount.getOrDefault(question, Map.of())
            ));
        }

        return result;
    }

}
