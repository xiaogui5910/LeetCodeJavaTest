package sort;

public class HeapSort {
    private void heapSortSolution(int[] arr) {
        //创建大顶堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点，从下至上，从右至左,调整堆
            adjustHeap(arr, i, arr.length);
        }

        //调整排序
        for (int i = arr.length - 1; i >= 0; i--) {
            //交换堆顶和堆尾
            SortUtils.swap(arr, 0, i);

            //重新调整,此时len = i
            adjustHeap(arr, 0, i);
        }

    }
    public void test() {
        int[] testArr = {1, 6, 3, 8, 2, 4, 7, 5};
        SortUtils.printArr(this.getClass().getSimpleName(),testArr);

        heapSortSolution(testArr);
        SortUtils.printArr(this.getClass().getSimpleName(),testArr);
    }

    private void adjustHeap(int[] arr, int i, int length) {
        int parent = i;

        //记录父结点值
        int temp = arr[parent];

        //左子结点
        int leftChild = 2 * parent + 1;

        //存在着左结点
        while (leftChild < length) {
            //右结点
            int rightChild = leftChild + 1;
            //如果存在右结点，并且左结点小于右结点，则选择右结点去和父结点比较
            if (rightChild < length && arr[leftChild] < arr[rightChild]) {
                leftChild++;
            }

            //如果父结点大于所有子结点（因为之前左右结点已经比较过），则不用处理
            if (temp > arr[leftChild]) {
                break;
            }

            //父节点设置为左子结点值
            arr[parent] = arr[leftChild];

            //往下继续比较调整，如果有的话,leftChild<length条件符合继续
            parent = leftChild;
            leftChild = parent * 2 + 1;
        }

        //把父结点的值设置给调整了的子结点
        arr[parent] = temp;
    }

}
