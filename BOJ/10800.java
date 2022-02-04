import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static class ball implements Comparable<ball> {
		int idx,color,size;
		public ball(int idx,int color,int size) {
			this.idx = idx;
			this.color = color;
			this.size = size;
		}
		
		@Override
		public int compareTo(ball o) {
			if(this.size == o.size) return this.color-o.color;
			return this.size-o.size;
		}
	}
	
	static int n;
	static ball[] data;
	static int[] weight,ans;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		weight = new int[n+1];
		data = new ball[n];
		ans = new int[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			data[i] = new ball(i,color,size);
		}
		
		Arrays.sort(data);
		
		int sum=0;

		for(int i=0,j=0;i<n;i++) {
			
			for(; data[j].size < data[i].size;j++ ) {
				weight[data[j].color] += data[j].size;
				sum += data[j].size;
			}
			ans[data[i].idx] = sum - weight[data[i].color];
		}
		
		for(int i=0;i<n;i++) 
			sb.append(ans[i] + "\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}