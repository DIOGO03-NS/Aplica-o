public class MergeSort {

    static void mergesort(Aluno arr[]) {
		int n = arr.length;
		if (n < 2)
			return;
		int mid = n / 2;
		Aluno left[] = new Aluno[mid];
		Aluno right[] = new Aluno[n - mid];
		for (int i = 0; i < mid; i++)
			left[i] = arr[i];
		for (int i = mid; i < n; i++)
			right[i - mid] = arr[i];
		mergesort(left);
		mergesort(right);
		merge(arr, left, right);
	}

    public static void merge(Aluno arr[], Aluno left[], Aluno right[]) {
		int nL = left.length;
		int nR = right.length;
		int i = 0, j = 0, k = 0;
		while (i < nL && j < nR) {
			if (left[i].getNota() <= right[j].getNota()) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < nL) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < nR) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}
}
