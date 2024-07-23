// Time Complexity : O(log K)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int brokenCalc(int startValue, int target) {
        int count=0;

        while(target > startValue) {
            count++;

            if(target %2 == 0) {
                target = target /2;
            }else{
                target += 1;
            }
        }

        return count + startValue - target;
    }
}

// BFS - Exponential solution O(2^n)
class Solution {
    public int brokenCalc(int startValue, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startValue);

        HashSet<Integer> set = new HashSet<>();
        set.add(startValue);

        int level =0;

        while(!q.isEmpty()){
            int size= q.size();

            for(int i=0;i< size;i++){
                int curr = q.poll();

                if(curr == target) return level;
                if(curr > 1) {
                    int num = curr- 1;

                    if(num == target){
                        return level+1;
                    }

                    if(!set.contains(num)){
                        set.add(num);
                        q.add(num);
                    }
                }

                if(curr < target) {
                    int num = curr * 2;

                    if(num == target){
                        return level+1;
                    }

                    if(!set.contains(num)){
                        set.add(num);
                        q.add(num);
                    }
                }
            }
            level++;

        }
        return -1;

    }
}