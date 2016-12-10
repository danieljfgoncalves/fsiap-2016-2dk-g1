/*
 * Package location for Utils concepts.
 */
package utils;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import model.Curiosity;
import model.Gas;
import model.Material;
import model.Simulator;

/**
 * Create instances of model concepts.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class DefaultInstantiator {

    /**
     * Creates a simulator with default values.
     *
     * @return the simulator
     */
    public static Simulator createSimulator() {
        Set<Gas> gases = new TreeSet<>();
        gases.add(new Gas("Nd:YAG(fifth harmonic)", 213E-9, 213E-9));
        gases.add(new Gas("KrCl excimer", 222E-9, 222E-9));
        gases.add(new Gas("He-Ag", 224.3E-9, 224.3E-9));
        gases.add(new Gas("KrF", 248E-9, 248E-9));
        gases.add(new Gas("Ne-Cu", 248E-9, 270E-9));
        gases.add(new Gas("Nd:YAG(fourth harmonic)", 266E-9, 266E-9));
        gases.add(new Gas("He-Au", 282E-9, 292E-9));
        gases.add(new Gas("XeCl excimer", 308E-9, 308E-9));
        gases.add(new Gas("He-Cd", 325E-9, 325E-9));
        gases.add(new Gas("Ne+", 332E-9, 332E-9));
        gases.add(new Gas("Nitrogen", 337.1E-9, 337.1E-9));
        gases.add(new Gas("Ruby (doubled)", 347E-9, 347E-9));
        gases.add(new Gas("Ar2+", 351E-9, 351E-9));
        gases.add(new Gas("Nd:YAG(tripled)", 355E-9, 355E-9));
        gases.add(new Gas("Alexandrite(doubled)", 360E-9, 400E-9));
        gases.add(new Gas("Ti:sapphire(doubled)", 360E-9, 460E-9));
        gases.add(new Gas("InGaN", 370E-9, 493E-9));
        gases.add(new Gas("He-Cd", 441.6E-9, 441.6E-9));
        gases.add(new Gas("Ar+", 488E-9, 488E-9));
        gases.add(new Gas("Copper Vapor", 510.5E-9, 510.5E-9));
        gases.add(new Gas("Ar+", 514.5E-9, 514.5E-9));
        gases.add(new Gas("GaN", 515E-9, 520E-9));
        gases.add(new Gas("Xe3+", 539.5E-9, 539.5E-9));
        gases.add(new Gas("He-Ne", 543.5E-9, 543.5E-9));
        gases.add(new Gas("Copper Vapor", 578.2E-9, 578.2E-9));
        gases.add(new Gas("He-Ne", 594.1E-9, 594.1E-9));
        gases.add(new Gas("He-Ne", 611.9E-9, 611.9E-9));
        gases.add(new Gas("He-Ne", 632.8E-9, 632.8E-9));
        gases.add(new Gas("Gold Vapor", 628E-9, 628E-9));
        gases.add(new Gas("Kr+", 647.1E-9, 647.1E-9));
        gases.add(new Gas("InGaAIP", 630E-9, 685E-9));
        gases.add(new Gas("Ruby", 694.3E-9, 694.3E-9));
        gases.add(new Gas("Alexandrite", 700E-9, 800E-9));
        gases.add(new Gas("GaAIAs", 750E-9, 850E-9));
        gases.add(new Gas("Cr-fluoride", 780E-9, 850E-9));
        gases.add(new Gas("Ti-sapphire", 670E-9, 1130E-9));
        gases.add(new Gas("InGaAs", 904E-9, 1065E-9));
        gases.add(new Gas("Nd:YAG", 946E-9, 946E-9));
        gases.add(new Gas("He-Ne", 1152E-9, 1152E-9));
        gases.add(new Gas("InGaAs", 1270E-9, 1330E-9));
        gases.add(new Gas("InGaAs", 1430E-9, 1570E-9));
        gases.add(new Gas("Fosterite", 1130E-9, 1360E-9));
        gases.add(new Gas("Iodine", 1315E-9, 1315E-9));
        gases.add(new Gas("He-Ne", 1523E-9, 1523E-9));
        gases.add(new Gas("AlGaIn", 1870E-9, 2200E-9));
        gases.add(new Gas("Xe-He", 2000E-9, 4000E-9));
        gases.add(new Gas("Er:YAG", 2900E-9, 2900E-9));
        gases.add(new Gas("Er:YAG", 2940E-9, 2940E-9));
        gases.add(new Gas("He-Ne", 3391E-9, 3391E-9));
        gases.add(new Gas("CO2 (doubled)", 4600E-9, 5800E-9));
        gases.add(new Gas("CO", 5000E-9, 7000E-9));
        gases.add(new Gas("CO2", 9200E-9, 11400E-9));
        gases.add(new Gas("Pb salts", 3300E-9, 27000E-9));

        Set<Material> materials = new TreeSet<>();
        materials.add(new Material("Aluminium", 398000.0, 910.0, 2712.0, 2467.0, 660.0, true));
        materials.add(new Material("Copper", 205000.0, 390.0, 8940.0, 2575.0, 1084.0, true));
        materials.add(new Material("Gold", 63000.0, 130.0, 19320.0, 2800.0, 1063.0, true));
        materials.add(new Material("Nickel", 297000.0, 440.0, 8908.0, 2800.0, 1453.0, true));
        materials.add(new Material("Silver", 111000.0, 230.0, 10490.0, 2212.0, 961.0, true));
        materials.add(new Material("Iron", 272000.0, 450.0, 7850.0, 2870.0, 1149.0, true));
        materials.add(new Material("Zinc", 113000.0, 390.0, 7135.0, 910.0, 419.5, true));
        materials.add(new Material("Graphit", 5.95303E7, 7.20000E2, 2.23000E3, 4200.0, null, false));

        Set<Curiosity> curiosities = new HashSet<>();
        curiosities.add(new Curiosity("É impressionante  como tantos tipos de laser e tantos comprimentos de onda de laser foram descobertos."
                + " Estes cobrem essencialmente quase todo tipo de material, desde eletrões, gases, liquidos e sólidos.\n"
                + "Há decadas atrás, cientistas estavam a tentar como criar um laser... hoje em dia alguns tipos de laser até são fáceis de se construir.\n"
                + "Felizmente os lasers despoletaram  a imaginação de muitas pessoas inteligentes, levando a que se criassem diversas aplicabilidades para os lasers dentro das quais cirurgias médicas, cortar materiais industriais, pesquisa científica, etc..\n"));
        curiosities.add(new Curiosity("\"Mas afinal o que é um laser? um laser é um aparelho que amplifica a luz para produzir um feixe intenso e fino de ondas. As suas propriedades dependem do material que emite luz, do sistema óptico e da forma como energizá-lo, a luz laser provem principalmente de uma transição determinada entre níveis de energia dos eletrões (ou seja eletrão do estado fundamental para o estado ‘excitado’ estimulando assim a emissão de fotões amplificando a emissão de feixes de luz de comprimento de onda definido e coerente). \n"
                + "\"Entretanto, para se compreender perfeitamente um laser, faz-se necessário o uso da mecânica .\""));
        curiosities.add(new Curiosity("Será que um laser de 200 tetrawatts poderia destruir os asteróides que ameaçam a Terra?\n"
                + "Um raio laser com capacidade de 202 terawatts poderia destruir um asteróide de 7,5 km de diâmetro, como o que causou a extinção dos dinossauros há 65 milhões de anos. \n"
                + "Atualmente não se tem sido capaz construir um dispositivo laser dessa potência, o que põe em dúvida as teorias destes projetos de \"defesa contra asteróides \", disse uma equipa de físicos britânicos num artigo publicado na revista \"Journal of Physics Special Topics\". \n"
                + "Astrónomos de países como a Rússia e dos EUA recentemente consideraram a possibilidade de a Terra colidir com um dos grandes asteróides ou cometas que passam relativamente próximos à órbita do nosso planeta. \n"
                + "Teorias originais estão sendo consideradas incluíndo um sistema de defesa com base na instalação de armas nucleares ou lasers de alta potência, localizadas em plataformas orbitais . \n"
                + "Um grupo de físicos britânicos liderados por Henry Simms, da Universidade de Leicester, calculou a potência para destruir um asteróide como o que eliminou os dinossauros, deixando uma cratera de 180 milhas no Golfo do México, conhecida como Chicxulub . \n"
                + "De acordo com Simms e seus colegas, um feixe que possa afectar o campo do asteróides de várias formas. Em primeiro lugar, um fluxo de luz derretia e vaporizava o objeto rochoso, criando uma espécie de impulso de propulsão. Em segundo lugar, o feixe teria a sua própria pressão de  \"arrastar\" o asteróide na direcção do seu próprio movimento. \n"
                + "Considerando estes fatores, os autores calcularam ser necessário uma capacidade mínima de 202 tetrawatts por metro quadrado para desviar um asteróide de 4,42 biliões de toneladas, a fim de evitar a colisão com a Terra, que está fora do alcance das atuais tecnologias terrestres. \n"
                + "Esta conclusão põe em causa a viabilidade de muitas iniciativas para proteger a Terra de asteróides com satélites armados de raios lasers. No entanto, do ponto de vista técnico da construção do tal laser é possível, se os cientistas conseguirem criar uma fonte de energia capaz de gerar a quantidade necessária de energia para \"carregar\" um poderoso raio laser. "));
        curiosities.add(new Curiosity("Mecanismo básico de corte de laser (exemplo do laser de CO2):\n"
                + "1. Feixe de alta intensidade the luz vermelha é gerada pelo laser.\n"
                + "2. Este feixe é focado na superfície da peça de trabalho por meio de uma lente.\n"
                + "3. O feixe focado aquece o material numa zona muito específica geralmente menos que 0.5mm de diametro.\n"
                + "4. O material derretido é ejectado da área por um jato de gas pressurizado ao mesmo tempo de o feixe atua, na maioria dos casos o uso do gás aumenta a velocidade de corte atuando quimicamente como fisicamente.\n"
                + "5. Esta zona muito específica (zona específica de remoção de material) é deslocada da superfície do material gerando assim um corte."));
         curiosities.add(new Curiosity("Exemplos de aplicações do laser:\n"
                + "1. Médicas – O feixe altamente colimado de um laser pode ser mais focado para um ponto microscópico de densidade de energia extremamente alta. Isso o torna útil como um instrumento de corte e cauterização. Os lasers são usados para a fotocoagulação da retina para interromper a hemorragia da retina e para a aderência das lágrimas da retina. Os lasers de maior potência são usados após a cirurgia de catarata se a membrana de suporte que envolve a lente implantada se torna leitosa. Um laser focado pode atuar como um bisturi extremamente afiado para a cirurgia delicada, cauterizando como corta. (\"Cauterização\" refere-se a práticas médicas de uso de um instrumento quente ou uma sonda elétrica de alta frequência para “queimar” o tecido ao redor de uma incisão, selando minúsculos vasos sanguíneos para parar a hemorrogia.) A acção cauterizante é particularmente importante para procedimentos cirúrgicos em tecidos que são muito irrigados, como o fígado.\n"
                + "2. Soldagem e Corte - A indústria automobilística faz uso extensivo de lasers de dióxido de carbono com potências de até vários quilowatts para soldagem controlada por computador em linhas de montagem automotiva.\n"
                + "3. Reconhecimento – Os lasers de hélio-néon e semicondutores tornaram-se peças padrão do equipamento do topógrafo de campo. Um pulso laser rápido é enviado para um refletor de canto no ponto a ser medido e o tempo de reflexão é medido para obter a distância.\n"
                + "Alguns desses levantamentos são de longa distância! Os astronautas Apollo 11 e Apollo 14 colocaram refletores de canto na superfície da Lua para determinação da distância Terra-Lua.\n"
                + "4. Comunicação – Os cabos de fibra óptica são um importante modo de comunicação em parte porque vários sinais podem ser enviados com alta qualidade e baixa perda de propagação de luz ao longo das fibras. Os lasers têm vantagens significativas porque são mais monocromáticos e isso permite que a forma do pulso seja mantida melhor em longas distâncias. Se uma forma de pulso melhor pode ser mantida, então a comunicação pode ser enviada a taxas mais elevadas sem sobreposição dos pulsos."));
       
        return new Simulator(materials, gases, curiosities);
    }
}
