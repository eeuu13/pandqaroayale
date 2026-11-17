import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Menu {
    Terminal terminal;
    Screen screen;
    TextGraphics graphics;
    public Menu(){
        try {
            terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            graphics = screen.newTextGraphics();
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run() throws IOException {
        draw();
    }
    private void draw() throws IOException {
        screen.clear();
        graphics.setForegroundColor(TextColor.Factory.fromString("#DD33FF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(32,5),"Panda Royale");
        screen.refresh();
    }
}
