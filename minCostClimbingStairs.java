class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return helper(cost, -1);
    }
    public int helper(int[]cost, int i){
        if(i+2>=cost.length) return 0;
        else return Math.min(cost[i+1]+helper(cost,i+1), cost[i+2]+helper(cost, i+2));
    }
}