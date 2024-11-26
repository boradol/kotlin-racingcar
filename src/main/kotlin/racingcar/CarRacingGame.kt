package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.strategy.MoveStrategy

class CarRacingGame private constructor(
    private val cars: Cars,
    private val rounds: Int,
) {
    constructor(
        carNames: String,
        rounds: Int,
    ) : this(
        parseCarNames(carNames),
        validateRounds(rounds),
    )

    fun play(moveStrategy: MoveStrategy): List<Cars> {
        val initCars = cars.move(moveStrategy)

        return generateSequence(initCars) { it.move(moveStrategy) }
            .take(rounds)
            .toList()
    }

    companion object {
        private fun parseCarNames(carNames: String): Cars {
            val names = carNames.split(",").map { it.trim() }

            return Cars(names.map { Car.from(it) })
        }

        private fun validateRounds(rounds: Int): Int {
            require(rounds > 0) { "라운드 수는 1 이상이어야 합니다." }

            return rounds
        }
    }
}
