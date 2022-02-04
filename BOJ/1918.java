import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static char[] str;
	static Stack<Character> s;
	static String ans="";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine().toCharArray();
		s = new Stack<Character>();

		int size = str.length;
		for(int i=0;i<size;i++) {
			if('A'<=str[i] && str[i]<='Z') ans+=str[i];
			else if(str[i]=='(') s.push(str[i]);
			else if(str[i]==')') {
				while(s.peek()!='(') ans += s.pop();
				s.pop();
			}
			else {
				while(!s.empty() && solve(s.peek()) >= solve(str[i])) ans+=s.pop();
				s.push(str[i]);
			}
		}

		while(!s.isEmpty()) ans+=s.pop();

		bw.write(ans);

		bw.flush();
		bw.close();
	}

	public static int solve(char c) {
		if(c=='+' || c=='-') return 2;
		else if(c=='*' || c=='/') return 3;
		else return 1;
	}
}