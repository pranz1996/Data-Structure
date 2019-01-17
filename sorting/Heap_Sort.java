package sorting;

public class Heap_Sort {

	public static void main(String[] args) {
		int arr[] = {12,11,13,5,6,7};
		
		Heap_Sort hp = new Heap_Sort();
		hp.sort(arr);
		
		System.out.println(" Sorted Array : ");
		hp.print(arr);
	}

	private void print(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
	}
	
	private void sort(int[] arr) {
		int n = arr.length;
		
		for(int i = n/2 - 1; i >= 0 ; i--) {
			heapify(arr,n,i);
		}
		
		for(int i = n-1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, i, 0);
		}
	}

	private void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if(left < n && arr[left] > arr[largest])
			largest = left;
		if(right < n && arr[right] > arr[largest])
			largest = right;
		
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heapify(arr, n, largest);
		}
	}
}
