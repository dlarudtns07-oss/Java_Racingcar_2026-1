package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputHandler {

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + buildProgressBar(car.getPosition()));
        }
        System.out.println();
    }

    private String buildProgressBar(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void printWinners(List<Car> winners) {
        String names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + names);
    }
}