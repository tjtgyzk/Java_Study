package myStudy.Zuo.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class NiuBiHeap<T> {
    private ArrayList<T> heap; //堆结构
    private HashMap<T, Integer> indexMap;//反向索引表 Key:元素 Value：位置
    private int heapSize;
    private Comparator<? super T> comparator;//比较器  ？泛型？待解决

    public NiuBiHeap(Comparator<T> comparator) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        this.comparator = comparator;
    }

    //交换，同时交换位置信息
    private void swap(int i, int j) {
        //提取这两个位置的数据
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        //在交换后的位置放入数据
        heap.set(i, o2);
        heap.set(j, o1);
        //更新位置数据
        indexMap.put(o2, i);
        indexMap.put(o1, j);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean isContains(T o) {
        return indexMap.containsKey(o);
    }

    public void push(T o) {
        heap.add(o);
        indexMap.put(o, heapSize);
        heapInsert(heapSize++);
    }

    public T pop() {
        T ans = heap.get(0);

        swap(0, heapSize - 1);
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapIfy(0);

        return ans;
    }

    public T peek() {
        return heap.get(0);
    }

    public void remove(T o) {
        T replace = heap.get(heapSize - 1);//先把最后一个位置的值拿出来
        int index = indexMap.get(o);//找到要删除位置的索引
        indexMap.remove(o);//先删除该元素的索引
        heap.remove(--heapSize);//删除最后一个元素，之前已经保存过该元素
        if (index == heapSize - 1) {//如果待删除元素就是堆中最后一个元素
            return;
        } else {
            heap.set(index, replace);
            indexMap.put(replace, index);
            rebuild(replace);
        }
    }

    public List<T> getAllElements() {//获取堆中所有元素
        return heap;
    }

    public void rebuild(T o) {
        heapIfy(indexMap.get(o));
        heapInsert(indexMap.get(o));
    }

    private void heapInsert(int index) {//上浮
        while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapIfy(int index) {//下沉
        int zuoHaiZi = 2 * index + 1;
        while (zuoHaiZi < heapSize) {//ArrayList下标从0开始
            int largest = ((zuoHaiZi + 1 < heapSize) && comparator.compare(heap.get(zuoHaiZi + 1), heap.get(zuoHaiZi)) < 0) ? zuoHaiZi + 1 : zuoHaiZi;//先让最大值等于左右孩子中最大的那个
            largest = (comparator.compare(heap.get(index), heap.get(largest)) < 0) ? index : largest;
            if (index == largest) {
                break;
            }
            swap(index, largest);
            index = largest;
            zuoHaiZi = 2 * index + 1;
        }
    }
}
