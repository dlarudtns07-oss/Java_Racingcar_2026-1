package racingcar;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + name);
        }
    }

    public static int validateAndParseAttemptCount(String input) {
        try {
            int count = Integer.parseInt(input.trim());
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}