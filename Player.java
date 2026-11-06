import java.util.List;

public class Player {
    List<Dice> die;
    public Score score(){
        int total=0;
        int yellow=0;
        int number_reds=0;
        boolean sparkle=false;
        for (Dice dice:die){
            if (dice.getClass()==Dice_Red.class){
                number_reds++;
            }
            if (dice.getClass()==Dice_Blue.class){
                sparkle=true;
            }
        }
        for (Dice dice:die){
            int roll;
            if (dice.getClass()==Dice_Blue.class){
                roll=dice.roll_blue(sparkle);
            }
            else if (dice.getClass()==Dice_Red.class){
                roll=dice.roll_red(number_reds);
            }
            else{
                roll=dice.roll();
                if (dice.getClass()==Dice_Yellow.class){
                    yellow+=roll;
                }

            }
            total+=roll;
        }
        Score output=new Score(total,yellow);
        return output;
    }
}
