class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] score = new int[n][n];
        int[][] cnt = new int[n][n];
        int[][] map = new int[n][n];
        int mod = 1000000007;
        
        for(int[] c: cnt) {
            Arrays.fill(c, -1);
        }
        for(int[] c: score) {
            Arrays.fill(c, -1);
        }
        cnt[n-1][n-1] = 1;
        score[n-1][n-1] = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board.get(i).charAt(j)=='E' || board.get(i).charAt(j)=='S') {
                    map[i][j] = 0;
                } else if(board.get(i).charAt(j)=='X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = board.get(i).charAt(j)-'0';
                }
            }
        }
        
        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(map[i][j] == -1 || cnt[i][j] == -1) continue;
                
                if(j-1>=0) {
                    if(map[i][j-1] >= 0) {
                        int cur = (score[i][j]+map[i][j-1])%mod;
                        if(score[i][j-1] == cur) {
                            cnt[i][j-1]=(cnt[i][j-1]+cnt[i][j])%mod;
                        } else if(score[i][j-1] < cur) {
                            cnt[i][j-1] = cnt[i][j];
                            score[i][j-1] = cur;
                        }
                    }
                }
                if(j-1>=0 && i-1>=0) {
                    if(map[i-1][j-1] >= 0) {
                        int cur = (score[i][j]+map[i-1][j-1])%mod;
                        if(score[i-1][j-1] == cur) {
                            cnt[i-1][j-1]=(cnt[i-1][j-1]+cnt[i][j])%mod;
                        } else if(score[i-1][j-1] < cur) {
                            cnt[i-1][j-1] = cnt[i][j];
                            score[i-1][j-1] = cur;
                        }
                    }
                }
                if(i-1>=0) {
                    if(map[i-1][j] >= 0) {
                        int cur = (score[i][j]+map[i-1][j])%mod;
                        if(score[i-1][j] == cur) {
                            cnt[i-1][j]=(cnt[i-1][j]+cnt[i][j])%mod;
                        } else if(score[i-1][j] < cur) {
                            cnt[i-1][j] = cnt[i][j];
                            score[i-1][j] = cur;
                        }
                    }
                }
            }
        }
        
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<n; j++) {
        //         System.out.print(score[i][j]+" " );
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<n; j++) {
        //         System.out.print(cnt[i][j]+" " );
        //     }
        //     System.out.println();
        // }
        
        return new int[]{score[0][0]==-1?0:score[0][0], cnt[0][0]==-1?0:cnt[0][0]};
    }
}