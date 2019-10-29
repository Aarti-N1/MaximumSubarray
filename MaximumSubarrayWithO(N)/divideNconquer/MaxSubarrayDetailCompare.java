package linear.divideNconquer;

public class MaxSubarrayDetailCompare {
	int totalSum, maxSum, maxPrefix, maxSuffix;

	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

	public int getMaxSum() {
		return maxSum;
	}

	public void setMaxSum(int maxSum) {
		this.maxSum = maxSum;
	}

	public int getMaxPrefix() {
		return maxPrefix;
	}

	public void setMaxPrefix(int maxPrefix) {
		this.maxPrefix = maxPrefix;
	}

	public int getMaxSuffix() {
		return maxSuffix;
	}

	public void setMaxSuffix(int maxSuffix) {
		this.maxSuffix = maxSuffix;
	}
	
	public MaxSubarrayDetailCompare(){
		super();
	}
	public MaxSubarrayDetailCompare(int totalSum, int maxSum, int maxPrefix, int maxSuffix) {
		super();
		this.totalSum = totalSum;
		this.maxSum = maxSum;
		this.maxPrefix = maxPrefix;
		this.maxSuffix = maxSuffix;
	}

	@Override
	public String toString() {
		return "The maximum Sum is " + maxSum ;
	}
	
}
