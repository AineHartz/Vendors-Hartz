import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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

    /*
    I originally planned on checking if the item was in stock and if there
    was enough money, hence the itemPrice and hasItem methods, but I figured
    it'd be more produtive for a test to enforce that those things were true
    and that the method worked given those variables.
     */
    @Test
    void buyItem()
    {
        vendor.addMoney(100);
        double current = vendor.getBalance();
        vendor.select("Candy");
        assertEquals(current - vendor.itemPrice("Candy"), vendor.getBalance());
    }

    @Test
    void emptyInventory()
    {
        vendor.emptyInventory();
        assertFalse(vendor.hasItem("Candy"));
    }

    @Test
    void restock()
    {
        int current = vendor.itemAmount("Candy");
        vendor.restock(10, "Candy", 5);
        assertEquals(current + 10, vendor.itemAmount("Candy"));
    }

    @Test
    void restockNew()
    {
        vendor.restock(5, "Lollipop", 10);
        assertTrue(vendor.hasItem("Lollipop"));
    }
}