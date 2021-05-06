package offer;

import common.ListNode;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 两个链表的第一个公共节点
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 20:20
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 */
public class Day050504 {
    public ListNode findFirstCommonNode(ListNode pHead1,ListNode pHead2){
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while (p1!=p2){
            p1=p1!=null?p1.getNext():pHead2;
            p2=p2!=null?p2.getNext():pHead1;
        }
        return p1;
    }
}
