/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop_app;

import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author Daniel Goncalves <1151452@isep.ipp.pt>
 */
public class LogErros {

    private final static String FICHEIRO_LOG = "LogErros.txt";
    private Formatter escreverFicheiro;

    public void abrir() throws FileNotFoundException {

        escreverFicheiro = new Formatter(FICHEIRO_LOG);

    }

    public void escrever(String ficheiroLido, int numLinha, String linha, String msgErro) throws FileNotFoundException {

        escreverFicheiro.format("linha: %-5d || '%-30s'|| (ERRO: %-30s)|| Ficheiro: %-20s\n", numLinha, linha, msgErro, ficheiroLido);

    }
    
    public void fechar() {
        escreverFicheiro.close();
    }
}
