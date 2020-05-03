//给你一个整数数组 nums，请你将该数组升序排列。
//        示例 1：
//        输入：nums = [5,2,3,1]
//        输出：[1,2,3,5]
//        示例 2：
//        输入：nums = [5,1,1,2,0,0]
//        输出：[0,0,1,1,2,5] 
//        提示：
//        1 <= nums.length <= 50000
//        -50000 <= nums[i] <= 50000
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/sort-an-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int rand = l + (int) (Math.random() * (r - l + 1));
        swap(nums, rand, r);
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] < nums[r]) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
