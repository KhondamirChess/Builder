package khondamir.dev.builderpattern;

import java.util.Map;

public class QuestionStatistics {
    String questionTitle;
    Map<String, Integer> selectedVariantsCount;
    Map<String, Integer> userSelectedVariantsCount;


    public QuestionStatistics(
            String questionTitle,
            Map<String, Integer> selectedVariantsCount,
            Map<String, Integer> userSelectedVariantsCount
    ) {
        this.questionTitle = questionTitle;
        this.selectedVariantsCount = selectedVariantsCount;
        this.userSelectedVariantsCount = userSelectedVariantsCount;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }
    public Map<String, Integer> getSelectedVariantsCount() {
        return selectedVariantsCount;
    }
    public Map<String, Integer> getUserSelectedVariantsCount() {
        return userSelectedVariantsCount;
    }
}
