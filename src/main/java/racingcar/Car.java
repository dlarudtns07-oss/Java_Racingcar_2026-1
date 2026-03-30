package racingcar;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
package racingcar;

    public class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
            validateName(name);
            this.name = name;
        }

        private void validateName(String name) {
            if (name == null || name.isBlank() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }

        public void move(int number) {
            if (number >= 4) {
                position++;
            }
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        public String getStatusString() {
            return name + " : " + "-".repeat(position);
        }
    }

