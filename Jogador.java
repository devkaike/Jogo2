import java.util.ArrayList;
import java.util.Random;

public class Jogador {
	private String nome; 
	private ArrayList<Integer> tentativa = new ArrayList<>();

	
	public Jogador(String n, ArrayList<Integer> tentativas) {
		nome = n;
		setTentativa(tentativa);
		this.tentativa = tentativa;
	}
	public Jogador() {
		
	}
	
	

	public ArrayList<Integer> getTentativa() {
		return tentativa;
	}
	public void setTentativa(ArrayList<Integer> tentativa) {
		this.tentativa = tentativa;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
} 
