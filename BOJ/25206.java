import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static double totalRating, mulRating;

    public static void main(String[] args) throws Exception {
        for(int i=0;i<20;i++) {
            String[] st = br.readLine().split(" ");

            if(st[2].equals("P")) {
                continue;
            }

            double rating = getRating(st[1]);
            double subjectRating = getSubject(st[2]);

            totalRating += rating;
            mulRating += rating * subjectRating;
        }

        sb.append(mulRating/totalRating);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static double getRating(String s) {
        if(s.equals("4.0")) return 4.0;
        else if(s.equals("3.0")) return 3.0;
        else if(s.equals("2.0")) return 2.0;
        return 1.0;
    }

    public static double getSubject(String s) {
        if(s.equals("A+")) return 4.5;
        else if(s.equals("A0")) return 4.0;
        else if(s.equals("B+")) return 3.5;
        else if(s.equals("B0")) return 3.0;
        else if(s.equals("C+")) return 2.5;
        else if(s.equals("C0")) return 2.0;
        else if(s.equals("D+")) return 1.5;
        else if(s.equals("D0")) return 1.0;
        return 0;
    }
}
