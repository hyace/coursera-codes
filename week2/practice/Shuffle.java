public class Shuffle {
    public static void shuffle(Object[] obj){
        int N=obj.length;
        for(int i=0;i<N;i++){
            int t=StdRandom.uniform(i+1);
            Object swap=obj[t];
            obj[t]=obj[i];
            obj[i]=swap;
        }
    }
}
