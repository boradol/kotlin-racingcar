package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.fixture.CarsFixture

class WinnersTest {
    @Test
    fun `우승자가 한 명일 때`() {
        val cars = CarsFixture.singleWinner()

        val winners = Winners.from(cars)

        val winnersCar = winners.values.currentCars()
        winnersCar.size shouldBe 1
        winnersCar.first() shouldBe HOUNUX_CAR
    }

    @Test
    fun `우승자가 여러 명일 때`() {
        val cars = CarsFixture.multipleWinners()

        val winners = Winners.from(cars)

        val winnerNames = winners.values.currentCars().map { it.name.value }
        winners.values.currentCars().size shouldBe 2
        winnerNames.toSet() shouldBe setOf("pobi", "honux")
    }

    companion object {
        private val HOUNUX_CAR = Car(CarName("honux"), CarPosition(3))
    }
}
