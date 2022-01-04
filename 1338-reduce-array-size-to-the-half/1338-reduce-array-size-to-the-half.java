class Solution {
    class Freq implements Comparator<Integer>
    {
        public int compare(Integer i1, Integer i2)
        {
            return Integer.compare(i2.intValue(),i1.intValue());
        }
    }
    public int minSetSize(int[] arr) {
       
        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue(arr.length,new Freq());
        
         //Use a HashMap to keep a count of frequencies of each element
        for(int i=0;i<arr.length;i++)
        {
          hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);            
        }
        
        //Iterate over the Hashmap values and add them to Priority Queue so that we get the values in descending order
        //By Sorting in descending order, we ensure that we need to remove minimum type of numbers
        for(Map.Entry<Integer,Integer> entry: hm.entrySet())
        {
           pq.add(entry.getValue());
         
        }
       
        //Keep removing elements from Priority Queue and adding them until the length becomes greater than or equal to half of length of array. 
        int count=0; int len=0;
        while(!pq.isEmpty())
        {
            count++;
            len+=pq.poll();
            if(len>=arr.length/2)
                return count;
          
        }
        return count;
    }
}