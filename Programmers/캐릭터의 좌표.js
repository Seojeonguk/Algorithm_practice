class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        Coordinate[] coordinates = new Coordinate[4];
        coordinates[0] = new Coordinate("up", 0, 1);
        coordinates[1] = new Coordinate("down", 0, -1);
        coordinates[2] = new Coordinate("left", -1, 0);
        coordinates[3] = new Coordinate("right", 1, 0);

        int curX = 0;
        int curY = 0;

        for (String key : keyinput) {
            for (Coordinate coordinate : coordinates) {
                if (key.equals(coordinate.name)) {
                    int nextX = curX + coordinate.x;
                    int nextY = curY + coordinate.y;

                    if (isIn(nextX, nextY, board[0], board[1])) {
                        curX = nextX;
                        curY = nextY;
                    }
                }
            }
        }

        return new int[]{curX, curY};
    }

    public boolean isIn(int x, int y, int width, int height) {
        return Math.abs(x) <= width / 2 && Math.abs(y) <= height / 2;
    }

    static class Coordinate {
        String name;
        int x;
        int y;

        public Coordinate(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }
}