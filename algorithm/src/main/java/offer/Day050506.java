package offer;

import common.TreeNode;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 求二叉树深度
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 20:51
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 */
public class Day050506 {

    private int deepNum=0;

    public int getDeepNum(TreeNode treeNode){
        helper(treeNode,0);
        return deepNum;
    }

    private void helper(TreeNode treeNode,int curDeepNum){
        if (treeNode==null){
            deepNum=Math.max(deepNum,curDeepNum);
            return;
        }
        helper(treeNode.getLeft(),curDeepNum+1);
        helper(treeNode.getRight(),curDeepNum+1);
    }
}
