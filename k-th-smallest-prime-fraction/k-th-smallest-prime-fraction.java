class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double l = 0.0;
        double r = 1.0;
        
        while (l<r) {
            int count = 0;
            double m = (l+r)/2.0;
            double maxFraction = 0.0;
            int j = 1;
            int x=0, y=0;
            
            for (int i=0; i<n-1; i++) {
                while(j < n && arr[i] > arr[j]*m) {
                    j++;
                }
                if(j==n) break;
                
                count+=(n-j);
                
                if((double)arr[i]/arr[j] > maxFraction) {
                    maxFraction = (double)arr[i]/arr[j];
                    x = arr[i];
                    y = arr[j];
                }
            }
            // System.out.println(m + " " + count + " " + x + " " + y);
            if(count == k) {
                return new int[]{x,y};
            } else if (count < k) {
                l = m;
            } else {
                r = m;
            }
            
        }
        
        return new int[]{0,0};
    }
}