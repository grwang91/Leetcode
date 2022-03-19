class Solution {
    public String[] getFolderNames(String[] names) {
        String[] ans = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<names.length; i++) {
            String name = names[i];
            if(!map.containsKey(name)) {
                map.put(name, 1);
                ans[i] = name;
                continue;
            }
            
            int version = map.get(name);
            
            while(map.containsKey(name+"("+version+")")) {
                version++;
            }
            ans[i] = name+"("+version+")";
            map.put(name, version+1);
            map.put(ans[i], 1);
        }
        
        return ans;
    }
}