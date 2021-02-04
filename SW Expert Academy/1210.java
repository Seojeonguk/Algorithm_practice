import java.io.*;
import java.util.*;
  
class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n,ans,dx,dy,tc;
    static int[][] arr;
    static boolean[][] visit;
    static int X[]= {0,0,-1},Y[]={-1,1,0};
    static boolean chk;
    
    // dir (0:위로 1:오른쪽 2:왼쪽)
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // = new StringTokenizer(br.readLine());
        //
         
        for (int test_case = 1; test_case <= 10; test_case++) {
        	tc = Integer.valueOf(br.readLine());
        	arr = new int[100][100];
        	visit = new boolean[100][100];
        	
        	chk = false;
        	
        	for(int i=0;i<100;i++)  {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0;j<100;j++) {
        			arr[i][j] = Integer.valueOf(st.nextToken());
        			if(arr[i][j] == 2) {
        				dx=i;
        				dy=j;
        			}
        		}
        	}
        	
        	solve(dx,dy);
             
            bw.write("#" + String.valueOf(test_case)+ " " + String.valueOf(ans) + "\n");
        }
         
        bw.flush();
        bw.close();
    }
    
    public static void solve(int x,int y) {
    	if(chk) return;
    	if(x==0) {
    		ans = y;
    		chk = true;
    		return;
    	}
    	visit[x][y] = true;
    	for(int i=0;i<3;i++) {
    		int nx = x + X[i];
    		int ny = y + Y[i];
    		if(range(nx,ny)) continue;
    		solve(nx,ny);
    	}
    }
    
    public static boolean range(int x,int y) {
    	if(x<0 || y<0 || x>99 || y>99 || arr[x][y] == 0 || visit[x][y]) return true;
    	return false;
    }
}