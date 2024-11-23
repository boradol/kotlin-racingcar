package racingcar.fixture

import racingcar.domain.Car
import racingcar.domain.CarName
import racingcar.domain.CarPosition
import racingcar.domain.Cars

object CarsFixture {
    fun singleWinner(): List<Cars> {
        return listOf(
            create("pobi" to 1, "crong" to 2, "honux" to 3),
        )
    }

    fun multipleWinners(): List<Cars> {
        return listOf(
            create("pobi" to 3, "crong" to 2, "honux" to 3),
        )
    }

    private fun create(vararg carData: Pair<String, Int>): Cars {
        val cars =
            carData.map { (name, position) ->
                Car(CarName(name), CarPosition(position))
            }
        return Cars(cars)
    }
}
