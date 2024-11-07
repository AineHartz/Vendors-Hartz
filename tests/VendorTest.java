import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    @BeforeEach
    void setup()
    {
        Vendor vendor = new Vendor(2, 5);
    }

    @Test
    void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void addMoney(int amount)
    {
        assertEquals(vendor.getBalance+amount, vendor.addMoney(amount))
    }

}