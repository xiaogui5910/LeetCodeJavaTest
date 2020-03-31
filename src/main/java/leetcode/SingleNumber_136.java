package leetcode;

import org.apache.log4j.Logger;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 *解法：异或
 *
 * 异或运算的特点：两个相同的数字异或，结果为0。
 *
 * 因为数组中除了一个元素只出现一次之外，其它的元素都出现两次，如果把所有的数都异或，
 * 相同的数字异或为0，最后只剩下出现一次的数字，它和0异或，结果就是它本身。
 */
public class SingleNumber_136 {
    public int singleNumber(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        return result;
    }

    public void test() {
        Logger logger = Logger.getLogger(Logger.class);
        int[] arr = {4, 1, 2, 1, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }

        System.out.println();
        int result = singleNumber(arr);
        logger.debug(result);
    }

}
