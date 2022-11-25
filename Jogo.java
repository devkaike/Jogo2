import java.util.Scanner;

public class Jogo {
	public static void main(String[] args) {
		Scanner dado = new Scanner(System.in);
		int qtdJogador, interInicial, interFinal, tentativa;
		System.out.print("informe a quantidade de jogadores > 3: ");
		do {
			qtdJogador = dado.nextInt();
		}while(qtdJogador < 3);
		System.out.print("informe o intervalo inicial e o final >= 50: ");
		do {
			interInicial = dado.nextInt();
			interFinal = dado.nextInt();
		}while(interInicial > interFinal && (interInicial - interFinal) < 50);
		System.out.print("informe a quantidade de tentativas > 1 <= 4: ");
		do {
			tentativa = dado.nextInt();
		}while(tentativa < 1 || tentativa > 4);
		
		//int tentativas[] = new int[qtdJogador];
		Jogador j = new Jogador();
		int t;
		Jogador tentativas[] = new Jogador[qtdJogador];
		int qtdTent[] = new int[(tentativa * qtdJogador)];
		String nome;
		int aux;
	    Controle c = new Controle(interInicial, interFinal);
		for(int i = 0; i < qtdJogador; i++) {
			System.out.println("informe seu nome jogador "+(i+1));
			dado.nextLine();
			String nomeAux = dado.nextLine();
			j.setNome(nomeAux);
			System.out.print("jogador "+j.getNome()+", faça sua jogada: ");
			aux = i;
			
			for(int x = 0; x < tentativa; x++) {
				
				if(i != 0) {
					qtdTent[aux] = dado.nextInt();
					aux++;
				}else {
					qtdTent[aux] = dado.nextInt();
					aux++;
				}
				
				
			}
			
			nome = j.getNome();
			Jogador obj = new Jogador(nome);
			tentativas[i] = obj;
		}
		for(int i = 0; i < qtdJogador; i++) {
			
			System.out.print("\nJogador: "+tentativas[i].getNome());
			aux = i;
			
			for(int x = 0; x < tentativa; x++) {
				
				if(i != 0) {
					System.out.println();
					System.out.print("Tentativas "+(x+1)+": "+qtdTent[aux]);
					aux++;
				}else {
					System.out.println();
					System.out.print("Tentativas "+(x+1)+": "+qtdTent[aux]);
					aux++;
				}
				
				
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
				status = "um jogador ganhou";
				break;
			}
			
		}
        if(i == (qtdJogador * tentativa)) {
        	System.out.print("\n nimguem acertou"+"\n Numero da sorte: "+c.getNumSorteado());
        }else {
        	System.out.println("\n"+status+ "  "+tentativas[nomeP].getNome()+" "+c.getNumSorteado() );
        }
        
	}
}
