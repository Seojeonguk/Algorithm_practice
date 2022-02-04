import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,m,l=30,r,b,t=30;
	static char[][] map;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n+2][m+2];
		for(int i=0;i<n+2;i++)
			Arrays.fill(map[i], '.');
		
		for(int i=1;i<=n;i++) {
			String a = br.readLine();
			for(int j=1;j<=m;j++)
				map[i][j] = a.charAt(j-1);
		}
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++) {
				int cnt=0;
				for(int d=0;d<4;d++) 
					if(map[i+X[d]][j+Y[d]]=='.') 
						cnt++;
				
				if(cnt>=3) q.add(new int[] {i,j});
			}
		
		while(!q.isEmpty()) {
			int[] outdata = q.poll();
			map[outdata[0]][outdata[1]]='.';
		}
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++)
				if(map[i][j]=='X') {
					l = Math.min(l, j);
					r = Math.max(r, j);
					t = Math.min(t, i);
					b = Math.max(b, i);
				}
		
		for(int i=t;i<=b;i++) {
			for(int j=l;j<=r;j++)
				sb.append(map[i][j]);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
} 