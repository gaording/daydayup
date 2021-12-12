package offer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-30 15:30
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-30 gaorunding v1.0.0 修改原因
 * 题目描述：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Day043007 {
    public CustomListNode copy(CustomListNode node) {
        if (node == null) {
            return null;
        }
        CustomListNode pointer = node;
        CustomListNode newHead = new CustomListNode();
        CustomListNode newPointer = newHead;
        newPointer.val = node.val;
        newPointer.random=pointer.random;
        Map<CustomListNode, CustomListNode> map = new HashMap<>();
        map.put(pointer, newPointer);
        while ((pointer = pointer.next) != null) {
            CustomListNode nextNode = new CustomListNode();
            nextNode.val = pointer.val;
            nextNode.random=pointer.random;
            newPointer.next = nextNode;
            newPointer = nextNode;
            map.put(pointer, newPointer);
        }
        newPointer=newHead;
        while (newPointer!=null){
            newPointer.random=map.get(newPointer.random);
            newPointer=newPointer.next;
        }
        return newHead;
    }
}

class CustomListNode {
    int val;
    CustomListNode next;
    CustomListNode random;
}
