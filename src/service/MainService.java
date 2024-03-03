package service;

import java.util.Arrays;
import java.util.Random;

/**
 * First JAVA class
 * @author Karina Skirmante
 */



/*
 * Random ran = new Random();
 * [0] - how many are "1"
 * [1] - how many are "2"
 * int[] result = new int[6];
 *  0 1 2 3 4 5
 * [0 0 0 0 0 1]
 * 
 * for(int i = 0; i < N;i++)
 * {
 * 	int dice = rand.nextint(5);
 * result[dice] = result[dice]++;
 * 
 * }
 */

public class MainService {
	private static final double GRAVITY = -9.81; // Earth's gravity in m/s^2
	
	/*
	 * Multiline comments
	 */
	public static void main(String[] args) {
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt",
				"Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron",
				"Kate" };
		
		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393,
				299, 343, 317, 265 };
		
		
		if(names.length == times.length) {
			for(int i = 0; i < names.length; i++) {
				//[Name, <time>]:
				System.out.println("[" + names[i] + ", <" + times[i] + ">]");
			}
		}
		
		
		double initialVelocity = -1.0;
		double fallingTime = 10.0;
		double initialPosition = 0.0;
		double finalPosition = 0.0;
		System.out.println("Pos in "+fallingTime+"sec :"+finalPosition);
		try
		{
			double result = 
					positionCalc(initialVelocity, initialPosition, fallingTime);
			System.out.println(result + " m");
			
			int result2 = factorialForLoop(5);
			System.out.println(result2);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// One-line comment
		
		try
		{
			double[] myArray = generateArray(10, -8.9, 100.4);
			System.out.println(Arrays.toString(myArray));
			System.out.println(getMean(myArray));
			
			System.out.println(getMin(myArray));
			System.out.println(getMax(myArray));
			
			double[] sortedArray = arraySort(myArray);
			String arrayAsString = Arrays.toString(sortedArray);
			System.out.println(arrayAsString);

			//The same as ^^^
			//System.out.println(Arrays.toString(arraySort(myArray)));
			
			double[][] my2DArray = generateMatrix(3);
			String myArray2DAsString = Arrays.deepToString(my2DArray);
			System.out.println(myArray2DAsString);
			
			System.out.println("---------------------------------");
			//my implemantation for printing out 2D array
			for(int i = 0; i < my2DArray.length; i++) {
				for(int j = 0 ; j < my2DArray[i].length; j++)
				{
					System.out.print(my2DArray[i][j] + " ");
				}
				System.out.println();
			}
			
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}

		try {
			double[] resultForCoins = coinFlip(1000);
			String resultForCointsAsString = Arrays.toString(resultForCoins);
			System.out.println(resultForCointsAsString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			int[] resultFromRollDice = rollDice(100);
			String resultFromRollDiceString = Arrays.toString(resultFromRollDice);
			System.out.println(resultFromRollDiceString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(roll2Dices());
		byte[] msg = {72, 101, 108, 108, 111, 33, 32, 77, 121, 32, 115, 107, 105, 108, 108, 115, 32, 97, 114, 101,
				32, 103, 114, 101, 97, 116, 32, 97, 108, 114, 101, 97, 100, 121, 33};
		try {
			System.out.println(getTextFromBytes(msg));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			System.out.println(pascalsTriangle(6));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static double positionCalc(double initialVelocity, double
			initialPosition, double fallingTime) throws Exception{
		
		if(initialVelocity >= 0 && initialVelocity < 400
				&& initialPosition >= 0 && initialPosition < 10000
				&& fallingTime > 0 && fallingTime < 100000)
		{
			//                            fallingTime*fallingTime 
			return 0.5 * GRAVITY*Math.pow(fallingTime, 2) 
					+ initialVelocity*fallingTime + initialPosition;
		}
		
		throw new Exception("Wrong input parametrs");
		
	}

	// 4! = 1 * 2 * 3 * 4 = 24
	public static int factorialForLoop(int N)
	{
		if( N > 0) {
		int result = 1;
		for(int i = 1; i <= N; i++) {
			result = result * i;
		}
		
		return result;
		}
		else
		{
			return 0;
		}
	}

	public static double[] generateArray(int N, double lower, double upper) throws Exception {
		
		if(N < 0 || upper < lower)
		{
			throw new Exception("Worong input parameters");
		}
		
		else
		{
			//type[] name = new type[];
			double[] result = new double[N];
			Random myRand = new Random();
			
			for(int i = 0; i < result.length; i++) {
				result[i] = myRand.nextDouble(lower, upper);
			}
			return result;
			
		}
		
		
		
		
		
	}
	
	public static double getMean(double[] array) throws Exception {
		if(array == null)
		{
			throw new Exception("Worong input parameters");
		}
		
		double sum = 0;
		//for loop
		/*for(int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}*/
		// type variable : array
		for(double temp : array) { //0 ... arrays.lenght i++
			sum = sum + temp;
		}
		
		
		return (sum/array.length);
		
	}
	
	
	public static double getMin(double[] array) throws Exception {
		if(array == null) throw new Exception("Wrong input parameters");
		
		double min = array[0];
		
		for(int i = 1; i < array.length; i++ ) {
			if(min > array[i]) {
				min = array[i];
			}
		}
		
		return min;
		
	}
	
	public static double getMax(double[] array) throws Exception {
		if(array == null) throw new Exception("Wrong input parameters");
		
		double max = array[0];
		
		for(int i = 1; i < array.length; i++ ) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		
		return max;
		
	}
	
	
	public static double[] arraySort(double[] array) throws Exception{
		if(array == null) throw new Exception("Wrong input parameters");
			
		Arrays.sort(array);
		return array;
		
	}
	
	
	public static double[][] generateMatrix(int N) throws Exception{
		
		if(N <= 0) throw new Exception("Wrong input parameters");
		
		
		double[][] result = new double[N][N];
		
		Random rand = new Random();
		
		for(int i = 0; i < N; i++) { //this will be for rows
			for(int j = 0; j < N; j++) {//this will be for columns
				result[i][j] = rand.nextDouble();
			}
		}
		
		return result;
	}
	
	
	public static double[] coinFlip(int N) throws Exception {
		if(N <= 0) throw new Exception("Wrong input parameters");
		
		double[] result = new double[3];
		//[0] - how many heads (how many true values)
		//[1] - how many tails (how many false values)
		//[2] - ratio heads/tails -> true/false
		// 0 1 2
		//[3 0 0]
		Random rand = new Random();
		for(int i = 1; i <= N; i++) {
			boolean temp = rand.nextBoolean();
			
			if(temp) {//if it is true
				result[0] = result[0]+ 1;
			}
			else
			{
				result[1] = result[1] + 1;
			}
		}
		
		result[2] = result[0]/result[1];
		return result;		
		
	}
	public static int[] rollDice(int N) throws Exception{
		if(N <= 0) throw new Exception("Wrong input parameters");
		
		int[] results = new int[6];
		//[0] -> how many 1
		//[1] -> how many 2
		//...
		//[5] -> how many 6
		
		Random rand = new Random();
		for(int i = 1; i <= N; i++) {
			int diceResult = rand.nextInt(1, 7); //1, 2, 3, 4 ,5, 6 including, 7 excluding
			int index = diceResult-1;
			results[index] = results[index]+1;
		}
		return results;
		
	}
	
	public static int roll2Dices() {
		int howManyTries = 0;
		int diceResult = 0;
		Random rand = new Random();
		
		do {
			diceResult = rand.nextInt(1, 7);//1, 2, 3, 4, 5, 6 including

			howManyTries++;
		}
		while(diceResult!=6);
		
		do {
			diceResult = rand.nextInt(1, 7);//1, 2, 3, 4, 5, 6 including
			howManyTries++;
		}
		while(diceResult!=6);
			
		return howManyTries;
		
		
	}
	
	public static String getTextFromBytes(byte[] array) throws Exception{
		if(array == null) throw new Exception("Wrong input parameters");
	
		String result = new String(array);
		return result;
	
	}
	
	public static String pascalsTriangle(int level) throws Exception{
		if(level <= 0) throw new Exception("Wrong input parameters");
		
		
		String result = "1 ";
		
		for(int i= 1; i < level;i++) {
			int temp  = factorialForLoop(level)/ (factorialForLoop(i) * (factorialForLoop(level-i)));
			result+= temp + " ";
		}
		result+="1";
		
		
		return result;
		
		
	}
	
	
}
