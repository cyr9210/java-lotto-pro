package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final List<LottoNumber> LOTTO_NUMBERS =
        IntStream.rangeClosed(1, 45).mapToObj(LottoNumber::new).collect(Collectors.toList());

    public static List<LottoNumber> pick() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.subList(0, 6);
    }
}
