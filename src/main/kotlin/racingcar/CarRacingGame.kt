package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.strategy.MoveStrategy

class CarRacingGame private constructor(
    private val cars: Cars,
    private val rounds: Int,
) {
    fun play(moveStrategy: MoveStrategy): List<Cars> {
        val initCars = cars.move(moveStrategy)

        return generateSequence(initCars) { it.move(moveStrategy) }
            .take(rounds)
            .toList()
    }

    companion object {
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

            return Cars(names.map { Car.from(it) })
        }

        private fun validateRounds(rounds: Int) {
            require(rounds > 0) { "라운드 수는 1 이상이어야 합니다." }
        }
    }
}
