import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n,cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		
		while(n!=0) {
			if(n%2==0) {
				cnt++;
				n/=2;
			}
			else break;
		}

		bw.write(String.valueOf(n) + " " + String.valueOf(cnt));

		bw.flush();
		bw.close();
	}
}