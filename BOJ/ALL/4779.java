import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static String str;

	public static void main(String[] args) throws Exception {
		while((str=br.readLine())!=null) {
			n = Integer.valueOf(str);
			solve(n);
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
	
	public static void solve(int x) throws Exception {
		if(x==0) {
			bw.write("-");
			return;
		}
		
		int nx = 1;
		for(int i=0;i<x-1;i++) nx*=3;
		solve(x-1);
		for(int i=0;i<nx;i++) bw.write(" ");
		solve(x-1);
	}
}