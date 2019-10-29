package maximum.subarray.calculation;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxSubarrayTestFramework {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a comma seperated list for which maximum sequence is to be found: ");
		String inputString = reader.nextLine(); 
		if(null == inputString || ("").equals(inputString)) {
			System.out.println("Only a valid input of signed integers is allowed.");
		}else {
			String[] tokens = inputString.split(",");
	        ArrayList<Integer> array = new ArrayList<Integer>();
	        for (int i = 0; i < tokens.length; i++)
	            array.add(new Integer(tokens[i]));
			reader.close();	
			FindMaxSubarray mss = new FindMaxSubarray();
			MaxSubarrayDetails maxSubarray = mss.findMSS(array, 0, array.size()-1);
	        System.out.println(maxSubarray.toString());
		}
	}
}
