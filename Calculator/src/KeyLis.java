import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class KeyLis implements KeyListener{
	
	Calculator parent;
	
	public KeyLis(Calculator parent){
		this.parent = parent;
	}
	
	public void keyPressed(KeyEvent e){}
	
	public void keyReleased(KeyEvent e){}
	
	public void keyTyped(KeyEvent e){
		
		String clickedButtonLabel= parent.displayField.getText();
		parent.displayField.setText(clickedButtonLabel+e.getKeyChar());
		
	}
	
}
