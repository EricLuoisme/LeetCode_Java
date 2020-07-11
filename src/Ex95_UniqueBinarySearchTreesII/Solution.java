package Ex95_UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generateSubtrees(1, n);
    }

    public List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<>();
        if (s > e) {
            res.add(null);
            return res;
        }

        for (int i = s; i <= e; i++) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}