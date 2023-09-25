import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int studentCnt = Integer.parseInt(br.readLine());
        LinkedList<Student> students = new LinkedList<>();
        while (studentCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            String initial = st.nextToken();
            int studentNum = Integer.parseInt(st.nextToken());
            students.add(new Student(initial, studentNum));
        }
        int currentIdx = 0;
        while (students.size() != 1) {
            Student student = students.remove(currentIdx);
            int idx = (currentIdx + student.studentNum - 1) % students.size();
            students.remove(idx);
            currentIdx = (idx) % students.size();
        }
        sb.append(students.get(0).initial);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Student {
        String initial;
        int studentNum;

        Student(String initial, int studentNum) {
            this.initial = initial;
            this.studentNum = studentNum;
        }
    }
}
