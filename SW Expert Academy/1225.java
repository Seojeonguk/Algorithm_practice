import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static Queue<Integer> q;
	static int t,x;
	static int X[]= {1,2,3,4,5};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case=1 ;test_case<=10;test_case++) {
			q = new LinkedList<Integer>();
			
			t = Integer.valueOf(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<8;i++) 
				q.offer(Integer.valueOf(st.nextToken()));
			
			int idx=0;
			while(true) {
				int outdata = q.poll();
				outdata -= X[idx];
				idx = (idx+1)%5;
				if(outdata<=0) {
					outdata = 0;
					q.offer(outdata);
					break;
				}
				q.offer(outdata);
			}
			
			System.out.printf("#%d ",test_case);
			while(!q.isEmpty()) {
				System.out.printf("%d ",q.poll());
			}
			System.out.println();
		}

		bw.flush();
		bw.close();
	}
}