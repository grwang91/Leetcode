class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] ans = new int[adjacentPairs.length+1];
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] pairs: adjacentPairs) {
            int a = pairs[0];
            int b = pairs[1];
            
            if(!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            if(!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            
            map.get(a).add(b);
            map.get(b).add(a);
            
            if(set.contains(a)) {
                set.remove(a);
            } else {
                set.add(a);
            }
            if(set.contains(b)) {
                set.remove(b);
            } else {
                set.add(b);
            }
        }
        
        Iterator iter = set.iterator();
        int cur = 0;
        while(iter.hasNext()) {
            cur = (int)iter.next();
            break;
        }

        ans[0] = cur;
        for(int i=1; i<ans.length; i++) {
            for(int next: map.get(cur)) {
                if(i>=2 && next == ans[i-2]) continue;
                cur = next;
            }
            ans[i] = cur;
        }
        
        return ans;
    }
}