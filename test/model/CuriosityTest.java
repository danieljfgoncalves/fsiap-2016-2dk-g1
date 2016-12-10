/*
 * Package location for model tests concepts.
 */
package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of Curiosity class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class CuriosityTest {

    /**
     * The instance to be tested;
     */
    private Curiosity instance;

    @Before
    public void setUp() {
        instance = new Curiosity("Mecanismo básico de corte de laser (exemplo do laser de CO2):\n"
                + "1. Feixe de alta intensidade the luz vermelha é gerada pelo laser.\n"
                + "2. Este feixe é focado na superfície da peça de trabalho por meio de uma lente.\n"
                + "3. O feixe focado aquece o material numa zona muito específica geralmente menos que 0.5mm de diametro.\n"
                + "4. O material derretido é ejectado da área por um jato de gas pressurizado ao mesmo tempo de o feixe atua, na maioria dos casos o uso do gás aumenta a velocidade de corte atuando quimicamente como fisicamente.\n"
                + "5. Esta zona muito específica (zona específica de remoção de material) é deslocada da superfície do material gerando assim um corte.");
    }

    /**
     * Test of getCuriosityString method, of class Curiosity.
     */
    @Test
    public void testGetCuriosityString() {
        System.out.println("getCuriosityString");

        String expResult = "Mecanismo básico de corte de laser (exemplo do laser de CO2):\n"
                + "1. Feixe de alta intensidade the luz vermelha é gerada pelo laser.\n"
                + "2. Este feixe é focado na superfície da peça de trabalho por meio de uma lente.\n"
                + "3. O feixe focado aquece o material numa zona muito específica geralmente menos que 0.5mm de diametro.\n"
                + "4. O material derretido é ejectado da área por um jato de gas pressurizado ao mesmo tempo de o feixe atua, na maioria dos casos o uso do gás aumenta a velocidade de corte atuando quimicamente como fisicamente.\n"
                + "5. Esta zona muito específica (zona específica de remoção de material) é deslocada da superfície do material gerando assim um corte.";
        String result = instance.getCuriosityString();

        assertEquals(expResult, result);
    }

    /**
     * Test of setCuriosity method, of class Curiosity.
     */
    @Test
    public void testSetCuriosity() {
        System.out.println("setCuriosity");
        String curiosity_description = "\"Mas afinal o que é um laser? um laser é um aparelho que amplifica a luz para produzir um feixe intenso e fino de ondas. As suas propriedades dependem do material que emite luz, do sistema óptico e da forma como energizá-lo, a luz laser provem principalmente de uma transição determinada entre níveis de energia dos eletrões (ou seja eletrão do estado fundamental para o estado ‘excitado’ estimulando assim a emissão de fotões amplificando a emissão de feixes de luz de comprimento de onda definido e coerente). \n"
                + "\"Entretanto, para se compreender perfeitamente um laser, faz-se necessário o uso da mecânica .\"";

        instance.setCuriosity(curiosity_description);

        assertEquals(instance.getCuriosityString(), curiosity_description);
    }

    /**
     * Test of equals method, of class Curiosity.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Object otherObject = null;
        assertFalse(instance.equals(otherObject));

        otherObject = new Curiosity();
        assertFalse(instance.equals(otherObject));

        otherObject = new Curiosity("Mecanismo básico de corte de laser (exemplo do laser de CO2):\n"
                + "1. Feixe de alta intensidade the luz vermelha é gerada pelo laser.\n"
                + "2. Este feixe é focado na superfície da peça de trabalho por meio de uma lente.\n"
                + "3. O feixe focado aquece o material numa zona muito específica geralmente menos que 0.5mm de diametro.\n"
                + "4. O material derretido é ejectado da área por um jato de gas pressurizado ao mesmo tempo de o feixe atua, na maioria dos casos o uso do gás aumenta a velocidade de corte atuando quimicamente como fisicamente.\n"
                + "5. Esta zona muito específica (zona específica de remoção de material) é deslocada da superfície do material gerando assim um corte.");
        assertTrue(instance.equals(otherObject));
    }

}
