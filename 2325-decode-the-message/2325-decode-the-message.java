
class Solution {
    public String decodeMessage(String key, String message) {
        boolean[] check = new boolean[26];
        Map<Character, Character> map = new HashMap<>();
        
        int cnt = 0;
        for(char c: key.toCharArray()) {
            if(c==' ') continue;
            if(!check[c-'a']) {
                map.put(c, (char)(cnt+'a'));
                check[c-'a'] = true;
                cnt++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c: message.toCharArray()) {
            if(c==' ') {
                sb.append(c);
                continue;
            }
            sb.append(map.get(c));
        }
        
        return sb.toString();
    }
}