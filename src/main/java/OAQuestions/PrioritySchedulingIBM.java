package OAQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrioritySchedulingIBM {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of process: ");
        int n = Integer.parseInt(bf.readLine());
        System.out.println("Enter the number of logs: ");
        int m = Integer.parseInt(bf.readLine());
        String logs[] = new String[m];
        for(int i = 0; i < m; i++){
            String log = bf.readLine();
            logs[i] = log;
        }
        System.out.println(Arrays.toString(getExclisiveTime(n, logs)));
    }
    private static int[] getExclisiveTime(int n, String logs[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->-(a-b));
        int ans[] = new int[n];
        int timeStamp = 0;
        int currProcess = 0;
        pq.add(0);
        for(int i = 1; i < logs.length; i++){
            String event[] = logs[i].split(":");
            int processId = Integer.parseInt(event[0]);
            if(event[1].equals("start")){
               int time = Integer.parseInt(event[2]) - timeStamp - 1;
               ans[currProcess] += time;
               currProcess = processId;
               timeStamp = Integer.parseInt(event[2]);
               pq.add(processId);
            }else{
                int time = Integer.parseInt(event[2]) - timeStamp + 1;
                ans[processId] += time;
                pq.poll();
                if(pq.size() > 0)
                currProcess = pq.peek();
                timeStamp = Integer.parseInt(event[2]);
            }
        }
        return ans;
    }
}
