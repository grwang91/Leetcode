class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        int ans = 0;
        
        String[] start = startTime.split(":");
        String[] finish = finishTime.split(":");
        
        int startHour = Integer.parseInt(start[0]);
        int startMin = Integer.parseInt(start[1]);
        int finishHour = Integer.parseInt(finish[0]);
        int finishMin = Integer.parseInt(finish[1]);
        
        int ss = startHour*60 + startMin;
        int ff = finishHour*60 + finishMin;
        
        int calibS = startHour*60 + calibrateStartMin(startMin);
        int calibF = finishHour*60 + calibrateFinishMin(finishMin);
        
        int diffTime = ff >= ss ? calibF-calibS : calibF-calibS+24*60;
        
        ans+=diffTime/15;
        
        return Math.max(0,ans);
        
    }
    
    private int calibrateStartMin(int min) {
        if(min>0 && min<=15) {
            return 15;
        } else if (min > 15 && min <= 30) {
            return 30;
        } else if (min > 30 && min <= 45) {
            return 45;
        } else if (min == 0) {
            return 0;
        }
        
        return 60;
    }
    
    private int calibrateFinishMin(int min) {
        if(min>=0 && min<15) {
            return 0;
        } else if (min >= 15 && min < 30) {
            return 15;
        } else if (min >= 30 && min < 45) {
            return 30;
        }
        
        return 45;
    }
}