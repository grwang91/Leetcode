class Solution {
    public List<Integer> findLonely(int[] nums) {
        int[] check = new int[1000001];
        List<Integer> ans = new ArrayList<>();
        
        for (int num : nums) {
            check[num]++;
        }
        
        for(int num : nums) {
            if(check[num] == 0 || check[num] > 1) {
                continue;
            }
            
            if(num == 0) {
                if(check[num+1] == 0) {
                    ans.add(num);
                }
                continue;
            }
            if(num == 1000000) {
                if(check[num-1] == 0) {
                    ans.add(num);
                }
                continue;
            }
            
            if(check[num-1] == 0 && check[num+1] == 0) {
                ans.add(num);
            }
        }
        return ans;
    }
}