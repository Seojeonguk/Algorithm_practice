import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[][] map;
	static boolean[][] width,height;
	static boolean[][][] sqr;

	public static void main(String[] args) throws Exception {
		map = new int[9][9];
		
		width = new boolean[9][10];
		height = new boolean[9][10];
		sqr = new boolean[3][3][10];
		
		for(int i=0;i<9;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0;j<9;j++) {
				map[i][j] = temp[j]-'0';
				width[i][map[i][j]] = true;
				height[j][map[i][j]] = true;
				sqr[i/3][j/3][map[i][j]] = true;
			}
		}
		
		solve(0);
	}
	
	public static void solve(int x) throws Exception {
		if(x==81) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			br.close();
			System.exit(0);
		}
		
		int w = x/9;
		int h = x%9;
		if(map[w][h]!=0) solve(x+1);
		else {
			for(int i=1;i<=9;i++) {
				if(!width[w][i] && !height[h][i] && !sqr[w/3][h/3][i]) {
					width[w][i] = true;
					height[h][i] = true;
					sqr[w/3][h/3][i] = true;
					map[w][h] = i;
					solve(x+1);
					map[w][h] = 0;
					width[w][i] = false;
					height[h][i] = false;
					sqr[w/3][h/3][i] = false;
				}
			}
		}
	}
}