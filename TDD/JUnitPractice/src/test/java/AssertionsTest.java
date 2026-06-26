import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void testAssertions() {

        // Equal
        assertEquals(5, 2 + 3);

        // True
        assertTrue(5 >3);

        // False
        assertFalse(5 < 3);

        // Null
        String name = null;
        assertNull(name);

        // Not Null
        Object obj = new Object();
        assertNotNull(obj);
    }
}