public class ZigzagIterator {
    int i1;
    int i2;
    boolean turnOne;
    List<Integer> v1;
    List<Integer> v2;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i1 = 0;
        i2 = 0;
        turnOne = v1.size() > 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        int output;
        if(turnOne) {
            output = v1.get(i1);
            i1++;
            if(i2 < v2.size()) {
                turnOne= false;
            }
        } else {
            output = v2.get(i2);
            i2++;
            if(i1 < v1.size()) {
                turnOne= true;
            }
        }
        return output;
    }

    public boolean hasNext() {
        return i1 < v1.size() || i2 < v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */