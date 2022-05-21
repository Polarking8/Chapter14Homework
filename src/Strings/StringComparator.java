package Strings;

import java.util.Comparator;

public class StringComparator implements Comparator<String>{

    public int compare(String s1, String s2){
        if(s1.length()!= s2.length()){
            return s1.length()-s2.length();
        } else{
            return(s1.compareTo(s2));
        }

    }
}
