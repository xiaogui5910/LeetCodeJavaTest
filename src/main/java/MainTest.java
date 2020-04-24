import leetcode.*;
import sort.*;

import java.util.*;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("hello world!");

        new SingleNumber_136().test();

        new SingleNumber_260().test();

        new BubbleSort().test();

        new SelectionSort().test();

        new InsertSort().test();

        new ShellSort().test();

        new MergeSort().test();

        new QuickSort().test();

        new HeapSort().test();

        new CountSort().test();

        new BucketSort().test();

        new RadixSort().test();

        new TwoSum_1().test();
        new ReverseInteger_7().test();
        new RomanToInteger_13().test();
        new LongestCommonPrefix_14().test();
        new ValidParentheses().test();
        new MergeTwoLists_21().test();
        new RemoveDuplicates_26().test();
        new RemoveElement_27().test();
        new StrStr_28().test();
        new SearchInsert_35().test();
        new CountAndSay_38().test();
        new MaxSubArray_53().test();
        new LengthOfLastWord_58().test();
        new PlusOne_66().test();
        new AddBinary_67().test();
        new Sqrt_69().test();
        new ClimbStairs_70().test();
        new DeleteDuplicates_83().test();
        new MergeSortedArray_88().test();
        new Message().test();
        new MaximumDepthOfBinaryTree_104().test();
        new BinaryTreeLevelOrderTraversal_107().test();
        new SortedArrayToBinarySearchTree_108().test();
        new MinimumDepthOfBinaryTree_111().test();
        new PathSum_112().test();
        new PalindromeString_125().test();
        new PascalsTriangle_119().test();
        new BestTimeToBuyAndSellStock_121().test();
        new BestTimeToBuyAndSellStock_122().test();
        new DiameterOfBinaryTree_543().test();

        new AddTwoNumbers_2().test();
        new AddTwoNumbers_445().test();
        new LongestSubstringWithoutRepeatingCharacters_3().test();

//        reviewSort();
    }

    private static void reviewSort() {
        int[] arr = {2, 6, 4, 1, 8, 7, 3, 5};
        Utils.printArr("maintest", arr);
//        bubble(arr);
//        selection(arr);
//        insert(arr);
//        shell(arr);
//        merge(arr);
//        quick(arr);
//        heap(arr);
//        count(arr);
        bucket(arr);
        Utils.printArr("maintest", arr);
    }

    private static void bucket(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int value :
                arr) {
            if (max < value) {
                max = value;
            }
            if (min > value) {
                min = value;
            }
        }

        //计算桶数量
        int bucketNum = (max-min)/arr.length+1;
        //创建桶集合
        ArrayList<ArrayList<Integer>> bucketList= new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new ArrayList<Integer>());
        }

        //将数组元素放入桶中
        for (int i = 0; i < arr.length; i++) {
            int index= (arr[i]-min)/arr.length;
            bucketList.get(index).add(arr[i]);
        }

        //取出桶内数据，并排序，放回原数组
        int index=0;
        for (int i = 0; i < bucketList.size(); i++) {
            ArrayList<Integer> dataList = bucketList.get(i);
            if (dataList.isEmpty()){
                continue;
            }
            Collections.sort(dataList);
            for (int j = 0; j < dataList.size(); j++) {
                arr[index++]=dataList.get(j);
            }
        }

    }

    private static void count(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int value :
                arr) {
            if (max < value) {
                max = value;
            }
            if (min > value) {
                min = value;
            }
        }

        int len = max - min+1;
        int[] countArr = new int[len];

        for (int value : arr) {
            countArr[value - min]++;
        }

        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    private static void heap(int[] arr) {
        //创建大顶堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            //交换第一个和最后一个元素
            Utils.swap(arr, 0, i);
            //排除最后一个元素后继续调整成大顶堆,此时只有第一个父结点没有调整，所以parent=0，调整长度len=i
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int parent, int length) {
        //记录父节点值
        int temp = arr[parent];
        int leftChild = 2 * parent + 1;

        while (leftChild < length) {
            int rightChild = leftChild + 1;
            //存在右结点，右结点大于左结点，取两者最大值去和父结点比较
            if (rightChild < length && arr[rightChild] > arr[leftChild]) {
                leftChild++;
            }

            //父结点大于所有子结点
            if (temp > arr[leftChild]) {
                break;
            }

            //交换父结点和左结点（子结点中较大值）
            arr[parent] = arr[leftChild];
            //继续向下比较
            parent = leftChild;
            leftChild = 2 * parent + 1;
        }
        //把和父结点交换的子结点，重新赋值temp
        arr[parent] = temp;

    }

    private static void quick(int[] arr) {
        quickArr(arr, 0, arr.length - 1);
    }

    private static void quickArr(int[] arr, int left, int right) {
        //递归跳出条件
        if (left >= right) {
            return;
        }
        //随机数组内一元素和最后一位交换，达到随机选取一个元素作为key效果
        int random = new Random().nextInt(right - left + 1);
        //数组从left开始，所以交换位置索引left+random
        Utils.swap(arr, left + random, right);

        //分组，大于key为一组放右边，小于key的为一组放左边
        int[] position = partition(arr, left, right, arr[right]);
        quickArr(arr, left, position[0] - 1);
        quickArr(arr, position[1] + 1, right);
    }

    private static int[] partition(int[] arr, int left, int right, int key) {
        int less = left - 1;
        int more = right + 1;
        int index = left;

        while (index < more) {
            //小于key处理
            if (arr[index] < key) {
                Utils.swap(arr, ++less, index++);
            } else if (arr[index] > key) {
                //此时index不+1，为了比较交换最后一位之后，最后一位还有和key作比较
                Utils.swap(arr, --more, index);
            } else {
                //和key相等则比较下一位
                index++;
            }
        }

        return new int[]{less + 1, more - 1};
    }

    private static void merge(int[] arr) {
        int[] tempArr = new int[arr.length];
        sort(arr, 0, arr.length - 1, tempArr);
    }

    private static void sort(int[] arr, int left, int right, int[] tempArr) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid, tempArr);
        sort(arr, mid + 1, right, tempArr);

        mergeArr(arr, left, right, mid, tempArr);
    }

    private static void mergeArr(int[] arr, int left, int right, int mid, int[] tempArr) {
        //左指针
        int i = left;
        //右指针
        int j = mid + 1;
        //临时指针
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tempArr[t++] = arr[i++];
            } else {
                tempArr[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            tempArr[t++] = arr[i++];
        }

        while (j <= right) {
            tempArr[t++] = arr[j++];
        }

        t = 0;
        while (left <= right) {
            arr[left++] = tempArr[t++];
        }
    }

    private static void shell(int[] arr) {
        //增量
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            //分组排序
            for (int i = increment; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - increment;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + increment] = arr[j];
                    j -= increment;
                }
                arr[j + increment] = temp;
            }
        }
    }

    private static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    private static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    private static void bubble(int[] arr) {
        //是否有序，默认无序，需要交换
        boolean isSwap = true;
        for (int i = 0; i < arr.length && isSwap; i++) {
            isSwap = false;
            for (int j = arr.length - 1 - 1; j >= i; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwap = true;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
