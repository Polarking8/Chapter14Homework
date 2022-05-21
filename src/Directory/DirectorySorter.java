package Directory;

import java.util.*;

public class DirectorySorter implements Comparator<String>{
    /**
     * @param strNum string to test if numeric
     * @return returns if the string is numeric
     */
    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * @param file1 the first file to compare
     * @param file2 the second file to compare
     * @return the lexicographic difference of the files
     */
    public int compare(String file1, String file2) {
        if (!isNumeric(file1.substring(0,1)) && !isNumeric(file2.substring(0,1))) {
            ArrayList<String> group1 = findGroups(file1);
            ArrayList<String> group2 = findGroups(file2);
            if (group1.size() < group2.size()) {
                for (int i = 0; i < group2.size() - group1.size(); i++) {
                    group1.add("0");
                }
            } else {
                for (int i = 0; i < group1.size() - group2.size(); i++) {
                    group2.add("0");
                }
            }
            if (!group1.get(0).equals(group2.get(0))) {
                return group1.get(0).compareTo(group2.get(0));
            }
            for (int i = 1; i < group1.size(); i++) {
                int number1 = Integer.parseInt(group1.get(i));
                int number2 = Integer.parseInt(group2.get(i));
                if (number1 != number2) {
                    return number1 - number2;
                }
            }
            return 0;
        }
        else if (isNumeric(file1.substring(0, 1)) && isNumeric(file2.substring(0, 1))) {
            ArrayList<String> group1 = findGroups(file1);
            ArrayList<String> group2 = findGroups(file2);
            if (group1.size() < group2.size()) {
                for (int i = 0; i < group2.size() - group1.size(); i++) {
                    group1.add("0");
                }
            } else {
                for (int i = 0; i < group1.size() - group2.size(); i++) {
                    group2.add("0");
                }
            }
            for (int i = 1; i < group1.size(); i++) {
                int number1 = Integer.parseInt(group1.get(i));
                int number2 = Integer.parseInt(group2.get(i));
                if (number1 != number2) {
                    return number1 - number2;
                }
            }
            return 0;
        } else {
            return file1.compareTo(file2);
        }
    }

    /**
     * @param file the file being fed in to separate into different strings
     * @return an array of the parts of the string (numbers, letters, etc.)
     */
    public ArrayList<String> findGroups(String file) {
        ArrayList<String> result = new ArrayList<>();
        boolean stringFound;
        stringFound = isNumeric(file.substring(0, 1));
        int startIndex = 0;
        for (int i = 0; i < file.length(); i++) {
            if (!stringFound && isNumeric(file.substring(i, i + 1))) {
                result.add(file.substring(0, i));
                stringFound = true;
                startIndex = i;
                if (i == file.length() -1) {
                    result.add(file.substring(i));
                }
            } else if (stringFound && isNumeric(file.substring(i, i + 1)) && startIndex < 0) {
                startIndex = i;
                if (i == file.length() -1) {
                    result.add(file.substring(i));
                }
            } else if (stringFound && isNumeric(file.substring(i, i + 1)) && startIndex >= 0 && i == file.length() - 1) {
                result.add(file.substring(startIndex, i + 1));
                startIndex = -1;
            } else if (stringFound && !isNumeric(file.substring(i, i + 1)) && startIndex >= 0) {
                result.add(file.substring(startIndex, i));
                startIndex = -1;
            } else if (!stringFound && !isNumeric(file.substring(i, i + 1)) && i == file.length() - 1) {
                result.add(file);
            }
        }
        return result;
    }
}


