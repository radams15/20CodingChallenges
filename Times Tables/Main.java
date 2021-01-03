import java.util.Scanner;
import java.lang.Math;

class Main{
    private Scanner in;

    private final static int maxTable = 12;

    public Main(){
        in = new Scanner(System.in);

        System.out.print("Times Table: ");
        int num = in.nextInt();
        in.nextLine();

        for(int i=1 ; i<=maxTable ; i++){
            int out = num * i;

            System.out.printf("%d x %d = %d%n", i, num, out);
        }
    }

    public static void main(String[] args){
        new Main();
    }
}
