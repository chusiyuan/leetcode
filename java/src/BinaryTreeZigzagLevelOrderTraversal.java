import java.util.*;

//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//        例如：
//        给定二叉树 [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回锯齿形层次遍历如下：
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            levels.add(new ArrayList<Integer>());
            int lens = queue.size();
            for(int i = 0; i < lens; i++) {
                TreeNode p = queue.poll();
                if (level % 2 == 0) {
                    levels.get(level).add(p.val);
                }
                else {
                    levels.get(level).add(0, p.val);//倒序输入数值满足要求，始终将其新的值放在最前面
                }
                if(p.left != null) queue.add(p.left);
                if(p.right != null) queue.add(p.right);
            }
            level++;
        }
        return levels;
    }

}
