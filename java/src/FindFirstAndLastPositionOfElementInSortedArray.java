//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//你的算法时间复杂度必须是 O(log n) 级别。
//如果数组中不存在目标值，返回 [-1, -1]。
//        示例 1:
//        输入: nums = [5,7,7,8,8,10], target = 8
//        输出: [3,4]
//        示例 2:
//        输入: nums = [5,7,7,8,8,10], target = 6
//        输出: [-1,-1]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) { //找左边界
            int m = l + (h - l) / 2;
            if (nums[m] == target) {
                if (m == 0 || nums[m - 1] < target) {
                    result[0] = m;
                    break;
                }
            }
            if (nums[m] >= target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        int l1 = 0;
        int h1 = nums.length - 1;
        while (l1 <= h1) { //找右边界
            int m1 = l1 + (h1 - l1) / 2;
            if (nums[m1] == target) {
                if (m1 == nums.length - 1 || nums[m1 + 1] > target) {
                    result[1] = m1;
                    break;
                }
            }
            if (nums[m1] <= target) {
                l1 = m1 + 1;
            } else {
                h1 = m1 - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(solution.searchRange(nums, target)[0]);
        System.out.println(solution.searchRange(nums, target)[1]);
    }
}
