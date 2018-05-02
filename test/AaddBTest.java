import org.junit.Test;

import static org.junit.Assert.*;

public class AaddBTest {

    @Test
    public void getSum() {
        assertEquals(3, aaddB(1,2));
        System.out.println(1);
    }

    private int aaddB(int i, int i1) {
        return i+i1;
    }

    @Test
    public void main() {
    }
}