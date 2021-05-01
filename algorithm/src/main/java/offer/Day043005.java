package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 二叉树前中后序遍历
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-30 14:58
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-30 gaorunding v1.0.0 修改原因
 */
public class Day043005 {
    /**
     * 前序
     * @param root
     * @return
     */
    public List<TreeNode> qx(TreeNode root){
        if (root==null){
            return null;
        }
        List<TreeNode> result=new ArrayList<>();
        qxSort(result,root);
        return result;
    }

    private void qxSort(List<TreeNode> result,TreeNode root){
        result.add(root);
        if (root.getLeft()!=null){
            qxSort(result,root.getLeft());
        }
        if (root.getRight()!=null){
            qxSort(result,root.getRight());
        }
    }

    /**
     * 中序
     * @param root
     * @return
     */
    public List<TreeNode> zx(TreeNode root){
        if (root==null){
            return null;
        }
        List<TreeNode> result=new ArrayList<>();
        zxSort(result,root);
        return result;
    }

    private void zxSort(List<TreeNode> result,TreeNode root){
        if (root.getLeft()!=null){
            zxSort(result,root.getLeft());
        }
        result.add(root);
        if (root.getRight()!=null){
            zxSort(result,root.getRight());
        }
    }

    /**
     * 后序
     * @param root
     * @return
     */
    public List<TreeNode> hx(TreeNode root){
        if (root==null){
            return null;
        }
        List<TreeNode> result=new ArrayList<>();
        hxSort(result,root);
        return result;
    }

    private void hxSort(List<TreeNode> result,TreeNode root){
        if (root.getLeft()!=null){
            hxSort(result,root.getLeft());
        }
        if (root.getRight()!=null){
            hxSort(result,root.getRight());
        }
        result.add(root);
    }
}
