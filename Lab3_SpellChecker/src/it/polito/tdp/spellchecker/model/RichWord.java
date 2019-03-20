package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String parola;
	private boolean correct;
	
	
	public RichWord(String parola) {
		super();
		this.parola = parola;
	}


	public RichWord(String parola, boolean correct) {
		super();
		this.parola = parola;
		this.correct = correct;
	}


	public String getParola() {
		return parola;
	}


	public void setParola(String parola) {
		this.parola = parola;
	}


	public boolean isCorrect() {
		return correct;
	}


	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	
	
	

}
