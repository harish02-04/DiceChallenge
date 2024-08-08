import java.util.*;
public class Undoom {
    public void undoom_dice(int[] Die_A,int[] Die_B){
        int[] p1=fill_arr(4);
        int[] p2=fill_arr(get_max(Die_A)+get_max(Die_B)-1);
        ArrayList<ArrayList<Integer>> comb1=new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> comb2=new ArrayList<ArrayList<Integer>>();
        HashMap<Integer,Integer> target=get_target(Die_A,Die_B);
        get_comb1(p1.length-1,p1,new ArrayList<Integer>(),comb1);
        get_comb2(p2.length-1,p2,new ArrayList<Integer>(),comb2);
        int flag=-1;
        for(int i=0;i<comb1.size();i++){
            for(int j=0;j<comb2.size();j++){
                if(check(get_frequencies(comb1.get(i), comb2.get(j)),target)){
                    System.out.println("New_Die_A: "+comb1.get(i));
                    System.out.println("New_Die_B: "+comb2.get(j));
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                break;
            }
        }
        if(flag==-1){
            System.out.println("No such combinations were found");
        }
    }
    public static boolean check(HashMap<Integer,Integer> f1,HashMap<Integer,Integer> f2){
        if(f1.size()!=f2.size()){
            return false;
        }
        for(int key:f1.keySet()){
            if(f2.containsKey(key)==false || f1.get(key)!=f2.get(key)){
                return false;
            }
        }
        return true;
    }
    public static HashMap<Integer,Integer> get_frequencies(ArrayList<Integer> d1,ArrayList<Integer> d2){
        HashMap<Integer,Integer> f=new HashMap<Integer,Integer>();
        for(int i=0;i<d1.size();i++){
            for(int j=0;j<d2.size();j++){
                if(f.containsKey(d1.get(i)+d2.get(j))){
                    f.put(d1.get(i)+d2.get(j),f.get(d1.get(i)+d2.get(j))+1);
                }
                else{
                    f.put(d1.get(i)+d2.get(j),1);
                }
            }
            
        }
        return f;
    }
    public static HashMap<Integer,Integer> get_target(int[] d1,int[] d2){
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
        return f;
    }
    public static void get_comb1(int ptr,int[] p,ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> comb){
        if(arr.size()==6){
            comb.add(new ArrayList<Integer>(arr));
            return;
        }
        if(ptr<0){
            return;
        }
        arr.add(p[ptr]);
        get_comb1(ptr,p,arr,comb);
        arr.remove(arr.size()-1);
        get_comb1(ptr-1,p,new ArrayList<Integer>(arr),comb);
    }
    public static void get_comb2(int ptr,int[] p,ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> comb){
        if(arr.size()==6){
            comb.add(new ArrayList<Integer>(arr));
            return;
        }
        if(ptr<0){
            return;
        }
        arr.add(p[ptr]);
        get_comb1(ptr-1,p,arr,comb);
        arr.remove(arr.size()-1);
        get_comb1(ptr-1,p,new ArrayList<Integer>(arr),comb);
    }
    public static int[] fill_arr(int l){
        int[] arr=new int[l];
        for(int i=1;i<=l;i++){
            arr[i-1]=i;
        }
        return arr;
    }
    public static int get_max(int[] arr){
        int m=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(m<arr[i]){
                m=arr[i];
            }
        }
        return m;
    }
}
