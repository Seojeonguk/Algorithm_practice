import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] omok;
	static int[] X= {-1,1,1,0},Y= {1,0,1,1};

	public static void main(String[] args) throws Exception {
		omok = new int[21][21];
		
		for(int i=1;i<=19;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=19;j++)
				omok[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=19;i++) {
			for(int j=1;j<=19;j++) {
				if(omok[i][j] != 0) {
					for(int k=0;k<4;k++)
						if(solve(i,j,k)) {
							System.out.println(omok[i][j]);
							System.out.println(i + " " + j);
							System.exit(0);
						}
				}
			}
		}
		System.out.println("0");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean solve(int x,int y,int d) {
		int now = omok[x][y];
		if(omok[x-X[d]][y-Y[d]] == now) return false;
		for(int i=1;i<=5;i++) {
			if(omok[x][y] != now) return false;
			x += X[d];
			y += Y[d];
		}
		return omok[x][y] != now;
	}
}