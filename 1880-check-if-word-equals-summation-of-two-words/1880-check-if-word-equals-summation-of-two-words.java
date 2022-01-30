class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return toNum(targetWord) == toNum(firstWord)+toNum(secondWord);
    }
    
    private int toNum(String word) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : word.toCharArray()) {
            sb.append(c-'a');
        }
        
        return Integer.parseInt(sb.toString());
    }
}