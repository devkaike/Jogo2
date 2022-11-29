import java.util.ArrayList;
import java.util.Random;

public class Controle {
	private int interI, interF, numSorteado;
	Random r = new Random();
	public Controle( int ii, int inf) {
		
		interI = ii;
		interF = inf;  
	}
    
	/*public void teste() {
		
	}*/
	
	public boolean iniciaJogo(Integer tentativas, int i) {
		if(i == 0) {
			numSorteado = r.nextInt((interF-interI+1))+interI;
		}
        if(tentativas == getNumSorteado()) {
        	return true;
        }else {
        	return false;
        }
	}
	
	

	public int getNumSorteado() {
		return numSorteado;
	}
	public void setNumSorteado(int numSorteado) {
		this.numSorteado = numSorteado;
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
    
}
