package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-30 15:15
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-30 gaorunding v1.0.0 修改原因
 * 题目描述：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Day043006 {

    public List<List<TreeNode>> getPath(TreeNode root, int sum) {
        List<List<TreeNode>> result = new ArrayList<>();
        fromTopToBottom(result, new ArrayList<>(), root, sum);
        return result;
    }

    private void fromTopToBottom(List<List<TreeNode>> result, List<TreeNode> prefix, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        prefix.add(root);
        if (sum == root.getVal()) {
            if (root.getLeft() == null && root.getRight() == null) {
                result.add(prefix);
            }
            return;
        }
        if (sum < root.getVal()) {
            return;
        }
        if (sum > root.getVal()) {
            //TODO 其实这里可以用一个list，每回遍历完之后list移除最后一个元素，相当于回退
            fromTopToBottom(result, new ArrayList<>(prefix), root.getLeft(), sum - root.getVal());
            fromTopToBottom(result, new ArrayList<>(prefix), root.getRight(), sum - root.getVal());
        }
    }
}
