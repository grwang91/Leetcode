class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<Triple> operations = new ArrayList<>();
        Map<Integer, Triple> replaceMap = new HashMap<>();
        
        for (int i=0; i<indices.length; i++) {
            operations.add(new Triple(indices[i], sources[i], targets[i]));
        }
        Collections.sort(operations, (o1, o2) -> o1.indice - o2.indice);
        
        // int start = 0;
        for (Triple operation : operations) {
            int index = s.indexOf(operation.source, operation.indice);
            if(index == operation.indice) {
                replaceMap.put(index, operation);
                // start+=operation.source.length();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if(replaceMap.containsKey(i)) {
                sb.append(replaceMap.get(i).target);
                i+=replaceMap.get(i).source.length()-1;
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
    class Triple {
        int indice;
        String source;
        String target;
        
        public Triple(int indice, String source, String target) {
            this.indice = indice;
            this.source = source;
            this.target = target;
        }
    }
}