class Solution {
    public int compareVersion(String version1, String version2) {
        String[] splited1 = version1.split("\\.");
        String[] splited2 = version2.split("\\.");
        
        for(int i=0; i<Math.min(splited1.length, splited2.length); i++) {
            int num1 = Integer.parseInt(splited1[i]);
            int num2 = Integer.parseInt(splited2[i]);

            if(num1 < num2) {
                return -1;
            } else if(num1 > num2) {
                return 1;
            }
        }
        String[] tmp = null;
        if(splited1.length > splited2.length) {
            tmp = splited1;
        } else {
            tmp = splited2;
        }
        
        if(splited1.length != splited2.length) {
            for(int i=Math.min(splited1.length, splited2.length); i<Math.max(splited1.length, splited2.length); i++) {
                if(Integer.parseInt(tmp[i]) != 0) {
                    return splited1.length > splited2.length? 1: -1;
                }
            }
        }
        
        return 0;
    }
}