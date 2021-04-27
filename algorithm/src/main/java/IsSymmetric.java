import common.TreeNode;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 二叉树的镜像
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-27 20:11
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-27 gaorunding v1.0.0 修改原因
 * 题目描述：操作给定的二叉树，将其变换为源二叉树的镜像。
 * 思路：使用递归或非递归方式交换每个节点的左右子树位置。
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.getLeft(),root.getRight());
    }

    private boolean isMirror(TreeNode leftNode,TreeNode rightNode){
        if (leftNode==null&&rightNode==null){
            return true;
        }
        if (leftNode==null||rightNode==null){
            return false;
        }
        if (leftNode.getVal()!=rightNode.getVal()){
            return false;
        }
        return isMirror(leftNode.getLeft(),rightNode.getRight())&&isMirror(leftNode.getRight(),rightNode.getLeft());
    }
}
