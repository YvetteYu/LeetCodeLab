import java.util.Arrays;
import java.util.List;

public class AlternatePrime {

    private static int kickoutMinNum(List<Integer> list) {
        int minPrime = 0;
        int minNonPrime = 0;
        int countPrime = 0;
        int countNonPrime = 0;
        for(int n : list) {
            if(isPrime(n)) {
                countPrime++;
                if(countPrime == 1 || n < minPrime)
                    minPrime = n;
            } else {
                countNonPrime++;
                if(countNonPrime == 1 || n < minNonPrime)
                    minNonPrime = n;
            }
        }
        return countPrime > countNonPrime ? minPrime : minNonPrime;
    }

    private static boolean isPrime(int n) {
        if(n < 2)
            return false;
        boolean nonPrime = false;
        int square = (int)(Math.sqrt(n));
        int i = 2;
        while(i <= square) {
            if(n % i == 0) {
                nonPrime = true;
                break;
            }
            i++;
        }
        return !nonPrime;
    }

    public static void main(String[] args) {
        Integer[] array1 = {1, 11, 13, 4, 18};
        System.out.println(kickoutMinNum(Arrays.asList(array1)));
        Integer[] array2 = {2, 11, 13, 4, 18};
        System.out.println(kickoutMinNum(Arrays.asList(array2)));
        Integer[] array3 = {5, 11, 13, 4, 18, 19, 36};
        System.out.println(kickoutMinNum(Arrays.asList(array3)));
    }
}
