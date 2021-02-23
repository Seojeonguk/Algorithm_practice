import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t,idx,num;
	static int[][] arr;
	static char[] str;
	static boolean dupl;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.valueOf(br.readLine());
		//t = 10;

		for(int test_case = 1;test_case<=t;test_case++) {
			str = br.readLine().toCharArray();
            arr = new int[4][15];
            arr[0][0] = arr[1][0] = arr[2][0] = arr[3][0] = 13;
            dupl = false;
			int size = str.length;
			
			for(int i=0;i<size;i+=3) {
				num = (str[i+1]-'0')*10 + (str[i+2]-'0');
				if(str[i]=='S') idx = 0;
				else if(str[i]=='D') idx=1;
				else if(str[i]=='H') idx=2;
				else if(str[i]=='C') idx=3;
				
				if(arr[idx][num]!=0) {
					dupl = true;
					break;
				}
				
				arr[idx][num]++;
				arr[idx][0]--;
			}
			
			bw.write("#" + String.valueOf(test_case) + " ");
			if(dupl) bw.write("ERROR");
			else {
				for(int i=0;i<4;i++)
					bw.write(String.valueOf(arr[i][0]) + " ");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}