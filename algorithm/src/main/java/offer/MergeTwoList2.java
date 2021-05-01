package offer;

import common.ListNode;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 合并单调递增链表
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-27 19:46
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-27 gaorunding v1.0.0 修改原因
 */
public class MergeTwoList2 {
    public ListNode mergeTwoList2(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1, null);
        ListNode pre = preHead;
        while (list1 != null && list2 != null) {
            if (list1.getNode() < list2.getNode()) {
                pre.setNext(list1);
                list1 = list1.getNext();
            } else {
                pre.setNext(list2);
                list2 = list2.getNext();
            }
            pre = pre.getNext();
        }
        pre.setNext(list1==null?list2:list1);
        return preHead;
    }
}
