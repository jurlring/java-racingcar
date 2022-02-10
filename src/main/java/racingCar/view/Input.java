package racingCar.view;

import java.util.Scanner;

public class Input {

	static final String REQUEST_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	static final String REQUEST_COUNT = "시도할 회수는 몇회인가요?";

	public static String inputCarsName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(REQUEST_CARS_NAME);
		return scanner.next();
	}

	public static String inputCount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(REQUEST_COUNT);
		return scanner.next();
	}

}