package racingcar.domain

import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `차들이 전진한다`() {
        val carList = listOf(Car.from("bobi"), Car.from("cobi"), Car.from("dobi"))
        val cars = Cars(carList)

        val movedCars = cars.move { true }

        movedCars.currentCars().map { it.position.value } shouldBe listOf(1, 1, 1)
    }

    @Test
    fun `차들이 전진하지 않는다`() {
        val carList = listOf(Car.from("bobi"), Car.from("cobi"), Car.from("dobi"))
        val cars = Cars(carList)

        val movedCars = cars.move { false }

        movedCars.currentCars().map { it.position.value } shouldBe listOf(0, 0, 0)
    }

    @Test
    fun `가장 많이 전진한 자동차들을 찾을 수 있다`() {
        val car1 = Car(CarName("bobi"), CarPosition(5))
        val car2 = Car(CarName("cobi"), CarPosition(3))
        val car3 = Car(CarName("dobi"), CarPosition(5))
        val cars = Cars(listOf(car1, car2, car3))

        val maxPosition = cars.maxPosition()

        maxPosition shouldBe 5
    }

    @Test
    fun `현재 자동차 목록을 반환할 수 있다`() {
        val car1 = Car(CarName("bobi"), CarPosition(3))
        val car2 = Car(CarName("cobi"), CarPosition(2))
        val cars = Cars(listOf(car1, car2))

        val currentCars = cars.currentCars()

        currentCars.map { it.name.value } shouldContainExactly listOf("bobi", "cobi")
        currentCars.map { it.position.value } shouldContainExactly listOf(3, 2)
    }
}
