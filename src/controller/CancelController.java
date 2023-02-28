package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CancelController implements ActionListener{
	
	private JFrame frame;
	
	// Procede dispose() da tela.
	public CancelController(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}
	
	

}
