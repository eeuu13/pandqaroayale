import java.util.ArrayList;

public class PinkReceivers {
    private int pink_die;
    private int number_players;
    public PinkReceivers(int pink, int players){
        pink_die=pink;
        number_players=players;
    }
    public ArrayList<Integer> calculatePinkReceivers(ArrayList<Integer> round_total, int first){
        ArrayList<Integer> min_scores= new ArrayList<>();
        ArrayList<Integer> indexes= new ArrayList<>();
        for (int i=0;i<pink_die;i++){
            min_scores.add(Integer.MAX_VALUE);
            indexes.add(-1);
        }
        int order=(first-1);
        if (order==-1){
            order=number_players-1;
        }
        for (int i=0;i<number_players;i++){
            int value=round_total.get(order);
            if (value<min_scores.getFirst()){
                min_scores.set(0, value);
                indexes.set(0, order);
            }
            int j=1;
            while (j<pink_die && round_total.get(order)<min_scores.get(j)){
                min_scores.set(j-1,min_scores.get(j));
                indexes.set(j-1, indexes.get(j));
                min_scores.set(j, value);
                indexes.set(j, order);
                j++;
            }
            order=(order-1);
            if (order==-1){
                order=number_players-1;
            }
        }
        return indexes;
    }
}
