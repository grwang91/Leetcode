class Solution {
    public String reformat(String s) {
        Stack<Character> stackLetter = new Stack<>();
        Stack<Character> stackNum = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if(c >= '0' && c<='9') {
                stackNum.push(c);
            } else {
                stackLetter.push(c);
            }
        }
        
        if(Math.abs(stackLetter.size()-stackNum.size()) > 1)
            return "";
        
        StringBuilder sb = new StringBuilder();
        
        while(!stackLetter.isEmpty() && !stackNum.isEmpty()) {
            sb.append(stackLetter.pop());
            sb.append(stackNum.pop());
        }
        String output=sb.toString();
        if(!stackLetter.isEmpty()) {
            output = output+stackLetter.pop();            
        }
        if(!stackNum.isEmpty()) {
            output = stackNum.pop()+output;
        }
        return output;
        
    }
}