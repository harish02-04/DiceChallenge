public class App {
    public static void main(String[] args) throws Exception {
        int[] dice1=new int[6];
        int[] dice2=new int[6];
        dice1[0]=dice2[0]=1;
        dice1[1]=dice2[1]=2;
        dice1[2]=dice2[2]=3;
        dice1[3]=dice2[3]=4;
        dice1[4]=dice2[4]=5;
        dice1[5]=dice2[5]=6;
        BasicFuntions b=new BasicFuntions(dice1,dice2);
        b.print_comb();
        b.get_prob();
        Undoom u=new Undoom();
        u.undoom_dice(dice1, dice2);
    }
}
