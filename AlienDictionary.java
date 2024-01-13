import java.util.*;

public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K){
        // Write your code here


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for( int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        for( int i=0;i<N-1;i++ ){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            for( int ptr=0;ptr<len;ptr++ ){
                if( s1.charAt(ptr)!=s2.charAt(ptr) ){
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }    
            }
        }
        
        int[] topo = topoSort(K,adj);
        String ans = "";
        for( int it:topo){
        ans = ans + (char)(it + (int)('a'));        }
        return ans;
    }
    static int[] topoSort( int V, ArrayList<ArrayList<Integer>> adj ){
        
        int indegree[] = new int[V];
        for( int i=0;i<V;i++ ){
            for( int it:adj.get(i)){ indegree[it]++; }
        }

        Queue<Integer> q = new LinkedList<>();
        for( int i=0;i<V;i++ ){
            if( indegree[i] == 0 ) q.add(i);
        }
        int[] topo = new int[V];
        int ind = 0;
        while ( !q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[ind++] = node;
            for( int it:adj.get(node) ){
                indegree[it]--;
                if( indegree[it] == 0 ) q.add(it); 
            }
        }

        if( ind == V ) return topo;
        int[] arr = {};
        return arr;

    }
}
