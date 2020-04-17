package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SymmetricTree_101 {
    public boolean solution(TreeNode root) {
        if (root == null || root.left == null || root.right == null) {
            return false;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return check(left.left, right.right) && check(left.right, right.left);
        }

        return false;
    }

    public boolean solution1(TreeNode root) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> list = new Stack<TreeNode>();
        list.add(root.left);
        list.add(root.right);
        while (list.size() != 0) {
            TreeNode left = list.pop();
            TreeNode right = list.pop();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }

            if (left.val == right.val) {
                list.add(left.left);
                list.add(right.right);
                list.add(left.right);
                list.add(right.left);
            } else {
                return false;
            }
        }

        return true;
    }
}
