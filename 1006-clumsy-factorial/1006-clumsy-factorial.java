class Solution {
    public int clumsy(int n) {
        if(n<=2)
            return n;
        int ans = 0;
        int operation = 0;  // 0-> start, 1->*, 2->/, 3->+
        boolean first = true;
        int tmp = 0;
        while(n>0) {
            if(operation == 0) {
                tmp = n;
                operation++;
            } else if (operation == 1) {
                tmp*=n;
                operation++;
            } else if (operation == 2) {
                tmp/=n;
                if(first) {
                    ans+=tmp;
                    first = false;
                } else {
                    ans-=tmp;
                }
                tmp = 0;
                operation++;
            } else if (operation == 3) {
                ans+=n;
                operation++;
                operation%=4;
            }
            n--;
        }
        
        return ans-tmp;
    }
}