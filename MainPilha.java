import java.util.Scanner;

public class MainPilha {

    public static void resolverTorreHanoi(int n, PilhaEncadeada origem, PilhaEncadeada destino, PilhaEncadeada auxiliar) {
        if (n > 0) {

            resolverTorreHanoi(n - 1, origem, auxiliar, destino);


            int disco = origem.getUltimo();
            origem.removeUltimo();
            destino.adiciona(disco);
            System.out.println("Mover disco " + disco + " de " + origem + " para " + destino);


            resolverTorreHanoi(n - 1, auxiliar, destino, origem);
        }
    }

    public static boolean isOrdenadaDecrescente(PilhaEncadeada pilha) {
        boolean ordenadaDecrescente = true;
        int temp = pilha.getUltimo();
        pilha.removeUltimo();

        while (pilha.getTamanho() > 0) {
            int elemento = pilha.getUltimo();
            pilha.removeUltimo();

            if (elemento < temp) {
                ordenadaDecrescente = false;
                break;
            }

            temp = elemento;
        }

        return ordenadaDecrescente;
    }

    public static boolean isOrdenadaCrescente(PilhaEncadeada pilha) {
        boolean ordenadaCrescente = true;
        int temp = pilha.getUltimo();
        pilha.removeUltimo();

        while (pilha.getTamanho() > 0) {
            int elemento = pilha.getUltimo();
            pilha.removeUltimo();

            if (elemento > temp) {
                ordenadaCrescente = false;
                break;
            }

            temp = elemento;
        }

        return ordenadaCrescente;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaEncadeada pilha1 = new PilhaEncadeada();
        PilhaEncadeada pilha2 = new PilhaEncadeada();
        PilhaEncadeada pilha3 = new PilhaEncadeada();

        System.out.println("Digite o tamanho das pilhas: ");
        int valor;
        int cont = 0;
        int escolha = -1;
        int ordem;
        valor = sc.nextInt();
        int tamanhopilha = valor;
        int contadorMovimentos = 0;

        while (valor != cont) {
            int numeroAleatorio = (int) (Math.random() * 100);
            pilha1.adiciona(numeroAleatorio);
            cont++;
        }

        pilha1.imprimir();
        pilha2.imprimir();
        pilha3.imprimir();

        System.out.println("Você deseja ordenar a pilha de que forma: Crescente [0] ou Decrescente [1]");
        ordem = sc.nextInt();

        while (escolha != 0){
            System.out.println("0 - sair do jogo: ");
            System.out.println("1 - movimentar: ");
            System.out.println("2 - solução automatica: ");
            escolha = sc.nextInt();

            if (escolha == 1){
                int escolharemover;
                int valorRemovido;
                System.out.println("Qual pilha você deseja remover um número: ");
                pilha1.imprimir();
                pilha2.imprimir();
                pilha3.imprimir();
                escolharemover = sc.nextInt();
                int escolharemovefixo = escolharemover;

                if (escolharemover == 1){
                    valorRemovido = pilha1.getUltimo();
                    pilha1.removeUltimo();
                } else if (escolharemover == 2) {
                    valorRemovido = pilha2.getUltimo();
                    pilha2.removeUltimo();
                } else{
                    valorRemovido = pilha3.getUltimo();
                    pilha3.removeUltimo();
                }

                contadorMovimentos = contadorMovimentos + 1;

                System.out.println("Qual pilha você deseja adicionar esse valor: ");
                pilha1.imprimir();
                pilha2.imprimir();
                pilha3.imprimir();
                escolharemover = sc.nextInt();

                if (ordem == 1){
                    if (escolharemover == 1){
                        if (pilha1.getTamanho() == 0){
                            pilha1.adiciona(valorRemovido);
                        } else if (pilha1.getUltimo() > valorRemovido){
                            pilha1.adiciona(valorRemovido);
                        } else {
                            if (escolharemovefixo == 1){
                                pilha1.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 2) {
                                pilha2.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 3) {
                                pilha3.adiciona(valorRemovido);
                            }
                        }

                    } else if (escolharemover == 2) {
                        if (pilha2.getTamanho() == 0){
                            pilha2.adiciona(valorRemovido);
                        } else if (pilha2.getUltimo() > valorRemovido) {
                            pilha2.adiciona(valorRemovido);
                        } else {
                            if (escolharemovefixo == 1){
                                pilha1.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 2) {
                                pilha2.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 3) {
                                pilha3.adiciona(valorRemovido);
                            }
                        }

                    } else if (escolharemover == 3){
                        if (pilha3.getTamanho() == 0){
                            pilha3.adiciona(valorRemovido);
                        } else if (pilha3.getUltimo() > valorRemovido) {
                            pilha3.adiciona(valorRemovido);
                        } else {
                            if (escolharemovefixo == 1){
                                pilha1.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 2) {
                                pilha2.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 3) {
                                pilha3.adiciona(valorRemovido);
                            }
                        }
                    }

                    if ((pilha1.getTamanho() == tamanhopilha && isOrdenadaDecrescente(pilha1)) ||
                            (pilha2.getTamanho() == tamanhopilha && isOrdenadaDecrescente(pilha2)) ||
                            (pilha3.getTamanho() == tamanhopilha && isOrdenadaDecrescente(pilha3))) {
                        System.out.println("Uma das pilhas atingiu o tamanho máximo e está ordenada de forma decrescente em " +contadorMovimentos + " vezes");
                        break;
                    }
                } else {
                    if (escolharemover == 1){
                        if (pilha1.getTamanho() == 0){
                            pilha1.adiciona(valorRemovido);
                        } else if (pilha1.getUltimo() < valorRemovido){
                            pilha1.adiciona(valorRemovido);
                        } else {
                            if (escolharemovefixo == 1){
                                pilha1.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 2) {
                                pilha2.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 3) {
                                pilha3.adiciona(valorRemovido);
                            }
                        }

                    } else if (escolharemover == 2) {
                        if (pilha2.getTamanho() == 0){
                            pilha2.adiciona(valorRemovido);
                        } else if (pilha2.getUltimo() < valorRemovido) {
                            pilha2.adiciona(valorRemovido);
                        } else {
                            if (escolharemovefixo == 1){
                                pilha1.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 2) {
                                pilha2.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 3) {
                                pilha3.adiciona(valorRemovido);
                            }
                        }

                    } else if (escolharemover == 3){
                        if (pilha3.getTamanho() == 0){
                            pilha3.adiciona(valorRemovido);
                        } else if (pilha3.getUltimo() < valorRemovido) {
                            pilha3.adiciona(valorRemovido);
                        } else {
                            if (escolharemovefixo == 1){
                                pilha1.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 2) {
                                pilha2.adiciona(valorRemovido);
                            } else if (escolharemovefixo == 3) {
                                pilha3.adiciona(valorRemovido);
                            }
                        }
                    }

                    if ((pilha1.getTamanho() == tamanhopilha && isOrdenadaCrescente(pilha1)) ||
                            (pilha2.getTamanho() == tamanhopilha && isOrdenadaCrescente(pilha2)) ||
                            (pilha3.getTamanho() == tamanhopilha && isOrdenadaCrescente(pilha3))) {
                        System.out.println("Uma das pilhas atingiu o tamanho máximo e está ordenada de forma crescente. Ordenado em " +contadorMovimentos + " vezes");
                        break;
                    }
                }
            }

            if (escolha == 2) {

                if (ordem == 0){
                    PilhaEncadeada pilhaAux = new PilhaEncadeada();

                    while (pilha1.getTamanho() > 0) {
                        int elemento = pilha1.getUltimo();
                        pilha1.removeUltimo();

                        while (pilhaAux.getTamanho() > 0 && elemento > pilhaAux.getUltimo()) {
                            pilha1.adiciona(pilhaAux.getUltimo());
                            pilhaAux.removeUltimo();
                        }

                        pilhaAux.adiciona(elemento);
                    }

                    while (pilhaAux.getTamanho() > 0) {
                        pilha1.adiciona(pilhaAux.getUltimo());
                        pilhaAux.removeUltimo();
                    }
                } else{
                    PilhaEncadeada pilhaAux = new PilhaEncadeada();

                    while (pilha1.getTamanho() > 0) {
                        int elemento = pilha1.getUltimo();
                        pilha1.removeUltimo();


                        while (pilhaAux.getTamanho() > 0 && elemento < pilhaAux.getUltimo()) {
                            pilha1.adiciona(pilhaAux.getUltimo());
                            pilhaAux.removeUltimo();
                        }

                        pilhaAux.adiciona(elemento);
                    }

                    while (pilhaAux.getTamanho() > 0) {
                        pilha1.adiciona(pilhaAux.getUltimo());
                        pilhaAux.removeUltimo();
                    }
                }


                System.out.println("Resolvendo automaticamente a Torre de Hanoi...");
                resolverTorreHanoi(tamanhopilha, pilha1, pilha3, pilha2);

                System.out.println("Torre de Hanoi resolvida:");
                pilha1.imprimir();
                pilha2.imprimir();
                pilha3.imprimir();
                break;
            }
        }
    }
}