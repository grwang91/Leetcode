class Solution {
    public int lengthOfLastWord(String s) {
        String[] splited = s.trim().split(" ");
        return splited[splited.length-1].length();
    }
}