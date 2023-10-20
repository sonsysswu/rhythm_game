package rhythm;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e){
        if(DynamicBeat.game==null){
            return;
        }
        if(e.getKeyCode() == KeyEvent.VK_Q){
            DynamicBeat.game.pressQ();
        }else if(e.getKeyCode() == KeyEvent.VK_W){
            DynamicBeat.game.pressW();
        }else if(e.getKeyCode() == KeyEvent.VK_E){
            DynamicBeat.game.pressE();
        }else if(e.getKeyCode() == KeyEvent.VK_R){
            DynamicBeat.game.pressR();
        }else if(e.getKeyCode() == KeyEvent.VK_U){
            DynamicBeat.game.pressU();
        }else if(e.getKeyCode() == KeyEvent.VK_I){
            DynamicBeat.game.pressI();
        }else if(e.getKeyCode() == KeyEvent.VK_O){
            DynamicBeat.game.pressO();
        }else if(e.getKeyCode() == KeyEvent.VK_P){
            DynamicBeat.game.pressP();
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        if(DynamicBeat.game==null){
            return;
        }
        if(e.getKeyCode() == KeyEvent.VK_Q){
            DynamicBeat.game.releaseQ();
        }else if(e.getKeyCode() == KeyEvent.VK_W){
            DynamicBeat.game.releaseW();
        }else if(e.getKeyCode() == KeyEvent.VK_E){
            DynamicBeat.game.releaseE();
        }else if(e.getKeyCode() == KeyEvent.VK_R){
            DynamicBeat.game.releaseR();
        }else if(e.getKeyCode() == KeyEvent.VK_U){
            DynamicBeat.game.releaseU();
        }else if(e.getKeyCode() == KeyEvent.VK_I){
            DynamicBeat.game.releaseI();
        }else if(e.getKeyCode() == KeyEvent.VK_O){
            DynamicBeat.game.releaseO();
        }else if(e.getKeyCode() == KeyEvent.VK_P){
            DynamicBeat.game.releaseP();
        }
    }
}
