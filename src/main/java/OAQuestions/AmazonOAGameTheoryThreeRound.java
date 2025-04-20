package OAQuestions;
import java.util.Arrays;
//https://www.desiqna.in/17662/amazon-oa-sde1-ctc-45-l-2024-august
public class AmazonOAGameTheoryThreeRound {
    public static void main(String[] args) {
        int a[] = {9,4,2};
        int b[] = {5,12,10};
        int c[] = {11,3,13};
        System.out.println(getWinnerCount(a,b,c));
    }

    private static int getWinnerCount(int a[], int b[], int c[]){
        int n = a.length;
        //sorting the energies
        for(int i = 0; i < n; i++){
            int y[] = new int[3];
            y[0] = a[i]; y[1] = b[i]; y[2] = c[i];
            Arrays.sort(y);
            a[i] = y[0];
            b[i] = y[1];
            c[i] = y[2];
        }
        int prefixMax[] = new int[n];
        int prefixSecMax[] = new int[n];
        prefixMax[0] = -1;
        prefixMax[1] = b[0];
        prefixSecMax[0] = -1;
        prefixSecMax[1] = a[0];
        for(int i = 2; i < n; i++){
            prefixMax[i] = Math.max(prefixMax[i - 1], b[i - 1]);
            prefixSecMax[i] = Math.max(prefixSecMax[i - 1], a[i - 1]);
        }
        int suffixMax[] = new int[n];
        int suffixSecMax[] = new int[n];
        suffixMax[n - 1] = -1;
        suffixMax[n - 2] = b[n - 1];
        suffixSecMax[n - 1] = -1;
        suffixSecMax[n - 2] = a[n-1];
        for(int i = n - 3; i >= 0; i--){
            suffixMax[i] = Math.max(suffixMax[i + 1], b[i + 1]);
            suffixSecMax[i] = Math.max(suffixSecMax[i + 1], a[i + 1]);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if((c[i] > prefixMax[i] && c[i] > suffixMax[i]) && (b[i] > prefixSecMax[i] && b[i] > suffixSecMax[i])){
                count++;
            }
        }
        return count;

    }
}
