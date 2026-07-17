class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int latestDayToCross(int row, int col, int[][] cells) {

        int low = 1;
        int high = cells.length;
        int ans = 0;

        while(low <= high){

            int mid = low + (high-low)/2;

            if(canCross(row,col,cells,mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canCross(int row,int col,int[][] cells,int day){

        int[][] grid = new int[row][col];

        for(int i=0;i<day;i++){
            int r = cells[i][0]-1;
            int c = cells[i][1]-1;
            grid[r][c] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[row][col];

        for(int j=0;j<col;j++){
            if(grid[0][j]==0){
                q.offer(new int[]{0,j});
                vis[0][j]=true;
            }
        }

        while(!q.isEmpty()){

            int[] cur=q.poll();
            int x=cur[0];
            int y=cur[1];

            if(x==row-1) return true;

            for(int[] d:dir){

                int nx=x+d[0];
                int ny=y+d[1];

                if(nx>=0 && nx<row && ny>=0 && ny<col &&
                        !vis[nx][ny] && grid[nx][ny]==0){

                    vis[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        return false;
    }
}