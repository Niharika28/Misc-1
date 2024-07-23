// Time Complexity : O(N)
// Space Complexity : O(N) - recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int result;
    public int depthSum(List<NestedInteger> nestedList) {
        this.result =0;
        dfs(nestedList, 1);
        return result;
    }

    private void dfs(List<NestedInteger> nestedList, int depth) {

        for(NestedInteger ne : nestedList) { //{3, [1,2]}
            if(ne.isInteger()) {
                result += depth * ne.getInteger();
            }else{
                dfs(ne.getList(), depth+1);
            }
        }
    }
}


//Approach BFS
// Time Complexity : O(N)
// Space Complexity : O(N)
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int depth =1;
        int total =0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0;i< size;i++) {
                NestedInteger ne = queue.poll();
                if(ne.isInteger()) {
                    total += ne.getInteger() * depth;
                }else{
                    queue.addAll(ne.getList());
                }
            }
            depth++;
        }
        return total;

    }
}