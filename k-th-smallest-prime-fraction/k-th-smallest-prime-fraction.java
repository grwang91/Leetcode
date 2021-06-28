class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1,p2)->p2.a*p1.b - p2.b*p1.a);
        
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                Pair p = new Pair(arr[i],arr[j]);
                maxHeap.add(p);
                if(maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        int[] ans = new int[2];
        Pair p = maxHeap.poll();
        ans[0] = p.a;
        ans[1] = p.b;
        
        return ans;
        
    }
    
    static class Pair {
        int a;
        int b;
        
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}