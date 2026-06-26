import org.example.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//why static import

/*Without static import, you would have to write:
Assertions.assertEquals(5, result);
Because assertEquals() belongs to the Assertions class. */

//import org.junit.jupiter.api.*;  can be done to import all things

public class CalculatorTest {

    @Test
    void testAddition() {

        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(2, 3);

        // Assert
        assertEquals(5, result);

    }
}


