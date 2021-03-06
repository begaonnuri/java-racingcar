package racingcargame;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.domain.MoveStrategy;
import racingcargame.domain.NumberGenerator;
import racingcargame.domain.RacingLog;
import racingcargame.domain.car.Car;

class RacingLogTest {
	private MoveStrategy moveStrategy;
	private List<Car> cars;

	@BeforeEach
	void setUp() {
		moveStrategy = new NumberGenerator();
		cars = new ArrayList<>();
		cars.add(new Car("car1"));
		cars.add(new Car("car2"));
		cars.add(new Car("car3"));
	}

	@Test
	@DisplayName("생성자 테스트")
	void constructor() {
		Assertions.assertThat(new RacingLog(cars)).isInstanceOf(RacingLog.class);
	}

	@Test
	@DisplayName("getWinners 테스트")
	void getWinners() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("car1"));
		cars.add(new Car("car2"));
		cars.add(new Car("car3"));

		cars.get(0).decideMoveOrStop(moveStrategy.getMoveNo());
		RacingLog racingLog = new RacingLog(cars);
		Assertions.assertThat(racingLog.getWinners()).contains("car1");

		cars.get(2).decideMoveOrStop(moveStrategy.getMoveNo());
		racingLog = new RacingLog(cars);
		Assertions.assertThat(racingLog.getWinners()).containsExactly("car1", "car3");
	}
}
