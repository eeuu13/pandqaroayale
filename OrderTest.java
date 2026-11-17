import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderTest {
    @Test
    public void testPink(){
        PinkReceivers pink =new PinkReceivers(2,4);
        ArrayList<Integer> round_total=new ArrayList<>(List.of(1,2,3,4));
        ArrayList<Integer> output=pink.calculatePinkReceivers(round_total,0);
        ArrayList<Integer> expected=new ArrayList<>(List.of(1,0));
        Assertions.assertEquals(expected,output);
    }
    @Test
    public void testPink_same(){
        PinkReceivers pink =new PinkReceivers(2,4);
        ArrayList<Integer> round_total=new ArrayList<>(List.of(1,1,1,1));
        ArrayList<Integer> output=pink.calculatePinkReceivers(round_total,0);
        ArrayList<Integer> expected=new ArrayList<>(List.of(2,3));
        Assertions.assertEquals(expected,output);
    }
    @Test
    public void testPink3(){
        PinkReceivers pink =new PinkReceivers(2,4);
        ArrayList<Integer> round_total=new ArrayList<>(List.of(1,0,1,1));
        ArrayList<Integer> output=pink.calculatePinkReceivers(round_total,0);
        ArrayList<Integer> expected=new ArrayList<>(List.of(3,1));
        Assertions.assertEquals(expected,output);
    }

    @Test
    public void testOrder(){

        Order order =new Order(4);
        ArrayList<Integer> round_yellow=new ArrayList<>(List.of(1,2,3,4));
        ArrayList<Integer> output=order.calculateOrder(round_yellow);
        ArrayList<Integer> expected=new ArrayList<>(List.of(3,2,1,0));
        Assertions.assertEquals(expected,output);
    }
    @Test
    public void testOrder2(){

        Order order = new Order(2);

        ArrayList<Integer> round_yellow=new ArrayList<>(List.of(3,3));
        ArrayList<Integer> output=order.calculateOrder(round_yellow);
        ArrayList<Integer> expected=new ArrayList<>(List.of(0,1));
        if (Objects.equals(output, expected)){
            Assertions.assertEquals(expected,output);
        }
        else {
            Assertions.assertEquals(new ArrayList<>(List.of(1,0)), output);
        }
    }
    @Test
    public void testOrder3(){
        Order order= new Order(4);
        ArrayList<Integer> round_yellow=new ArrayList<>(List.of(1,3,1,3));
        ArrayList<Integer> output=order.calculateOrder(round_yellow);
        if (output.getFirst()==1){
            Assertions.assertEquals(new ArrayList<>(List.of(1,3,2,0)),output);
        }
        else{
            Assertions.assertEquals(new ArrayList<>(List.of(3,1,0,2)),output);
        }

    }
}
