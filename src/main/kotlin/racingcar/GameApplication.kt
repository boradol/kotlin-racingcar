package racingcar

import racingcar.strategy.RandomMoveStrategy
import racingcar.ui.printAllResults
import racingcar.ui.printWinners
import racingcar.ui.readCarNames
import racingcar.ui.readTries

fun main() {
    val carNames = readCarNames()
    val round = readTries()

    val game = CarRacingGame.create(carNames, round)
    val raceResults = game.play(RandomMoveStrategy())
    val winners = game.findWinners(raceResults)

    printAllResults(raceResults)
    printWinners(winners)
}
