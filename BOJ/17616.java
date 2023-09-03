import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(st.nextToken());
        int informationCnt = Integer.parseInt(st.nextToken());
        int studentNum = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] better = new ArrayList[studentCnt + 1];
        ArrayList<Integer>[] worst = new ArrayList[studentCnt + 1];
        for (int i = 1; i <= studentCnt; i++) {
            better[i] = new ArrayList<>();
            worst[i] = new ArrayList<>();
        }
        for (int i = 0; i < informationCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int betterStudent = Integer.parseInt(st.nextToken());
            int worstStudent = Integer.parseInt(st.nextToken());
            better[betterStudent].add(worstStudent);
            worst[worstStudent].add(betterStudent);
        }

        int betterCnt = getCnt(studentCnt, better, studentNum);
        int worstCnt = getCnt(studentCnt, worst, studentNum);

        sb.append(1 + worstCnt).append(" ").append(studentCnt - betterCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getCnt(int studentCnt, ArrayList<Integer>[] arrayLists, int studentNum) {
        boolean[] isVisit = new boolean[studentCnt + 1];
        Queue<Integer> q = new LinkedList<>();
        isVisit[studentNum] = true;
        q.add(studentNum);
        int cnt = 0;

        while (!q.isEmpty()) {
            int student = q.poll();
            cnt++;
            for (int nextStudent : arrayLists[student]) {
                if (isVisit[nextStudent]) {
                    continue;
                }
                isVisit[nextStudent] = true;
                q.add(nextStudent);
            }
        }

        return cnt - 1;
    }
}
