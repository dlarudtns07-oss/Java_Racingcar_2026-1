package racingcar.view;

public class InputView {
}
package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public int readAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            int count = Integer.parseInt(input);
            validateCount(count);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}