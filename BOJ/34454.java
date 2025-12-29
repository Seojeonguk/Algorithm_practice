import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final String CAN_RIDE_NEXT_TRAIN_RSLT = "yes";
    private static final String CAN_NOT_RIDE_NEXT_TRAIN_RSLT = "no";

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int myPlace = Integer.parseInt(br.readLine());
            int carNumPerTrain = Integer.parseInt(br.readLine());
            int peopleNumPerCar = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            sb.append(myPlace <= carNumPerTrain * peopleNumPerCar ? CAN_RIDE_NEXT_TRAIN_RSLT : CAN_NOT_RIDE_NEXT_TRAIN_RSLT);

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
