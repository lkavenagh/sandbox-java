import java.util.Arrays;

public class MaxDiffSeries {
	public static void main(String args[]) {
		//int[] prices = {5, 6, 4, 8, 7, 10, 7, 8, 1, 8, 9};
		int[] prices = {10,9,8,7,6,5,4};
		
		int minIdx = 0;
		int maxIdx = 1;
		int curMax = Integer.MIN_VALUE;
		int bestMin = 0;
		int bestMax = 1;
		
		maxIdx = findMaxIdx(prices);
		minIdx = findMinIdx(Arrays.copyOfRange(prices, minIdx, maxIdx));
		bestMin = minIdx;
		bestMax = maxIdx;
		curMax = prices[maxIdx]-prices[minIdx];
		System.out.println("Current diff is: " + Integer.toString(curMax));
		
		while (minIdx < prices.length-1 || maxIdx < prices.length-1) {
			minIdx = maxIdx + findMinIdx(Arrays.copyOfRange(prices, maxIdx, prices.length));
			maxIdx = minIdx + findMaxIdx(Arrays.copyOfRange(prices, minIdx, prices.length));
			if (prices[maxIdx]-prices[minIdx] > curMax) {
				curMax = prices[maxIdx]-prices[minIdx];
				bestMin = minIdx;
				bestMax = maxIdx;
			}
			System.out.println("Current diff is: " + Integer.toString(curMax));
		}
		
		System.out.println("Buy at prices[" + bestMin + "] : $" + prices[bestMin]);
		System.out.println("Sell at prices[" + bestMax + "] : $" + prices[bestMax]);
	}
	
	static int findMaxIdx(int[] a) {
		int maxIdx = 0;
		int curMax = Integer.MIN_VALUE;
		
		for (int i=0; i < a.length; ++i) {
			if (a[i] > curMax) {
				curMax = a[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}
	
	static int findMinIdx(int[] a) {
		int minIdx = 0;
		int curMin = Integer.MAX_VALUE;
		
		for (int i=0; i < a.length; ++i) {
			if (a[i] < curMin) {
				curMin = a[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
}
