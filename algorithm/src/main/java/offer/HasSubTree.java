package offer;

import common.TreeNode;

/**
 *
 * @program: daydayup
 * @description:判断二叉树A中是否包含子树B
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-27 19:53
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-27 gaorunding v1.0.0 修改原因
 * 题目描述：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 思路：若根节点相等，利用递归比较他们的子树是否相等，若根节点不相等，则利用递归分别在左右子树中查找
 */
public class HasSubTree {

    public boolean hasSubTree(TreeNode A,TreeNode B){
        if (null==A||null==B){
            return false;
        }
        if (A.getVal()==B.getVal()){
            if (A.getLeft()==null&&A.getRight()==null&&B.getLeft()==null&&B.getRight()==null){
                return true;
            }
            return hasSubTree(A.getLeft(),B.getLeft())&&hasSubTree(A.getRight(),B.getRight());
        }
        return hasSubTree(A.getLeft(),B)||hasSubTree(A.getRight(),B);
    }
}
