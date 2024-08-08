import java.util.*;
public class BasicFuntions {
    int[] d1;
    int[] d2;
    int[][] comb;
    int tot;
    BasicFuntions(int[] d1,int[] d2){
        this.d1=d1;
        this.d2=d2;
        get_combinations();
        this.tot=tot_combinations();

    }
    public int tot_combinations(){
        return d1.length*d2.length;
    }
    public void get_prob(){
        HashMap<Integer,Integer> f=new HashMap<Integer,Integer>();
        for(int i=0;i<d1.length;i++){
            for(int j=0;j<d2.length;j++){
                if(f.containsKey(d1[i]+d2[j])){
                    f.put(d1[i]+d2[j],f.get(d1[i]+d2[j])+1);
                }
                else{
                    f.put(d1[i]+d2[j],1);
                }
            }
        }
        System.out.println("The probabilities are");
        for(int key:f.keySet()){
            System.out.println("P(sum=" + key + ")=" + ((double) f.get(key) / tot));
        }
    }
    public void print_comb(){
        System.out.println("The combinations were represented as 6x6 matrix as given below");
        System.out.print("DieA\\DieB"+"  ");
        for(int i=0;i<d2.length;i++){
            System.out.print(d2[i]+" ");
        }
        System.out.println("");
        for(int i=0;i<d1.length;i++){
            System.out.print(d1[i]+"          ");
            for(int j=0;j<d2.length;j++){
                System.out.print(comb[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public void get_combinations(){
        comb=new int[d1.length][d2.length];
        for(int i=0;i<d1.length;i++){
            for(int j=0;j<d2.length;j++){
                comb[i][j]=d1[i]+d2[j];
            }
        }
    }
}
