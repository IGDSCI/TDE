public class No {
    private int informacao;
    private No proximo;

    public No(int informacao){
        this.informacao = informacao;
        this.proximo = null;
    }

    public int getInformacao() {
        return informacao;
    }

    public void setInformacao(int informacao) {
        this.informacao = informacao;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

}
