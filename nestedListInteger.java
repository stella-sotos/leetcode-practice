//Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
//Each element is either an integer, or a list -- whose elements may also be integers or other lists.

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dSum(nestedList,1);
    }
    public int dSum(List<NestedInteger> nestedList, int depth){
        int ans = 0;
        for(int i = 0; i<nestedList.size(); i++){
            if(nestedList.get(i).isInteger()) ans+=(depth*nestedList.get(i).getInteger());
            else ans+=dSum(nestedList.get(i).getList(), depth+1);
        }
        return ans;
    }
}