package Strings;

import java.util.Arrays;

public class StringComparatorTester {
    public static void main(String[] args) {
        String[] words = new String[]{"apple", "Apple", "phone", "book", "cook", "anomalous", "cat", "shake"};

        Arrays.sort(words, new StringComparator());
        System.out.println("Sorted Words: "+ Arrays.toString(words));
    }
}
