import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 从尾到头打印链表
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-23 21:38
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-23 gaorunding v1.0.0 修改原因
 */
public class printList {
    public static void main(String[] args) {

    }

    /**
     * 用栈
     * @param listNode
     * @return
     */
    public List<Integer> printListFromTailToHead(ListNode listNode){
        List<Integer> result=new ArrayList<>();
        if (null==listNode){
            return result;
        }
        Stack stack=new Stack();
        while (null!=listNode){
            stack.push(listNode.getNode());
            listNode=listNode.getNext();
        }
        result= (List<Integer>) stack.stream().collect(Collectors.toList());
        return result;
    }


    /**
     * 递归
     * @param listNode
     * @return
     */
    public List<Integer> printListReverse2(ListNode listNode){
        List<Integer> result=new ArrayList<>();
        if (null==listNode){
            return result;
        }
        addList(listNode,result);
        return result;
    }

    private void addList(ListNode listNode,List<Integer> result){
        if (listNode==null){
            return;
        }
        addList(listNode.getNext(),result);
        result.add(listNode.getNode());
    }
}

