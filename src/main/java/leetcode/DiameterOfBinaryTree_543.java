package leetcode;

import sort.Utils;

/**
 * 543. 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 算出二叉树中最远的两个节点的距离，分别计算左右子树的最大高度，然后不断迭代出其和的最大值就是最终结果。
 */
public class DiameterOfBinaryTree_543 {
    int max = 0;

    public int solution(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        if (l + r > max) {
            max = l + r;
        }
        return Math.max(l, r) + 1;
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
