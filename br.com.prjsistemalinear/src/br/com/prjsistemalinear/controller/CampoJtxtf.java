package br.com.prjsistemalinear.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class CampoJtxtf extends JTextField {
	/*
	 * Esta classe foi obtida de um exemplo 
	 * da internet
	 * */
	// atributos
	private int numeroMaximoCaracteres = -1;
	private String eventoKeyReleased ="";


	public String getEventoKeyReleased() {
		return eventoKeyReleased;
	}

	public void setEventoKeyReleased(String eventoKeyReleased) {
		this.eventoKeyReleased = eventoKeyReleased;
	}

	public int getNumeroMaximoCaracteres() {
		return numeroMaximoCaracteres;
	}

	public void setNumeroMaximoCaracteres(int numeroMaximoCaracteres) {
		this.numeroMaximoCaracteres = numeroMaximoCaracteres;
	}

	public CampoJtxtf(int numeromaximocaracteres) {
		super();
		setNumeroMaximoCaracteres(numeromaximocaracteres);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				tipoDigitado(e);
				
			}
		});
	}
	//

	public CampoJtxtf(String nameCampo, int maximoCaracter, int x, int y) {

		setName(nameCampo);
		setBorder(BorderFactory.createEmptyBorder());
		setHorizontalAlignment(JTextField.CENTER);
		setSize(40, 40);
		setLocation(x, y);

		setNumeroMaximoCaracteres(maximoCaracter);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				tipoDigitado(e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				setEventoKeyReleased(getText());
				System.out.println(getEventoKeyReleased());
			}

		});
	}

	// determina quantidade m�xima de caracteres digitados no campo
	// e define que pode ser digitados somente n�meros
	private void tipoDigitado(KeyEvent e) {
		String caracteres = "-1234567890"; // caracteres que ser�o verificados
		if (!caracteres.contains(e.getKeyChar() + "")) {
			e.consume(); // propriedade que elimina a��o do evento
		}
		if (getText().length() >= getNumeroMaximoCaracteres() && (getNumeroMaximoCaracteres() != -1)) {
			// if para saber se precisa verificar tamb�m o tamanho da string do campo
			// maior ou igual ao tamanho m�ximo, cancela e nao deixa inserir mais
			e.consume();
			setText(getText().substring(0, getNumeroMaximoCaracteres())); // move caracteres inv�lidos
		}

	}

}
