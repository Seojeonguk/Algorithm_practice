import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int size = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < size; i++) {
        	for(int j = 0; j < size; j++) {
        		if(j == 0 || j == size - 1) {
        			sb.append('|');
        		} else if(i == 0 || i == size - 1) {
        			sb.append('-');
        		} else if(i == j || i == size - j - 1) {
        			sb.append('*');
        		} else {
        			sb.append(' ');
        		}
        	}
        	sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
