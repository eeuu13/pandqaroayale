import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Player {
    private ArrayList<Dice> die;
    public Player(){
        die= new ArrayList<>();
        die.add(new Dice_Yellow(6));
    }
    public Score score(){
        int total=0;
        int yellow=0;
        int number_reds=0;
        boolean sparkle=false;
        for (Dice dice:die){
            if (dice.getColor().equals("Red")){
                number_reds++;
            }
            if (dice.getSparkle()){
                sparkle=true;
            }
        }
        for (Dice dice:die){
            int roll;
            if (dice.getColor().equals("Blue")){
                Dice_Blue blue_dice=(Dice_Blue) dice;
                roll=blue_dice.roll_blue(sparkle);
            }
            else if (dice.getColor().equals("Red")){
                Dice_Red red_dice= (Dice_Red) dice;
                roll=red_dice.roll_red(number_reds);
            }
            else{
                roll=dice.roll();
                if (dice.getColor().equals("Yellow")){
                    yellow+=roll;
                }

            }
            total+=roll;
        }
        Score output=new Score(total,yellow);
        return output;
    }
    public void give_dice(Dice dice){
        die.add(dice);
    }
    public void take_pink(){
        int index=-1;
        for (int i=0;i<die.size();i++){
            if (die.get(i).getColor().equals("Pink")){
                index=i;
                break;
            }
        }
        if (index!=-1){
            die.remove(index);
        }


    }
    public int rollYellow(){
        int yellow=0;
        for (Dice dice:die){
            if (dice.getColor().equals("Yellow")) {
                yellow += dice.roll();
            }
        }
        return yellow;
    }
}
