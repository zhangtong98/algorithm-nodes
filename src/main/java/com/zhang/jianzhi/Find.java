package com.zhang.jianzhi;

import java.util.Scanner;

/**
 * Created by kongweichun on 2019/11/4.
 * 二维数组中的查找
 *  给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 *  Consider the following matrix:
 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]

 Given target = 5, return true.
 Given target = 20, return false.

 解题思路
 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。

 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，
 就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
 */
public class Find {

    public static void main(String[] args) {
        int matrix[][] = {{1,  4,  7,  11, 15},
                {2,  5,  8,  12, 19},
                {3,  6,  9,  16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.err.println(find(target, matrix) ? target + "存在二维数组中" : target + "不存在二维数组中");
    }

    public static boolean find(int target, int[][]matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length, cols = matrix[0].length;
        //从右上角开始，初始坐标(r,c)
        int r = 0, c = cols - 1;

        while (r < rows && c >= 0){
            if (target == matrix[r][c])
                return true;
                //目标大于当前数，目标数可能在下一行中
            else if (target > matrix[r][c])
                r++;
                //目标小于当前数，目标数可能在上一列中
            else
                c--;
        }
        return false;
    }
}
