import java.util.Scanner;

class Main{

    Scanner in;

    public Main(){
        in = new Scanner(System.in);

        ShoppingList list = new ShoppingList();


        while(true) {
            Item newItem = getItem();

            list.add(newItem);

            for(Item i : list.getOrderedItems()){
                System.out.println("\t"+i.toString());
            }
            System.out.println("Total Cost " + list.totalCost());

            System.out.println("\n\n");
        }
    }

    private Item getItem(){
        Item i = new Item();

        System.out.print("Priority: ");
        i.priority = in.nextInt();
        in.nextLine();

        System.out.print("Name: ");
        i.name = in.nextLine();

        System.out.print("Shop: ");
        i.shop = in.nextLine();

        System.out.print("Quantity: ");
        i.quantity = in.nextInt();
        in.nextLine();

        System.out.print("Cost: ");
        i.cost = in.nextFloat();
        in.nextLine();

        System.out.print("Purchased? [y/N]: ");
        i.purchased = in.nextLine().equals("y");

        return i;
    }

    public static void main(String[] args){
        new Main();
    }
}