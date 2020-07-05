package com.grayson.top;

/**
 * @author peng.wei
 * @date 2020/6/27 22:32
 * @description
 */
public class L41 {

    /**
     * 41. 缺失的第一个正数
     * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int minNotExist = 1;
        for (int i = 0; i < nums.length; i++) {
            if (minNotExist != nums[i]) continue;
            minNotExist += 1;
        }
        return minNotExist;
    }

    /**
     * 41. 缺失的第一个正数(官方)
     * 叙述：给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     *      你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
     * 解法：
     *      1、将小于0的数修改为(n+1)
     *      2、将小于等于n的数对应位置变为负数
     *      3、返回第一个不是负数的对应的位置
     *         如果所有的数都是负数，则返回(n+1)
     * @param nums
     * @return
     */
    public int firstMissingPositiveOfficial(int[] nums) {
        int n = nums.length;
        //  1、将小于0的数修改为(n+1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) nums[i] = n + 1;
        }

        //  2、将小于等于n的数对应位置变为负数
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) <= n) nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i])- 1]);
        }

        //  3、返回第一个不是负数的对应的位置
        //     如果所有的数都是负数，则返回(n+1)
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        L41 l41 = new L41();
        int[] nums = new int[]{1, 2, 0};
        int[] nums2 = new int[]{3,4,-1,1};
        int[] nums3 = new int[]{7,8,9,11,12};
        int[] nums4 = new int[]{2,1};
        System.out.println(l41.firstMissingPositive(nums));
        System.out.println(l41.firstMissingPositiveOfficial(nums));
        System.out.println(l41.firstMissingPositive(nums2));
        System.out.println(l41.firstMissingPositiveOfficial(nums2));
        System.out.println(l41.firstMissingPositive(nums3));
        System.out.println(l41.firstMissingPositiveOfficial(nums3));
        System.out.println(l41.firstMissingPositive(nums4));
        System.out.println(l41.firstMissingPositiveOfficial(nums4));
    }

}
