package com.grayson.top;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author peng.wei
 * @version 1.0
 * @date 2021/3/17 21:14
 * @Description 素数个数统计算法
 */
public class PrimeCount {

    /**
     * 判断一个数是否为素数(版本4)
     * @param n 数字
     * @return  该数字是否为素数
     */
    public static boolean isPrimeV4(int i, int n, boolean[] isPrime) {
        //  如果 n 小于 2，则该数肯定不是素数
        if (n < 2 || i < 2) {isPrime[i] = false;}
        if (isPrime[i]) {
            //  如果 i 是素数，则 i 的倍数一定不是素数
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        //  如果不满足上面的条件，则该数一定是素数
        return true;
    }

    /**
     * 判断一个数是否为素数(版本3)
     * @param n 数字
     * @return  该数字是否为素数
     */
    public static boolean isPrimeV3(int i, int n, boolean[] isPrime) {
        //  如果 n 小于 2，则该数肯定不是素数
        if (n < 2 || i < 2) {isPrime[i] = false;}
        if (isPrime[i]) {
            //  如果 i 是素数，则 i 的倍数一定不是素数
            for (int j = 2 * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        //  如果不满足上面的条件，则该数一定是素数
        return true;
    }

    /**
     * 判断一个数是否为素数(版本2)
     * @param n 数字
     * @return  该数字是否为素数
     */
    public static boolean isPrimeV2(int n) {
        //  如果 n 小于 2，则该数肯定不是素数
        if (n < 2) {return false;}
        for (int i = 2; i * i <= n; i++) {
            //  如果除了 1 和他本身外，还可以整除其他数，则该数不是素数
            if (n % i == 0) {return false;}
        }
        //  如果不满足上面的条件，则该数一定是素数
        return true;
    }

    /**
     * 判断一个数是否为素数(版本1)
     * @param n 数字
     * @return  该数字是否为素数
     */
    public static boolean isPrimeV1(int n) {
        //  如果 n 小于 2，则该数肯定不是素数
       if (n < 2) {return false;}
        for (int i = 2; i < n; i++) {
            //  如果除了 1 和他本身外，还可以整除其他数，则该数不是素数
            if (n % i == 0) {return false;}
        }
        //  如果不满足上面的条件，则该数一定是素数
        return true;
    }

    /**
     * 统计一个不大于一个数的所有素数的个数(版本4)
     * @param n 数字
     * @return  不大于该数的所有素数的个数
     */
    public static int countPrimeV4(int n) {
        //  创建一个数组，存储不大于 n 的所有数是否为 素数，初始默认都为素数
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (int i = 2; i <= n; i++) {
            isPrimeV4(i, n, isPrime);
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {count++;}
        }
        return count;
    }

    /**
     * 统计一个不大于一个数的所有素数的个数(版本3)
     * @param n 数字
     * @return  不大于该数的所有素数的个数
     */
    public static int countPrimeV3(int n) {
        //  创建一个数组，存储不大于 n 的所有数是否为 素数，初始默认都为素数
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (int i = 2; i <= n; i++) {
            isPrimeV3(i, n, isPrime);
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {count++;}
        }
        return count;
    }

    /**
     * 统计一个不大于一个数的所有素数的个数(版本2)
     * @param n 数字
     * @return  不大于该数的所有素数的个数
     */
    public static int countPrimeV2(int n) {
        int count = 0;
        for (Integer i = 2; i <= n; i++) {
            if (isPrimeV2(i)) {count++;}
        }
        return count;
    }

    /**
     * 统计一个不大于一个数的所有素数的个数(版本1)
     * @param n 数字
     * @return  不大于该数的所有素数的个数
     */
    public static int countPrimeV1(int n) {
        int count = 0;
        for (Integer i = 2; i <= n; i++) {
            if (isPrimeV1(i)) {count++;}
        }
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        //  统计一个不大于一个数的所有素数的个数(版本1)
        stopWatch.start();
        System.out.println(countPrimeV1(2));
        System.out.println(countPrimeV1(10));
        System.out.println(countPrimeV1(20));
        System.out.println(countPrimeV1(50));
        System.out.println(countPrimeV1(100));
        System.out.println(countPrimeV1(1000));
        stopWatch.stop();
        System.out.println(String.format("版本1执行用时：%s微秒", stopWatch.getTime(TimeUnit.MICROSECONDS)));
        Thread.sleep(1000);

        //  统计一个不大于一个数的所有素数的个数(版本2)
        stopWatch.reset();
        stopWatch.start();
        System.out.println(countPrimeV2(2));
        System.out.println(countPrimeV2(10));
        System.out.println(countPrimeV2(20));
        System.out.println(countPrimeV2(50));
        System.out.println(countPrimeV2(100));
        System.out.println(countPrimeV2(1000));
        stopWatch.stop();
        System.out.println(String.format("版本2执行用时：%s微秒", stopWatch.getTime(TimeUnit.MICROSECONDS)));
        Thread.sleep(1000);

        //  统计一个不大于一个数的所有素数的个数(版本3)
        stopWatch.reset();
        stopWatch.start();
        System.out.println(countPrimeV3(2));
        System.out.println(countPrimeV3(10));
        System.out.println(countPrimeV3(20));
        System.out.println(countPrimeV3(50));
        System.out.println(countPrimeV3(100));
        System.out.println(countPrimeV3(1000));
        stopWatch.stop();
        System.out.println(String.format("版本3执行用时：%s微秒", stopWatch.getTime(TimeUnit.MICROSECONDS)));
        Thread.sleep(1000);

        //  统计一个不大于一个数的所有素数的个数(版本4)
        stopWatch.reset();
        stopWatch.start();
        System.out.println(countPrimeV4(2));
        System.out.println(countPrimeV4(10));
        System.out.println(countPrimeV4(20));
        System.out.println(countPrimeV4(50));
        System.out.println(countPrimeV4(100));
        System.out.println(countPrimeV4(1000));
        stopWatch.stop();
        System.out.println(String.format("版本4执行用时：%s微秒", stopWatch.getTime(TimeUnit.MICROSECONDS)));
    }
}
