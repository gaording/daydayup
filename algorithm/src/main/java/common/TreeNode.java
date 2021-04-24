package common;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 树节点
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-23 22:10
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-23 gaorunding v1.0.0 修改原因
 */
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
