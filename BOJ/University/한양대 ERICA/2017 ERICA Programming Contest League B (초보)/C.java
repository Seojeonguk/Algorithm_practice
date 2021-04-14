import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static List<Integer> l = new LinkedList<Integer>();
	static int ans,sum;
	static HashSet<String> hashset = new HashSet<String>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			
			int x = Integer.parseInt(st.nextToken());
			l.add(x);
		}
		
		sum = Integer.parseInt(br.readLine());
		
		Collections.sort(l);
		
		int size = l.size();
		
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				if(i==j) continue;
				int first = l.get(i);
				int second = l.get(j);
				if(first+second==sum) {
					String temp = String.valueOf(first)+ String.valueOf(second);
					if(!hashset.contains(temp)) {
						hashset.add(temp);
						sb.append(first + " " + second + "\n");
					}
				}
			}
		}
		
		sb.append(hashset.size());
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}