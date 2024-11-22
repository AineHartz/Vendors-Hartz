import java.util.HashMap;


/**
 * Class for a Vending Machine. Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vending {
    //I made this not static so VendorSystem would work properly.
    private HashMap<String, Item> Stock = new HashMap<String, Item>();
    private double balance;

    Vending(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
    }

    /**
     * resets the Balance to 0
     */
    void resetBalance() {
        this.balance = 0;
    }

    /**
     * returns the current balance
     */
    double getBalance() {
        return this.balance;
    }

    /**
     * adds money to the machine's balance
     *
     * @param amt how much money to add
     */
    void addMoney(double amt) {
        this.balance = this.balance + amt;
    }

    /**
     * I made this method to be able to check the stock
     * from the unit test class without making Stock
     * public.
     *
     * @param itemName the name of the item to check
     * @return a boolean telling if the item is in stock or not
     */
    boolean hasItem(String itemName)
    {
        return Stock.containsKey(itemName);
    }

    /**
     * The same as hasItem, but for checking price.
     *
     * @param itemName the name of the item to check
     * @return a double containing the item's price
     */
    double itemPrice(String itemName)
    {
        Item item = Stock.get(itemName);
        return item.price;
    }

    /*
    Another accesor method written for a test class. This one checks
    how much of an item is in stock.
     */
    int itemAmount(String itemName)
    {
        return Stock.get(itemName).stock;
    }

    /**
     * attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void select(String name)
    {
        if (Stock.containsKey(name))
        {
            Item item = Stock.get(name);

            if (balance >= item.price)
            {
                item.purchase(1);
                this.balance = this.balance - item.price;
            }

            else
                System.out.println("Gimme more money");

        }

        else
            System.out.println("Sorry, don't know that item");
    }

    /*
    A simple method to empty out the inventory, for the third unit test.
     */
    void emptyInventory()
    {
        Stock.clear();
    }

    /*
    A method meant to get an item from the stock, increase the stock of that
    item, and then put it back in.

    Ver 2: If the item doesn't already exist in Stock, it is added to the Stock.
     */
    void restock(int amount, String name, double price)
    {
        if (Stock.containsKey(name))
        {
            Stock.get(name).restock(amount);
        }

        else
        {
            Stock.put(name, new Item(price, amount));
        }
    }

    void printInventory()
    {
        for (HashMap.Entry<String, Item> entry : Stock.entrySet())
        {
            String itemName = entry.getKey();
            Item item = entry.getValue();

            //throw new RuntimeException("on purpose");

            System.out.println("Item: " + itemName + ", Price: " + item.price + ", Quantity: " + item.stock);
        }
    }

    //A simple method to remove a specific item from inventory.
    void removeItem(String itemName)
    {
        Stock.remove(itemName);
    }
}

