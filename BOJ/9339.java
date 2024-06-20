import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static final int CERTIFICATED_LIMIT_MINUTE = 6 * 60;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                int totalAttendee = Integer.parseInt(br.readLine());

                HashSet<Integer> attendees = new HashSet<>();
                StringTokenizer attendeeNums = new StringTokenizer(br.readLine());
                for (int i = 0; i < totalAttendee; i++) {
                    int attendeeNum = Integer.parseInt(attendeeNums.nextToken());
                    attendees.add(attendeeNum);
                }

                int bestAttendee = -1;
                int bestAttendeeRecordMinute = Integer.MAX_VALUE;
                int certificatedAttendee = 0;

                int totalParticipant = Integer.parseInt(br.readLine());
                for (int i = 0; i < totalParticipant; i++) {
                    StringTokenizer participants = new StringTokenizer(br.readLine());
                    int participantNum = Integer.parseInt(participants.nextToken());
                    int recordHour = Integer.parseInt(participants.nextToken());
                    int recordMinute = Integer.parseInt(participants.nextToken());

                    if (!isAttendee(attendees, participantNum) || !validRecord(recordHour, recordMinute)) {
                        continue;
                    }

                    int totalRecordMinute = convertMinute(recordHour, recordMinute);
                    if (totalRecordMinute < bestAttendeeRecordMinute) {
                        bestAttendee = participantNum;
                        bestAttendeeRecordMinute = totalRecordMinute;
                    }

                    if (totalRecordMinute <= CERTIFICATED_LIMIT_MINUTE) {
                        certificatedAttendee++;
                    }
                }

                sb.append(bestAttendee).append(" ").append(certificatedAttendee).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static boolean isAttendee(HashSet<Integer> attendees, int attendeeNum) {
        return attendees.contains(attendeeNum);
    }

    public static boolean validRecord(int recordHour, int recordMinute) {
        return (recordHour != -1 && recordMinute != -1);
    }

    public static int convertMinute(int hour, int minute) {
        return hour * 60 + minute;
    }
}
