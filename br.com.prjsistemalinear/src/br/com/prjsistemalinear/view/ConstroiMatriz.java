package br.com.prjsistemalinear.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.prjsistemalinear.model.Matriz;

public class ConstroiMatriz extends JPanel {

	//
	private ArrayList<Matriz> aListaMatriz = new ArrayList<Matriz>();// lista que recebe as instâncias Matriz
	private Point posicao;

	// inclusão da matriz à lista, verificando o nome
	public void addMatrizLista(String nomeMatriz, int linhaMatriz, int colunaMatriz) {
		boolean nomeExiste = false;

		if (aListaMatriz.isEmpty()) {

			aListaMatriz.add(new Matriz(nomeMatriz, linhaMatriz, colunaMatriz, 0));

			System.out.println("Matriz adicionada!");
			System.out.println("Tamanho lista: " + aListaMatriz.size());
			System.out.println("Posição: " + aListaMatriz.get(0).getPosicaoPrimeiroCampo());

		} else {

			for (int i = 0; i < aListaMatriz.size(); i++) {
				if ((aListaMatriz).get(i).getNome().equals(nomeMatriz)) {

					nomeExiste = true;
					JOptionPane.showMessageDialog(null, "Matriz '" + nomeMatriz + "' já adicionada! Dê outro nome.");
				}
			}
			if (!nomeExiste) {

				for (int i = 0; i < aListaMatriz.size(); i++) {
					for (int j = 0; j < aListaMatriz.get(i).getListaCampoJtxtf().size(); j++) {

						posicao = aListaMatriz.get(i).getPosicaoUltimoCampo();
					}
				}

				aListaMatriz.add(new Matriz(nomeMatriz, linhaMatriz, colunaMatriz, (int) posicao.getY() + 50));
				System.out.println("Nova matriz adicionada!");
				System.out.println("Posição: " + posicao);
			}
		}
	}

	//
	public void deletaMatrizLista(String nomeMatrizDeletar) {

		for (int i = 0; i < aListaMatriz.size(); i++) {
			if (aListaMatriz.get(i).getNome().equals(nomeMatrizDeletar)) {

				for (int j = 0; j < aListaMatriz.get(i).getListaCampoJtxtf().size(); j++) {

					this.remove(aListaMatriz.get(i).getListaCampoJtxtf().get(j));
					this.updateUI();
				}

				aListaMatriz.remove(i);
				System.out.println("Matriz lista " + nomeMatrizDeletar + " deletada!");
			}else if(!aListaMatriz.get(i).getNome().contentEquals(nomeMatrizDeletar)) {
				
				JOptionPane.showMessageDialog(null, "Matriz não encontrada!");
			}
		}
	}

	//
	public void addListaAoPanel() {

		for (int i = 0; i < aListaMatriz.size(); i++) {
			for (int j = 0; j < aListaMatriz.get(i).getListaCampoJtxtf().size(); j++) {

				this.add(aListaMatriz.get(i).getListaCampoJtxtf().get(j));
				this.updateUI();
			}
		}
	}
	// método para desenhar 
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		recebeAtualizacaoDesenha(g2d);
	
	}
	// pesquisa e devolve um resultado
	public void search(String search) {
		
		for (int i = 0; i < aListaMatriz.size(); i++) {
			if(aListaMatriz.get(i).getNome().equals(search) && aListaMatriz.get(i).isQuadrado()) {
				JOptionPane.showMessageDialog(null, "Traço: " + aListaMatriz.get(i).traco());
				break;
			}
		}
	}
	// método que desenha colchetes no JPanel e atualiza os campos
	private void recebeAtualizacaoDesenha(Graphics2D g2d) {
		
		for (Matriz matriz : aListaMatriz) {
			int controleDistancia = matriz.getPosicaoUltimoCampo().x - matriz.getPosicaoPrimeiroCampo().x;// variável de controle da distância dos colchetes
			
			g2d.drawString(matriz.getNome() + " =", matriz.getPosicaoUltimoCampo().x + 100, matriz.getPosicaoUltimoCampo().y + 30);// desenho nome da matriz
			g2d.drawLine(matriz.getPosicaoUltimoCampo().x + 150, matriz.getPosicaoPrimeiroCampo().y, matriz.getPosicaoUltimoCampo().x + 180, 
					matriz.getPosicaoPrimeiroCampo().y);// linha horizontal cima colchete
			g2d.drawLine(matriz.getPosicaoUltimoCampo().x + 150, matriz.getPosicaoPrimeiroCampo().y, 
							matriz.getPosicaoUltimoCampo().x + 150, matriz.getPosicaoUltimoCampo().y + 50);// linha vertical colchete
			for (int i = 0; i < matriz.getListaCampoJtxtf().size(); i++) {
				String c = matriz.getListaCampoJtxtf().get(i).getEventoKeyReleased();
				g2d.drawString(c, matriz.getListaCampoJtxtf().get(i).getLocation().x + matriz.getPosicaoUltimoCampo().x + 120,
						matriz.getListaCampoJtxtf().get(i).getLocation().y + 30);
			}
			
			//
			g2d.drawLine(matriz.getPosicaoUltimoCampo().x + 150, matriz.getPosicaoUltimoCampo().y + 50, matriz.getPosicaoUltimoCampo().x + 180, 
					matriz.getPosicaoUltimoCampo().y + 50); // linha horizontal baixo colchete 
			// desenho fim colchetes
			g2d.drawLine(matriz.getPosicaoUltimoCampo().x + controleDistancia + 220, matriz.getPosicaoPrimeiroCampo().y, 
					matriz.getPosicaoUltimoCampo().x + controleDistancia + 190, matriz.getPosicaoPrimeiroCampo().y);// linha horizontal cima colchete
			g2d.drawLine(matriz.getPosicaoUltimoCampo().x + controleDistancia + 220, matriz.getPosicaoPrimeiroCampo().y, 
					matriz.getPosicaoUltimoCampo().x + controleDistancia + 220, matriz.getPosicaoUltimoCampo().y + 50);// linha vertical colchete
			g2d.drawLine(matriz.getPosicaoUltimoCampo().x + controleDistancia + 220, matriz.getPosicaoUltimoCampo().y + 50, 
					matriz.getPosicaoUltimoCampo().x + controleDistancia + 190, matriz.getPosicaoUltimoCampo().y + 50); // linha horizontal baixo colchete
			this.updateUI();
		}
	}

	//
	public void statusLista() {

		for (int i = 0; i < aListaMatriz.size(); i++) {
			System.out.println("Nome matriz: " + aListaMatriz.get(i).getNome());
			for (int j = 0; j < aListaMatriz.get(i).getListaCampoJtxtf().size(); j++) {
				System.out.print(aListaMatriz.get(i).getListaCampoJtxtf().get(j).getName());
				System.out.println(" ");
			}
			System.out.println("Posição primeira campo: " + aListaMatriz.get(i).getPosicaoPrimeiroCampo());
			System.out.println("Posição último campo: " + aListaMatriz.get(i).getPosicaoUltimoCampo());
			System.out.println(" ");
			System.out.println("Traço: " + aListaMatriz.get(i).traco());
		}
		System.out.println("");
	}

}
