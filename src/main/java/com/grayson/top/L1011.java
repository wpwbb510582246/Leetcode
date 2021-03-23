package com.grayson.top;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author peng.wei
 * @version 1.0
 * @date 2021/3/21 18:47
 * @Description 在 D 天内送达包裹的能力
 */
public class L1011 {

    /**
     * 判断 D 天内能否运完包裹
     * @param weights   每个包裹的重量
     * @param D 运送期限
     * @param cap   载重量
     * @return  D 天内能否运完包裹
     */
    public static boolean canFinish(int[] weights, int D, int cap) {
        int realD = 0, weightSum = 0, index = 0;
        while (index < weights.length) {
            int weight = weights[index];
            weightSum += weight;
            if (weightSum > cap) {
                realD++;
                weightSum = 0;
            } else {
                if (index == weights.length - 1) {realD++;}
                index++;
            }
        }
        return realD <= D;
    }

    /**
     * 获取货物的总重量
     * @param weights   货物重量
     * @return  货物的总重量
     */
    public static int getSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }

    /**
     * 获取货物中的最大值
     * @param weights   货物重量
     * @return  货物中的最大值
     */
    public static int getMax(int[] weights) {
        int max = -1;
        for (int weight : weights) {
            max = Math.max(max, weight);
        }
        return max;
    }

    /**
     * 1011.在 D 天内送达包裹的能力
     * @param weights   每个包裹的重量
     * @param D 运送期限
     * @return  最小载重量
     */
    public static int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights), right = getSum(weights);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, D, mid)) {right = mid - 1;}
            else {left = mid + 1;}
        }
        return left;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        int cap = shipWithinDays(weights, D);
        stopWatch.stop();
        System.out.println(String.format("测试用例1结果为：%s，执行用时：%s微秒", cap, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        weights = new int[]{3,2,2,4,1,4};
        D = 3;
        cap = shipWithinDays(weights, D);
        stopWatch.stop();
        System.out.println(String.format("测试用例2结果为：%s，执行用时：%s微秒", cap, stopWatch.getTime(TimeUnit.MICROSECONDS)));
    }

}
