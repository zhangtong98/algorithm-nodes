package com.zhang.sortUtils;

import java.util.Arrays;

/**
 * Created by zhangtong on 2021/5/6.
 * chongqing liangyao
 * 计数排序
 * 计数排序英文称Counting sort，是一种稳定的线性时间排序算法。计数排序使用一个额外的数组C，
 * 其中第i个元素是待排序数组A中值等于 i的元素的个数。然后根据数组C来将A中的元素排到正确的位置。
 * 基本的步骤如下：
 * 1.找出待排序的数组中最大和最小的元素
 * 2.统计数组中每个值为i的元素出现的次数，存入数组C的第i项
 * 3.对所有的计数累加,从C中的第一个元素开始，每一项和前一项相加
 * 4.反向填充目标数组,将每个元素i放在新数组的第C[i]项，每放一个元素就将C[i]减去1
 * 链接：resources/imgs/sort/countingSort.gif
 *
 * 平均时间复杂度：O(n+k)
 * 空间复杂度：O(k)
 */
public class CountingSort<T extends Comparable<T>> extends AbstractSort<T> {

    private Integer[] aux;
    @Override
    public void sort(T[] _nums) {
        Integer[] nums = (Integer[])_nums;
        Integer min = nums[0];
        Integer max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        aux = new Integer[max - min + 1];
        Arrays.fill(aux,0);
        //记录重复的个数
        for (int i = 0; i < nums.length; i++) {
            aux[(nums[i]-min)]++;
        }
        int j = 0, auxLen = aux.length, i = 0;
        while (i < nums.length) {
            if (aux[j] == 0){
                j++;
                continue;
            }
            while (aux[j]-- > 0){
                nums[i++] = max - auxLen + 1 + j;
            }
            j++;
        }
    }
}
