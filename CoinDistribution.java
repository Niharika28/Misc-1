// Time Complexity : O(log N)
// Space Complexity : O(H) - recurssive stack space - height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        this.moves=0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode curr){
        if(curr == null) return 0;

        int extras = curr.val-1;

        int leftMoves = dfs(curr.left);
        int rightMoves = dfs(curr.right);

        moves += Math.abs(leftMoves + rightMoves + extras);

        return leftMoves + rightMoves + extras;
    }
}