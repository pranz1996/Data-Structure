package sorting;


public class Merge_Sort {

	public static void main(String[] args) {
		
		int arr[] = {12,11,13,5,6,7};
		int temp[] = new int[arr.length];
		
		Merge_Sort ms = new Merge_Sort();
		ms.sortArray(temp, arr,0,arr.length-1);
		
		System.out.println(" Sorted Array : ");
		ms.print(temp);
	}
	
	private void print(int[] arr) {
		for(int i = 0 ; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	private void sortArray(int temp[], int[] arr, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			sortArray(temp, arr, low, mid);
			sortArray(temp, arr, mid+1, high);
			merge(temp, arr, low, mid, high);
		}
	}

	private void merge(int temp[], int[] arr, int low, int mid, int high) {
		int i = low, j = mid + 1, k = low;
		
		while(i <= mid && j <= high) {
			if(arr[i] <= arr[j])
				temp[k++] = arr[i++]; 
			else{
				temp[k++] = arr[j++];
			}
		}
		while(i <= mid) {
			temp[k++] = arr[i++];
		}
		while(j <= high) {
			temp[k++] = arr[j++];
		}
		
	}

}
