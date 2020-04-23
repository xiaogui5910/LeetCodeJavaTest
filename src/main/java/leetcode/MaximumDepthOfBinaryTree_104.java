package leetcode;

import javafx.util.Pair;
import sort.Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class MaximumDepthOfBinaryTree_104 {
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(solution(root.left), solution(root.right));
    }

    /**
     * bfs解法,队列
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        //当前节点加入到队列中，当前深度为1，
        queue.add(new Pair<TreeNode, Integer>(root, 1));
        while (!queue.isEmpty()) {
            //取出队列中第一个
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer currentLen = pair.getValue();

            //不为空则判断当前深度和最大深度
            if (node != null) {
                depth = Math.max(depth, currentLen);
                //下一层级加入到队列中，当前深度+1
                queue.add(new Pair<TreeNode, Integer>(node.left, currentLen + 1));
                queue.add(new Pair<TreeNode, Integer>(node.right, currentLen + 1));
            }
        }
        return depth;
    }

    /**
     * bfs解法2，队列
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //每一层级，深度+1
            depth++;
            //取出这一层级的所有节点
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                //将下一层有叶子结节点的加入到队列中
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return depth;
    }

    /**
     * dfs解法,栈
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int solution3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
        stack.push(new Pair<TreeNode, Integer>(root, 1));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            Integer currentLen = pair.getValue();
            depth = Math.max(depth, currentLen);
            //右边节点先入栈
            if (node.right != null) {
                stack.push(new Pair<TreeNode, Integer>(node.right, currentLen + 1));
            }
            if (node.left != null) {
                stack.push(new Pair<TreeNode, Integer>(node.left, currentLen + 1));
            }
        }
        return depth;
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
        int result = solution3(node);
        Utils.printNum(this, result);
    }
}
