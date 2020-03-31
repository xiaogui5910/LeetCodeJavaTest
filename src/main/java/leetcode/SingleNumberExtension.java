package leetcode;

import java.util.HashMap;
import java.util.Set;

/**
 * 进阶版
 * 有一个 n 个元素的数组，除了两个数只出现一次外，其余元素都出现两次，让你找出这两个只出现一次的数分别是几，要求时间复杂度为 O(n) 且再开辟的内存空间固定(与 n 无关)。
 * <p>
 * 示例 :
 * 输入: [1,2,2,1,3,4]
 * 输出: [3,4]
 * <p>
 * 解法1：
 * 1、思路：
 * (1)对于出现两次的元素，使用“异或”操作后结果肯定为0，那么我们就可以遍历一遍数组，对所有元素使用异或操作，那么得到的结果就是两个出现一次的元素的异或结果。
 * (2)因为这两个元素不相等，所以异或的结果肯定不是0，也就是可以再异或的结果中找到1位不为0的位，例如异或结果的最后一位不为0。
 * (3)这样我们就可以最后一位将原数组元素分为两组，一组该位全为1，另一组该位全为0。
 * (4)再次遍历原数组，最后一位为0的一起异或，最后一位为1的一起异或，两组异或的结果分别对应着两个结果。
 * 2、复杂度：
 * （1）时间复杂度：第一次循环，将所有元素异或得到对应结果，时间开销为O(n)；第二次循环，找出第一次异或结果为1的位，时间开销为O(32)；第三次循环，根据为1的位将元素分为两组进行异或得到两个结果，时间复杂度为O(n)，所以总的时间复杂度为T(n) = 2*O(n)+O(32) = O(n)。
 * （2）空间复杂度：常数，因为只分配了两个空间用于结果的保存，因此空间复杂度为常数。
 */
public class SingleNumberExtension {
    public int[] singleNumberExtension(int[] arr) {
        int[] resultArr = new int[2];
        //数组内元素异或，结果就是两个不同数的异或结果
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        //找到两个数异或结果的二进制位为1的索引
        int index = 0;
        for (int i = 0; i < 32; i++) {
            if (((result >> i) & 1) == 1) {
                index = i;
                break;
            }
        }

        //二进制位为1的异或是一个结果数 位为0的异或为另一个结果
        for (int i = 0; i < arr.length; i++) {
            if (((arr[i] >> index) & 1) == 1) {
                resultArr[0] ^= arr[i];
            } else {
                resultArr[1] ^= arr[i];
            }
        }

        return resultArr;
    }

    public void test() {
        System.out.println();
        int[] arr = {1, 2, 2, 1, 3, 4};
        System.out.print("arr[]=");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        int[] result = singleNumberExtension(arr);

        System.out.println();
        System.out.print("resultArr[]=");
        for (int i = 0; i < result.length; i++) {
            System.out.print(" " + result[i]);
        }
    }

    /**
     * 解法2：
     * （1）思路：这个可以可以使用一个Map，Map对应的键值key就是数组中的元素，value就是这个元素出现的次数。这样我
     * 通过一次遍历数组中的元素，如果元素出现在map中，则将其对应的value加1，否则将元素添加到map中，这样遍历一遍数组，我们就可以得到数组中每个元素对应出现的次数，然后再通过遍历一遍map，返回value为1对应的key就是我们需要求得元素。
     * （2）时间复杂度：因为首先需要遍历一遍数组，时间开销为O(n)，构建完map后需要遍历一遍map找到value为1的元素，而map的个数为n/2，时间开销为O(n/2)，所以总的时间开销为O(n)。
     * （3）空间复杂度：因为需要建立一个map，而且最后map的大小为n/2，所以空间复杂度为O(n)。
     *
     * @param arr 数组
     * @return 结果
     */
    public int[] singleNumberExtension1(int[] arr) {
        int[] resultArr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], 2);
            } else {
                map.put(arr[i], 1);
            }
        }
        Set<Integer> integers = map.keySet();
        int index = 0;
        for (int i : integers) {
            resultArr[index++] = i;
        }
        return resultArr;
    }
}
