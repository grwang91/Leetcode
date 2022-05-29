class Solution {
    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        
        String[] split = sentence.split(" ");
        
        for(int i=0; i<split.length; i++) {
            split[i] = replacePrice(split[i], discount);
        }
        
        for(String s: split) {
            sb.append(s+" ");
        }
        
        return sb.toString().trim();
    }
    
    private String replacePrice(String s, int discount) {
        if(s.charAt(0) != '$' || s.length() == 1) return s;
        
        for(int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '.' || c>='0' && c<='9') continue;
            
            return s;
        }
        
        Double num = Double.parseDouble(s.substring(1));
        Double d = num*(100-discount)/100;
        
        return "$"+String.format("%.2f",d);
    }
}