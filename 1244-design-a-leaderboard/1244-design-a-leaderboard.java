class Leaderboard {
    TreeMap<Integer, Integer> scoreMap;
    Map<Integer, Integer> map;
    public Leaderboard() {
        scoreMap = new TreeMap<>(Collections.reverseOrder());
        map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        int pre = map.getOrDefault(playerId, 0);
        map.put(playerId, pre+score);
        scoreMap.put(score+pre, scoreMap.getOrDefault(pre+score,0)+1);
        scoreMap.put(pre, scoreMap.getOrDefault(pre,1)-1);
    }
    
    public int top(int K) {
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry: scoreMap.entrySet()) {
            for(int i=0; i<entry.getValue(); i++) {
                if(K == 0) break;
                sum+=entry.getKey();
                K--;
            }
        }
        return sum;
    }
    
    public void reset(int playerId) {
        int score = map.get(playerId);
        map.remove(playerId);
        scoreMap.put(score, scoreMap.get(score)-1);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */