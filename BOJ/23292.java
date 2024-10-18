import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] birthday = br.readLine().toCharArray();

            int totalCodingDay = Integer.parseInt(br.readLine());

            int maxBioRhythm = 0;
            String maxBioRhythmBirthday = "";

            for (int i = 0; i < totalCodingDay; i++) {
                String codingDay = br.readLine();
                char[] codingDayChars = codingDay.toCharArray();

                int bioRhythm = calBioRhythm(birthday, codingDayChars);
                if (bioRhythm > maxBioRhythm) {
                    maxBioRhythm = bioRhythm;
                    maxBioRhythmBirthday = codingDay;
                } else if (bioRhythm == maxBioRhythm) {
                    maxBioRhythmBirthday = (maxBioRhythmBirthday.compareTo(codingDay) > 0 ? codingDay : maxBioRhythmBirthday);
                }
            }

            sb.append(maxBioRhythmBirthday);

            bw.write(sb.toString());
        }
    }

    public static int calBioRhythm(char[] birthday, char[] codingDay) {
        int yearRhythm = 0;
        for (int i = 0; i < 4; i++) {
            yearRhythm += pow(birthday[i] - codingDay[i]);
        }

        int monthRhythm = 0;
        for (int i = 0; i < 2; i++) {
            monthRhythm += pow(birthday[i + 4] - codingDay[i + 4]);
        }

        int dayRhythm = 0;
        for (int i = 0; i < 2; i++) {
            dayRhythm += pow(birthday[i + 6] - codingDay[i + 6]);
        }

        return yearRhythm * monthRhythm * dayRhythm;
    }

    public static int pow(int a) {
        return a * a;
    }
}
