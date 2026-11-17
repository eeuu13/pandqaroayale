import java.util.Random;

public abstract class Dice  {
    public final int sides;
    public String color;
    public boolean sparkle=false;
    protected final Random random=new Random();
    public Dice(int sides){
       this.sides=sides;
    }
    public int roll(){
        return random.nextInt(1,sides+1);
    }
    public int getSides(){
        return sides;
    }
    public String getColor(){
        return color;
    }
    public boolean getSparkle(){
        return sparkle;
    }
}
