import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalStudent = Integer.parseInt(st.nextToken());
            int hongStudentNum = 1;
            int joStudentNum = Integer.parseInt(st.nextToken());
            int happyDiff = Integer.parseInt(st.nextToken());
            int totalWeek = Integer.parseInt(st.nextToken());

            int hong = hongStudentNum, jo = joStudentNum;
            int happyWeek = 0, maxContinuousHappyWeek = 0, continuousHappyWeek = 0;
            if (isHappy(hong, jo, happyDiff)) {
                happyWeek++;
                continuousHappyWeek++;
                maxContinuousHappyWeek++;
            }

            int[] studentNums = new int[totalStudent + 1];
            for (int studentNum = 1; studentNum <= totalStudent; studentNum++) {
                studentNums[studentNum] = studentNum;
            }

            int[] scores = new int[totalStudent + 1];
            for (int week = 1; week < totalWeek; week++) {
                StringTokenizer points = new StringTokenizer(br.readLine());
                StringTokenizer penalties = new StringTokenizer(br.readLine());

                for (int studentNum = 1; studentNum <= totalStudent; studentNum++) {
                    scores[studentNum] = Integer.parseInt(points.nextToken()) - Integer.parseInt(penalties.nextToken());
                }

                for (int roomNum = 1; roomNum < totalStudent; roomNum++) {
                    int firstStudentNum = studentNums[roomNum];
                    int secondStudentNum = studentNums[roomNum + 1];

                    if (isChange(scores[firstStudentNum], scores[secondStudentNum])) {
                        scores[secondStudentNum] -= 2;
                        scores[firstStudentNum] += 2;

                        int temp = studentNums[roomNum];
                        studentNums[roomNum] = studentNums[roomNum + 1];
                        studentNums[roomNum + 1] = temp;
                    }
                }

                for (int roomNum = 1; roomNum <= totalStudent; roomNum++) {
                    if (studentNums[roomNum] == hongStudentNum) {
                        hong = roomNum;
                    } else if (studentNums[roomNum] == joStudentNum) {
                        jo = roomNum;
                    }
                }

                if (isHappy(hong, jo, happyDiff)) {
                    happyWeek++;
                    continuousHappyWeek++;
                } else {
                    continuousHappyWeek = 0;
                }

                maxContinuousHappyWeek = Math.max(maxContinuousHappyWeek, continuousHappyWeek);
            }

            sb.append(happyWeek).append(" ").append(maxContinuousHappyWeek);

            bw.write(sb.toString());
        }
    }

    public static boolean isChange(int a, int b) {
        if (a >= 0 && b >= 0 && a + 2 <= b) {
            return true;
        }

        if (b >= 0 && a < 0) {
            return true;
        }

        if (a < 0 && b < 0 && a + 4 <= b) {
            return true;
        }

        return false;
    }

    public static boolean isHappy(int a, int b, int diff) {
        return (Math.abs(a - b) <= diff);
    }
}
