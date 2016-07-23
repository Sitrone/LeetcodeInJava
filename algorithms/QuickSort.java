public class QuickSort {
	public void quickSort(int[] arr, int low, int high) {
		if(low >= high){
			return ;
		}
		int mid = partion(arr, low, high);
		quickSort(arr, low, mid - 1);
		quickSort(arr, mid + 1, high);
	}

	private int partion(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low, j = high + 1;

		while (true) {
			while (less(arr[++i], pivot)) if (i == high) break;
			while (less(pivot, arr[--j])) if (j == low) break;
			// check if pointers cross
			if (i >= j) break;
			exch(arr, i, j);
		}
		// put partitioning item v at a[j]
		exch(arr, low, j);

		// now, a[low .. j-1] <= a[j] <= a[j+1 .. high]
		return j;
	}

	private boolean less(int v, int w) {
		return v < w ? true : false;
	}

	// exchange a[i] and a[j]
	private void exch(int[] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}