import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n,m;
	static int arr[];
	static int input[];
	static boolean chk[];
	
	public static void solve (int x) throws Exception {
		if(x==m) {
			for(int i=0;i<arr.length;i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(chk[i] == false) {
				chk[i] = true;
				arr[x]=input[i];
				solve(x+1);
				chk[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		input = new int[n];
		chk = new boolean[n];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) 
			input[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(input);
		
		solve(0);
		
		bw.flush();
		bw.close();
	}

}
