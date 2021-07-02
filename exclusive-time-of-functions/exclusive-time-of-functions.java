class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[n];
        int current = 0;
        
        for (String log : logs) {
            String[] splited = log.split(":");
            int num = Integer.parseInt(splited[0]);
            int time = Integer.parseInt(splited[2]);
            
            if(splited[1].equals("start")) {
                if(!stack.isEmpty()) {
                    ans[stack.peek().num]+=time-current;
                }
                stack.push(new Pair(num,time));
                current = time;
            } else {
                
                ans[stack.peek().num]+=time-current+1;
                stack.pop();
                current = time+1;
            }
        }
        return ans;
        
    }
    class Pair {
        int num;
        int time;
        
        public Pair(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}