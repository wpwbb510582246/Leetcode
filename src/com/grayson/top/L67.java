package com.grayson.top;

/**
 * @author peng.wei
 * @date 2020/6/23 22:29
 * @description
 */
public class L67 {

    /**
     * 67. 二进制求和
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * @param a 参数 a
     * @param b 参数 b
     * @return  两个二进制字符串的和（用二进制表示）
     */
    public String addBinary(String a, String b) {
        String[] splitA = a.split("");
        String[] splitB = b.split("");
        int len = Math.min(splitA.length, splitB.length);

        String resStr = "";
        int tmpRes = 0;
        boolean extAdd = false;
        for (int i = 0; i < len; i++) {
            tmpRes = Integer.parseInt(splitA[splitA.length - i - 1]) + Integer.parseInt(splitB[splitB.length - i - 1]);
            //  如果上一步需要进位，则当前结果加1
            if (extAdd) tmpRes += 1;
            if (tmpRes >= 2) {
                resStr = (tmpRes % 2) + resStr;
                //  需要进位
                extAdd = true;
            }
            else {
                resStr = tmpRes + resStr;
                //  不需要进位
                extAdd = false;
            }
        }

        boolean flag = false;
        if (splitA.length > len) {
            //  a的长度较大，则将a的前边部分加到结果前面
            for (int i = splitA.length - len - 1; i >= 0; i--) {
                //  如果上一步需要进位，则当前结果加1
                if (extAdd) {
                    tmpRes = Integer.parseInt(splitA[i]) + 1;
                    if (tmpRes >= 2) {
                        resStr = 0 + resStr;
                        continue;
                    }
                    resStr = tmpRes + resStr;
                    extAdd = false;
                    continue;
                }
                flag = true;
                resStr = splitA[i] + resStr;
            }
            if (!flag) resStr = 1 + resStr;
        }
        if (splitB.length > len){
            //  b的长度较大，则将b的前边部分加到结果前面
            for (int i = splitB.length - len - 1; i >= 0; i--) {
                //  如果上一步需要进位，则当前结果加1
                if (extAdd) {
                    tmpRes = Integer.parseInt(splitB[i]) + 1;
                    if (tmpRes >= 2) {
                        resStr = 0 + resStr;
                        continue;
                    }
                    resStr = tmpRes + resStr;
                    extAdd = false;
                    continue;
                }
                flag = true;
                resStr = splitB[i] + resStr;
            }
            if (!flag) resStr = 1 + resStr;
        }
        if (splitA.length == splitB.length && extAdd) resStr = 1 + resStr;
        return resStr;
    }

    /**
     * 67. 二进制求和(官方解法)
     * @param a 参数 a
     * @param b 参数 b
     * @return  两个二进制字符串的和（用二进制表示）
     */
    public String addBinaryOfficial(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {
        L67 l67 = new L67();
//        System.out.println(l67.addBinary("11", "1"));
//        System.out.println(l67.addBinary("111", "11"));
//        System.out.println(l67.addBinary("1010", "1011"));
//        System.out.println(l67.addBinary("101111", "10"));
        System.out.println(l67.addBinary("11", "1001"));
        System.out.println(l67.addBinaryOfficial("11", "1001"));
    }

}
