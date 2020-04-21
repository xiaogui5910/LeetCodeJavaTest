package leetcode;

/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 */
public class BalancedBinaryTree_110 {
    public boolean solution(TreeNode root) {
        return helper(root) != -1;
    }

    /**
     * 判断是否为高度平衡
     *
     * @param root 根节点
     * @return 结果，-1：不是高度平衡
     */
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNum = helper(root.left);
        //如果子节点中已发现高度大于1则直接判断不是高度平衡
        if (leftNum == -1) {
            return -1;
        }
        int rightNum = helper(root.right);
        if (rightNum == -1) {
            return -1;
        }
        //判断两个子节点高度是否大于1
        if (Math.abs(leftNum - rightNum) > 1) {
            return -1;
        }
        return 1 + Math.max(leftNum, rightNum);
    }
}
