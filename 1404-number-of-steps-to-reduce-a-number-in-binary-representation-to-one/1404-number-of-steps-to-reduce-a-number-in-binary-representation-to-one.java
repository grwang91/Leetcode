class Solution {
    public int numSteps(String s) {
        int c=0,ans=0;
        if(s.length()==1)
            return 0;
        
        for(int i=s.length()-1;i>=0;i--)
        {
            if(i==0 && s.charAt(i)=='1' && c==0)
                break;
                
            int tmp= Character.getNumericValue(s.charAt(i))  +c;
            if(tmp%2==0)
            {
                c=tmp/2;
                ans++;
            }
            else
            {
                ans+=2;
                c=1;
            }
        }
        return ans;
    }
}