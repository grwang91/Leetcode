class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        
        while(!path.equals(path.replaceAll("//","/"))) {
            path = path.replaceAll("//", "/");
        }
        for (String s : path.split("/")) {
            
            if(s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(s);
            }
        }
        
        String ans = "";
        while(!stack.isEmpty()) {
            if(stack.peek().equals("")) {
                stack.pop();
                continue;
            }
            ans = "/" + stack.pop()+ans;
        }
        
        
        return ans.equals("")? "/" : ans;
    }
}