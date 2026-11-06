public class Dice_Purple extends Dice {
    private int sides;

    public Dice_Purple(int sides) {
        super(sides);
    }
    @Override
    public int roll(){
        return random.nextInt(1,sides+1)*2;
    }
}
