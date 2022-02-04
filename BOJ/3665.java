import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t,n,m;
	static int[] r,chk;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			n = Integer.parseInt(br.readLine());
			
			r = new int[n+1];
			chk = new int[n+1];
			arr = new int[n+1][n+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
				r[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					arr[r[i]][r[j]] = 1;
					arr[r[j]][r[i]] = -1;
				}
			}
			
			m = Integer.parseInt(br.readLine());
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				
				int temp = arr[first][second];
				arr[first][second] = arr[second][first];
				arr[second][first] = temp;
			}
			
			
			for(int i=1;i<=n;i++) {
				int cnt=0;
				for(int j=1;j<=n;j++) {
					if(arr[i][j] == -1) cnt++;
				}
				chk[cnt] = i;
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i=0;i<n;i++) {
				if(chk[i] == 0) break;
				q.add(chk[i]);
			}
			if(q.size()!=n) System.out.println("IMPOSSIBLE");
			else {
				StringBuilder sb = new StringBuilder();
				while(!q.isEmpty()) {
					sb.append(q.poll()).append(" ");
				}
				System.out.println(sb.toString());
			}
		}
	}
}