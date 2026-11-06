import java.util.Random;

public class Dice  {
    public int sides;
    protected final Random random=new Random();
    public Dice(int sides){
       this.sides=sides;
    }
    public int roll(){
        return random.nextInt(1,sides+1);
    }
    public int roll_blue(boolean sparkle){
        return 0; /*To Fix: Dar erro*/
    }
    public int roll_red(int number_reds){
        return 0; /*To Fix: Dar erro*/
    }
}
