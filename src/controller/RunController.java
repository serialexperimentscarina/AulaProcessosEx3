package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RunController implements ActionListener{
	
	private JTextField textField;
	private JFrame frame;
	
	// Tenta executar o que está escrito no JTextField. 
	// Caso o arquivo seja inválido, retorna uma mensagem de erro. Uma vez executado, sem erro, a tela é ser finalizada 

	public RunController(JTextField textField,JFrame frame) {
		this.textField = textField;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String process = "";
		try {
			process = textField.getText().trim();
			Runtime.getRuntime().exec(process);
			frame.dispose();
		} catch (Exception e1) {
			String msgErro = e1.getMessage();
			if (msgErro.contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(process);
				try {
					Runtime.getRuntime().exec(buffer.toString());
					frame.dispose();
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
