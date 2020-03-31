package sort;

import java.util.Arrays;

public class SortUtils {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(String tag, int[] arr) {
        System.out.println();
        System.out.println(tag + "------------start_print_arr-----------");
        System.out.println(Arrays.toString(arr));
//        System.out.print("arr = {");
//        for (int i = 0; i < arr.length; i++) {
//            if (i == arr.length - 1) {
//                System.out.println(arr[i] + "} ");
//                break;
//            }
//            System.out.print(arr[i] + " , ");
//        }

        System.out.println("------------end_print_arr-----------");
    }
}
