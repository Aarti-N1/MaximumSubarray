package linear.divideNconquer;

import java.util.ArrayList;
import java.util.Scanner;

public class FindMaxSubarrayCompare {

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
			FindMaxSubarrayCompare mss = new FindMaxSubarrayCompare();
			MaxSubarrayDetailCompare maxSubarrayCompare = mss.FMSCompare(array, 0, array.size()-1);
	        System.out.println(maxSubarrayCompare.toString());
		}
	}

	public MaxSubarrayDetailCompare FMSCompare(ArrayList<Integer> A, int low, int high) {
		if (low == high)
			return new MaxSubarrayDetailCompare(A.get(low), A.get(low), A.get(low), A.get(low));
		else {
			int mid = (low + high) / 2;
			MaxSubarrayDetailCompare left, right;
			left = FMSCompare(A, low, mid);
			right = FMSCompare(A, mid + 1, high);
			return compare(A, left, right);
		}

	}

	public MaxSubarrayDetailCompare compare(ArrayList<Integer> A, MaxSubarrayDetailCompare left,
			MaxSubarrayDetailCompare right) {
		MaxSubarrayDetailCompare temp = new MaxSubarrayDetailCompare();
		temp.setTotalSum(left.getTotalSum() + right.getTotalSum());
		temp.setMaxPrefix(Math.max(left.getMaxPrefix(), (left.getTotalSum() + right.getMaxPrefix())));
		temp.setMaxSuffix(Math.max(right.getMaxSuffix(), (left.getMaxSuffix() + right.getTotalSum())));
		temp.setMaxSum(
				Math.max(left.getMaxSum(), Math.max(right.getMaxSum(), (left.getMaxSuffix() + right.getMaxPrefix()))));
		return temp;

	}

}
