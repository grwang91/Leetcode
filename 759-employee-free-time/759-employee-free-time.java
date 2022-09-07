/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> flat = new ArrayList<>();
        for(List<Interval> i: schedule) {
            for(Interval j: i) {
                flat.add(j);
            }
        }
        Collections.sort(flat, (i1,i2)->i1.start==i2.start? i1.end-i2.end : i1.start-i2.start);
        List<Interval> ans = new ArrayList<>();
        int s = flat.get(0).start;
        
        for(Interval i: flat) {
            if(i.start > s) {
                ans.add(new Interval(s, i.start));
                s = i.end;
            } else {
                s = Math.max(s,i.end);
            }
        }
        return ans;
    }
}