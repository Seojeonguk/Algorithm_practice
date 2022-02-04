import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,ans;
	static String a,b;
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		a = br.readLine();
		b = br.readLine();
		
		for(int i=0;i<n;i++)
			if(a.charAt(i) != b.charAt(i))
				ans++;
		
		System.out.println(ans);
	}
}