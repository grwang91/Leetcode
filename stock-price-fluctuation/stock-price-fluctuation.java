class StockPrice {

    int time;
    int current;
    Map<Integer,Integer> timeToPrice;
    TreeMap<Integer,Integer> treeMap;
    
    public StockPrice() {
        timeToPrice = new HashMap<>();
        treeMap = new TreeMap<>();
        time = 0;
        current = 0;
    }
    
    public void update(int timestamp, int price) {
        if(time <= timestamp) {
            current = price;
            time = timestamp;
        }
        if(timeToPrice.containsKey(timestamp)) {
            int pre = timeToPrice.get(timestamp);
            timeToPrice.put(timestamp,price);
            treeMap.put(price, treeMap.getOrDefault(price,0)+1);
            treeMap.put(pre,treeMap.get(pre)-1);
            if(treeMap.get(pre) <= 0) {
                treeMap.remove(pre);
            }
        } else {
            timeToPrice.put(timestamp,price);
            treeMap.put(price,treeMap.getOrDefault(price,0)+1);
        }
    }
    
    public int current() {
        return current;
    }
    
    public int maximum() {
        return treeMap.lastKey();
    }
    
    public int minimum() {
        return treeMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */