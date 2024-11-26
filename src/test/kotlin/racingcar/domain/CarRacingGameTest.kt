package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.CarRacingGame
import racingcar.strategy.RandomMoveStrategy

class CarRacingGameTest {
    @Test
    fun `자동차 이름을 받아서 게임을 생성한다`() {
        val carNames = "pobi, crong, honux"
        val game = CarRacingGame(carNames = carNames, rounds = 5)

        val raceResult = game.play(RandomMoveStrategy())

        raceResult.size shouldBe 5
        raceResult.forEach { round ->
            round.currentCars().size shouldBe 3
        }
    }

    @Test
    fun `자동차가 모든 라운드에서 전진하면 자동차의 위치는 라우드 수와 일치한다`() {
        val carNames = "pobi,crong,honux"
        val game = CarRacingGame(carNames = carNames, rounds = 5)

        val raceResult = game.play { true }

        raceResult.last().currentCars().forEach { car ->
            car.position.value shouldBe 5
        }
    }

    @Test
    fun `자동차가 모든 라운드에서 정지하면 자동차의 위치는 0이다`() {
        val carNames = "pobi,crong,honux"
        val game = CarRacingGame(carNames = carNames, rounds = 5)

        val raceResult = game.play { false }

        raceResult.last().currentCars().forEach { car ->
            car.position.value shouldBe 0
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -10])
    fun `라운드 수는 1 이상이어야 한다`(rounds: Int) {
        val carNames = "pobi,crong,honux"

        assertThrows<IllegalArgumentException> {
            CarRacingGame(carNames, rounds)
        }
    }
}
