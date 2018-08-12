public class BubbleSort {
	
	public int[] bubbleSort(int[] list) {
		int n = list.length;
		int temp;
		int lastCheck = n;
		while (lastCheck > 0) {
			lastCheck = 0;
			for (int i = 1; i < n; i ++) {
				//Check if two values are out of order
				if (list[i - 1] > list[i]) {
					//swap them
					temp = list[i - 1];
					list[i - 1] = list[i];
					list[i] = temp;
					//When indices are swapped, set the last value to check
					//This is done because bubble sort leaves the last few indices sorted
					lastCheck = i;
				}
			}
			n = lastCheck;
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort sort = new BubbleSort();
		int nums[] = {63,	66,	67,	58,	56,
				8,	99,	8,	48,	29,
				47,	4,	17,	36,	26,
				69,	6,	34,	32,	5,
				26,	68,	53,	72,	1,
				51,	29,	18,	52,	71,
				77,	74,	85,	77,	4,
				68,	82,	98,	6,	45,
				10,	51,	32,	61,	28,
				50,	2,	22,	61,	85,
				12,	94,	71,	17,	81,
				40,	34,	59,	47,	51,
				7,	65,	59,	67,	60,
				48,	84,	69,	52,	97,
				9,	72,	67,	53,	84,
				65,	59,	3,	5,	29,
				53,	26,	45,	30,	46,
				87,	38,	76,	84,	74,
				66,	96,	32,	25,	28,
				90,	94,	63,	81, 53};
		
		nums = sort.bubbleSort(nums);
		
		for (int i = 0; i < nums.length; i ++) {
			System.out.println(nums[i]);
		}
		
	}

}
