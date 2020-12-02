import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class Main{
	public Main(){
		/*Scanner in = new Scanner(System.in);
		Currency ukCurrency = new Currency(new double[]{2.0, 1.0, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01});
		Currency usCurrency = new Currency(new double[]{1.0, 0.5, 0.25, 0.1, 0.05, 0.01});

		System.out.print("Cost: ");
		double cost = in.nextDouble();
		in.nextLine();

		System.out.print("Given: ");
		double given = in.nextDouble();
		in.nextLine();

		double change = given-cost;

		System.out.printf("Change Is: %.2f\n", change);

		System.out.println("US: "+usCurrency.getCoins(change));
		System.out.println("UK: "+ukCurrency.getCoins(change));*/

		System.out.println(test());
	}

	public boolean test(){
		Random rand = new Random();

		Currency ukCurrency = new Currency(new double[]{2.0, 1.0, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01});
		Currency usCurrency = new Currency(new double[]{1.0, 0.5, 0.25, 0.1, 0.05, 0.01});

		double given = rand.nextInt(100)+rand.nextFloat();
		double price = rand.nextInt((int)given)+rand.nextFloat();

		double change = given-price;

		double usSum = usCurrency.getCoins(change).stream()
		.mapToDouble(a -> a)
		.sum();

		double ukSum = ukCurrency.getCoins(change).stream()
		.mapToDouble(a -> a)
		.sum();

		System.out.printf("Change: %f, Actual: %f / %f\n", change, ukSum, usSum);

		if(usSum != change || ukSum != change){
			return false;
		}


		return true;
	}

	public static void main(String[] args){
		new Main();
	}
}
