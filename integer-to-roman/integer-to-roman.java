class Solution {
    public String intToRoman(int num) {
        int thousand = num/1000;
        num-=thousand*1000;
        int hundred = num/100;
        num-=hundred*100;
        int ten = num/10;
        num-=ten*10;
        int one = num;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<thousand; i++) {
            sb.append("M");
        }
        
        if(hundred <=3) {
            for (int i=0; i<hundred; i++) {
                sb.append("C");
            }
        } else if (hundred == 4) {
            sb.append("CD");
        } else if (hundred>=5 && hundred <=8) {
            sb.append("D");
            for (int i=5; i<hundred; i++) {
                sb.append("C");
            }
        } else {
            sb.append("CM");
        }
        
        if(ten <=3) {
            for (int i=0; i<ten; i++) {
                sb.append("X");
            }
        } else if (ten == 4) {
            sb.append("XL");
        } else if (ten>=5 && ten <=8) {
            sb.append("L");
            for (int i=5; i<ten; i++) {
                sb.append("X");
            }
        } else {
            sb.append("XC");
        }
        
        if(one <=3) {
            for (int i=0; i<one; i++) {
                sb.append("I");
            }
        } else if (one == 4) {
            sb.append("IV");
        } else if (one>=5 && one <=8) {
            sb.append("V");
            for (int i=5; i<one; i++) {
                sb.append("I");
            }
        } else {
            sb.append("IX");
        }
        
        return sb.toString();
    }
}