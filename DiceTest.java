import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiceTest {
    @Test
    public void testDice() {
        Dice test = new Dice_Yellow(6);
        Assertions.assertNotEquals(7, test.roll());
    }
    @Test
    public void testDiceBlue(){
        Dice_Blue test=new Dice_Blue(6);
        Assertions.assertNotEquals(7,test.roll_blue(false));
    }
}
