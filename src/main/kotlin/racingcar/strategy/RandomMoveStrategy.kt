package racingcar.strategy

class RandomMoveStrategy : MoveStrategy {
    override fun move(): Boolean {
        return (0..9).random() >= 4
    }
}
