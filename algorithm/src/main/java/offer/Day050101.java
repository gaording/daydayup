package offer;

import common.TreeNode;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-01 15:11
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-01 gaorunding v1.0.0 修改原因
 * 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
 */
public class Day050101 {

    public TreeNode convert(TreeNode root){
        TreeNode lastlist=convertNode(root,null);
        TreeNode pHead=lastlist;
        while (pHead!=null&&pHead.getLeft()!=null){
            pHead=pHead.getLeft();
        }
        return pHead;
    }


    public TreeNode convertNode(TreeNode root,TreeNode lastlist){
        if (root==null){
            return null;
        }
        TreeNode cur=root;
        if (cur.getLeft()!=null){
            lastlist=convertNode(cur.getLeft(),lastlist);
        }
        cur.setLeft(lastlist);
        if (lastlist!=null){
            lastlist.setRight(cur);
        }
        lastlist=cur;
        if (cur.getRight()!=null){
            lastlist=convertNode(cur.getRight(),lastlist);
        }
        return lastlist;
    }
}
