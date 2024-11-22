class Item
{
    double price;
    int stock;
    int purchaseCount;
    String itemDescription;
    double priceModifier;
    boolean bestseller;

    Item(double price, int numPieces)
    {
        this.price = price;
        this.stock = numPieces;
        purchaseCount = 0;
        itemDescription = "";
        priceModifier = 1;
        bestseller = false;
    }

    void restock(int amount)
    {
        this.stock = this.stock + amount;
    }

    void purchase(int amount)
    {
        this.stock = this.stock - amount;
        purchaseCount++;
    }

    //For the item description user story.
    void setDescription(String desc)
    {
        itemDescription = desc;
    }

    //The idea is that the price will always stay the same, but you can set a modifier that is multiplied by the price
    //when you go to buy something. A modifier of 1 will make the price normal, a modifier of 0.8 will be 20% off, etc.
    void setModifier(double mod)
    {
        priceModifier = mod;
    }

    //No longer using purely the price field, it is now affected by a modifier!
    double getPrice()
    {
        return price * priceModifier;
    }

    void setBestseller()
    {
        bestseller = true;
    }
}