package MergeSort;

public class MergeSortLexicographic {
    /**
     * @param inputArr the array of strings to input
     * @param low the beginning of the array
     * @param high the end of the array
     * @return returns the sorted array
     */
    public static String[] mergeSort(String[] inputArr, int low, int high) {
        if (low == high) {
            return new String[]{inputArr[low]};
        }
        int mid = low + (high - low) / 2;
        String[] arr1 = mergeSort(inputArr, low, mid);
        String[] arr2 = mergeSort(inputArr, mid + 1, high);
        return merge(arr1, arr2);
    }
    /**
     * @param Arr1 first array to put in to merge
     * @param Arr2 second array to put in to merge
     * @return the merged single array
     */
    private static String[] merge(String[] Arr1, String[] Arr2) {
        int m = Arr1.length;
        int n = Arr2.length;
        String[] Arr3 = new String[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (isAlphabeticallySmaller(Arr1[i], Arr2[j])) {
                Arr3[index] = Arr1[i];
                i++;
            } else {
                Arr3[index] = Arr2[j];
                j++;
            }
            index++;
        }
        while (i < m) {
            Arr3[index] = Arr1[i];
            i++;
            index++;
        }
        while (j < n) {
            Arr3[index] = Arr2[j];
            j++;
            index++;
        }
        return Arr3;
    }
    /**
     * sorts the strings, if one is lexicographically less than the other, then it switches.
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return returns if string 1 is less than string 2 alphabetically.
     */
    private static boolean isAlphabeticallySmaller(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        return str1.compareTo(str2) < 0;
    }
}
