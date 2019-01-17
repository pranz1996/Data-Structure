package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort bb = new BubbleSort();
		int arr[]  = {64, 34,25,12,22,11,90};
		bb.bubble(arr);
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	private void bubble(int[] arr) {
		int n = arr.length;
		boolean swap = false;
		for(int i = 0 ; i < n-1; i++) {
			swap = false;
			for(int j = 0 ; j < n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap = true;
				}
			}
		}
		if(swap == false) {
			return;
		}
	}

}
