//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//        示例 1:
//        输入: [3,2,1,5,6,4] 和 k = 2
//        输出: 5
//        示例 2:
//        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//        输出: 4
//        说明:
//        你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int i = partition(nums, l, r);
            if (i+1 == k) {
                break;
            } else if (i+1 > k) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return nums[k-1];
    }

    public int partition(int[] nums, int p, int r) {
        int num=p+(int)(Math.random()*(r-p+1));
        swap(nums,num,r);
        int flag = nums[r];
        int i = p - 1;
        for (int j = i + 1; j < r; j++) {
            if (nums[j] > flag) {
                i++;
                swap(nums,i,j);
            }
        }
        nums[r] = nums[i + 1];
        nums[i + 1] = flag;
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
