package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarPositionTest {
    @Test
    fun `처음 자동차 위치는 0이다`() {
        val position = CarPosition()

        position shouldBe CarPosition(0)
    }

    @Test
    fun `자동차 위치가 1 증가한다`() {
        val position = CarPosition()
        val movedPosition = position.move()

        movedPosition shouldBe CarPosition(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -100, -99999])
    fun `자동차 위치는 음수이면 예외가 발생한다`(value: Int) {
        assertThrows<IllegalArgumentException> { CarPosition(value) }
    }
}
