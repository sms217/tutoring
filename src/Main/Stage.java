package Main;

import java.util.*;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.*;

public class Stage extends JFrame implements Runnable{
	
	private OnOffButton[] btn = new OnOffButton[9];
	
	private boolean find = false;
	
	private JLabel startBtn;
	private JLabel backImage;
	private JLabel frontImage;
	private JPanel panel;
	private ImageIcon icon;
	private MyAdapter myAdapter= new MyAdapter();
	
	public Stage() {
		panel = new JPanel();
		setTitle("자바게티 1807110 서민성");
		setSize(380, 405);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		frontImage= new JLabel(new ImageIcon("src/Source/St_Pic.png"));
		frontImage.setBounds(0, 0, 366, 369);
		backImage= new JLabel(new ImageIcon("src/Source/Door_Rock1.png"));
		backImage.setBounds(0, 0, 366, 369);
		
		startBtn = new JLabel(new ImageIcon("src/Source/START-CLICK.png"));
//		startBtn.setBounds(0, 0, 366, 369);
//		startBtn.setBounds(25, 60, 316, 249);
		startBtn.setBounds(50, 120, 266, 129);
		startBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				frontImage.setVisible(false);
				frontImage.setIcon(new ImageIcon("src/Source/End_Pic.png"));
				for(int i = 0;i<btn.length;i++) {
					btn[i].setVisible(true);
				}
				startBtn.setVisible(false);
			}
			
		});
		
		panel.setLayout(null);
		
		panel.add(startBtn);
		panel.add(frontImage);
		start();
		panel.add(backImage);
		this.add(panel);
		setVisible(true);
		
	}

	public void start() {
		
		for(int i = 0;i<btn.length;i++) {
			btn[i] = new OnOffButton(i);
			panel.add(btn[i]);
			int idx = btn[i].getNUMBER();
			btn[i].addMouseListener(myAdapter);
		}
	}
	
	public void end() {
		find = true;
		for(int i = 0;i<btn.length;i++) {
			if(!btn[i].isOnOff()) {
				find = false;
				break;
			}
		}
		if(find) {
			for(int i = 0;i<btn.length;i++) {
				btn[i].removeMouseListener(myAdapter);
			}
			
			
			Thread thread = new Thread(this);
			thread.start();
		}
		
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		for(int i = 0;i<btn.length;i++) {
			btn[i].setVisible(false);
			this.remove(btn[i]);
		}
		frontImage.setVisible(true);
	}

	class MyAdapter extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			OnOffButton button = (OnOffButton)e.getSource();
			button.change();
			switch(button.getNUMBER()) {
			case 0:
				btn[1].change();
				btn[3].change();
				break;
			case 1:
				btn[0].change();
				btn[2].change();
				btn[4].change();
				break;
			case 2:
				btn[1].change();
				btn[5].change();
				break;
			case 3:
				btn[0].change();
				btn[4].change();
				btn[6].change();
				break;
			case 4:
				btn[1].change();
				btn[3].change();
				btn[5].change();
				btn[7].change();
				break;
			case 5:
				btn[2].change();
				btn[8].change();
				btn[4].change();
				break;
			case 6:
				btn[3].change();
				btn[7].change();
				break;
			case 7:
				btn[4].change();
				btn[6].change();
				btn[8].change();
				break;
			case 8:
				btn[7].change();
				btn[5].change();
				break;
			}
			end();
		}
	
	}
}
