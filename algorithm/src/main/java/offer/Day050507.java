package offer;

import common.TreeNode;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 判断是否是平衡二叉树
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 21:01
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 */
public class Day050507 {

    public boolean isBalance(TreeNode root){
        if (root==null){
            return true;
        }
        boolean isCondition=Math.abs(maxDepth(root.getLeft())-maxDepth(root.getRight()))<=1;
        return isCondition&&isBalance(root.getLeft())&&isBalance(root.getRight());
    }

    public int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=maxDepth(root.getLeft())+1;
        int right=maxDepth(root.getRight())+1;
        return Math.max(left,right);
    }
}
