import java.util.Random;

public class Controle {
	private int tentativa, interI, interF;
	private int tam, qtdJogador, numJogadorVec;
	
	public Controle(int tent, int ii, int inf, int t, int qtdJ) {
		tentativa = tent;
		interI = ii;
		interF = inf;
		tam = t;
        qtdJogador = qtdJ;
       
	}
    
    int t[] = new int[tam];
    int i = 0, aux;
    public void setJogadas(int j){
        aux = j;
        t[i] = aux;
        i++;
    }
	
	Random r = new Random();
	public void iniciaJogo() {
		int n, aux = 0, numeroJogador = 0;
        String status = "";
		n = 7;//r.nextInt(interF)+interI;
        for(int i = 0; i < tam; i++){
            aux++;
            if(t[i] == n){
                status  = "um jogador ganhou";
                break;
            }
            if(qtdJogador == aux){
                aux = 0;
                numeroJogador++;
                setNumJogadorVec(numeroJogador);
            }
        }
	}
	public int getTentativa() {
		return tentativa;
	}

	public void setTentativa(int tentativa) {
		this.tentativa = tentativa;
	}

	public int getInterI() {
		return interI;
	}

	public void setInterI(int interI) {
		this.interI = interI;
	}

	public int getInterF() {
		return interF;
	}

	public void setInterFinal(int interF) {
		this.interF = interF;
	}
    public int getNumJogadorVec(){
        return numJogadorVec;
    }
    public void setNumJogadorVec(int njv){
        this.numJogadorVec = njv;
    }
}