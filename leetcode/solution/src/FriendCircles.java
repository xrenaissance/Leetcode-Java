public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int num = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                dfs(M, i);
                num++;
            }
        }
        return num;
    }

    /**
     * M[i][i] = 0表示第i个人我们已经访问过了
     * 访问过的人无需重复访问
     */
    private void dfs(int[][] M, int i) {
        M[i][i] = 0;
        for (int j = 0; j < M.length; j++) {
            if (M[j][j] != 0 && M[i][j] == 1) {
                dfs(M, j);
            }
        }
    }
}
