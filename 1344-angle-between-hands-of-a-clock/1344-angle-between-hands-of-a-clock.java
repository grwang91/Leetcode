class Solution {
    public double angleClock(int hour, int minutes) {
        double hourHand = 30*(hour%12)+0.5*minutes;
        double minHand = 6*minutes;
        
        double diff = Math.abs(hourHand-minHand);
        return diff > 180? 360-diff: diff;
    }
}