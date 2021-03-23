package com.grayson.top;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author peng.wei
 * @version 1.0
 * @date 2021/3/22 18:55
 * @Description 删除有序数组中的重复项
 */
public class L26 {

    /**
     * 26.删除有序数组中的重复项
     *
     * @param nums 数组
     * @return 删除后数组的新长度
     */
    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = slow + 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        int[] nums = {1, 1, 2};
        int len = removeDuplicates(nums);
        stopWatch.stop();
        System.out.println(String.format("测试用例1结果为：%s，执行用时：%s微秒", len, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        len = removeDuplicates(nums);
        stopWatch.stop();
        System.out.println(String.format("测试用例2结果为：%s，执行用时：%s微秒", len, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        nums = new int[]{1, 1, 2};
        len = removeDuplicates(nums);
        stopWatch.stop();
        System.out.println(String.format("测试用例2结果为：%s，执行用时：%s微秒", len, stopWatch.getTime(TimeUnit.MICROSECONDS)));
    }

}
