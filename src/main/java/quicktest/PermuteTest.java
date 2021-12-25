package quicktest;

import sort.Utils;

import java.util.*;

/**
 * Created by xiaogui on 2021/12/25.
 */
public class PermuteTest {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans =new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len ==0){
            return ans;
        }

        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[len];
        dfs(nums,len,0,path,used,ans);

        return ans;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> ans) {
        if (depth==len){
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]){
                path.addLast(nums[i]);
                used[i]=true;
                dfs(nums,len,depth+1,path,used,ans);
                path.removeLast();
                used[i] = false;
            }
        }
    }


    //    public List<List<Integer>> permute(int[] nums) {
//        int len = nums.length;
//        // 使用一个动态数组保存所有可能的全排列
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        if (len == 0) {
//            return res;
//        }
//
//        boolean[] used = new boolean[len];
//        Deque<Integer> path = new ArrayDeque<Integer>(len);
//
//        dfs(nums, len, 0, path, used, res);
//        return res;
//    }
//
//    private void dfs(int[] nums, int len, int depth,
//                     Deque<Integer> path, boolean[] used,
//                     List<List<Integer>> res) {
//        if (depth == len) {
//            res.add(new ArrayList<Integer>(path));
//            return;
//        }
//
//        for (int i = 0; i < len; i++) {
//            if (!used[i]) {
//                path.addLast(nums[i]);
//                used[i] = true;
//
//                System.out.println("  递归之前 => " + path);
//                dfs(nums, len, depth + 1, path, used, res);
//
//                used[i] = false;
//                path.removeLast();
//                System.out.println("递归之后 => " + path);
//            }
//        }
//    }
    public void test() {
        int[] nums = {1, 2, 3};
        Utils.printArr(this.toString(), nums);
        List result = permute(nums);
        Utils.printNum(this, result);

    }


}
