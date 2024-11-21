package racingcar.domain

private const val DEFAULT_POSITION = 0

data class CarPosition(val value: Int = DEFAULT_POSITION) {
    fun move(): CarPosition {
        return copy(value = value + 1)
    }
}
