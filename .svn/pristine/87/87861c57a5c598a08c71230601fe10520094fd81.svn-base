package com.grayson.top;

/**
 * @author peng.wei
 * @date 2020/6/26 23:07
 * @description
 */
public class L2 {


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 2. 两数相加
     * @param l1    第一个 非空 的链表
     * @param l2    第二个 非空 的链表
     * @return  相加后的非空链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        //  存储l1、l2及而这所表示的十进制数相加后结果的数据
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        //  存储l1和l2实际表示的十进制数及二者相加的结果
        Integer ans, ans1, ans2;

        //  获取l1表示的十进制数
        while (l1.next != null) {
            sb1.append(l1.val);
        }
        sb1.reverse();
        ans1 = Integer.parseInt(sb1.toString());

        //  获取l2表示的十进制数
        while (l2.next != null) {
            sb2.append(l2.val);
        }
        sb2.reverse();
        ans2 = Integer.parseInt(sb2.toString());

        //  获取ans1和ans2相加的结果
        ans = ans1 + ans2;

        //  获取ans1和ans2相加后结果反转后的数据
        sb.append(ans.toString()).reverse();

        //  将结果转换为ListNode
        ListNode tmpL = l;
        for (int i = 0; i < sb.length(); i++) {
            tmpL.val = sb.charAt(i) + '0';
            ListNode nextL = null;
            if (i == sb.length() - 2) {
                nextL = new ListNode(sb.charAt(i + 1) + '0');
                tmpL.next = nextL;
            } else {
                tmpL.next = null;
            }
            tmpL = nextL;
        }

        return l;

    }

    /**
     * 2. 两数相加(官方)
     * @param l1    第一个 非空 的链表
     * @param l2    第二个 非空 的链表
     * @return  相加后的非空链表
     */
    public ListNode addTwoNumbersOfficial(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode(0);
        ListNode tmpRes = resHead;
        ListNode tmpL1 = l1, tmpL2 = l2;
        int carry = 0;
        while (tmpL1 != null && tmpL2 != null) {
            ListNode tmpL = new ListNode((carry + tmpL1.val + tmpL2.val) % 10);
            carry = (carry + tmpL1.val + tmpL2.val) / 10;
            tmpRes.next = tmpL;
            tmpRes = tmpL;
            tmpL1 = tmpL1.next;
            tmpL2 = tmpL2.next;
        }

        if (tmpL1 == null && tmpL2 != null) {
            while (tmpL2 != null) {
                ListNode tmpL = new ListNode((carry + tmpL2.val) % 10);
                carry = (carry + tmpL2.val) / 10;
                tmpRes.next = tmpL;
                tmpRes = tmpL;
                tmpL2 = tmpL2.next;
            }
        }

        if (tmpL2 == null && tmpL1 != null) {
            while (tmpL1 != null) {
                ListNode tmpL = new ListNode((carry + tmpL1.val) % 10);
                carry = (carry + tmpL1.val) / 10;
                tmpRes.next = tmpL;
                tmpRes = tmpL;
                tmpL1 = tmpL1.next;
            }
        }

        if (carry > 0) {
            ListNode tmpL = new ListNode(1);
            tmpRes.next = tmpL;
        }
        return resHead.next == null ? resHead : resHead.next;
    }

}
