/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int i=0; i<employees.size(); i++) {
            Employee em = employees.get(i);
            map.put(em.id,i);
        }
        
        return bfs(employees, id, map);
    }
    
    private int bfs(List<Employee> employees, int start, Map<Integer,Integer> map) {
        Queue<Integer> q = new LinkedList<>();
        int importanceSum = 0;
        
        q.add(start);
        
        while(!q.isEmpty()) {
            int id = q.poll();
            importanceSum+=employees.get(map.get(id)).importance;
            
            for (int next : employees.get(map.get(id)).subordinates) {
                q.add(next);
            }
        }
        
        return importanceSum;
        
    }
}