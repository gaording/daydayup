import common.ListNode;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 求链表中倒数第K个节点
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-27 18:05
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-27 gaorunding v1.0.0 修改原因
 * 题目描述：输入一个链表，输出该链表中倒数第k个结点。
 * 思路：定义一快一慢两个指针，快指针走K步，然后慢指针开始走，快指针到尾时，慢指针就找到了倒数第K个节点
 */
public class FindKthToTail {

    public ListNode findKthToTail(ListNode head,int k){
        if (head==null||k<=0){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        for (int i = 0; i < k; i++) {
            fast=fast.getNext();
            if (fast==null){
                return null;
            }
        }
        while (fast!=null){
            fast=fast.getNext();
            slow=slow.getNext();
        }
        return slow;
    }
}
