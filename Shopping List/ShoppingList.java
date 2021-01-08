import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShoppingList {
    private ArrayList<Item> items;

    public ShoppingList(){
        items = new ArrayList<>();
    }

    public float totalCost(){
        float out = 0.0f;

        for(Item i : items){
            if(!i.purchased) {
                out += (i.quantity * i.cost);
            }
        }

        return out;
    }

    public ArrayList<Item> getOrderedItems(){
        ArrayList<Item> out = (ArrayList<Item>) items.clone();
        Collections.sort(out, new Comparator<Item>() {
            @Override
            public int compare(Item l, Item r) {
                if(l.priority == r.priority) return 0;
                else if(l.priority > r.priority) return 1;
                return -1;
            }
        });

        return out;
    }

    public void add(Item i){
        items.add(i);
    }
}
