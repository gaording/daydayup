package common;

/**
 *
 * @program: daydayup
 * @description: 节点
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-23 21:39
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-23 gaorunding v1.0.0 修改原因
 */
public class ListNode {
    Integer node;
    ListNode next;

    public ListNode() {
    }

    public ListNode(Integer node, ListNode next) {
        this.node = node;
        this.next = next;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
