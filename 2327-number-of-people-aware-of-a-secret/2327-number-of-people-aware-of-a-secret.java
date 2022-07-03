class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        int[] newPerson = new int[n+1];
        
        newPerson[1] = 1;
        int secret = 1;
        int delayed = 0;
        
        for(int i=2; i<=n; i++) {
            if(i-delay>=1) {
                delayed=(delayed+newPerson[i-delay])%mod;
            }
            if(i-forget >= 1) {
                secret-=newPerson[i-forget]%mod;
                while(secret<0) {
                    secret+=mod;
                }
                delayed-=newPerson[i-forget];
                while (delayed<0) {
                    delayed+=mod;
                }
            
            }
            newPerson[i] = delayed%mod;
            secret=(secret+delayed)%mod;
        }
        
        return secret;
    }
}