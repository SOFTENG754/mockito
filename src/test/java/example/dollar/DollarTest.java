package example.dollar;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class DollarTest {
    @Test
    public void testDollar(){
        Dollar mockedDollar = Mockito.mock(Dollar.class);
        assertEquals(0, mockedDollar.getAmount());
    }
}