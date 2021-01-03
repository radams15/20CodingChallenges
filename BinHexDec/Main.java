import java.util.Scanner;

class Main{
    private Scanner in;

    public Main(){
        in = new Scanner(System.in);

        System.out.print("Number: ");
        int num = 1000;
        while(num >= 255) {
            num = in.nextInt();
            in.nextLine();
        }

        System.out.printf("%d is:\n\t%s in hex\n\t%s in binary\n", num, Integer.toHexString(num), Integer.toBinaryString(num));
    }

    public static void main(String[] args){
        new Main();
    }
}
