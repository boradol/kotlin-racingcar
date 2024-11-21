package racingcar.domain

import io.kotest.core.spec.style.Test
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import racingcar.CarRacingGame
import racingcar.strategy.RandomMoveStrategy

class CarRacingGameTest {
    @Test
    fun `자동차들이 n번의 라운드 동안 이동한다`() {
        val carNames = "pobi,crong,honux"
        val game = CarRacingGame.create(carNames = carNames, rounds = 5)

        val raceResult = game.play(RandomMoveStrategy())

        raceResult.size shouldBe 5
        raceResult.forEach { round ->
            round.getPositions().size shouldBe 3
        }
    }

    @Test
    fun `자동차의 위치가 라운드 수를 초과하지 않는다`() {
        val carNames = "pobi,crong,honux"
        val game = CarRacingGame.create(carNames = carNames, rounds = 5)

        val raceResult = game.play(RandomMoveStrategy())

        raceResult.forEach { round ->
            round.getPositions().forEach { position ->
                position shouldBeGreaterThanOrEqual 0
                position shouldBeLessThanOrEqual 5
            }
        }
    }
}
