class trie{
    trie[] child;
    boolean isEnd;
    int val;
    trie(){
        child=new trie[10];
        isEnd=false;
        val=-1;
    }
}
class Solution {
    trie root;
    public void traverse(trie root,List<Integer> res){
        if(root.isEnd){
            res.add(root.val);
        } 
        for(int i=0;i<10;i++){
            if(root.child[i]!=null){
                traverse(root.child[i],res);
            }
          
        }
    }
    public List<Integer> lexicalOrder(int n) {
        root=new trie();
        for(int i=1;i<=n;i++){
            trie cur=root;
            for(char c:Integer.toString(i).toCharArray()){
                int k=c-'0';
                if(cur.child[k]==null)
                    cur.child[k]=new trie();
                cur=cur.child[k];
            }
            cur.val=i;
            cur.isEnd=true;
        }
        List<Integer> res=new ArrayList<>();
        traverse(root,res);
        return res;
    }
}