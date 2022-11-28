import java.util.Scanner;

import javax.swing.JOptionPane;

public class Jogo {
	public static void main(String[] args) {
		Scanner dado = new Scanner(System.in);
		int qtdJogador = 0, interInicial = 0, interFinal = 0, tentativa = 0;
		//System.out.print("informe a quantidade de jogadores > 3: ");
		do {
			try{
				String s = JOptionPane.showInputDialog(null, "informe a quantidade de jogadores > 3:", "entrada de dados", 1);
				qtdJogador = Integer.valueOf(s);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Erro!", "entrada de dados", 1);
			}
			
		}while(qtdJogador < 3);
		//System.out.print("informe o intervalo inicial e o final >= 50: ");
		do {
			try{
				String s = JOptionPane.showInputDialog(null, "informe o intervalo inicial:", "entrada de dados", 1);
				interInicial = Integer.valueOf(s);
				s = JOptionPane.showInputDialog(null, "informe o intervalo final:", "entrada de dados", 1);
				interFinal = Integer.valueOf(s);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Erro!", "entrada de dados", 1);
			}
			
		}while(interInicial > interFinal && (interInicial - interFinal) < 50);
		//System.out.print("informe a quantidade de tentativas > 1 <= 4: ");
		do {
			try{
				String s = JOptionPane.showInputDialog(null, "informe a quantidade de tentativas > 1 <= 4", "entrada de dados", 1);
				tentativa = Integer.valueOf(s);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Erro!", "entrada de dados", 1);
			}
			
		}while(tentativa < 1 || tentativa > 4);
		
		//int tentativas[] = new int[qtdJogador];
		Jogador j = new Jogador();
		Jogador tentativas[] = new Jogador[qtdJogador];
		int qtdTent[] = new int[(tentativa * qtdJogador)];
		String nome;
	    Controle c = new Controle(interInicial, interFinal);
		int salva = 0;
		for(int i = 0; i < qtdJogador; i++) {
			String nomeAux = "";
			try{
				String s = JOptionPane.showInputDialog(null,"informe seu nome jogador "+(i+1) , "entrada de dados", 1);
				nomeAux = s;
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Erro!", "entrada de dados", 1);
			}
			
			j.setNome(nomeAux);
			int tent =0;
			for(int x = 0; x < tentativa; x++) {
				do{
					try{
						String s = JOptionPane.showInputDialog(null, "jogador "+j.getNome()+", faça sua jogada", "entrada de dados", 1);
						tent = Integer.valueOf(s);
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Erro!", "entrada de dados", 1);
					}
					
				}while(tent < interInicial || tent > interFinal);
				qtdTent[salva] = tent;
				salva++;
			}
			
			nome = j.getNome();
			Jogador obj = new Jogador(nome);
			tentativas[i] = obj;
		}
		String somaString = "";
		salva = 0;
		for(int i = 0; i < qtdJogador; i++) {
			somaString += "\nJogador: "+tentativas[i].getNome();
			for(int x = 0; x < tentativa; x++) {
				somaString += "\n";
				somaString += "Tentativas "+(x+1)+": "+qtdTent[salva];
				salva++;
			}
		}
		
		String status = "";
		int x= 0, nomeP = 0;
		int i = 0;
		for(;i < (qtdJogador * tentativa) ; i++, x++) {
			
			if(x == qtdJogador) {
				nomeP++;
				x = 0;
			}
			
			if(c.iniciaJogo(qtdTent[i], i)) {
				somaString += "\num jogador ganhou";
				break;
			}
			
		}
        if(i == (qtdJogador * tentativa)) {
        	somaString += "\n nimguem acertou"+"\n Numero da sorte: "+c.getNumSorteado();
        }else {
        	somaString += "\n"+status+ "  "+tentativas[nomeP].getNome()+" "+c.getNumSorteado();
        }
		try{
			JOptionPane.showMessageDialog(null, somaString, "entrada de dados", 1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro!", "saida de dados", 1);
		}
	}
}
