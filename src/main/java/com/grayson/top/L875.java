package com.grayson.top;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author peng.wei
 * @version 1.0
 * @date 2021/3/21 15:43
 * @Description 爱吃香蕉的珂珂
 */
public class L875 {

    /**
     * 一堆香蕉吃完所用的时间：
     *  1.当 n 可以被 k 整除时，h = n / k
     *  2.当 n 不可以被 k 整除时，h = n / k + 1
     * @param n 香蕉数量
     * @param k 吃香蕉的速度
     * @return  香蕉吃完所用的时间
     */
    public static int timeOf(int n, int k) {
        return (n / k) + ((n % k) > 0 ? 1 : 0);
    }

    /**
     * 判断能否在指定的时间吃完所有香蕉
     *
     * @param piles 香蕉
     * @param k     吃香蕉的速度
     * @param h     指定时间
     * @return 能否在指定的时间吃完所有香蕉
     */
    public static boolean canFinish(int[] piles, int k, int h) {
        int realH = 0;
        for (int pile: piles) {
            realH += timeOf(pile, k);
        }
        return realH <= h;
    }

    /**
     * 获取香蕉数量最大的一堆的橡胶数量
     *
     * @param piles 香蕉
     * @return 香蕉数量最大的一堆的橡胶数量
     */
    public static int getMax(int[] piles) {
        int max = -1;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    /**
     * 875.爱吃香蕉的珂珂
     * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
     * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
     *
     * @param piles 每堆香蕉的数量
     * @param h     时长
     * @return
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles) + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        int[] piles = new int[]{3, 6, 7, 11};
        int h = 8;
        int k = minEatingSpeed(piles, h);
        stopWatch.stop();
        System.out.println(String.format("测试用例1结果为：%s，执行用时：%s微秒", k, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        piles = new int[]{30, 11, 23, 4, 20};
        h = 5;
        k = minEatingSpeed(piles, h);
        stopWatch.stop();
        System.out.println(String.format("测试用例2结果为：%s，执行用时：%s微秒", k, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        piles = new int[]{30, 11, 23, 4, 20};
        h = 6;
        k = minEatingSpeed(piles, h);
        stopWatch.stop();
        System.out.println(String.format("测试用例3结果为：%s，执行用时：%s微秒", k, stopWatch.getTime(TimeUnit.MICROSECONDS)));
    }

}
