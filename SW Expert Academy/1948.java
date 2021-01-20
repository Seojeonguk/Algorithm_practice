import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		int arr[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		for(int test_case = 1; test_case <= T; test_case++) {
			int input[] = new int[4];
			for(int i=0;i<4;i++) {
				input[i] = sc.nextInt();
			}
			
			int front=input[1];
			for(int i=0;i<input[0]-1;i++) {
				front+=arr[i];
			}

			int back = input[3];
			for(int i=0;i<input[2]-1;i++)
				back+=arr[i];
			
			System.out.println("#" + test_case + " " + (back-front+1));
		}
	}

}
