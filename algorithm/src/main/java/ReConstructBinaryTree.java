import common.TreeNode;

import java.util.Arrays;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 由前序和中序遍历重建二叉树
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-23 22:08
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-23 gaorunding v1.0.0 修改原因
 */
public class ReConstructBinaryTree {
    /**
     * 递归（传入数组的拷贝）
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre,int[] in){
        if (pre==null||in==null||pre.length==0||in.length==0){
            return null;
        }
        if (pre.length!=in.length){
            return null;
        }
        TreeNode root=new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0]==in[i]){
                root.setLeft(reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i)));
                root.setRight(reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length)));
            }
        }
        return root;
    }

    /**
     * 递归（传入子数组的边界索引）
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode reConstructBinaryTree2(int[] preorder,int[] inorder){
        if (preorder==null||preorder.length==0||inorder==null||inorder.length==0){
            return null;
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder,int preL,int preR,int[] inorder,int inL,int inR){
        if (preL>preR||inL>inR){
            return null;
        }
        int rootVal=preorder[preL];
        int index=0;
        while (index<=inR&&inorder[index]!=rootVal){
            index++;
        }
        TreeNode root=new TreeNode(rootVal);
        root.setLeft(helper(preorder,preL+1,preL-inL+index,inorder,inL,index));
        root.setRight(helper(preorder,preL-inL+index,preR,inorder,index+1,inR));
        return root;
    }
}
