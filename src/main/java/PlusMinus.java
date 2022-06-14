import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

    class Result {

        /*
         * Complete the 'plusMinus' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static void plusMinus(List<Integer> arr) {
            // Write your code here
            HashMap<Integer, Integer> countSighMap = new HashMap<>();
            countSighMap.put(1, 0);
            countSighMap.put(-1, 0);
            countSighMap.put(0, 0);
            for (int item : arr) {
                if (item > 0) {
                    countSighMap.put(1, countSighMap.get(1) + 1);
                } else if (item < 0) {
                    countSighMap.put(-1, countSighMap.get(-1) + 1);
                } else {
                    countSighMap.put(0, countSighMap.get(0) + 1);
                }
            }
            int arrSize = arr.size();
            System.out.printf("%.6f\n", (float) countSighMap.get(1) / arrSize);
            System.out.printf("%.6f\n", (float) countSighMap.get(-1) / arrSize);
            System.out.printf("%.6f\n", (float) countSighMap.get(0) / arrSize);
        }
    }
    public class PlusMinus {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            Result.plusMinus(arr);

            bufferedReader.close();
        }
    }



