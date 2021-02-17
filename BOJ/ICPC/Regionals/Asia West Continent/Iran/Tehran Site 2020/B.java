import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,ans,now,input;
	
	public static void main(String[] args) throws Exception {
		n = Integer.valueOf(br.readLine());
		
		for(int i=0;i<n;i++) {
			input = Integer.valueOf(br.readLine());
			if(i==0) now = input;
			
			if(input < now) now = input;
			else ans += input-now;
		}
		
		bw.write(String.valueOf(ans));
		bw.newLine();
		
		bw.flush();
		bw.close();
	}
}