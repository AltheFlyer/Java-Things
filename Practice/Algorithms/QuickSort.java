
public class QuickSort {
	
	int list[];
	
	public int[] quickSort(int low, int high) {
		//lowest and highest indices to search in (used in recursion)
		int i = low;
		int j = high;
		//pivot is the index in the middle of the array
		int pivot = list[low + (high-low) / 2];
		int temp;
		
		while (i <= j) {
			//Check for the first index lower than pivot with a higher value
			while (list[i] < pivot) {
				i ++;
			}
			//Check for the first index higher than pivot with a lower value
			while (list[j] > pivot) {
				j --;
			}
			//Swap the two above found values
			if (i <= j) {
				temp = list[i];
				list[i] = list[j];
				list[j] = temp;
				i ++;
				j --;
			}
		}
		
		//Now do the same for the two newly created sets
		//This is recursive, and won't end until lists are sorted
		if (low < j) {
			quickSort(low, j);
		}
		if (i < high) {
			quickSort(i, high);
		}
		return list;
	}
	
	public static void main(String[] args) {
		
		QuickSort sort = new QuickSort();
		int nums[] = {63, 66, 67, 58, 56,
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
		
		sort.list = nums;
		nums = sort.quickSort(0, nums.length - 1);
		
		for (int i = 0; i < nums.length; i ++) {
			System.out.println(nums[i]);
		}
		
	}

}
