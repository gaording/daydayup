import common.ListNode;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: o(1)时间删除链表节点
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-27 16:59
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-27 gaorunding v1.0.0 修改原因
 */
public class DeleteNode {

    public void deleteNode(ListNode head,ListNode deListNode){
        if (head==null||deListNode==null){
            return;
        }
        if (head==deListNode){
            head=null;
            return;
        }
        if (deListNode.getNext()==null){
            ListNode pointerNode=head;
            while (pointerNode.getNext().getNext()!=null){
                pointerNode=pointerNode.getNext();
            }
            pointerNode.setNext(null);
            return;
        }
        deListNode.setNode(deListNode.getNext().getNode());
        deListNode.setNext(deListNode.getNext().getNext());
    }
}
