import common.ListNode;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 反转链表
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-27 18:17
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-27 gaorunding v1.0.0 修改原因
 * 题目描述：输入一个链表，反转链表后，输出新链表的表头
 * 思路：定义两个指针，反向输出
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = pre.getNext();
        ListNode tmp = null;
        pre.setNext(tmp);
        while (cur != null) {
            tmp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode p= reverseList2(head.getNext());
        head.getNext().getNext().setNext(head.getNext());
        head.getNext().setNext(null);
        return p;
    }
}
