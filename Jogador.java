import java.util.Random;

public class Jogador {
	private String nome; 
	private int tentativa;

	public Jogador(String n) {
		nome = n;
	}
	public Jogador() {
		
	}
	public int getTentativa() {
		return tentativa;
	}
	public void setTentativa(int tentativa) {
		this.tentativa = tentativa;
	}
	Random aleatorio = new Random();
	public String criaNome() {
		String n = "";
        char l;
        int num;
        num = aleatorio.nextInt(26)+ 65;
        l = (char)num;
        n += l;
        for(int i = 0; i < 19; i++) {
            num = aleatorio.nextInt(26) + 97;
            l = (char)num;
            n += l;
        }
        nome = n;
        return nome;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
} 