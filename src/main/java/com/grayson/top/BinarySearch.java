package com.grayson.top;

import java.util.List;

/**
 * @author peng.wei
 * @version 1.0
 * @date 2021/3/21 14:25
 * @Description 二分查找算法框架
 */
public class BinarySearch {

    /**
     * 二分查找算法
     * @param nums  原始数组
     * @param target    目标值
     * @return  目标值在原始数组中的位置
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //  为了防止 (left + right) 太大导致溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {left = mid + 1;}
            else if (nums[mid] > target) {right = mid - 1;}
            //  直接返回
            else if (nums[mid] == target) {return mid;}
        }
        //  直接返回
        return -1;
    }

    /**
     * 寻找左侧边界的二分查找算法
     * @param nums  原始数组
     * @param target    目标值
     * @return  目标值在原始数组中的位置
     */
    public static Integer leftBond(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {left = mid + 1;}
            else if (nums[mid] > target) {right = mid - 1;}
            //  1.别返回，锁定左边界
            else if (nums[mid] == target) {right = mid - 1;}
        }
        //  2.最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target) {return -1;}
        return left;
    }

    /**
     * 寻找右侧边界的二分查找算法
     * @param nums  原始数组
     * @param target    目标值
     * @return  目标值在原始数组中的位置
     */
    public static Integer rightBond(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {left = mid + 1;}
            else if (nums[mid] > target) {right = mid - 1;}
            //  1.别返回，锁定右边界
            else if (nums[mid] == target) {left = mid + 1;}
        }
        //  2.最后要检查 right 越界的情况
        if (right < 0 || nums[left] != target) {return -1;}
        return right;
    }

}
