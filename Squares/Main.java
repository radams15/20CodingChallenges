import java.util.Scanner;
import java.lang.Math;

class Main{
    private Scanner in;

    public Main(){
        in = new Scanner(System.in);

        System.out.print("Number: ");
        int num = in.nextInt();
        in.nextLine();

        for(int i=1 ; i<=num ; i++){
            int out = (int) Math.pow(i, 2);

            System.out.printf("%d squared is %d%n", i, out);
        }
    }

    public static void main(String[] args){
        new Main();
    }
}
