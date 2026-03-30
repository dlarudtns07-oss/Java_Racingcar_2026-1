package racingcar;

public class Application {
}
package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        List<Car> cars = createCars(names);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = parseTryCount(Console.readLine());

        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            playOneRound(cars);
            System.out.println();
        }

        printFinalWinners(cars);
    }

    private static List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private static int parseTryCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count < 0) throw new IllegalArgumentException();
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void playOneRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
            System.out.println(car.getStatusString());
        }
    }

    private static void printFinalWinners(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        StringJoiner winners = new StringJoiner(", ");
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + winners.toString());
    }
}