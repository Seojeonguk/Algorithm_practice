import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n,m;
	static char[][] arr;
	static int[] yu,land;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		arr = new char[n][m];
		yu = new int[m];
		land = new int[m];
		
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		Arrays.fill(yu, -1);
		Arrays.fill(land, n);
		
		int down = 999999;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[j][i]=='X') yu[i] = j;
				else if(arr[j][i] == '#' && land[i]==n) land[i]=j;  
			}
			if(yu[i]!=-1)down = Math.min(down, land[i]-yu[i]);
		}
		down--;
		
		for(int i=0;i<m;i++) {
			for(int j=land[i]-1;j>=0;j--) {
				if(j<down) arr[j][i] = '.';
				else {
					if(arr[j-down][i]=='X') {
						arr[j-down][i] ='.';
						arr[j][i] = 'X';
					}
				}
			}
		}
		
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
		
		bw.flush();
		bw.close();
	}
}