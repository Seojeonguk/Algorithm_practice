import java.io.*;
import java.util.*;
 
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n,ans=Integer.MAX_VALUE;
    static int[][] map;
 
    public static void main(String[] args) throws Exception {
    	n = Integer.valueOf(br.readLine());
    	
    	map = new int [n+1][n+1];
    	
    	for(int i=1;i<=n;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=1;j<=n;j++)
    			map[i][j] = Integer.valueOf(st.nextToken());
    	}
    	
    	for(int d1=1;d1<=n;d1++)
    		for(int d2=1;d2<=n;d2++)
    			for(int i=1;i<=n;i++)
    				for(int j=1;j<=n;j++)
    					solve(i,j,d1,d2);
         
    	System.out.println(ans);
    	
        bw.flush();
        bw.close();
    }
    
    public static void solve(int x,int y,int d1,int d2) {
    	if(!(1<=x && x+d1+d2 <=n && 1<=y-d1 && y+d2<=n)) return;
    	int[][] temp = new int[n+1][n+1];
    	int[] sum = new int[5];
    	
    	
    	for(int r=1;r<x+d1;r++) {
    		int last = (r<x ? y : y-(r-x+1));
    		for(int c=1;c<=last;c++)
    			temp[r][c]=1;
    	}
    	
    	for(int r=1;r<=x+d2;r++) {
    		int start = y+1+(r<=x?0:r-x);
    		for(int c=start;c<=n;c++)
    			temp[r][c]=2;
    	}
    	
    	for(int r=x+d1;r<=n;r++) {
    		int last = y-d1+(r<x+d1+d2?r-(x+d1):d2);
    		for(int c=1;c<last;c++)
    			temp[r][c] = 3;
    	}
    	
    	for(int r=x+d2+1;r<=n;r++) {
    		int start = y+d2 + (r<=x+d1+d2 ? 1-(r-(x+d2)) : -d1);
    		for(int c=start;c<=n;c++)
    			temp[r][c]=4;
    	}
    	
    	for(int r=1;r<=n;r++)
    		for(int c=1;c<=n;c++)
    			sum[temp[r][c]] += map[r][c];
    	
    	
    	
    	Arrays.sort(sum);
    	ans = Math.min(ans,sum[4]-sum[0]);
    }
}