package MergeSort;

public class MergeSortTester {
    public static void main(String[] args) {
        String[] Array = { "Hoth", "Kamino", "Tatooine", "Yavin", "Naboo","Mandalore", "Mustafar", "Geonosis", "Kashyyk","Mon Cala"};
        String[] sortedArray = MergeSortLexicographic.mergeSort(Array, 0, Array.length - 1);
        for (String s : sortedArray) {
            System.out.println(s);
        }
    }
}

