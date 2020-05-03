/*
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
        1.二叉树的根是数组中的最大元素。
        2.左子树是通过数组中最大值左边部分构造出的最大二叉树。
        3.右子树是通过数组中最大值右边部分构造出的最大二叉树。
        通过给定的数组构建最大二叉树，并且输出这个树的根节点。
        示例 ：
        输入：[3,2,1,6,0,5]
        输出：返回下面这棵树的根节点：

          6
        /   \
       3     5
       \    /
        2  0
         \
         1

        提示：给定的数组的大小在 [1, 1000] 之间。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/maximum-binary-tree
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
import java.util.Arrays;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums.length == 0) {
            return null;
        }
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
        return root;
    }

    public static void main(String[] args) {
        MaximumBinaryTree sln = new MaximumBinaryTree();
        int[] arr = {3, 2, 1, 6, 0, 5};
        TreeNode root = sln.constructMaximumBinaryTree(arr);
    }
}