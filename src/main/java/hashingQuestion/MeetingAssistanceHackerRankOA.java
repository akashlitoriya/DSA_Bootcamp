package hashingQuestion;

public class MeetingAssistanceHackerRankOA {
    public static void main(String[] args) {
        String events[] = {"Alex sleep 00:00 08:00", "Sam sleep 07:00 13:00", "Alex lunch 12:30 13:59"};
        int k = 60;
        System.out.println(getEarliestMeeting(events, k));
        String events2[] = {"sam sleep 12:00 23:59", "Alex sleep 00:00 13:00"};
        int k1 = 1;
        System.out.println(getEarliestMeeting(events2,k1));
    }
    private static String getEarliestMeeting(String[] events, int k){
        int time[] = new int[1440];
        for(int i = 0; i < events.length; i++){
            String desc[] = events[i].split(" ");
            String start = desc[2];
            String end = desc[3];
            int x = getTimeInMinutes(start);
            int y = getTimeInMinutes(end);
            time[x] = 1;
            if(y + 1 < 1440) time[y + 1] = -1;
        }

        //Now we will find for each minutes how many people are working
        int sum = 0;
        int count = 0;
        for(int i = 0; i < time.length; i++){
            sum += time[i];
            time[i] = sum;
            if(time[i] == 0){
                count++;
                if(count == k){
                    //convert minutes to exact time
                    return getExactTime(i - k + 1);
                }
            }else{
                count = 0;
            }
        }
        return "-1";
    }
    private static int getTimeInMinutes(String time){
        String[] sepTime = time.split(":");
        int hour = Integer.parseInt(sepTime[0]);
        int minutes = Integer.parseInt(sepTime[1]);
        return hour * 60 + minutes;
    }
    private static String getExactTime(int minutes){
        int hr = minutes /60;
        int min = minutes % 60;
        StringBuilder ans = new StringBuilder();
        if(hr > 9){
            ans.append(hr/10);
            ans.append(hr%10);
        }else{
            ans.append(0);
            ans.append(hr);
        }
        ans.append(':');
        if(min < 10){
            ans.append(0);
            ans.append(min);
        }else{
            ans.append(min/10);
            ans.append(min%10);
        }
        return ans.toString();
    }
}
