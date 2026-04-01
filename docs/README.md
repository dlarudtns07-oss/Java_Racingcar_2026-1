# 입력 기능
경주할 자동차 이름 입력 받기 (쉼표 구분)
시도할 횟수 입력 받기
# 유효성 검사 기능
자동차 이름이 공백인 경우 IllegalArgumentException 발생
자동차 이름이 5자 초과인 경우 IllegalArgumentException 발생
시도 횟수가 숫자가 아닌 경우 IllegalArgumentException 발생
시도 횟수가 0 이하인 경우 IllegalArgumentException 발생
# 자동차 기능
자동차 이름과 위치(position) 관리
0~9 무작위 값이 4 이상이면 전진
# 게임 진행 기능
입력한 횟수만큼 라운드 반복 실행
매 라운드 결과 출력 (이름 + 진행 막대)
# 우승자 계산 및 출력 기능
최대 위치값을 가진 자동차를 우승자로 선정 
공동 우승자 쉼표로 구분하여 출력