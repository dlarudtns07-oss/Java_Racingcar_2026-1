package racingcar.view;

public class OutputView {
}
package racingcar.view;

import racingcar.model.Car;
import java.util.List;

public class OutputView {
    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionVisual());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    public void printResultHeader() {
        System.out.println("\n실행 결과");
    }
}