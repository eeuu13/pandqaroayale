import java.util.List;
public class Game {
    List<List<Integer>> Table;
    List<Player> players;
    int pink_die;
    private number_pink_die(int number_players){
        return (number_players+2)/3;
    }

    public Game(int number_players) {
        pink_die=number_pink_die(number_players);
        for (int i = 0; i < 10; i++) {
            List<Integer> round_total= new java.util.ArrayList<>(List.of());
            List<Integer> round_yellow= new java.util.ArrayList<>(List.of());
            for (Score score:round()){
                round_total.add(score.getTotal());
                round_yellow.add(score.getYellow());
            }
            /*take_pink()*/
            /*give_pink();*/
            Table.add(round_total);
            /*draw_table();*/
            /*choose_dice();*/

        }
    }

    private List<Score> round(){
        List<Score> scores = new java.util.ArrayList<>(List.of());
        for (Player player:players){
            scores.add(player.score());
        }
        return scores;
    }


    private List<Integer> give_pink(List<Integer> round_total){

    }
}
