import java.util.ArrayList;

public class Order {
    int number_players;
    ArrayList<Player> players;
    public Order(int number_players,ArrayList<Player>players){
        this.number_players=number_players;
        this.players=players;
    }
    public Order(int number_players){
        this.number_players=number_players;
        players=new ArrayList<>();
        for(int i=0;i<number_players;i++){
            Player player=new Player();
            player.give_dice(new Dice_Yellow(6));
            players.add(player);
        }
    }

    public ArrayList<Integer> calculateOrder(ArrayList<Integer> round_yellow){
        int max=-1;
        ArrayList<Integer> max_indexes= new ArrayList<>();
        ArrayList<Integer> final_order=new ArrayList<>();
        for (int i=0;i<number_players;i++){
            int value=round_yellow.get(i);
            if (value==max){
                max_indexes.add(i);
            }
            else if (value>max){
                max_indexes=new ArrayList<>();
                max_indexes.add(i);
                max=value;
            }
        }
        int first;
        if (max_indexes.size()>1){
            first=decideTie(max_indexes);
        }
        else {
            first = max_indexes.getFirst();
        }
        int previous_max=max+1;
        while(max!=-1){
            max=-1;
            int order=first;
            max_indexes=new ArrayList<>();
            for (int i=0;i<number_players;i++){
                int value=round_yellow.get(order);
                if (value>=previous_max){
                    order=(order+1)%number_players;
                    continue;
                }
                if (value==max){
                    max_indexes.add(order);
                }
                else if (value>max){
                    max_indexes=new ArrayList<>();
                    max_indexes.add(order);
                    max=value;
                }
                order=(order+1)%number_players;

            }
            previous_max=max;
            final_order.addAll(max_indexes);
        }
        return final_order;
    }

    public int decideTie( ArrayList<Integer>  max_indexes){
        int max=-1;
        ArrayList<Integer> new_max_indexes= new ArrayList<>();
        for (int index:max_indexes){
            int value=players.get(index).rollYellow();
            if (value==max){
                new_max_indexes.add(index);
            }
            else if (value>max){
                new_max_indexes=new ArrayList<>();
                new_max_indexes.add(index);
                max=value;
            }
        }
        if (max_indexes.size()>1){
            return decideTie(new_max_indexes);
        }
        return new_max_indexes.getFirst();
    }
}
