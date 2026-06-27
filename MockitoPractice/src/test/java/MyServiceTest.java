
import org.example.Externalapi;
import org.example.MyService;

import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testExternalapi(){


        Externalapi mockapi = mock(Externalapi.class);
        /* how are we making mock (fake object ) of interface class but at runtime mockito makes a
        implement class and  implements it
         */

        when(mockapi.getData()).thenReturn("mock data");

        MyService service = new MyService(mockapi);

        String result = service.fetchData();

        assertEquals("mock data", result);
        verify(mockapi).getData();
    }
}
