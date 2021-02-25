import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int first;
	static List<Integer> ans,templist;

	public static void main(String[] args) throws Exception {
		first = Integer.valueOf(br.readLine());
		ans = new LinkedList<Integer>();
		
		for(int i=0;i<=first;i++) {
			templist = new LinkedList<Integer>();
			templist.add(first);
			templist.add(i);
			int size = 2;
			while(true) {
				int bb = templist.get(size-2);
				int b = templist.get(size-1);
				if(bb>=b) {
					templist.add(bb-b);
					size++;
				} 
				else break;
			}
			
			if(size>ans.size())
				ans = templist;
		}
		
		bw.write(String.valueOf(ans.size()));
		bw.newLine();
		
		for (int item : ans)
			bw.write(String.valueOf(item) + " " );


		bw.flush();
		bw.close();
	}
}