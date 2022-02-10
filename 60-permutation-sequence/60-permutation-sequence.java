class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            list.add(i);
        }
        
        int fact = factorial(n);
        k--;
        while(list.size()>0) {
            fact = n==0? 1: fact/n;
            n--;
            
            int idx = k/fact;
            k%=fact;
            
            sb.append(list.get(idx));
            list.remove(idx);
        }

        return sb.toString();
    }
    
    private int factorial(int n) {
        if(n<=1) return 1;
        return n*factorial(n-1);
    }
}