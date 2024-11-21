package racingcar

import racingcar.domain.Car
import racingcar.domain.CarPosition
import racingcar.domain.Cars
import racingcar.strategy.MoveStrategy

class CarRacingGame private constructor(
    private val cars: Cars,
    private val rounds: Int,
) {
    fun play(moveStrategy: MoveStrategy): List<Cars> {
        val totalRounds = rounds + INITIAL_ROUND_COUNT

        return generateSequence(cars) { it.move(moveStrategy) }
            .take(totalRounds)
            .toList()
    }

    companion object {
        private const val INITIAL_ROUND_COUNT = 1

        fun create(
            carNames: String,
            rounds: Int,
        ): CarRacingGame {
            val cars = parseCarNames(carNames)
            validateRounds(rounds)

            return CarRacingGame(cars, rounds)
        }

        private fun parseCarNames(carNames: String): Cars {
            val names = carNames.split(",").map { it.trim() }
            require(names.all { it.length <= 5 }) { "자동차 이름은 5자를 초과할 수 없습니다." }

            return Cars(names.map { Car(CarPosition()) })
        }

        private fun validateRounds(rounds: Int) {
            require(rounds > 0) { "라운드 수는 1 이상이어야 합니다." }
        }
    }
}
