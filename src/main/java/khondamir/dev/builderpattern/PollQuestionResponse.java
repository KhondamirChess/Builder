package khondamir.dev.builderpattern;

import java.util.List;

public record PollQuestionResponse(
        PollQuestion pollQuestion,
        List<String> selectedVariants
) {
}
