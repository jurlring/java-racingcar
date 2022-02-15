package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.Car;
import racingcar.utlis.Convertor;
import racingcar.validator.NameValidator;

public class RacingCarService {

	private List<Car> cars;

	public RacingCarService(List<Car> cars) {
		this.cars = cars;
	}

	public void playRound() {
		cars.forEach(Car::decideMove);
	}

	public void saveCars(String inputCarNames) {
		List<String> carNames = Arrays.asList(Convertor.separateNamesByDelimiter(inputCarNames));
		NameValidator.checkNameList(carNames);
		save(carNames);
	}

	private void save(List<String> carNames) {
		carNames.forEach(carName -> cars.add(new Car(carName, 0)));
	}

	public int findMaxPosition() {
		return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
	}

	public List<String> findWinner() {
		int maxPosition = findMaxPosition();
		return cars.stream()
			.filter(car -> car.matchPosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toUnmodifiableList());
	}

	public List<Car> findAllCars() {
		return Collections.unmodifiableList(cars);
	}

	public void resetCars() {
		cars = new ArrayList<>();
	}
}