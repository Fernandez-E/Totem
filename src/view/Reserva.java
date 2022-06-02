package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.text.MaskFormatter;

import model.EstacoesDAO;
import model.ReservasDAO;
import model.UsuariosDAO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Reserva extends JFrame {
	/*ImageIcon check = new ImageIcon("check.png");
	ImageIcon medical = new ImageIcon("cesar-logo.png");
	ImageIcon ilustracao = new ImageIcon("ilustracao.png");
	*/
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*try {
					Reserva frame = new Reserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				*/
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Reserva(String id, String data, String horaInicio) throws SQLException {
		ArrayList<String> estacoes = EstacoesDAO.verificarEstacoesLivres(data);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ResultSet funcionario = UsuariosDAO.procurarFuncionario(id);
		String nome = funcionario.getString("nome");
		//MASK
		MaskFormatter fmtDataMask = null;
		try {
			fmtDataMask = new MaskFormatter("####-##-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		MaskFormatter fmtHourMask = null;	
				
		try {
			fmtHourMask = new MaskFormatter("##:##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		MaskFormatter fmtHourMask2 = null;	
		try {
			fmtHourMask2 = new MaskFormatter("##:##:##");
		} catch (ParseException e3) {
		e3.printStackTrace();
					
		}
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,255,255,235));
		panel.setBounds(10, 59, 452, 342);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lbl_nome = new JLabel("Olá, ");
		lbl_nome.setBounds(0, 11, 429, 35);
		panel.add(lbl_nome);
		lbl_nome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nome.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		lbl_nome.setText("Olá, " + nome + "!");
		
		
		JLabel lbl_horario = new JLabel("Você chegou às <dynamic>.");
		lbl_horario.setBounds(10, 57, 419, 35);
		panel.add(lbl_horario);
		lbl_horario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_horario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lbl_horario.setText("Você chegou às " + horaInicio + ".");
		
		JLabel lbl_info = new JLabel("Escolha horário de saída e estação de deseja utilizar.");
		lbl_info.setBounds(10, 99, 419, 35);
		panel.add(lbl_info);
		lbl_info.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_info.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Horario de saída:");
		lblNewLabel_1_1_1_1.setBounds(54, 166, 202, 34);
		panel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 51, 0));
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		JFormattedTextField fmtHour = new JFormattedTextField(fmtHourMask);
		fmtHour.setBounds(266, 166, 99, 35);
		panel.add(fmtHour);
		fmtHour.setHorizontalAlignment(SwingConstants.CENTER);
		fmtHour.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Estações livres:");
		lblNewLabel_1_1_2_1_1.setBounds(27, 211, 229, 35);
		panel.add(lblNewLabel_1_1_2_1_1);
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1_1.setForeground(new Color(255, 51, 0));
		lblNewLabel_1_1_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(266, 211, 99, 35);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(230, 275, 135, 31);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(255, 51, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI Historic", Font.BOLD, 11));
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio screen = new Inicio();
				screen.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(117, 279, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Sem estações disponíveis. Tente novamente mais tarde.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 134, 429, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		ImageIcon imageIcon = new ImageIcon("src/img/WhatsApp Image 2022-06-01 at 20.21.45.jpeg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(440, 440,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String data = ftmData.getText();
				String horaSaida = (fmtHour.getText());
				
				String idFuncionario = id;
				String estacao = (String) comboBox.getSelectedItem();
				System.out.println(idFuncionario);
				ReservasDAO.inserirReserva(estacao, data, horaInicio, horaSaida, null, null, idFuncionario);
				ReservasDAO.fazerCheckin(id, data, horaInicio);
				
				Concluido screen = new Concluido();
				screen.setVisible(true);
				dispose();
			}
		});
		
		
		
		ImageIcon imageIconBack = new ImageIcon("src/img/WhatsApp Image 2022-05-23 at 18.38.07.jpeg"); // load the image to a imageIcon
		Image imageBack = imageIconBack.getImage(); // transform it 
		Image newimgback = imageBack.getScaledInstance(734, 480,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIconBack = new ImageIcon(newimgback);
		
		JLabel lblA01 = new JLabel("A01");
		lblA01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.getModel().setSelectedItem("A01");
			}
		});
		lblA01.setBounds(516, 29, 46, 14);
		contentPane.add(lblA01);
		
		JLabel lblA03 = new JLabel("A03");
		lblA03.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.getModel().setSelectedItem("A03");
			}
		});
		lblA03.setBounds(516, 128, 46, 14);
		contentPane.add(lblA03);
		
		JLabel lblA02 = new JLabel("A02");
		lblA02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.getModel().setSelectedItem("A02");
			}
		});
		lblA02.setBounds(516, 77, 46, 14);
		contentPane.add(lblA02);
		
		JLabel lblMap = new JLabel("");
		lblMap.setBounds(472, 0, 440, 442);
		contentPane.add(lblMap);
		lblMap.setIcon(imageIcon);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(imageIconBack);
		lblNewLabel.setBounds(0, -31, 938, 482);
		contentPane.add(lblNewLabel);
		
	
		
		int count = 0;
		System.out.println(estacoes.size());
		if (estacoes.size() == 0) {
			comboBox.setEnabled(false);
			btnNewButton.setEnabled(false);
			fmtHour.setEnabled(false);
			btnNewButton.setBackground(new Color(200, 200, 200));
			lblNewLabel_1.setVisible(true);
			
		} else {
			while(count < estacoes.size()) {
			comboBox.addItem(estacoes.get(count));
			count++;
			}
		}
		
	}
}
