package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @program: daydayup
 * @description: 层序遍历二叉树
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-30 14:45
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-30 gaorunding v1.0.0 修改原因
 */
public class Day043004 {
    public List<TreeNode> printFromTopToBottomm(TreeNode treeNode){
        if (treeNode==null){
            return null;
        }
        LinkedList<TreeNode> linkNode=new LinkedList<>();
        linkNode.add(treeNode);
        List<TreeNode> result=new ArrayList<>();
        while (!linkNode.isEmpty()){
            TreeNode node=linkNode.pop();
            result.add(node);
            if (null!=node.getLeft()){
                linkNode.add(node.getLeft());
            }
            if (null!=node.getRight()){
                linkNode.add(node.getRight());
            }
        }
        return result;
    }
}
