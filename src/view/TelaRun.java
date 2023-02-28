package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.RunController;
import controller.SearchController;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaRun extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRun frame = new TelaRun();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaRun() {
		setTitle("Executar - Windows");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o caminho do executável ou clique em \r\nprocurar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(115, 50, 280, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaRun.class.getResource("/view/JavaIcon.jpg")));
		lblNewLabel_1.setBounds(10, 15, 85, 80);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Abrir:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(35, 110, 45, 15);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(115, 110, 280, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBounds(115, 140, 90, 20);
		RunController runController = new RunController(textField, this);
		btnOK.addActionListener(runController);
		contentPane.add(btnOK);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(210, 140, 90, 20);
		contentPane.add(btnCancelar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(305, 140, 90, 20);
		SearchController searchController = new SearchController(textField);
		btnProcurar.addActionListener(searchController);
		contentPane.add(btnProcurar);
	}
}
