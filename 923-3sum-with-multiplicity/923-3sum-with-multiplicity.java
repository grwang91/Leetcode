class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int ans = 0;
        int mod = 1000000007;

        for(int i=0; i<arr.length; i++) {
            int s = i+1;
            int e = arr.length-1;
            // i = 1
            // s = 2, e = 4
            boolean flag = false;
            while(s<e) {
                // sum = 8
                int sum = arr[s]+arr[e]+arr[i];
                if(sum == target) {
                    flag = true;
                    // s = 2, e = 9
                    int startEnd = s;

                    // se = 3
                    while(startEnd < arr.length && arr[startEnd] == arr[s]) {
                        startEnd++;
                    }

                    // es = 3
                    int endStart = e;
                    while(endStart >=0 && arr[endStart] == arr[e]) {
                        endStart--;
                    }

                    if(arr[s]==arr[e]) {
                        ans= (ans+(e-s+1)*(e-s)/2)%mod;
                    } else {
                        ans=(ans+(startEnd-s)*(e-endStart))%mod;
                    }

                    // s = 6, se = 8, e = 7, es = 5
                    
                    s = startEnd;
                    e = endStart;
                    
                } else if(sum > target) {
                    e--;
                } else {
                    s++;
                }
            }
            if(!flag) {
                continue;
            }
            
            // ans = 10
        }
        return ans;
    }
}