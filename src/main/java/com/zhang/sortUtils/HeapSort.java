package com.zhang.sortUtils;

/**
 * Created by zhangtong on 2021/5/6.
 * chongqing liangyao
 * 堆排序
 * 把最大元素和当前堆中数组的最后一个元素交换位置，并且不删除它，那么就可以得到一个从尾到头的递减序列，
 * 从正向来看就是一个递增序列，这就是堆排序。
 * 1 构建堆
 * 无序数组建立堆最直接的方法是从左到右遍历数组进行上浮操作。一个更高效的方法是从右至左进行下沉操作，
 * 如果一个节点的两个节点都已经是堆有序，那么进行下沉操作可以使得这个节点为根节点的堆有序。
 * 叶子节点不需要进行下沉操作，可以忽略叶子节点的元素，因此只需要遍历一半的元素即可。
 * 2 交换堆顶元素与最后一个元素
 * 交换之后需要进行下沉操作维持堆的有序状态。
 *
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 */
public class HeapSort<T extends Comparable<T>> extends AbstractSort<T> {
//    @Override
//    public void sort(T[] nums) {
//        int N = nums.length;
//        for (int k = N / 2; k >= 1; k--) {
//            sink(nums, k, N);
//        }
//
//        while (N > 1){
//            swap(nums, 1, N--);
//            sink(nums, 1, N);
//        }
//    }
//
//    private void sink(T[] nums, int k, int N){
//        while (2 * k <= N){
//            int j = 2 * k;
//            if (j < N && less(nums, j, j+1)){
//                j++;
//            }
//            if (!less(nums, k, j)){
//                break;
//            }
//            swap(nums, k, j);
//            k = j;
//        }
//    }
//
//    public boolean less(T[] nums, int i, int j){
//        return nums[i].compareTo(nums[j]) < 0;
//    }


    @Override
    public void sort(T[] nums) {
        int len = nums.length;
        //初始化，i从最后一个父节点开始调整
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, len - 1);
        }
        //先將第一个元素和已经排好的元素前一位做交换，再重调整，(刚调整的元素之前的元素)，直到排序完毕
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, i-1);
        }
    }

    private void maxHeapify(T[] nums, int start, int end){
        //建立父节点指标和子节点指标
        int dad = start;
        int son = dad * 2 + 1;
        //子节点指标在范围内才做比较
        while (son <= end){
            //比较两个子节点大小，选择最大的
            if (son + 1 <= end && less(nums[son],nums[son+1])){
                son++;
            }
            if (less(nums[son],nums[dad])){//如果父节点大于子节点代表调整完毕，直接跳出函数
                return;
            }else {//否則交换父子内容再继续子节点和孙节点比较
                swap(nums, son, dad);
                dad = son;
                son = dad * 2 + 1;
            }
        }
    }
}
