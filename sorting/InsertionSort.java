package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = new int[]{12, 11,13,5,6};
		InsertionSort is = new InsertionSort();
		is.insertionSort(arr);
		
		System.out.println("\n Sorted Array : ");
		is.printArray(arr);
	}

	private void insertionSort(int[] arr) {
		int n = arr.length;
		for(int i = 1; i < n ; i++) {
			int key = arr[i];
			int j = i - 1;
			
			while( j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j]; 
				j--;
			}
			arr[j+1] = key; 
		}
	}

	private void printArray(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
	}

}
