package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int MOVE_THRESHOLD = 4;

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingGame() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void run() {
        List<Car> cars = inputHandler.readCars();
        int attemptCount = inputHandler.readAttemptCount();

        System.out.println();
        System.out.println("실행 결과");

        playRounds(cars, attemptCount);

        outputHandler.printWinners(findWinners(cars));
    }

    private void playRounds(List<Car> cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            playOneRound(cars);
            outputHandler.printRoundResult(cars);
        }
    }

    private void playOneRound(List<Car> cars) {
        for (Car car : cars) {
            moveIfPossible(car);
        }
    }

    private void moveIfPossible(Car car) {
        if (isMovable()) {
            car.move();
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD;
    }

    private List<Car> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}