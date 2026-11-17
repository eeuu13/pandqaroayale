import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Draw {
    int collums;
    TextGraphics graphics;
    public Draw(int collums,TextGraphics graphics){
        this.collums=collums;
        this.graphics=graphics;
    }
    public void draw_centered(String name,int row){
        draw_centered(new ArrayList<>(List.of(name)),row);
    }
    public void draw_centered(ArrayList<String> names,int row){
        int size=names.size();
        int max_size=0;
        for (String s:names){
            if (s.length()>max_size){
                max_size=s.length();
            }
        }
        draw_centered(names,max_size,row);
    }
    public void draw_centered(ArrayList<String> names,int allocated_space,int row){
        int remaining_space=collums-allocated_space*names.size();
        int space_between=remaining_space/(names.size()+1);
        for (int i=0;i<names.size();i++){
            int starting_position=(space_between+allocated_space)*i+space_between;
            graphics.putString(starting_position,row,names.get(i));
        }
    }
}
