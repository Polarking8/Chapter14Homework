package Directory;

public class DirectoryTester {
    public static void main(String[] args) {
        DirectorySorter dirSort = new DirectorySorter();
        String s1 = "sec3_14.txt";
        String s2 = "sec10_1.txt";
        System.out.println("The lexicographical difference between the first and second text is:" + dirSort.compare(s1,s2));
    }
}
