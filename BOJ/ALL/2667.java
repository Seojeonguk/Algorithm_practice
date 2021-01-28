import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n;
	static int arr[][];
	static boolean visit[][];
	static Vector<Integer> v = new Vector<>();
	static int X[] = {1,0,-1,0}, Y[] = {0,1,0,-1};
	static int cnt;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		visit = new boolean[n][n];
		
		
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			
			for(int j=0;j<n;j++)
				arr[i][j] = line.charAt(j)-'0';
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					solve(i,j);
					v.add(cnt);
				}
			}
		}
		
		Collections.sort(v);
		
		bw.write(String.valueOf(v.size()) + "\n");
		
		for(int x : v) 
			bw.write(String.valueOf(x) + "\n");
		
		bw.flush();
		bw.close();
	}
	
	public static void solve(int dx,int dy) throws Exception {
		Queue<node> q = new LinkedList<node>();
		q.add(new node(dx,dy));
		visit[dx][dy] = true;
		cnt=0;
		
		while(!q.isEmpty()) {
			node node = q.poll();
			cnt++;

			for(int i=0;i<4;i++) {
				int nx = node.x + X[i];
				int ny = node.y + Y[i];
				
				if(nx <0 || ny<0 || nx>n-1 || ny>n-1||visit[nx][ny] || arr[nx][ny] ==0) continue;
				q.add(new node(nx,ny));
				visit[nx][ny]  = true;
			}
		}
	}
}

class node{
	int x;
	int y;
	
	node(int x,int y) {
		this.x = x;
		this.y = y;
	}
}