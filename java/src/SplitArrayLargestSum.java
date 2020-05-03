//https://leetcode-cn.com/problems/split-array-largest-sum/

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int l = Integer.MIN_VALUE;
        int h = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > l) l = nums[i];
            h += nums[i];
        }
        while(l <= h) {
            int mid = l + (h-l)/2;
            int sum = 0;
            int count = 1;
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if(sum > mid) {
                    sum = nums[i];
                    count++;
                }
            }
            if(count > m) l = mid + 1;
            else h = mid - 1;
        }
        return l;
    }
}
