import org.example.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FixtureTest {

    private Calculator cal;

    @BeforeEach
    void setup() {

        System.out.println("creating obj");
        cal = new Calculator();

    }

    @Test
    void testOne() {

        System.out.println("Running Test 1");
        int result = cal.add(23,27);
        assertEquals(50,result);

    }

    @Test
    void testTwo() {

        System.out.println("Running Test 2");
        int result = cal.add(23,2);
        assertEquals(25,result);

    }

    @AfterEach
    void teardown() {

        System.out.println("Closing Resources");

    }

}