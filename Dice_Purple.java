public class Dice_Purple extends Dice {

    public Dice_Purple(int sides) {
        super(sides);
        color="Purple";
    }
    @Override
    public int roll(){
        return random.nextInt(1,sides+1)*2;
    }
}
