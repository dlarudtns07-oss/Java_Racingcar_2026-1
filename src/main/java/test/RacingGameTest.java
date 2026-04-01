package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("자동차가 이동 후 위치가 1 증가한다")
    void carMoveTest() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동하지 않으면 위치는 0이다")
    void carNoMoveTest() {
        Car car = new Car("woni");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void invalidCarNameLengthTest() {
        assertThatThrownBy(() -> Validator.validateCarName("toolongname"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외가 발생한다")
    void blankCarNameTest() {
        assertThatThrownBy(() -> Validator.validateCarName("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외가 발생한다")
    void invalidAttemptCountFormatTest() {
        assertThatThrownBy(() -> Validator.validateAndParseAttemptCount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 0 이하이면 예외가 발생한다")
    void invalidAttemptCountRangeTest() {
        assertThatThrownBy(() -> Validator.validateAndParseAttemptCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5자 이하의 유효한 이름은 예외가 발생하지 않는다")
    void validCarNameTest() {
        assertThatCode(() -> Validator.validateCarName("pobi"))
                .doesNotThrowAnyException();
    }
}