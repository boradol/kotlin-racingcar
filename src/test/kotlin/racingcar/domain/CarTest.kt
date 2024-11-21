package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `전진 조건을 만족하면 차는 전진한다`() {
        val carName = "bobi"

        val car = Car.from(carName).move { true }

        car shouldBe Car(CarName("bobi"), CarPosition(1))
    }

    @Test
    fun `전진 조건을 만족하지 않으면 차는 전진하지 않는다`() {
        val carName = "bobi"

        val car = Car.from(carName).move { false }

        car shouldBe Car(CarName("bobi"), CarPosition(0))
    }
}
