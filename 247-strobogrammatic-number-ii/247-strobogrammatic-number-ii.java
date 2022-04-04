class Solution {
    char[] num = {'0', '1', '6', '9', '8'};
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        recursive(0, n, new StringBuilder(), ans);
        return ans;
    }
    
    private void recursive(int len, int n, StringBuilder sb, List<String> ans) {
        if(len == n/2) {
            if(n%2==0) {
                ans.add(constructNumber(sb.toString(), n, ' '));
            } else {
                ans.add(constructNumber(sb.toString(), n, '1'));
                ans.add(constructNumber(sb.toString(), n, '8'));
                ans.add(constructNumber(sb.toString(), n, '0'));
            }
            
            return;
        }
        
        for(char c: num) {
            if(len == 0 && c=='0') continue;
            sb.append(c);
            recursive(len+1, n, sb, ans);
            sb.setLength(sb.length()-1);
        }
    }
    
    private String constructNumber(String s, int n, char c) {
        StringBuilder sb = new StringBuilder(s);
        if(n%2==1) {
            sb.append(c);
        }
        
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i)=='0') {
                sb.append('0');
            } else if(s.charAt(i)=='1') {
                sb.append('1');
            } else if(s.charAt(i)=='8') {
                sb.append('8');
            } else if(s.charAt(i)=='6') {
                sb.append('9');
            } else if(s.charAt(i)=='9') {
                sb.append('6');
            }
        }
        
        return sb.toString();
    }
}