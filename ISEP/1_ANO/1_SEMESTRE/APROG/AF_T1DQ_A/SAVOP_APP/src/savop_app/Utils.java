/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop_app;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Daniel Goncalves <1151452@isep.ipp.pt>
 */
public class Utils {

    private final static Scanner ler = new Scanner(System.in);

    /**
     * Elimina espaços em branco antes e depois de cada String do vector.
     *
     * @param vetor vetor onde realizar o trim.
     */
    public void trimVector(String[] vetor) {

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = vetor[i].trim();
        }
    }

    /**
     * Criar opções de um menu atraves de um vector com opções.
     *
     * @param opcoes vetor com opções do menu.
     * @return Devolve a opção escolhida.
     */
    public int opcoesMenu(String[] opcoes) {

        System.out.println("\nMENU:\n");
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i + 1) + " -\t" + opcoes[i]);
        }
        System.out.println();
        System.out.println("Seleccione a sua opção:");

        int opcao = ler.nextInt();
        return opcao;
    }

    /**
     * Encontrar um string numa coluna de uma matriz, e indicar a sua posição.
     *
     * @param matriz matriz onde pretende procurar.
     * @param numEl numero de elementos da matriz.
     * @param string string que pretende procurar.
     * @param coluna coluna da matriz onde pretende pocurar.
     * @return posicao da string encontrada.
     */
    public int posicaoColuna(String[][] matriz, int numEl, String string, int coluna) {

        int posicao = -1;
        int i = 0;
        while ((posicao == -1) && (i < numEl)) {
            if (matriz[i][coluna].equalsIgnoreCase(string)) {
                posicao = i;
            }
            i++;
        }

        return posicao;
    }

    /**
     * Encontrar um string numa coluna de uma matriz, e indicar a sua posição.
     *
     * @param vetor vetor onde pretende procurar.
     * @param numEl numero de elementos do vetor.
     * @param string string que pretende procurar.
     * @return posicao da string encontrada.
     */
    public int posicaoVetor(String[] vetor, int numEl, String string) {

        int posicao = -1;
        int i = 0;
        while ((posicao == -1) && (i < numEl)) {
            if (vetor[i].equalsIgnoreCase(string)) {
                posicao = i;
            }
            i++;
        }

        return posicao;
    }

    /**
     * Ordenar por ordem alfanumérica crescente.
     *
     * @param vetor vetor que pretende ordenar.
     * @param numEl numero de elementos da matriz.
     */
    public void ordenarVetor(String[] vetor, int numEl) {

        for (int i = 0; i < numEl; i++) {
            for (int j = i; j < numEl; j++) {
                if (vetor[i].compareToIgnoreCase(vetor[j]) >= 0) {
                    String tmp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = tmp;
                }
            }
        }
    }

    public String primeiroUltimoNome(String nomeCompleto) {

        String[] nomes = nomeCompleto.split(" ");
        String nome = nomes[0] + " " + nomes[nomes.length - 1];

        return nome;
    }

    public int calculoIdade(String dataNascimento) {

        int idade;

        int ano = Integer.parseInt(dataNascimento.substring(0, 4));
        int mes = Integer.parseInt(dataNascimento.substring(4, 6));
        int dia = Integer.parseInt(dataNascimento.substring(6));

        Calendar hoje = Calendar.getInstance();
        int anoH = hoje.get(Calendar.YEAR);
        int mesH = hoje.get(Calendar.MONTH) + 1;
        int diaH = hoje.get(Calendar.DAY_OF_MONTH);

        idade = anoH - ano;
        if ((mesH < mes) || ((mesH == mes) && (diaH < dia))) {
            idade--;
        }

        return idade;
    }

    public float percentagem(float num, int total) {

        float percentagem;

        if (total != 0) {
            percentagem = num / total;
        } else {
            percentagem = 0;
        }

        return percentagem;
    }
}
