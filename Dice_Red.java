public class Dice_Red extends Dice {
    private int sides;
    public Dice_Red(int sides) {
        super(sides);
    }
    @Override
    public int roll_red(int number_reds){
        int roll=random.nextInt(1,sides+1);
        if (roll<=sides/2){
            roll*=-1;
        }
        return roll*number_reds;
    }
    @Override
    public int roll(){
        return 0; /*To Fix: Dar erro*/
    }
}