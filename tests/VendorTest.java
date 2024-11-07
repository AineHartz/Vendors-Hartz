import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    private Vending vendor;

    @BeforeEach
    void setup()
    {
        vendor = new Vending(2, 5);
    }

    @Test
    void addition()
    {
        assertEquals(2, 1 + 1);
    }

    @Test
    void addMoney()
    {
        double currentBalance = vendor.getBalance();
        vendor.addMoney(5);
        assertEquals(currentBalance + 5, vendor.getBalance());
    }

}