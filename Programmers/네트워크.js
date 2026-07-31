class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        boolean[][] connected = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                connected[i][j] = (computers[i][j] == 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                marking(visited, connected, i);
            }
        }

        return answer;
    }
    
    public void marking(boolean[] visited, boolean[][] connected, int i) {
        visited[i] = true;

        for (int j = 0; j < connected.length; j++) {
            if (!visited[j] && connected[i][j]) {
                marking(visited, connected, j);
            }
        }
    }
}