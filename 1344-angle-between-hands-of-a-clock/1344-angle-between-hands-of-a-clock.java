class Solution {
    public double angleClock(int hour, int minutes) {
        return Math.abs(30*(hour%12)+0.5*minutes-6*minutes) > 180? 360-Math.abs(30*(hour%12)+0.5*minutes-6*minutes): Math.abs(30*(hour%12)+0.5*minutes-6*minutes);
    }
}