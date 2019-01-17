package sorting;

public class Quick_Sort {

	public static void main(String[] args) {
		int arr[] = {10, 7, 8, 9, 1, 5};
		
		Quick_Sort qs = new Quick_Sort();
		qs.sort(arr,0,arr.length-1);
		
		System.out.println(" Sroted Array : ");
		qs.print(arr);
	}

	private void print(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
	}

	private void sort(int[] arr, int low, int high) {
		if(low < high) {
			int pi = partition(arr,low,high);
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}
	}

	private int partition(int[] arr, int low, int high) {
		int temp = 0;
		int pivot = arr[high];
		int i = (low-1);
		
		for(int j = low; j < high ; j++) {
			if(arr[j] <= pivot) {
				i++;
				
				temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
			}
		}
		temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return (i+1);
	}
}
