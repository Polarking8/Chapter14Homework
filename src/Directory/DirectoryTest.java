package Directory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectoryTest {
    @Test
    void compareTest(){
        DirectorySorter dirSort = new DirectorySorter();
        String s1 = "seC10_1.txt";
        String s2 = "sec10_1.txt";
        Assertions.assertEquals(32,dirSort.compare(s2,s1));
    }
    @Test
    void findGroupTest() {
        DirectorySorter dirSort = new DirectorySorter();
        String s1 = "sec4_89";
        Assertions.assertEquals("[sec, 4, 89]", dirSort.findGroups(s1));
        // for some reason when I run this, even though they're identical, it says the test fails.
    }

}
