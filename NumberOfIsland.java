import java.util.*;

class NumberOfIsland {
    class pair{
        int first;
        int second;
        public pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m =grid[0].length;
        boolean [][]  visited = new boolean[n][m];
        int ans = 0;
        for(int i = 0 ;i<n ;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j] && grid[i][j]=='1')
                {
                    ans++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return ans;
    }

    // .....................DFS.......................................
    public void dfs(int row,int col,char[][]grid,boolean[][]visited)
    {
       visited[row][col]=true;
       int [] delrow ={-1,0,1,0};
       int [] delcol = {0,1,0,-1};
       for(int i=0 ; i<=3 ;i++){
           
              int  newrow=row+delrow[i];
              int newcol=col+delcol[i];
              if(newrow>=0 && newrow<grid.length && newcol >=0 && newcol<grid[0].length && grid[newrow][newcol]=='1' && visited[newrow][newcol]==false )
              {
                dfs(newrow,newcol,grid,visited);
              }
           
       }
    }
    // ....................BFS...............................
    public void bfs(int row,int col,char[][]grid,boolean[][]visited)
    {
        visited[row][col]=true;
        int [] delrow ={-1,0,1,0};
        int [] delcol = {0,1,0,-1}; 
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(row,col));
        while(q.isEmpty()==false){
            pair r=q.poll();
            int a =r.first;
            int b=r.second;
            for(int i=0 ; i<4 ;i++){
                  int  newrow=a+delrow[i];
                   int newcol=b+delcol[i];
                   if(newrow>=0 && newrow<grid.length && newcol >=0 && newcol<grid[0].length &&  grid [newrow][newcol]=='1' && visited[newrow][newcol]==false )
                  {
                     q.offer(new pair(newrow,newcol));
                     visited[newrow][newcol]=true;
                  }
                
            }

        }

    }
}
