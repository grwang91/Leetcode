class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        
        for(char c : brokenLetters.toCharArray()) {
            set.add(c);
        }
        
        for(String s: text.split(" ")) {
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(set.contains(c)) {
                    break;
                }
                if(i==s.length()-1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}