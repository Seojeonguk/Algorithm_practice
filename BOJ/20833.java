import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,ans;

	public static void main(String[] args) throws Exception {		
		n = Integer.valueOf(br.readLine());
		
		for(int i=1;i<=n;i++) {
			ans += i*i*i;
		}
		
		System.out.println(ans);
		
		bw.flush();
		bw.close();
	}
}