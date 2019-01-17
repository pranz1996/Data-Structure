package sorting;

public class Count_Sort {

	public static void main(String[] args) {
		int arr[] = {6,0,2,0,1,3,4,6,1,3,2} ;
		int barr[] = new int[arr.length];
		applyCountSort(arr,barr);
		print(barr);
	}

	private static void print(int[] barr) {
		for(int i = 0; i < barr.length ; i++)
			System.out.print(barr[i] + " ");
	}

	private static void applyCountSort(int[] arr, int barr[]) {
		int max = arr[0];
		int min = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
			if(arr[i] < min)
				min = arr[i];
		}

		int temp[] = new int[max-min + 1];
		
		for(int i = 0; i < temp.length; i++)
			temp[i] = 0;
		
		for(int i = 0; i < arr.length; i++) {
			temp[arr[i]] = temp[arr[i]] + 1;
		}
		
		for(int i = 1; i < temp.length; i++)
			temp[i] = temp[i] + temp[i-1];
	
		
		for(int i = arr.length - 1 ; i >= 0; i--) {
		     barr[temp[arr[i]]-1]  = arr[i];
		     temp[arr[i]] -= 1;
		}
	}
}
