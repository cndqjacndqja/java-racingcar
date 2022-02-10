package racingcar.view;

import java.util.Scanner;

public class InputView {
	private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String GET_ITERATION_NO_MESSAGE = "시도할 회수는 몇회인가요?";
	private static Scanner scanner = new Scanner(System.in);

	public static String getCarNames() {
		System.out.println(GET_CAR_NAMES_MESSAGE);
		return scanner.nextLine();
	}

	public static int getIterationNo() {
		System.out.println(GET_ITERATION_NO_MESSAGE);
		return Integer.parseInt(scanner.nextLine());
	}
}
