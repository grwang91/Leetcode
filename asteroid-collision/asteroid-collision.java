class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> right = new Stack<>();
        
        for (int asteroid : asteroids) {
            if(right.isEmpty() || right.peek() < 0 || asteroid > 0) {
                right.push(asteroid);
                continue;
            }
            
            boolean flag = false;
            
            while(!flag) {
                if(right.isEmpty() || right.peek() < 0) {
                    flag = true;
                    right.push(asteroid);
                    continue;
                }
                
                if(right.peek() == -asteroid) {
                    flag = true;
                    right.pop();
                } else if (right.peek() > -asteroid) {
                    flag = true;
                } else {
                    right.pop();
                }
            }
            
        }
        
        int[] ans = new int[right.size()];
        
        for (int i=ans.length-1; i>=0; i--) {
            ans[i] = right.pop();
        }
        return ans;
    }
}