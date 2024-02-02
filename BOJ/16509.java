import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static final int MAP_COL_SIZE = 10;
    static final int MAP_ROW_SIZE = 9;
    
    static final int[][][] DIRECTIONS = {
    	{{-1, 0}, {-2, -1}, {-3, -2}},
    	{{-1, 0}, {-2, 1}, {-3, 2}},
    	{{0, 1}, {-1, 2}, {-2, 3}},
    	{{0, 1}, {1, 2}, {2, 3}},
    	{{0, -1}, {-1, -2}, {-2, -3}},
    	{{0, -1}, {1, -2}, {2, -3}},
    	{{1, 0}, {2, -1}, {3, -2}},
    	{{1, 0}, {2, 1}, {3, 2}}
    };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int kingX = Integer.parseInt(st.nextToken());
        int kingY = Integer.parseInt(st.nextToken());
        
        boolean[][] isVisit = new boolean[MAP_COL_SIZE][MAP_ROW_SIZE];
        isVisit[startX][startY] = true;
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(startX, startY, 0));
        
        int minimumMoveCnt = -1;
        while(!q.isEmpty()) {
        	Position cur = q.poll();
        	
        	if(cur.x == kingX && cur.y == kingY) {
        		minimumMoveCnt = cur.cnt;
        		break;
        	}
        	
        	for(int i = 0; i < 8; i++) {
        		if(!checkMoveInMap(cur.x, cur.y, DIRECTIONS[i])) {
        			continue;
        		}
        		
        		if(checkCollision(cur.x, cur.y, DIRECTIONS[i], kingX, kingY)) {
        			continue;
        		}
        		
        		int nextX = cur.x + DIRECTIONS[i][2][0];
        		int nextY = cur.y + DIRECTIONS[i][2][1];
        		
        		if(isVisit[nextX][nextY]) {
        			continue;
        		}
        		
        		isVisit[nextX][nextY] = true;
        		q.add(new Position(nextX, nextY, cur.cnt + 1));
        	}
        }
        
        sb.append(minimumMoveCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean checkCollision(int x,int y, int[][] dirs, int kingX, int kingY) {
    	boolean isCollision = false;
    	
    	for(int i = 0; i < dirs.length - 1; i++) {
    		int nextX = x + dirs[i][0];
    		int nextY = y + dirs[i][1];
    		
    		if(nextX == kingX && nextY == kingY) {
    			isCollision = true;
    		}
    	}
    	
    	return isCollision;
    }
    
    public static boolean checkMoveInMap(int x,int y, int[][] dirs) {
    	boolean isMoveInMap = true;
    	
    	for(int i = 0; i < dirs.length; i++) {
    		int nextX = x + dirs[i][0];
    		int nextY = y + dirs[i][1];
    		
    		if(isOut(nextX, nextY)) {
    			isMoveInMap = false;
    		}
    	}
    	
    	return isMoveInMap;
    }
    
    public static boolean isOut(int x,int y) {
    	return (x < 0 || y < 0 || x >= MAP_COL_SIZE || y >= MAP_ROW_SIZE);
    }
    
    static class Position {
    	int x, y, cnt;
    	
    	Position(int x,int y,int cnt) {
    		this.x = x;
    		this.y = y;
    		this.cnt = cnt;
    	}
    }
}
