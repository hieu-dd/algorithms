import org.junit.Test
import kotlin.test.assertEquals

class ReverseIntegerTest {

    @Test
    fun `testReverseWithPositiveNumber`(){
        val number = 1234
        assertEquals(4321,reverse(number))
    }

    @Test
    fun `testReverseWithNegativeNumber`(){
        val number = -1234
        assertEquals(-4321,reverse(number))
    }
}