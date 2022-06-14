import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> numIndex = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(numIndex.containsKey(diff)) {
                ans[0] = numIndex.get(diff);
                ans[1] = i;
                System.out.println("first index = " + ans[0]);
                System.out.println("second index = " + ans[1]);
                break;
            }
            numIndex.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,3,6};
        int target = 6;
        TwoSum process = new TwoSum();
        process.twoSum(nums, target);
    }
}
