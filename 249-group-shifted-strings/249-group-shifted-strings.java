class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> output = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strings) {
            String shiftedS = makeStartWithA(s);
            System.out.println(shiftedS);
            if(!map.containsKey(shiftedS)) {
                map.put(shiftedS, new ArrayList<>());
            }
            map.get(shiftedS).add(s);
        }
        
        for(String key : map.keySet()) {
            output.add(map.get(key));
        }
        return output;
    }
    
    private String makeStartWithA(String s) {
        int shift = s.charAt(0)-'a';
        char[] arr = s.toCharArray();
        
        for (int i=0; i<arr.length; i++) {
            int num = arr[i]-'a';
            int shiftNum = (26+num-shift)%26;
            arr[i] = (char)(shiftNum);
        }
        
        return new String(arr);
    }
}