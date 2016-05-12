/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop_app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Daniel Goncalves <1151452@isep.ipp.pt> 
 * Francisco Pinelas <1140439@isep.ipp.pt>
 */
public class SAVOP_APP {

    // Constantes
    private final static int MAX_DEP = 230;
    private final static int NUM_CAMPOS = 4;
    private final static String FICHEIRO_DEP = "Deputados.txt";
    private final static int MAX_LINHAS_PAG = 5;
    private final static Scanner ler = new Scanner(System.in);
    private final static Utils utils = new Utils();
    private final static LogErros logErros = new LogErros();
    private final static String[] FAIXAS_ETARIAS = {"< 35 anos", "entre 35 e 60", "> 60 anos"};

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

        // Variáveis
        String[][] deputados = new String[MAX_DEP][NUM_CAMPOS];
        char[] votos = new char[MAX_DEP];
        int numDep = 0;

        // Menu Principal
        menuPrincipal(deputados, numDep, votos);
    }

    private static void menuPrincipal(String[][] deputados, int numDep, char[] votos) throws FileNotFoundException {

        // Lista de opções
        String[] opcoesMenuP = {
            "Ler ficheiro Deputados.",
            "Visualizar Deputados.",
            "Alterar info de Deputado.",
            "Ler votações.", //  pedir nome de ficheiro
            "Visualizar Deputados e Votos por ordem alfabética.",
            "Ver resultados das votações por Partido.",
            "Ver resultados das votações por Faixa Etária.",
            "Criar página HTML.",
            "Terminar."
        };

        int opcao;
        String assunto = "";

        do {

            // Escolher opção
            opcao = utils.opcoesMenu(opcoesMenuP);

            switch (opcao) {
                case 1:
                    numDep = lerDeputados(deputados, FICHEIRO_DEP);
                    break;
                case 2:
                    if (numDep > 0) {

                        listarMatriz(deputados, numDep);

                    } else {
                        System.out.println("Ler ficheiro de deputados primeiro.");
                    }
                    break;
                case 3:
                    if (numDep > 0) {
                        // Menu alterar Info de um deputado
                        System.out.println("Introduza o código do deputado a modificar:");
                        String id = ler.next();
                        boolean depEncontrado = menuAlterarInfo(deputados, numDep, id);
                        while (!depEncontrado) {
                            System.out.println("Introduza, novamente, o código do deputado a modificar:");
                            id = ler.next();
                            depEncontrado = menuAlterarInfo(deputados, numDep, id);
                        }
                    } else {
                        System.out.println("Ler ficheiro de deputados primeiro.");
                    }
                    break;
                case 4:
                    if (numDep > 0) {
                        assunto = lerVotacoes(votos, numDep, deputados);
                    } else {
                        System.out.println("Ler ficheiro de deputados primeiro.");
                    }
                    break;
                case 5:
                    if (!assunto.equalsIgnoreCase("")) {
                        visualizarDepsVotos(deputados, votos, numDep);
                    } else {
                        System.out.println("Ler ficheiro de votos e deputados primeiro.");
                    }
                    break;
                case 6:
                    if (!assunto.equalsIgnoreCase("")) {
                        String[] partidos = new String[numDep];
                        resultadosPorPartido(deputados, numDep, partidos, votos, assunto);
                    } else {
                        System.out.println("Ler ficheiro de votos e deputados primeiro.");
                    }
                    break;
                case 7:
                    if (!assunto.equalsIgnoreCase("")) {
                        resultadosPorFaixaEtaria(deputados, numDep, votos, assunto);
                    } else {
                        System.out.println("Ler ficheiro de votos e deputados primeiro.");
                    }
                    break;
                case 8:
                    if (!assunto.equalsIgnoreCase("")) {
                        criarpaginaHTML(assunto);
                    } else {
                        System.out.println("Ler ficheiro de votos e deputados primeiro.");
                    }
                    break;
                case 9:
                    System.out.println("Adeus!");
                    break;
                default:
                    System.out.println("\nCódigo inválido!\nIntroduza uma das opções disponíveis.\n");
                    break;

            }

        } while (opcao != 9);
    }

    /**
     * ler Deputados de um ficheiro e guardar numa matriz.
     *
     * @param deputados matriz onde guardar a informação dos deputados.
     * @param ficheiro
     * @return Devolve o numero de Deputados adicionados.
     * @throws FileNotFoundException
     */
    private static int lerDeputados(String[][] deputados, String ficheiro) throws FileNotFoundException {

        int numDep = 0;
        int numErros = 0;

        try (Scanner lerFicheiro = new Scanner(new File(ficheiro), "UTF-8")) {
//            LogErros logErros = new LogErros();
            logErros.abrir();

            do {
                String linha = lerFicheiro.nextLine();
                if (linha.length() > 0) {

                    String[] colunas = linha.split(";");
                    if (colunas.length == NUM_CAMPOS) {

                        utils.trimVector(colunas);
                        if (colunas[0].length() == 5) {

                            deputados[numDep] = colunas;
                            numDep++;
                        } else {

                            logErros.escrever(ficheiro, (numDep + 1), linha, "id de deputado inválido.");
                            numErros++;
                        }
                    } else {

                        logErros.escrever(ficheiro, (numDep + 1), linha, "Número de colunas inválido.");
                        numErros++;
                    }
                }
            } while (lerFicheiro.hasNextLine() && numDep < deputados.length);
//            logErros.fechar();
        }

        if (numErros != 0 && numDep > 0) {
            System.out.printf("Lido com sucesso %d Deputados mas com %d linha(s) incorrecta(s) (Verificar LogErros).\n\n", numDep, numErros);
        } else {
            System.out.println("Lido com sucesso!\n");
        }

        return numDep;
    }

    /**
     * Listar na Console a Matriz com paginação.
     *
     * @param matriz
     * @param numLinhas número de linhas da matriz que pretende listar (0-x).
     */
    private static void listarMatriz(String[][] matriz, int numLinhas) {

        int contPaginas = 0;
        for (int i = 0; i < numLinhas; i++) {
            if (i % MAX_LINHAS_PAG == 0) {
                if (contPaginas > 0) {
                    if (pausa().equalsIgnoreCase("c")) {
                        break;
                    }
                }
                contPaginas++;
                cabecalho(contPaginas, numLinhas);
            }
            System.out.printf("%-6s||%-30s||%-10s||%-12s%n", matriz[i][0], matriz[i][1], matriz[i][2], matriz[i][3]);
        }
        System.out.println("-----------------------------------------------");
    }

    private static void cabecalho(int pagina, int numLinhas) {

        int totalPag;
        if (numLinhas % MAX_LINHAS_PAG == 0) {
            totalPag = numLinhas / MAX_LINHAS_PAG;
        } else {
            totalPag = numLinhas / MAX_LINHAS_PAG + 1;
        }

        System.out.println("PÁG: " + pagina + " DE " + totalPag);
        System.out.printf("%-6s||%-30s||%-10s||%-12s%n", "ID", "NOME",
                "PARTIDO", "DATA NASC");
        System.out.println("==============================================================");
    }

    private static String pausa() {

        ler.useDelimiter("\n");

        System.out.println("\n\nPara continuar digite ENTER ou digite C depois ENTER para continuar programa.");
        return ler.nextLine();
    }

    /**
     * Alterar info de um deputado.
     *
     * @param deputados
     * @param linha
     * @param coluna
     */
    private static void alterarInfo(String[][] deputados, int linha, int coluna) {

        switch (coluna) {
            case 0:
                System.out.println("Introduza um novo código (max. 5char).");
                break;
            case 1:
                System.out.println("Introduza um novo nome (max. 30char).");
                break;
            case 2:
                System.out.println("Introduza um novo partido (max. 10char).");
                break;
            case 3:
                System.out.println("Introduza uma nova data de nascimento (formato ex: 19991031).");
        }
        ler.useDelimiter("\n");
        deputados[linha][coluna] = ler.next();
    }

    /**
     * Menu para alterar info de um deputado
     *
     * @param deputados
     * @param numDep
     */
    private static boolean menuAlterarInfo(String[][] deputados, int numDep, String id) {

        int opcao;
        int indiceDep = utils.posicaoColuna(deputados, numDep, id, 0);
        boolean idEncontrado = true;

        if (indiceDep > -1) {

            do {

                // Visulizar Deputado em questão
                System.out.printf("\nDeputado:\n%-6s||%-30s||%-10s||%-12s%n", deputados[indiceDep][0], deputados[indiceDep][1], deputados[indiceDep][2], deputados[indiceDep][3]);

                String[] opcoes = {
                    "Mudar o código de identificação",
                    "Mudar o nome do deputado",
                    "Mudar o partido do deputado",
                    "Mudar a data de nascimento do deputado",
                    "Sair"};

                opcao = utils.opcoesMenu(opcoes);

                switch (opcao) {
                    case 1:
                        alterarInfo(deputados, indiceDep, 0);
                        break;
                    case 2:
                        alterarInfo(deputados, indiceDep, 1);
                        break;
                    case 3:
                        alterarInfo(deputados, indiceDep, 2);
                        break;
                    case 4:
                        alterarInfo(deputados, indiceDep, 3);
                        break;
                    case 5:
                        System.out.println("\nFIM");
                        break;
                    default:
                        System.out.println("\nCódigo inválido!\nIntroduza uma das opções disponíveis.\n");
                        break;

                }
            } while (opcao != 5);

        } else {
            System.out.println("Deputado não encontrado\n");
            idEncontrado = false;
        }

        return idEncontrado;
    }

    private static String lerVotacoes(char[] votos, int numDep, String[][] deputados) throws FileNotFoundException {

        // Perguntar pelo nome de ficheiro
        System.out.println("Qual o ficheiro de votos que pretende ler?");
        String assunto = ler.next();

        String ficheiro = assunto + ".txt";

        for (int i = 0; i < numDep; i++) {
            votos[i] = 'F';
        }

        int numErros = 0;
        int numVot = 0;

        try (Scanner lerFicheiro = new Scanner(new File(ficheiro), "UTF-8")) {
//            LogErros logErros = new LogErros();
//            logErros.abrir();

            int indiceDep;
            int numLinha = 0;
            do {

                String linha = lerFicheiro.nextLine();
                numLinha++;
                if (linha.length() > 0) {
                    if (linha.length() == 6) {

                        indiceDep = utils.posicaoColuna(deputados, numDep, linha.substring(0, 5), 0);
                        if (indiceDep != -1) {
                            votos[indiceDep] = linha.charAt(5); // Verificar maiusculas!!
                            numVot++;
                        } else {
                            logErros.escrever(ficheiro, numLinha, linha, "Votação não corresponde a nenhum deputado na lista.");
                            numErros++;
                        }
                    } else {
                        logErros.escrever(ficheiro, numLinha, linha, "Codigo de votação inválido!");
                        numErros++;
                    }
                }
            } while (lerFicheiro.hasNextLine() && numVot < numDep);
            logErros.fechar();
        }

        if (numErros > 0 && numVot > 0) {
            System.out.printf("Lido com sucesso %d Votacão(ões) mas com %d linha(s) incorrecta(s) (Verificar LogErros).\n\n", numDep, numErros);
        } else {
            System.out.println("Lido com sucesso!\n");
        }

        return assunto;
    }

    private static void ordenarDepsVotos(String[][] matriz, char[] votos, int numEl, int coluna) {

        for (int i = 0; i < numEl; i++) {
            for (int j = i; j < numEl; j++) {
                if (matriz[i][coluna].compareToIgnoreCase(matriz[j][coluna]) >= 0) {
                    String[] tmpDeps = matriz[i];
                    char tmpVoto = votos[i];
                    matriz[i] = matriz[j];
                    votos[i] = votos[j];
                    matriz[j] = tmpDeps;
                    votos[j] = tmpVoto;
                }
            }
        }
    }

    private static void listarDepsVotos(String[][] deputados, char[] votos, int numLinhas) {

        int contPaginas = 0;
        for (int i = 0; i < numLinhas; i++) {
            if (i % MAX_LINHAS_PAG == 0) {
                if (contPaginas > 0) {
                    if (pausa().equalsIgnoreCase("c")) {
                        break;
                    }
                }
                contPaginas++;
                cabecalhoDepsVotos(contPaginas, numLinhas);
            }
            System.out.printf("%-6s||%-30s||%-10s||%-1s%n", deputados[i][0], utils.primeiroUltimoNome(deputados[i][1]), deputados[i][2], votos[i]);
        }
        System.out.println("-----------------------------------------------");
    }

    private static void cabecalhoDepsVotos(int pagina, int numLinhas) {

        int totalPag;
        if (numLinhas % MAX_LINHAS_PAG == 0) {
            totalPag = numLinhas / MAX_LINHAS_PAG;
        } else {
            totalPag = numLinhas / MAX_LINHAS_PAG + 1;
        }

        System.out.println("PÁG: " + pagina + " DE " + totalPag);
        System.out.printf("%-6s||%-30s||%-10s||%-1s%n", "ID", "NOME",
                "PARTIDO", "VOTO");
        System.out.println("===========================================================");
    }

    private static void visualizarDepsVotos(String[][] deputados, char[] votos, int numEl) {

        ordenarDepsVotos(deputados, votos, numEl, 0);
        listarDepsVotos(deputados, votos, numEl);
    }

    private static int posicaoVoto(char voto) {

        int posicao = -1;

        switch (voto) {
            case 'S':
                posicao = 1;
                break;
            case 'N':
                posicao = 2;
                break;
            case 'A':
                posicao = 3;
                break;
            default:
                posicao = 4;
                break;
        }
        return posicao;
    }

    private static int vetorPartidos(String[][] deputados, int numDep, String[] partidos) {

        int numPartidos = 0;

        int indicePartido;
        for (int i = 0; i < numDep; i++) {

            indicePartido = utils.posicaoVetor(partidos, numPartidos, deputados[i][2]);
            if (indicePartido == -1) {
                partidos[numPartidos] = deputados[i][2];
                numPartidos++;

            }
        }

        utils.ordenarVetor(partidos, numPartidos);

        return numPartidos;
    }

    private static void ordenarResultados(String[] partidos, int[][] resultados, int numPartidos, int coluna) {

        for (int i = 0; i < numPartidos; i++) {
            for (int j = i; j < numPartidos; j++) {
                if (resultados[i][coluna] < resultados[j][coluna]) {
                    int[] tmpRes = resultados[i];
                    String tmpPartido = partidos[i];
                    resultados[i] = resultados[j];
                    partidos[i] = partidos[j];
                    resultados[j] = tmpRes;
                    partidos[j] = tmpPartido;
                }
            }
        }
    }

    private static void escreverResultados(String ficheiro, String[] partidos, int[][] resultados, int[] totais, int numPartidos) throws FileNotFoundException {

        try (Formatter escreverFicheiro = new Formatter("Resultados_" + ficheiro + ".txt")) {

            escreverFicheiro.format("\nVotação de: " + ficheiro + "\n\n");

            for (int i = 0; i < numPartidos; i++) {
                escreverFicheiro.format("%-10s;nDep: %d;Votos a favor: %d;Votos contra: %d;Abstenções: %d;Faltou: %d\n", partidos[i], resultados[i][0], resultados[i][1], resultados[i][2], resultados[i][3], resultados[i][4]);
            }

            escreverFicheiro.format("\n%-10s;nDep: %d;Votos a favor: %d;Votos contra: %d;Abstenções: %d;Faltou: %d\n", "Totais", totais[0], totais[1], totais[2], totais[3], totais[4]);

        }
    }

    private static void resultadosPorPartido(String[][] deputados, int numDep, String[] partidos, char[] votos, String assunto) throws FileNotFoundException {

        int numPartidos = vetorPartidos(deputados, numDep, partidos);

        int[][] resultados = new int[numPartidos][5];
        int[] totais = new int[5];
        totais[0] = numDep;

        int linha;
        int coluna;

        for (int i = 0; i < numDep; i++) {
            linha = utils.posicaoVetor(partidos, numDep, deputados[i][2]);
            coluna = posicaoVoto(votos[i]);
            resultados[linha][coluna]++;
            resultados[linha][0]++;

            totais[coluna]++;
        }

        ordenarResultados(partidos, resultados, numPartidos, 0);

        System.out.println("\nVotação de: " + assunto + "\n");

        for (int i = 0; i < numPartidos; i++) {
            System.out.printf("%-10s || nDep: %d || Votos a favor: %d | Votos contra: %d | Abstenções: %d | Faltou: %d\n", partidos[i], resultados[i][0], resultados[i][1], resultados[i][2], resultados[i][3], resultados[i][4]);
        }

        System.out.printf("\n%-10s || nDep: %d || Votos a favor: %d | Votos contra: %d | Abstenções: %d | Faltou: %d\n", "Totais", totais[0], totais[1], totais[2], totais[3], totais[4]);

        escreverResultados(assunto, partidos, resultados, totais, numPartidos);
    }

    private static int posicaoFaixaEtaria(int idade) {

        int posicao = 0;

        if ((idade >= 35) && (idade <= 60)) {
            posicao = 1;
        } else if (idade > 60) {
            posicao = 2;
        }

        return posicao;
    }
    
    private static void resultadosPorFaixaEtaria(String[][] deputados, int numDep, char[] votos, String assunto) {

        float[][] resultados = new float[FAIXAS_ETARIAS.length][4];

        int linha;
        int coluna;
        
        int[] totais = new int[FAIXAS_ETARIAS.length];
        
        for (int i = 0; i < numDep; i++) {
            linha = posicaoFaixaEtaria(utils.calculoIdade(deputados[i][3]));
            coluna = posicaoVoto(votos[i]) - 1;
            resultados[linha][coluna]++;
            totais[linha]++;
        }

        System.out.println("\nVotação de: " + assunto + "\n");
        
        for (int i = 0; i < resultados.length; i++) {
            System.out.printf("%-15s || Votos a favor: %.2f | Votos contra: %.2f | Abstenções: %.2f | Faltou: %.2f\n",
                    FAIXAS_ETARIAS[i],
                    utils.percentagem(resultados[i][0], totais[i]),
                    utils.percentagem(resultados[i][1], totais[i]),
                    utils.percentagem(resultados[i][2], totais[i]),
                    utils.percentagem(resultados[i][3], totais[i]));
        }
    }

    public static void criarpaginaHTML(String assunto) throws FileNotFoundException {

        if (assunto == null) {
            System.out.println("Introduza um assunto válido.");
            return;
        }
        File fileResultados = new File("Resultados_" + assunto + ".txt");
        if (!fileResultados.exists()) {
            System.out.println("O ficheiro não existe");
            return;
        }

        try (Scanner lerFicheiro = new Scanner(fileResultados)) {
            try (Formatter html = new Formatter(new File("Pagina.html"))) {

                PaginaHTML.iniciarPagina(html, assunto);
                int nLinha = 0;
                String linha;
                String[][] conteudoTabela = new String[MAX_DEP][6];
                int nLinhaTabela = 0;
                while (lerFicheiro.hasNextLine()) {
                    linha = lerFicheiro.nextLine();
                    if (!linha.isEmpty()) {
                        if (nLinha == 0) {
                            nLinha++;
                            PaginaHTML.cabecalho(html, nLinha, linha);
                        } else {
                            String[] temp = linha.split(";");
                            for (int i = 0; i < temp.length; i++) {
                                conteudoTabela[nLinhaTabela][i] = temp[i];
                            }
                            nLinhaTabela++;
                        }
                    }
                }
                PaginaHTML.criarTabelaSemLinhaTitulos(html, conteudoTabela, nLinhaTabela);
                PaginaHTML.fecharPaginaComData(html);
            }
            System.out.println("Pagina HTML criada com sucesso!");
        }
    }

}
