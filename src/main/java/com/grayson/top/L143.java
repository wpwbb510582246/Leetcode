package com.grayson.top;

/**
 * @author peng.wei
 * @version 1.0
 * @date 2020/10/20 20:51
 * @Description
 */
public class L143 {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 143. 重排链表
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例 1:
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     * 示例 2:
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     * 解题思路：先将一个链表进行反转，然后将两个链表进行拼接
     * @param head
     * @return
     */
    public static ListNode reorderList(ListNode head) {
        if (head == null) {
            return head;
        }
        //  对单链表进行反转
        ListNode reverseListNodeHead = null;
        int headVal = head.val;
        ListNode headNext = head.next;
        int totalNode = 1;
        while (headNext != null) {
            ListNode reverseListNode = new ListNode();
            reverseListNode.val = headVal;
            reverseListNode.next = reverseListNodeHead;
            reverseListNodeHead = reverseListNode;
            headVal = headNext.val;
            headNext = headNext.next;
            totalNode += 1;
        }
        ListNode reverseListNode = new ListNode();
        reverseListNode.val = headVal;
        reverseListNode.next = reverseListNodeHead;
        reverseListNodeHead = reverseListNode;
        ListNode headTmp = head;
        int headTmpVal = headTmp.val;
        ListNode headTmpNext = headTmp.next;
        ListNode reverseListNodeHeadNext = reverseListNodeHead.next;
        int currentIndex = 1;
        while (headTmpNext != null && reverseListNodeHeadNext != null) {
            if (currentIndex >= totalNode) break;
            if (currentIndex % 2 != 0) {
                headTmp.next = reverseListNodeHead;
                headTmp = headTmpNext;
                headTmpNext = headTmp.next;
            } else {
                reverseListNodeHead.next = headTmp;
                reverseListNodeHead = reverseListNodeHeadNext;
                reverseListNodeHeadNext = reverseListNodeHead.next;
            }
            currentIndex += 1;
        }
        if (totalNode % 2 != 0) {
            headTmp.next = null;
        } else {
            reverseListNodeHead.next = null;
        }
        return head;
    }

    /**
     * 输出单链表
     *
     * @param head 单链表
     */
    public static void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode tmpHead = head;
        while (tmpHead != null) {
            if (tmpHead.next != null) {
                sb.append(String.valueOf(tmpHead.val)).append("->");
            } else {
                sb.append(String.valueOf(tmpHead.val));
            }
            tmpHead = tmpHead.next;
        }
        System.out.println(sb.toString());
    }

    /**
     * 生成指定节点个数的单链表
     *
     * @param nodeNum 节点个数
     * @return 单链表
     */
    private static ListNode createListNode(int nodeNum) {
        ListNode head = new ListNode();
        ListNode tmpHead = head;
        for (int i = 1; i <= nodeNum; i++) {
            ListNode node = new ListNode(i, null);
            tmpHead.next = node;
            tmpHead = node;
        }
        head = head.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = createListNode(0);
        System.out.println("--------------Previous ListNode--------------");
        printListNode(head);
        System.out.println("--------------Reordered ListNode--------------");
        ListNode recordedListNode = reorderList(head);
        printListNode(recordedListNode);
    }
}
