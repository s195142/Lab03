package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	private List<String> dizionario = new ArrayList<String>();
	private List<RichWord> parole = new ArrayList<RichWord>();
	private String language; //
	
	public Dictionary() {
		super();
	}
	
	public boolean loadDictionary(String language) {
		if(dizionario != null && this.language.equals(language)) //
			return true; //se ci sono già parole non serve tutto il metodo successivo.
		// (else)
		this.language = language;
		try {
			FileReader fr = new FileReader("rsc/"+language+".txt"); // si può mettere anche filereader(language)?
			BufferedReader br= new BufferedReader (fr);
			String word;
			while((word = br.readLine())!=null) {
				// aggiungere parola alla strutt dati
				dizionario.clear();
				dizionario.add(word.toLowerCase());
				
			}
			Collections.sort(dizionario);
			br.close();
			System.out.println("Dizionario "+ language + "loaded. Found "+dizionario.size()+"words.");
			return true;
		}catch(IOException e) {
			System.out.println("Errore nella lettura del file");	
			return false;
		}

		
		
		
	}
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		for(String str : inputTextList) {
			RichWord richWord = new RichWord(str);
			boolean trovato = false;
			for(String word : dizionario) {
				if(word.equalsIgnoreCase(str)) {
					trovato = true;
					break;
				}
			}
			if(trovato) {
				richWord.setCorrect(true);
			}else
				richWord.setCorrect(false);
			
			parole.add(richWord);
		}
		
		return parole;		
	}

}
