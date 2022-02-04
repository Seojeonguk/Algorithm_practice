import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int test_case,n,e;
	static int graph[];
	static boolean chk;
	static Vector<Integer> v[];
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		test_case = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<=test_case;tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.valueOf(st.nextToken());
			e = Integer.valueOf(st.nextToken());
			
			graph = new int[n+1];
			v = new Vector[n+1];
			chk = true;
			
			for(int i=0;i<n+1;i++)
				v[i] = new Vector<>();
			
			for(int i=0;i<e;i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				v[a].add(b);
				v[b].add(a);
			}
			
			for(int i=1;i<=n;i++) {
				if(graph[i] == 0 && !solve(i,-1)) {
					chk = false;
					break;
				}
			}
			bw.write(chk ? "YES" : "NO");
			bw.newLine();
		}
		
		
		bw.flush();
		bw.close();
	}
	
	public static boolean solve(int index,int color) {
		graph[index] = color;
		for(int next : v[index]) {
			if(graph[next] == color) return false;
			if(graph[next]==0 && !solve(next,-color))
				return false;
		}
		
		return true;
	}
}