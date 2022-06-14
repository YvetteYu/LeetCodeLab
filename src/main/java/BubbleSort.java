import java.util.*;

public class BubbleSort {

    private void sort(Integer[] intArray) {
        int bribes = 0;
        for(int i = 0; i < intArray.length -1; i++) {
            int j = i;
            while(j >= 0 && intArray[j+1] < intArray[j]) {
                swap(intArray, j, j+1);
                bribes++;
                j--;
            }
        }
        System.out.println(bribes);
        System.out.println(Arrays.toString(intArray));
    }

    private void swap(Integer[] array, int index1, int index2) {
        int tempInt = 0;
        tempInt = array[index1];
        array[index1] = array[index2];
        array[index2] = tempInt;
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("21534 21543".split(" "));
        BubbleSort bubble = new BubbleSort();

        for(String temp : list) {
            Integer[] intArray = new Integer[temp.trim().length()];
            char[] charArray = temp.toCharArray();
            for(int i = 0; i < charArray.length; i++) {
                intArray[i] = Character.getNumericValue(charArray[i]);
            }
            bubble.sort(intArray);
        }
    }
}
