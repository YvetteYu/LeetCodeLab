import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TreeConstructor {

    public static String TreeConstructor(String[] strArr) {
        // code goes here
        Map<String, Set<String>> parentMap = new HashMap<>();
        Map<String, String> childMap = new HashMap<>();
        boolean isTree = true;

        for(String temp : strArr) {

            String[] tempArr = temp.replaceAll("\\(|\\)", "").split(",");

            if(!parentMap.containsKey(tempArr[1]))
                parentMap.put(tempArr[1], new HashSet());

            parentMap.get(tempArr[1]).add(tempArr[0]);

            if(parentMap.get(tempArr[1]).size() > 2) {
                isTree = false;
                break;
            }
            if(childMap.containsKey(tempArr[0]) && !childMap.get(tempArr[0]).equals(tempArr[1])) {
                isTree = false;
                break;
            } else {
                childMap.put(tempArr[0], tempArr[1]);
            }
        }

        Set<String> child = childMap.keySet();
        Set<String> root = new HashSet<>(parentMap.keySet());
        root.removeAll(child);

        if(root.size() != 1) {
            isTree = false;
        }

        return isTree ? "true" : "false";
    }

    public static void main(String[] args) {
        String[] stringArr =  {"(1,2)", "(3,2)", "(2,12)", "(5,2)"};
        System.out.println(TreeConstructor(stringArr));
    }
}
