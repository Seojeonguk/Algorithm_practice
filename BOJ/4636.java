import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int studentCnt = Integer.parseInt(br.readLine());
            if (studentCnt == -1) {
                break;
            }

            Student[] students = new Student[studentCnt];
            for (int i = 0; i < studentCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());

                String name = st.nextToken();

                students[i] = new Student(w, l, h, name);
            }

            Arrays.sort(students, Comparator.comparingInt(Student::getVolume));
            sb.append(String.format("%s took clay from %s.\n", students[studentCnt - 1].name, students[0].name));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Student {
        int w, l, h;
        String name;

        Student(int w, int l, int h, String name) {
            this.w = w;
            this.l = l;
            this.h = h;
            this.name = name;
        }

        public int getVolume() {
            return w * l * h;
        }
    }
}
