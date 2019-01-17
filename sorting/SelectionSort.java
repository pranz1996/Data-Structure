package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = new int[]{12, 11,13,5,6};
		SelectionSort is = new SelectionSort();
		is.selection_Sort(arr);
		
		System.out.println("\n Sorted Array : ");
		is.printArray(arr);
	}

	private void selection_Sort(int[] arr) {
		int n = arr.length;
		for(int i = 0 ; i < n - 1 ; i++) {
			int min = i;
			for(int j = i + 1 ; j < n ; j++) {
				if(arr[j] < arr[min])
					min = j;
			}
			if(min != i) {
				int temp = arr[i]; arr[i] = arr[min]; arr[min] = temp;
			}
		}
	}

	private void printArray(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
	}

}
