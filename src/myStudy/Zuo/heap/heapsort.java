package myStudy.Zuo.heap;

import java.util.Arrays;

public class heapsort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 5, 7, 9, 5, 7, 0, 2, 3, 45};//大根堆{5，4，3，1，2}
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapIns(int[] arr, int index) {//上浮
        int father = (index - 1) / 2;
        while (arr[index] > arr[father]) {//控制终止条件：1.index到顶 2.父节点较大
            swap(arr, index, father);
            index = father;
            father = (index - 1) / 2;
        }
    }

    public static void heapIfy(int[] arr, int index, int heapSize) {//下沉
        int leftSon = 2 * index + 1;
        while (leftSon < heapSize) {//左孩子如果越界，则右孩子必然越界，跳出循环
            // 两个孩子中，谁的值大，把下标给largest
            // 1）只有左孩子，left -> largest
            // 2) 同时有左孩子和右孩子，右孩子的值<= 左孩子的值，left -> largest
            // 3) 同时有左孩子和右孩子并且右孩子的值> 左孩子的值， right -> largest
            int largest = (leftSon + 1 >= heapSize) || (arr[leftSon] > arr[leftSon + 1]) ? leftSon : leftSon + 1;//取得两个孩子中较大的孩子,注意heapSize位置的前一个位置是堆的最后一个数据，所以下标=heapSize即为越界
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {//如果当前位置比子节点大，则不用处理
                break;
            }
            swap(arr, index, largest);//如果子节点大，将子节点与当前节点交换
            index = largest;
            leftSon = 2 * index + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {//将数组变成大根堆 方法1：从上到下 O(N*logN)
//            heapIns(arr, i);
//        }
        int heapSize = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {//将变成大根堆 方法2：从下到上 O(N)（假设已经是大根堆，从后向前看看能不能下沉）
            heapIfy(arr, i, heapSize);
        }
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);//把最大的值与堆中最后一个位置交换
            heapIfy(arr, 0, heapSize);//将换过来的数下沉到正确位置，数组依然是大根堆
        }
    }
}
