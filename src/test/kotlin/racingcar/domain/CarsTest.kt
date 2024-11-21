package racingcar.domain

import io.kotest.core.spec.style.Test
import io.kotest.matchers.shouldBe

class CarsTest {
    @Test
    fun `차들이 전진한다`() {
        val cars = Cars(listOf(Car("bobi"), Car("cobi"), Car("dobi")))

        val movedCars = cars.move { true }

        movedCars.getPositions() shouldBe listOf(1, 1, 1)
    }

    @Test
    fun `차들이 전진하지 않는다`() {
        val cars = Cars(listOf(Car("bobi"), Car("cobi"), Car("dobi")))

        val movedCars = cars.move { false }

        movedCars.getPositions() shouldBe listOf(0, 0, 0)
    }
}
