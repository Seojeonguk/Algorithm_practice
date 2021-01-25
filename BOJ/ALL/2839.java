import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		int ans=-1;
		
		for(int i=n/5;i>=0;i--) {
			int x = n-i*5;
			if(x%3==0) {
				ans = i+x/3;
				break;
			}
		}

		bw.write(String.valueOf(ans));
		
		bw.flush();
		bw.close();
	}
}