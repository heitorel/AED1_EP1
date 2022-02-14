package ep_aed1;

public class PilhaIngenua{
	protected final int MAX = 1000000;
	protected Integer[] pilha;
	
	public PilhaIngenua() {
		pilha = new Integer[MAX];
		for(int i =0; i<pilha.length; i++) {
			pilha[i] = -1;
		}
	}
	
	public void add(int newElement) {
		int i = MAX-1;
		while(i>=0) {
			if(pilha[i]==-1) {
				pilha[i] = newElement;
				break;
			}else {
				i--;
			}
		}
	}
	
	public int remove() {
		int aux = -2;
		int iterador = MAX-1;
		while(iterador>=0) {
			if(pilha[iterador-1]==-1) {
				aux = pilha[iterador];
				pilha[iterador] = -1;
				break;
			}else {
				iterador--;
			}
		}
		return aux;
	}
	
}