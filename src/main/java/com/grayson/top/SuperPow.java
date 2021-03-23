package com.grayson.top;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @author peng.wei
 * @version 1.0
 * @date 2021/3/18 16:20
 * @Description 高效模幂算法
 */
public class SuperPow {

    /**
     * 计算 a 的 b 次方与 base 取模后的结果
     *  1. (a * b) % k = (a % k) * (b % k) % k
     * @param a 底数
     * @param k 指数
     * @param base  取模数
     * @return  a 的 b 次方与 base 取模后的结果
     */
    public static int myPow(int a, int k, int base) {
        int tmpRes = a % base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            //  这里有乘法，是潜在的溢出点
            res *= tmpRes;
            //  对乘法结果求模: 可以保证 res * tmpRes这句代码执行时两个因子都是小于 base 的，也就一定不会造成溢出
            res %= base;
        }
        return res;
    }

    /**
     * 返回模幂运算 a^[b] 的计算结果与 base 取模后的结果
     *  1. a^[1024] = a^4 * a^[1020]
     *              = a^4 * (a^[102])^10
     * @param a 底数
     * @param b 指数
     * @param base  取模数
     * @return  模幂运算 a^b 的计算结果与 base 取模后的结果
     */
    public static int superPow(int a, Vector<Integer> b, int base) {
        if (b.size() == 0) {return 1;}
        Integer last = b.lastElement();
        b.removeElementAt(b.size() - 1);
        int part1 = myPow(a, last, base);
        int part2 = myPow(superPow(a, b, base), 10, base);
        //  每次乘法都要求模
        return (part1 * part2) % base;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Vector<Integer> vector = new Vector<>();
        vector.addAll(Arrays.asList(3));
        int base = 3;
        int res = superPow(2, vector, base);
        stopWatch.stop();
        System.out.println(String.format("结果为: %s, 执行用时：%s微秒", res, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        vector.removeAllElements();
        vector.addAll(Arrays.asList(3));
        base = 7;
        res = superPow(4, vector, base);
        stopWatch.stop();
        System.out.println(String.format("结果为: %s, 执行用时：%s微秒", res, stopWatch.getTime(TimeUnit.MICROSECONDS)));

        stopWatch.reset();
        stopWatch.start();
        vector.removeAllElements();
        vector.addAll(Arrays.asList(1, 0, 2, 4));
        base = 1337;
        res = superPow(2, vector, base);
        stopWatch.stop();
        System.out.println(String.format("结果为: %s, 执行用时：%s微秒", res, stopWatch.getTime(TimeUnit.MICROSECONDS)));
    }

}
