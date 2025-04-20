package dpQuestion;
//https://docs.google.com/document/d/1OvybkF0hQ4uCWJxCMWiA01ed9-lnnCrW3OcP1_NzfDc/edit
public class Session13 {
    public static void main(String[] args) {
        int q[][] = {{5,-1}, {2,3},{5,-1}};
        System.out.println(getMaxEnergy(q));
    }
    private static int getMaxEnergy(int q[][]){
        int n = q.length;
        int dp_max[] = new int[n];
        int dp_min[] = new int[n];
        if(q[0][0] == 1){//addition query
            dp_max[0] = 1 + q[0][1];
            dp_min[0] = Math.min(1 + q[0][1], 1);
        }else if(q[0][0] == 2){//subtraction query
            dp_max[0] = Math.max(1 - q[0][1], 1);
            dp_min[0] = Math.min(1 - q[0][1], 1);
        }else if (q[0][0] == 3){//multiplication query
            dp_max[0] = Math.max(1 * q[0][1], 1);
            dp_min[0] = Math.min(1 * q[0][1], 1);
        }else if(q[0][0] == 4){//division query
            dp_max[0] = Math.max(1 / q[0][1], 1);
            dp_min[0] = Math.min(1 / q[0][1], 1);
        }else{//negation query
            dp_max[0] = Math.max(-1 * 1, 1);
            dp_min[0] = Math.min(-1 * 1, 1);
        }

        for(int i = 1; i < n; i++){
            if(q[i][0] == 1){//addition query
                dp_max[i] = Math.max(q[i][1] + dp_max[i - 1], dp_max[i-1]);
                dp_min[i] = Math.min(q[i][1] + dp_max[i-1], dp_min[i-1]);
            }else if(q[i][0] == 2){//subtraction query
                dp_max[i] = Math.max(dp_max[i-1] - q[i][1], dp_max[i-1]);
                dp_min[i] = Math.min(dp_min[i-1] - q[i][1], dp_min[i-1]);
            }else if (q[i][0] == 3){//multiplication query
                dp_max[i] = Math.max(dp_max[i-1] * q[i][1], dp_max[i-1]);
                dp_min[i] = Math.min(dp_min[i-1] * q[i][1], dp_min[i-1]);
            }else if(q[i][0] == 4){//division query
                dp_max[i] = Math.max(dp_max[i-1] / q[i][1], dp_max[i-1]);
                dp_min[0] = Math.min(dp_min[i-1] / q[i][1], dp_min[i-1]);
            }else{//negation query
                dp_max[i] = Math.max(-1 * dp_min[i-1], dp_max[i-1]);
                dp_min[0] = Math.min(-1 * dp_max[i-1], dp_min[i-1]);
            }
        }

        return dp_max[n-1];

    }
}
