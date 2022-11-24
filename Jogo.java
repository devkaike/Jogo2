import java.util.Scanner;

public class Jogo {
	public static void main(String[] args) {
		Scanner dado = new Scanner(System.in);
		int qtdJogador, interInicial, interFinal, tentativa;
		System.out.print("informe a quantidade de jogadores > 3: ");
		do {
			qtdJogador = dado.nextInt();
		}while(qtdJogador < 3);
		System.out.print("informe o intervalo inicial e o final > 50: ");
		do {
			interInicial = dado.nextInt();
			interFinal = dado.nextInt();
		}while((interInicial - interFinal) < 50);
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
	    Controle c = new Controle(tentativa, interInicial, interFinal, (tentativa * qtdJogador), qtdJogador);
		for(int i = 0; i < qtdJogador; i++) {
			j.criaNome();
			System.out.print("jogador "+j.getNome()+", faça sua jogada: ");
			aux = i;
			for(int x = 0; x < tentativa; x++) {
				if(i != 0) {
					aux++;
				}
				qtdTent[aux] = dado.nextInt();
				aux++;

				
                int aux1 = qtdTent[aux];
                c.setJogadas(aux1);
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
					aux++;
				}
				System.out.println();
				System.out.print("Tentativas "+(x+1)+": "+qtdTent[aux]);
				aux++;
			}
		}
        //Controle cont = new Controle();
        
        System.out.println("O jogador vencedor foi: "+tentativas[c.getNumJogadorVec()]);
	}
}
