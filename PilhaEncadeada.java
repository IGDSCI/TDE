public class PilhaEncadeada {
    private No inicio;
    private No ultimo;
    private int tamanho = 0;

    public void adiciona(int informacao) {
        No celula = new No(informacao);
        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
        System.out.println("O valor " + informacao + " foi adicionado com sucesso");
    }


    public void removeUltimo() {
        if (this.tamanho == 0) {
            System.out.println("Pilha vazia, não é possível remover.");
        } else if (this.tamanho == 1) {
            this.inicio = null;
            this.ultimo = null;
        } else {
            No penultimo = this.inicio;
            while (penultimo.getProximo() != this.ultimo) {
                penultimo = penultimo.getProximo();
            }
            System.out.println("O valor removido foi o número: " + penultimo.getProximo().getInformacao());
            penultimo.setProximo(null);
            this.ultimo = penultimo;
        }
        this.tamanho--;
    }

    public void imprimir() {
        No atual = this.inicio;
        System.out.print("PilhaEncadeada { ");
        while (atual != null) {
            System.out.print(atual.getInformacao());
            atual = atual.getProximo();
            if (atual != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" }");
    }

    public int getUltimo(){
        return ultimo.getInformacao();
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia(){
        return getTamanho() == 0;
    }
}
