public class Dice_Blue extends Dice {
    private int sides;

    public Dice_Blue(int sides) {
        super(sides);
    }
    @Override
    public int roll_blue(boolean sparkle){
        int roll=random.nextInt(1,sides+1);
        if (sparkle){
            roll*=2;
        }
        return roll;
    }
    @Override
    public int roll(){
        return 0; /*To Fix: Dar erro*/
    }
}
