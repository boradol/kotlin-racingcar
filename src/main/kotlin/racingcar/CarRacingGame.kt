package racingcar

import racingcar.domain.Car
import racingcar.strategy.MoveStrategy

class CarRacingGame(
    carCount: Int,
    private val rounds: Int,
) {
    private val cars: List<Car> = List(carCount) { Car() }

    fun play(moveStrategy: MoveStrategy): List<List<Car>> {
        val results = mutableListOf<List<Car>>()

        var currentCars = cars
        repeat(rounds) {
            currentCars = currentCars.map { it.move(moveStrategy) }
            results.add(currentCars)
        }

        return results
    }
}
