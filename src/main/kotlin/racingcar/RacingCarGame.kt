package racingcar

import racingcar.strategy.RandomMoveStrategy
import racingcar.ui.readNumberOfCars
import racingcar.ui.readTries

fun main() {
    readNumberOfCars()
    readTries()
    val position = Car().move(RandomMoveStrategy()).position
    println("position = $position")
}
