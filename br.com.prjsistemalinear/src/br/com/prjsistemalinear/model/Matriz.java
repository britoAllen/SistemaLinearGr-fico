package br.com.prjsistemalinear.model;

import java.awt.Point;
import java.util.ArrayList;

import br.com.prjsistemalinear.controller.CampoJtxtf;
import br.com.prjsistemalinear.controller.FormaMatricial;

public class Matriz implements FormaMatricial{
	/* atributos */
	private String nome;
	private int linha;
	private int coluna;
	private boolean isQuadrado = false;
	private int ajustaPosicao;
	private ArrayList<CampoJtxtf> listaCampoJtxtf = new ArrayList<CampoJtxtf>();
	private Point posicaoPrimeiroCampo;
	private Point posicaoUltimoCampo;
	
	/* getters e setters */
	public int getAjustaPosicao() {
		return ajustaPosicao;
	}
	public void setAjustaPosicao(int ajustaPosicao) {
		this.ajustaPosicao = ajustaPosicao;
	}
	public Point getPosicaoPrimeiroCampo() {
		return posicaoPrimeiroCampo;
	}
	public void setPosicaoPrimeiroCampo(Point posicaoPrimeiroCampo) {
		this.posicaoPrimeiroCampo = posicaoPrimeiroCampo;
	}
	public Point getPosicaoUltimoCampo() {
		return posicaoUltimoCampo;
	}
	public void setPosicaoUltimoCampo(Point posicaoUltimoCampo) {
		this.posicaoUltimoCampo = posicaoUltimoCampo;
	}
	public String getNome() {
		return nome;
	}
	public int getLinha() {
		return linha;
	}
	public int getColuna() {
		return coluna;
	}
	public boolean isQuadrado() {
		return isQuadrado;
	}
	public ArrayList<CampoJtxtf> getListaCampoJtxtf() {
		return listaCampoJtxtf;
	}
	/* construtor */
	public Matriz(String nome, int linha, int coluna, int ajustaPosicao) {
		super();
		this.nome = nome;
		this.linha = linha;
		this.coluna = coluna;
		this.ajustaPosicao = ajustaPosicao;
		/* valida a matriz se ela é quadrada */
		if(getLinha() == getColuna()) {
			this.isQuadrado = true;
		}
		/* inclusão do objeto modificado CampoJtextf a lista */
		int id = 1;
		for (int i = 1; i <= getLinha(); i++) {
			for (int j = 1; j <= getColuna(); j++) {
				listaCampoJtxtf.add(new CampoJtxtf(Integer.toString(id), 5, (j * 50), (i * 50) + this.getAjustaPosicao()));
				id++;
			}
		}
		posicaoPrimeiroCampo = getListaCampoJtxtf().get(0).getLocation();
		posicaoUltimoCampo = getListaCampoJtxtf().get(getLinha() * getColuna() - 1).getLocation();
	}
	@Override
	public int traco() {
		
		int temp = 0;
		int count = 0;
		int[][] tempM = new int[getLinha()][getColuna()];
		if(isQuadrado()) {
			
			for (int i = 0; i < tempM.length; i++) {
				for (int j = 0; j < tempM.length; j++) {
					tempM[i][j] = Integer.parseInt(listaCampoJtxtf.get(count).getText());
					count++;
				}
			}
			for (int i = 0; i < tempM.length; i++) {
				temp = temp + tempM[i][i];
				System.out.println(temp);
			}
			
		}
		return temp;
	}
	@Override
	public ArrayList transposicao() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
