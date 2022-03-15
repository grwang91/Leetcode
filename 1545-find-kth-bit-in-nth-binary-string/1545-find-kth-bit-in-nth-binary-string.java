class Solution {
    public char findKthBit(int n, int k) {
        boolean invert = false;
        while(k>1) {
            int pow = (int)(Math.log(k)/Math.log(2));
            if(pow == Math.log(k)/Math.log(2)) {
                return invert? '0': '1';
            }
            invert = !invert;
            k = 2*(int)Math.pow(2,pow) - k;
        }
        return invert? '1': '0';
    }
}