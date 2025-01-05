import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final String FIRST_CLASS_CD = "F";
    static final String BUSINESS_CLASS_CD = "B";
    static final String ECONOMY_CLASS_CD = "Y";
    static final int ECONOMY_MIN_MILEAGE = 500;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int mileageSum = 0;

            while (true) {
                String record = br.readLine();

                if ("0".equals(record)) {
                    sb.append(mileageSum).append("\n");
                    mileageSum = 0;
                    continue;
                } else if ("#".equals(record)) {
                    break;
                }

                String[] splitRecord = record.split(" ");
                int actualMileage = Integer.parseInt(splitRecord[2]);
                String classCd = splitRecord[3];
                if (FIRST_CLASS_CD.equals(classCd)) {
                    mileageSum += actualMileage * 2;
                } else if (BUSINESS_CLASS_CD.equals(classCd)) {
                    mileageSum += actualMileage + (actualMileage + 1) / 2;
                } else if (ECONOMY_CLASS_CD.equals(classCd)) {
                    if (actualMileage <= ECONOMY_MIN_MILEAGE) {
                        mileageSum += ECONOMY_MIN_MILEAGE;
                    } else {
                        mileageSum += actualMileage;
                    }
                }
            }

            bw.write(sb.toString());
        }
    }
}
