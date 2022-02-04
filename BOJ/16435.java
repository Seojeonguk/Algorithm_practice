import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,l;
	static int[] fruits;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		fruits = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			fruits[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(fruits);
		
		for(int i=0;i<n;i++) {
			if(fruits[i] > l) break;
			l++;
		}
		
		sb.append(l);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}