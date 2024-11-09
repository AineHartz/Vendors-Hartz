import java.util.*;

/*
This class exists for the 5 different vendors user story. Decided to make it replace the fake main
file that existed before, since it makes more sense for this to hold main.
 */
public class VendorSystem
{

    List<Vending> vendSys;

    VendorSystem()
    {
        vendSys = new ArrayList<>();

        Vending vendor1 = new Vending(2, 5);
        Vending vendor2 = new Vending(3, 6);
        Vending vendor3 = new Vending(4, 7);
        Vending vendor4 = new Vending(5, 8);
        Vending vendor5 = new Vending(6, 9);

        vendSys.add(vendor1);
        vendSys.add(vendor2);
        vendSys.add(vendor3);
        vendSys.add(vendor4);
        vendSys.add(vendor5);
    }

    public void printAll()
    {
        for (Vending vend : vendSys)
        {
            vend.printInventory();
        }
    }
}
