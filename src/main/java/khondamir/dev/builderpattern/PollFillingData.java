package khondamir.dev.builderpattern;

import java.util.List;

public record PollFillingData(
        String userLogin,
        List<PollQuestionResponse> pollQuestionResponseList
) {
}
