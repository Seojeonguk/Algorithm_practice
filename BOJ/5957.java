import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Stack<Integer> unwashed = new Stack<>();
        Stack<Integer> notDried = new Stack<>();
        Stack<Integer> finished = new Stack<>();
        String nextLine = "";
        int dishCnt = Integer.parseInt(br.readLine());
        for (int i = dishCnt; i >= 1; i--) {
            unwashed.push(i);
        }
        while ((nextLine = br.readLine()) != null) {
            int command = Integer.parseInt(nextLine.split(" ")[0]);
            int cnt = Integer.parseInt(nextLine.split(" ")[1]);

            if (command == 1) {
                for (int i = 0; i < cnt && !unwashed.empty(); i++) {
                    int top = unwashed.pop();
                    notDried.push(top);
                }
            } else if (command == 2) {
                for (int i = 0; i < cnt && !notDried.empty(); i++) {
                    int top = notDried.pop();
                    finished.add(top);
                }
            }
        }

        while (!finished.empty()) {
            sb.append(finished.pop()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
