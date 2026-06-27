import org.example.Calculator;
import org.example.Mathsum;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {
    @Test
    void verifycall(){

        Calculator Fobj = mock(Calculator.class);

        when(Fobj.add(30,20)).thenReturn(50);

        Mathsum obj = new Mathsum(Fobj);

        int result = obj.solve();

        assertEquals(50,result);

        verify(Fobj).add(30,20);


    }
}
