package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CarNameTest {
    @Test
    fun `유효한 이름으로 CarName 이 생성된다`() {
        val carName = CarName("bobi")

        carName shouldBe CarName("bobi")
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = [" ", "     "])
    fun `이름이 공백이면 예외 발생한다`(value: String) {
        assertThrows<IllegalArgumentException> { CarName(value) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["123456", "동해물과백두산이"])
    fun `이름이 5자를 초과하면 예외 발생한다`(value: String) {
        assertThrows<IllegalArgumentException> { CarName(value) }
    }
}
