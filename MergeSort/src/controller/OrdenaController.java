package controller;

public class OrdenaController {

	public OrdenaController() {
		super();
	}

	public int[] ordenaMerge (int[] vetor, int inicio, int fim) {
		
		if (inicio < fim) {
			int meio = (inicio + fim)/2;
			ordenaMerge(vetor, inicio, meio); 
			ordenaMerge(vetor, meio + 1, fim);
			intercala(inicio, meio, fim, vetor);
		}
		return vetor;
	}

	private void intercala(int inicio, int meio, int fim, int[] vetor) {
		int auxVetor[] = new int [vetor.length];
		for (int i = inicio; i <= fim; i++) {
			auxVetor[i] = vetor[i];
		}
		
		int esquerda = inicio;
		int direita = meio + 1;
		
		for (int cont = inicio; cont <= fim; cont++) {
			if (esquerda > meio) {
				vetor[cont] = auxVetor[direita];
				direita++;
			} else if (direita > fim) {
				vetor[cont] = auxVetor[esquerda];
				esquerda++; 
			} else if (auxVetor[esquerda] < auxVetor[direita]) {
				vetor[cont] = auxVetor[esquerda];
				esquerda++;
			} else {
				vetor[cont] = auxVetor[direita];
				direita++;
			}
		}
		
	}
}
