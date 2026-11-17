import java.util.ArrayList;
import java.util.List;

public class Game {
    ArrayList<ArrayList<Integer>> Table;
    ArrayList<Player> players;
    int pink_die;
    int number_players;

    public Game(int n_players) {
        number_players=n_players;
        pink_die=numberPinkDie();
        /*holding_pink_dice=List.of();*/
        for (int i = 1; i <= 10; i++) {
            ArrayList<Integer> round_total= new ArrayList<>();
            ArrayList<Integer> round_yellow= new ArrayList<>();
            for (Score score:round()){
                round_total.add(score.getTotal());
                round_yellow.add(score.getYellow());
            }
            ArrayList<Integer> round_order=decideOrder(round_yellow);
            int first=round_order.getFirst();
            takePink();
            givePink(round_total,first);
            Table.add(round_total);
            //draw_table();
            //steal_dice;
            //choose_dice();

        }
    }

    private List<Score> round(){
        ArrayList<Score> scores = new ArrayList<>();
        for (Player player:players){
            scores.add(player.score());
        }
        return scores;
    }

    private int numberPinkDie(){
        return (number_players+2)/3;
    }

    private void takePink(){
        for (int i=0;i<number_players;i++){
            players.get(i).take_pink();
        }
    }

    private void givePink(ArrayList<Integer> round_total,int first){
        List<Integer> recievers=calculatePinkReceivers(round_total,first);
        for (int i:recievers){
            players.get(i).give_dice(new Dice_Pink(12));
        }
    }

    private ArrayList<Integer> calculatePinkReceivers(ArrayList<Integer> round_total,int first){
        return new PinkReceivers(pink_die,number_players).calculatePinkReceivers(round_total,first);
    }

/*
    private boolean goesBefore(int p1, int p2,int first){
        if (first<=p1 && first>p2){
            return true;
        }
        if (first<p1 && first>=p2){
            return false;
        }
        return p1<p2;

    }
 */
    private ArrayList<Integer> decideOrder(ArrayList<Integer> round_yellow){
        return new Order(number_players,players).calculateOrder(round_yellow);
    }



}
