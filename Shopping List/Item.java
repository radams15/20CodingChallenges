public class Item {
    int priority;
    String name;
    String shop;
    int quantity;
    float cost;
    boolean purchased;

    public Item(int priority, String name, String shop, int quantity, float cost, boolean purchased){
        this.priority = priority;
        this.name = name;
        this.shop = shop;
        this.quantity = quantity;
        this.cost = cost;
        this.purchased = purchased;
    }

    public String toString(){
        return String.format("%d %s from %s (%.2f)", quantity, name, shop, cost);
    }

    public Item(){
        new Item(0, "", "", 0, 0, false);
    }
}
