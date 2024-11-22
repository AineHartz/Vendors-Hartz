class Item
{
    double price;
    int stock;
    int purchaseCount;

    Item(double price, int numPieces)
    {
        this.price = price;
        this.stock = numPieces;
        purchaseCount = 0;

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
}