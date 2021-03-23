package com.grayson.top;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author peng.wei
 * @version 1.0
 * @date 2021/3/22 15:26
 * @Description 接雨水
 */
public class L42 {

    /**
     * 获取一个数组中指定下标范围内的最大值
     * @param height    数组
     * @param startIndex    起始坐标
     * @param endIndex  结束坐标
     * @return  该数组指定下标范围内的最大值
     */
    public static int getMax(int[] height, int startIndex, int endIndex) {
        int max = -1;
        if (startIndex < 0 || endIndex > height.length - 1 || startIndex > endIndex) {return -1;}
        for (int i = startIndex; i <= endIndex; i++) {
            max = Math.max(height[i], max);
        }
        return max;
    }

    /**
     * 42.接雨水（版本4：双指针解法）
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * @param height    每个柱子的高度
     * @return  总共可以接多少雨水
     */
    public static int trapV4(int[] height) {
        if (height.length == 0) {return 0;}
        int left = 0, right = height.length - 1, trap = 0;
        int leftMax = height[0], rightMax = height[height.length - 1];
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                trap += leftMax - height[left];
                left++;
            } else {
                trap += rightMax - height[right];
                right--;
            }
        }
        return trap;
    }

    /**
     * 42.接雨水（版本3：备忘录解法-优化求最大值方法）
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * @param height    每个柱子的高度
     * @return  总共可以接多少雨水
     */
    public static int trapV3(int[] height) {
        if (height.length == 0) {return 0;}
        int trap = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            trap += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return trap;
    }

    /**
     * 42.接雨水（版本2：备忘录解法）
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * @param height    每个柱子的高度
     * @return  总共可以接多少雨水
     */
    public static int trapV2(int[] height) {
        int trap = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = getMax(height, 0, i);
            rightMax[i] = getMax(height, i, height.length - 1);
        }
        for (int i = 0; i < height.length; i++) {
            trap += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return trap;
    }

    /**
     * 42.接雨水（版本1：暴力解法）
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * @param height    每个柱子的高度
     * @return  总共可以接多少雨水
     */
    public static int trapV1(int[] height) {
        int trap = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = getMax(height, 0, i);
            int rightMax = getMax(height, i, height.length - 1);
            trap += Math.min(leftMax, rightMax) - height[i];
        }
        return trap;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trapV1(height);
        stopWatch.stop();
        System.out.println(String.format("版本1测试用例1结果为：%s，执行用时：%s微秒", trap, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        height = new int[]{4,2,0,3,2,5};
        trap = trapV1(height);
        stopWatch.stop();
        System.out.println(String.format("版本1测试用例2结果为：%s，执行用时：%s微秒", trap, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        trap = trapV2(height);
        stopWatch.stop();
        System.out.println(String.format("版本2测试用例1结果为：%s，执行用时：%s微秒", trap, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        height = new int[]{4,2,0,3,2,5};
        trap = trapV2(height);
        stopWatch.stop();
        System.out.println(String.format("版本2测试用例2结果为：%s，执行用时：%s微秒", trap, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        trap = trapV3(height);
        stopWatch.stop();
        System.out.println(String.format("版本3测试用例1结果为：%s，执行用时：%s微秒", trap, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        height = new int[]{4,2,0,3,2,5};
        trap = trapV3(height);
        stopWatch.stop();
        System.out.println(String.format("版本3测试用例2结果为：%s，执行用时：%s微秒", trap, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        trap = trapV4(height);
        stopWatch.stop();
        System.out.println(String.format("版本4测试用例1结果为：%s，执行用时：%s微秒", trap, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        height = new int[]{4,2,0,3,2,5};
        trap = trapV4(height);
        stopWatch.stop();
        System.out.println(String.format("版本4测试用例2结果为：%s，执行用时：%s微秒", trap, stopWatch.getTime(TimeUnit.MICROSECONDS)));
    }

}
