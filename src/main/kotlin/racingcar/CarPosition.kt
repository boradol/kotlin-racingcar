package racingcar

data class CarPosition(private val position: Int = 0) {
    fun move(): CarPosition {
        return CarPosition(position + 1)
    }
}
