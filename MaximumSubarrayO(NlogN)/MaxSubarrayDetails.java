package maximum.subarray.calculation;

public class MaxSubarrayDetails implements Comparable<Integer> {

	int startIndex, endIndex;
	Integer sum;

	public MaxSubarrayDetails() {
		this.endIndex = 0;
		this.startIndex = 0;
	}

	public MaxSubarrayDetails(int startIndex, int endIndex, int sum) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.sum = sum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public int compareTo(Integer o) {
		if (this.sum.compareTo(o) < 0)
			return -1;
		else if (this.sum.compareTo(o) > 0)
			return 1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "Maximum Subarray starts at startIndex=" + startIndex + ", endIndex=" + endIndex + ", with a total sum="
				+ sum;
	}

}
