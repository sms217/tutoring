package Main;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class OnOffButton extends JLabel{
	
	private final int NUMBER;
	
	private Icon icon = new ImageIcon("src/Source/Door_Rock_B_Off.png");
	private boolean onOff = false;
	
	public OnOffButton(int number) {
		this.NUMBER = number;
		
		this.setIcon(icon);
		
		if(NUMBER<3) {
			this.setBounds(0, 59, 100, 70);
		}else if(NUMBER<6) {
			this.setBounds(0, 151, 100, 70);
		}else {
			this.setBounds(0, 243, 100, 70);
		}
		
		if((NUMBER)%3==0) {
			this.setBounds(26, this.getY(), 100, 70);
		}else if((NUMBER)%3==1) {
			this.setBounds(133, this.getY(), 100, 70);
		}else {
			this.setBounds(240, this.getY(), 100, 70);
		}
		this.setVisible(false);
	}
	public void change() {
		if(onOff) {
			onOff = false;
		}else {
			onOff = true;
		}
		if(onOff) {
			icon = new ImageIcon("src/Source/Door_Rock_B_On.png");
		}else {
			icon = new ImageIcon("src/Source/Door_Rock_B_Off.png");
		}
		this.setIcon(icon);
	}
	public int getNUMBER() {
		return NUMBER;
	}
	public boolean isOnOff() {
		return onOff;
	}
}