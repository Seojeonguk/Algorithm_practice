import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			String encoding = sc.next();
			
			Decoder dc = Base64.getDecoder();
			
			byte[] dec = dc.decode(encoding);
			System.out.println("#" + test_case+ " " +new String(dec,"UTF-8"));
		}
	}
}