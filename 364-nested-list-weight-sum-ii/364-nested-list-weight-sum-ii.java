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
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int maxDepth = dfs(nestedList, 1, map);
        
        for (int key : map.keySet()) {
            ans+=(maxDepth-key+1)*map.get(key);
        }
        return ans;
    }
    
    private int dfs(List<NestedInteger> nestedList, int depth, Map<Integer,Integer> map) {
        int maxDepth = depth;
        for(NestedInteger list : nestedList) {
            if(list.isInteger()) {
                map.put(depth, map.getOrDefault(depth,0)+list.getInteger());
                continue;
            }
            maxDepth = Math.max(dfs(list.getList(), depth+1, map), maxDepth);
        }
        
        return maxDepth;
    }
}