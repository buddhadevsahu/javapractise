package bernard.problem;

public class NoOfBrief {
    static void minimumBribes(int[] q) {
        int count=0;
        for(int i=0; i< q.length-1 ;i++){

            if(q[i+1]<q[i]){
                int diff=q[i]-q[i+1];
                if((q[i]- (i+1+2))>2){
                    System.out.println("Too chaotic");
                    return;
                }
                count = count +1;
                //swap both value
                int t= q[i+1];
                q[i+1]=q[i];
                q[i]=t;
                //initialize scanning to 1st position
                i=0;
            }

        }
        System.out.println(count);

    }
}
