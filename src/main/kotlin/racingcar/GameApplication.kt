package racingcar

import racingcar.strategy.RandomMoveStrategy
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val carNames = InputView.readCarNames()
    val round = InputView.readTries()

    val game = CarRacingGame.create(carNames, round)
    val raceResults = game.play(RandomMoveStrategy())
    val winners = game.findWinners(raceResults)

    ResultView.printAllResults(raceResults)
    ResultView.printWinners(winners)
}
