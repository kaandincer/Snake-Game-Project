package project;

import edu.princeton.cs.introcs.StdDraw;

import javax.naming.StringRefAddr;
import javax.naming.spi.StateFactory;
import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.awt.event.KeyEvent;

public class Game {
    public static void main(String args[]) {
        StdDraw.setScale(0, 31);

        while(true){
            StdDraw.text(15, 5, "Press Up, Down, Left, Right to move Snake");
            StdDraw.text(15, 4, "Press Space to Boost in Game");
            StdDraw.text(15, 3, "Press Space to Continue, Press E to Exit");
            while (true){
                if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) break;
                if (StdDraw.isKeyPressed(KeyEvent.VK_E)) return;
            }
            StdDraw.clear();

            Snake s = new Snake();
            Food f = new Food(s);

            while (!s.dead()) {
                boolean up = false, dn = false, lt = false, rt = false, sp = false;

                for (int t = 0; t < 15; t++) {
                    sp = StdDraw.isKeyPressed(KeyEvent.VK_SPACE);
                    StdDraw.pause(sp ? 3 : 10);

                    up = up || StdDraw.isKeyPressed(KeyEvent.VK_UP);
                    dn = dn || StdDraw.isKeyPressed(KeyEvent.VK_DOWN);
                    lt = lt || StdDraw.isKeyPressed(KeyEvent.VK_LEFT);
                    rt = rt || StdDraw.isKeyPressed(KeyEvent.VK_RIGHT);
                }
                s.turn(up, dn, lt, rt);

                s.update(f);
                f.update(s);
            }
        }
    }
}
