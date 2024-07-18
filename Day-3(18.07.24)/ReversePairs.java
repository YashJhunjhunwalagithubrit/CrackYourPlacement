class ReversePairs {
    public int reversePairs(int[] nums) {
        return invCount(nums, 0, nums.length - 1);
    }

    public int invCount(int[] A, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int a = invCount(A, left, mid);
        int b = invCount(A, mid + 1, right);
        int aWithB = mergeSort(A, left, mid, right);
        return a + b + aWithB;
    }

    public int mergeSort(int[] A, int left, int mid, int right) {
        int count = 0;
        int i = left, j = mid + 1;
        
        // Count the reverse pairs
        for (i = left; i <= mid; i++) {
            while (j <= right && (long)A[i] > 2 * (long)A[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // Merge the two halves
        i = left;
        j = mid + 1;
        int k = 0;
        int[] C = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = A[j++];
            }
        }
        while (i <= mid) {
            C[k++] = A[i++];
        }
        while (j <= right) {
            C[k++] = A[j++];
        }

        // Copy the merged array back into the original array
        for (k = 0; k < C.length; k++) {
            A[left + k] = C[k];
        }

        return count;
    }
}
