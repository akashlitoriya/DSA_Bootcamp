package OAQuestions;
//https://www.desiqna.in/16582/microsoft-sde-oa-coding-questions-set-119
//https://docs.google.com/document/d/1gQHEO8EjsYk-9xjDLqb2woak2_8vpzeDVsYGOqnHVCo/edit
public class MinOperationBalanceStringMicrosoft {
    public static void main(String[] args) {
        String t = "W?WR?";
        String s = "R??W?";
        System.out.println(getMinOperation(t, s));
        String t1 = "R?R??";
        String s1 = "??W??";
        System.out.println(getMinOperation(t1, s1));
    }
    private static int getMinOperation(String s, String t){
        int op = 0;
        StringBuilder sb = new StringBuilder(s);
        StringBuilder tb = new StringBuilder(t);
        //First we will balance the column then we will balance the row
        int idx = 0;
        for(idx = 0; idx < sb.length(); idx++){
            //checking whether the row contains two different character or not. As R - W == 5
            if(Math.abs(sb.charAt(idx) - tb.charAt(idx)) != 5){
                //Checking whether the column have same character R or W or not. if yes return -1.
                if(Math.abs(sb.charAt(idx) - tb.charAt(idx)) == 0 && sb.charAt(idx) != '?'){
                    return -1;
                }
                //if Both are ? then no need to do anything
                else if(Math.abs(sb.charAt(idx) - tb.charAt(idx)) == 0 && sb.charAt(idx) == '?'){
                    continue;
                }
                //if anyone is ?
                else{
                    if(sb.charAt(idx) == '?'){
                        if(tb.charAt(idx) == 'R'){
                            sb.replace(idx, idx + 1, "W");
                        }else{
                            sb.replace(idx, idx + 1, "R");
                        }
                    }else{
                        if(sb.charAt(idx) == 'R'){
                            tb.replace(idx, idx + 1, "W");
                        }else{
                            tb.replace(idx, idx + 1, "R");
                        }
                    }
                    op++;
                }
            }


        }
        //now we will check whether we can balance the row or not
        int sr = 0,sw = 0,sq = 0,tr = 0,tw = 0,tq = 0;

        for(idx = 0; idx < sb.length(); idx++){
            if(sb.charAt(idx) == 'R'){
                sr++;
            }else if(sb.charAt(idx) == 'W'){
                sw++;
            }else{
                sq++;
            }
            if(tb.charAt(idx) == 'R'){
                tr++;
            }else if(tb.charAt(idx) == 'W'){
                tw++;
            }else{
                tq++;
            }
        }
        if(sq < Math.abs(sr - sw) || tq < Math.abs(tr - tw)){
            return -1;
        }
        op += Math.abs(sr - sw);
        op += Math.abs(tr - tw);
        return op;
    }

}
