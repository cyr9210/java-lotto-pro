package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;

public class ResultView {

    private static final String QUANTITY_PRINT_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String DELIMITER = ", ";
    private static final String LOTTO_MESSAGE_START_CHAR = "[";
    private static final String LOTTO_MESSAGE_END_CHAR = "]";

    public static void printLottos(Lottos lottos) {
        printQuantity(lottos.getQuantity());
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    private static void printQuantity(int quantity) {
        String message = String.format(QUANTITY_PRINT_MESSAGE_FORMAT, quantity);
        System.out.println(message);
    }

    private static void printLotto(Lotto lotto) {
        List<String> stringNumbers = lotto.getNumbers().stream().map(Object::toString).collect(Collectors.toList());
        String lottoMessage = LOTTO_MESSAGE_START_CHAR + String.join(DELIMITER, stringNumbers) + LOTTO_MESSAGE_END_CHAR;
        System.out.println(lottoMessage);
    }

    public static void printResults(List<Result> results) {
        printResult(results, Result.WINNER);
        printResult(results, Result.SECOND);
        printResult(results, Result.THIRD);
        printResult(results, Result.FOURTH);
    }

    private static void printResult(List<Result> results, Result printTarget) {
        int count = 0;
        for (final Result result : results) {
            count = checkCount(printTarget, count, result);
        }
        String message = String.format("%d개 일치 (%d원)- %d개", printTarget.getContainsCount(),
            printTarget.getPrizeMoney(), count);
        System.out.println(message);
    }

    private static int checkCount(Result printTarget, int count, Result result) {
        if (printTarget.equals(result)) {
            count++;
        }
        return count;
    }

}
