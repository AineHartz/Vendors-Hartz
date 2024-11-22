class Item
{
    double price;
    int stock;
    int purchaseCount;
    String itemDescription;

    Item(double price, int numPieces)
    {
        this.price = price;
        this.stock = numPieces;
        purchaseCount = 0;
        itemDescription = "";
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
}