package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @Test
    void creator() {
        Lotto lotto = new Lotto();
        assertEquals(6, lotto.getNumbers().size());
        assertThat(lotto.getNumbers().get(0)).isBetween(1, 45);
        assertThat(lotto.getNumbers().get(1)).isBetween(1, 45);
        assertThat(lotto.getNumbers().get(2)).isBetween(1, 45);
        assertThat(lotto.getNumbers().get(3)).isBetween(1, 45);
        assertThat(lotto.getNumbers().get(4)).isBetween(1, 45);
        assertThat(lotto.getNumbers().get(5)).isBetween(1, 45);
    }

    @MethodSource(value = "getResultParameter")
    @ParameterizedTest
    void getResult(Lotto lotto, Lotto winner, Result expectedResult) {
        Result result = lotto.getResult(winner);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> getResultParameter() {
        Lotto lotto = getLotto(1, 2, 3, 4, 5, 6);
        return Stream.of(
            arguments(lotto, getLotto(1, 2, 3, 4, 5, 6), Result.WINNER),
            arguments(lotto, getLotto(1, 2, 3, 4, 5, 7), Result.SECOND),
            arguments(lotto, getLotto(1, 2, 3, 4, 7, 8), Result.THIRD),
            arguments(lotto, getLotto(1, 2, 3, 7, 8, 9), Result.FOURTH),
            arguments(lotto, getLotto(1, 2, 7, 8, 9, 10), Result.LOSE),
            arguments(lotto, getLotto(1, 7, 8, 9, 10, 11), Result.LOSE),
            arguments(lotto, getLotto(7, 8, 9, 10, 11, 12), Result.LOSE)
        );
    }

    private static Lotto getLotto(int first, int second, int third, int fourth, int fifth, int sixth) {
        List<Integer> numbers = Arrays.asList(first, second, third, fourth, fifth, sixth);
        return new Lotto(numbers);
    }
}