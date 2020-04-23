package leetcode;

import sort.Utils;

/**
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 */
public class MinimumDepthOfBinaryTree_111 {
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = solution(root.left);
        int r = solution(root.right);
        //如果节点的左右深度都不是 0 的话，说明该节点含有左右子树，所以它的最小高度就是 1 加上其左右子树高度较小者
        if (l != 0 && r != 0) {
            return 1 + Math.min(l, r);
        }
        //如果左子树为空或者右子树为空或者两者都为空，那么就是 1 加上非空子树高度。
        return l + r + 1;
    }
    public void test() {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        int result = solution(node);
        Utils.printNum(this, result);
    }
}
