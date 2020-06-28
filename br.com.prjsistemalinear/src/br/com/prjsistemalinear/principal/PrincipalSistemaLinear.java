package br.com.prjsistemalinear.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import br.com.prjsistemalinear.controller.CampoJtxtf;
import br.com.prjsistemalinear.view.ConstroiMatriz;

public class PrincipalSistemaLinear {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

	//
	public static void createAndShowGUI() {
		//
		JFrame frame = new JFrame("OPERA��ES EM SISTEMAS LINEARES");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		/* Panel esquerdo */
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(3, 1, 5, 5));
		/* componentes do panel esquerdo */
		JLabel lblLinha = new JLabel("LINHA: ");
		CampoJtxtf txtfLinha = new CampoJtxtf(2);
		txtfLinha.setHorizontalAlignment(JTextField.CENTER);
		/* JLabel e CampoJtxtf para coluna */
		JLabel lblColuna = new JLabel("COLUNA: ");
		CampoJtxtf txtfColuna = new CampoJtxtf(2);
		txtfColuna.setHorizontalAlignment(JTextField.CENTER);
		/* JLabel e CampoJtxtf para nome da matriz */
		JLabel lblNomeMatriz = new JLabel("NOME: ");
		JTextField txtfNomeMatriz = new JTextField();
		txtfNomeMatriz.setHorizontalAlignment(JTextField.CENTER);
		txtfNomeMatriz.setToolTipText("Nome de matriz � sempre em letra mai�scula!");
		/* JButton para bot�o criar */
		JButton btnCriar = new JButton("CRIAR");
		/* JPanel para inclus�o dos componentes do panel esquerdo */
		JPanel panelCriar = new JPanel();
		panelCriar.setBorder(BorderFactory.createTitledBorder("Propriedades matriz: "));
		GroupLayout layout = new GroupLayout(panelCriar);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		panelCriar.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()

				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(lblLinha, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)// define
																													// o
																													// comprimento
																													// do
																													// componente
								.addComponent(txtfLinha, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(lblColuna, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtfColuna, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						
						.addGroup(layout.createSequentialGroup()
										.addComponent(lblNomeMatriz, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtfNomeMatriz, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						
						.addGroup(layout.createSequentialGroup().addComponent(btnCriar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))));

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblLinha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)// define
																											// altura do
																											// componente
						.addComponent(txtfLinha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblColuna, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtfColuna, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblNomeMatriz, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtfNomeMatriz, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(15)// ajusta o espa�o horizontal entre os componentes
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnCriar,
						GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)));

		/* inclus�o dos JPanel dentro do panel esquerdo */
		panelLeft.add(panelCriar);
		/* Panel central */
		ConstroiMatriz cm = new ConstroiMatriz();
		cm.setLayout(null);
		cm.setBackground(Color.gray);

		btnCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					String nomeM = txtfNomeMatriz.getText().toUpperCase();
					int linhaMatriz = Integer.valueOf(txtfLinha.getText());
					int colunaMatriz = Integer.valueOf(txtfColuna.getText());
					cm.addMatrizLista(nomeM, linhaMatriz, colunaMatriz);
					//cm.statusLista();
					cm.addListaAoPanel();

				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "Defina os atributos da matriz!");
				}

			}
		});

		/* componentes panelDeletar */
		JLabel lblDeleteNome = new JLabel("NOME: ");
		JTextField txtfDeleteNome = new JTextField();
		txtfDeleteNome.setHorizontalAlignment(JTextField.CENTER);
		/* JButton bot�o deletar */
		JButton btnDeletar = new JButton("DELETAR");
		/* inclus�o componentes no panel deletar */
		JPanel panelDelete = new JPanel();
		panelDelete.setBorder(BorderFactory.createTitledBorder("Deletar matriz: "));
		GroupLayout layout1 = new GroupLayout(panelDelete);
		layout1.setAutoCreateGaps(true);
		layout1.setAutoCreateContainerGaps(true);
		panelDelete.setLayout(layout1);
		layout1.setHorizontalGroup(layout1.createSequentialGroup()

				.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout1.createSequentialGroup()
								.addComponent(lblDeleteNome, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)// define
																														// o
																														// comprimento
																														// do
																														// componente
								.addComponent(txtfDeleteNome, GroupLayout.PREFERRED_SIZE, 40,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(layout1.createSequentialGroup().addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE,
								90, GroupLayout.PREFERRED_SIZE))));

		layout1.setVerticalGroup(layout1.createSequentialGroup()
				.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblDeleteNome, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)// define
																												// altura
																												// do
																												// componente
						.addComponent(txtfDeleteNome, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(15)
				.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)));
		/* evento do bot�o deletar */
		btnDeletar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cm.deletaMatrizLista(txtfDeleteNome.getText().toUpperCase());
				// txtfDName.setText("");

			}
		});
		/* componentes Panel opera��es */
		JButton btnSoma = new JButton("SOMA");
		JButton btnSubtracao = new JButton("SUBTRA��O");
		JButton btnMultiplicacao = new JButton("MULTIPLICA��O");
		JButton btnTransposta = new JButton("TRANSPOSTA");
		JButton btnTraco = new JButton("TRA�O");
		/* inclus�o componentes no JPanel opera��es */
		JPanel panelOperacoes = new JPanel();
		panelOperacoes.setBorder(BorderFactory.createTitledBorder("Opera��es: "));
		GroupLayout layout2 = new GroupLayout(panelOperacoes);
		layout2.setAutoCreateGaps(true);
		layout2.setAutoCreateContainerGaps(true);
		panelOperacoes.setLayout(layout2);
		layout2.setHorizontalGroup(layout2.createSequentialGroup()
				.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout2.createSequentialGroup()
								.addComponent(btnSoma, GroupLayout.PREFERRED_SIZE,130, GroupLayout.PREFERRED_SIZE))
						
						.addGroup(layout2.createSequentialGroup()
								.addComponent(btnSubtracao, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						
						.addGroup(layout2.createSequentialGroup()
								.addComponent(btnMultiplicacao, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						
						.addGroup(layout2.createSequentialGroup()
								.addComponent(btnTransposta, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						
						.addGroup(layout2.createSequentialGroup()
								.addComponent(btnTraco, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						));
				
		
		layout2.setVerticalGroup(layout2.createSequentialGroup()
				.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnSoma, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				
						.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnSubtracao, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						
						.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnMultiplicacao, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnTransposta, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnTraco, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								);
		/* adi��o do evento ActionListener para objeto btnTraco */
		btnTraco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					String nome = JOptionPane.showInputDialog("Digitar nome matriz para obter tra�o: ").toUpperCase();
					cm.search(nome);
					//cm.statusLista();
					
				} catch (Exception e2) {
				
					JOptionPane.showMessageDialog(null, "ERRO: os campos n�o podem ser: " + e2.getCause());
				}
			}
		});
		/* inclus�o panel dentro de panel */
		panelLeft.add(panelCriar);
		panelLeft.add(panelDelete);
		panelLeft.add(panelOperacoes);

		/* inclus�o dos paineis dentro do frame */
		frame.getContentPane().add(panelLeft, BorderLayout.WEST);
		frame.getContentPane().add(cm, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
