package com.kunal.Dsa.Backtracking;

public class LongesPath {
    static int maxPath =-1;

    static int [] dr={1,0,0,-1};
    static int [] dc={0,-1,1,0};
    public static void findLongestPath(int[][] mat, boolean[][] visited, int i, int j, int di, int dj, int n, int m, int cur) {
        if(i==di&&j==dj){
            maxPath=Math.max(maxPath,cur);
            return;
        }

        visited[i][j]=true;

        for (int k = 0; k < 4; k++) {
            int ni = i+dr[k];
            int nj = j+dc[k];
            if(isSafe(mat,visited,ni,nj,n,m,cur+1)){
                findLongestPath(mat,visited,ni,nj,di,dj,n,m,cur+1);
            }
        }
        visited[i][j]=false;
    }
    static boolean isSafe(int[][] mat, boolean[][] visited, int i, int j,  int n, int m, int cur){
        return i>=0&&j>=0&&i<n&&j<m&&!visited[i][j]&&mat[i][j]==1;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };

        int n = mat.length, m = mat[0].length;
        int sx = 0, sy = 0, dx = 2, dy = 3;

        // If source or destination is blocked, return -1
        if (mat[sx][sy] == 0 || mat[dx][dy] == 0) {
            System.out.println("-1");
            return;
        }

        boolean[][] visited = new boolean[n][m];
        findLongestPath(mat, visited, sx, sy, dx, dy, n, m, 0);

        System.out.println(maxPath);
    }
}
