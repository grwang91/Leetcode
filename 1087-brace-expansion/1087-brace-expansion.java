class Solution {
    public String[] expand(String s) {
        List<List<String>> arr = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        
        String[] splited = s.split("\\{");
        
        for(String str :  splited) {
            if(str.equals("")) continue;
            
            for(String str2 : str.split("\\}")) {
                List<String> tmp = new ArrayList<>();
                for(String str3 : str2.split(",")) {
                    tmp.add(str3);
                }
                Collections.sort(tmp);
                arr.add(tmp);
            }
        }
        
        backTrack(arr, 0, new StringBuilder(), ans);
        String[] ansToArray = new String[ans.size()];
        
        for (int i=0; i<ans.size(); i++) {
            ansToArray[i] = ans.get(i);
        }
        
        return ansToArray;
    }
    
    private void backTrack(List<List<String>> arr, int idx, StringBuilder current, List<String> ans) {
        if(idx == arr.size()) {
            ans.add(current.toString());
            return;
        }
        
        for(String s : arr.get(idx)) {
            current.append(s);
            backTrack(arr, idx+1, current, ans);
            current.setLength(current.length()-1);
        }
    }
}