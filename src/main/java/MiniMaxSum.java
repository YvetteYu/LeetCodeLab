import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MiniMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Integer max = arr.get(0);
        Integer min = arr.get(0);

        for(Integer ele : arr) {
            if(ele > max) {
                max = ele;
            }
            if(ele < min) {
                min = ele;
            }
        }

        long sum = arr.stream()
                .collect(Collectors.summingLong(Integer::intValue));

        long maxSum = sum - Long.valueOf(min);
        long miniSum = sum - Long.valueOf(max);
        System.out.printf("%d %d", miniSum, maxSum);
    }

    public static void main(String[] args) {
        String temp = "396285104 573261094 759641832 819230764 364801279";
        Integer[] intArr = new Integer[5];
        int i = 0;
        for(String str : temp.split(" ")) {
            intArr[i] = new Integer(str);
            i++;
        }
        List<Integer> arr = Arrays.asList(intArr);
        miniMaxSum(arr);
    }
}
