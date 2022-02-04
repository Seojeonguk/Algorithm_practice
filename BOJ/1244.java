import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n;
	
	static String arr[] = {"\"재귀함수가 뭔가요?\"","\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.","마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.","그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"","라고 답변하였지."};
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(br.readLine());
		
		bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		solve(0);
		
		
		bw.flush();
		bw.close();
	}
	
	public static void solve(int x) throws Exception {
		if(x==n+1) return;
		if(x!=n) {
			for(int i=0;i<4;i++) {
				minus(x);
				bw.write(arr[i] + "\n");
			}
		}
		else {
			minus(x);
			bw.write(arr[0] + "\n");
			minus(x);
			bw.write("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		}
		
		solve(x+1);
		minus(x);
		bw.write(arr[4]);
		bw.newLine();
	}
	
	public static void minus(int x) throws Exception {
		for(int i=0;i<4*x;i++) bw.write("_");
	}
}