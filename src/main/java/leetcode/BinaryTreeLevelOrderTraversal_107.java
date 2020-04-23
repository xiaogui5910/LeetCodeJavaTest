package leetcode;

import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversal_107 {

    /**
     * BFS
     * 常规的层序遍历稍加修改。一次把同一层的顶点全取出来，并把属于下一层的所有顶点一次性入队。然后每次都将subList插入到res的开头。
     *
     * @param root 根节点
     * @return 结果
     */
    public List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //在索引为0的位置插入
            list.add(0, subList);
        }
        return list;
    }

    /**
     * DFS
     * 递归遍历，但是多使用一个形参，记录当前层号。
     * 如果子列表的数量小于层数，说明第一次到达该层，为结果添加一个子列表。注意为了实现自底向上输出，每次都将子列表添加到结果的开头。
     * 子列表的下标对应的是自底向上遍历时结点所在的层号，即0对应最后一层。
     * 然后对遍历到的顶点，将其添加到所在层号对应的子列表中即可。
     *
     * @param root 根节点
     * @return 结果
     */
    public List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (root == null) {
            return list;
        }
        getSubList(list, root, 1);

        return list;
    }

    private void getSubList(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        //集合里面数量小于当前层级，说明第一次进入该层
        if (list.size() < level) {
            //索引为0的位置插入新列表
            list.add(0, new ArrayList<Integer>());
        }
        //根据当前level取出对应列表
        List<Integer> subList = list.get(list.size() - level);
        subList.add(root.val);

        //计算下一层
        getSubList(list, root.left, level + 1);
        getSubList(list, root.right, level + 1);

    }

    public void test() {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node2.right = node4;

        List<List<Integer>> list = solution1(node);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subLit = list.get(i);
            System.out.print("[");
            for (int j = 0; j < subLit.size(); j++) {
                System.out.print(subLit.get(j) + " ");
            }
            System.out.print("]");
        }
    }
}
