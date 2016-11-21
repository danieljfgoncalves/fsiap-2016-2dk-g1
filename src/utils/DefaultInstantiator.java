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
        curiosities.add(new Curiosity("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce maximus felis eget metus dapibus porta. Nam vel dictum diam, a finibus mi. Donec at rhoncus tellus. Suspendisse potenti. Praesent accumsan faucibus ante non tristique. Cras sed urna ac eros laoreet varius sagittis quis lorem. Integer non felis massa."));
        curiosities.add(new Curiosity("Pellentesque eu ullamcorper ex. Vestibulum quam lectus, tincidunt at felis et, fermentum tristique nisl. Proin mollis aliquam posuere. Proin pretium sit amet neque eu finibus. Aliquam a arcu varius, vehicula mauris eget, suscipit sapien. Aenean porta arcu quis tincidunt pellentesque. Nulla facilisi. Donec egestas imperdiet eros, non posuere erat ornare quis."));
        curiosities.add(new Curiosity("Curabitur vel imperdiet nibh. Integer gravida purus quis sapien fringilla, quis semper lorem varius. Mauris velit est, cursus at eros quis, fermentum sollicitudin augue. Nam finibus nisl turpis, ut finibus mauris aliquam id. Etiam eleifend dictum tellus, at varius arcu interdum eget."));
        curiosities.add(new Curiosity("Vivamus pharetra consectetur scelerisque. Ut tristique mi et tincidunt mattis. Sed justo nibh, venenatis nec cursus et, faucibus eu nisi. Vivamus efficitur rhoncus nunc, sit amet rutrum nulla placerat ut. Fusce pulvinar metus vel erat hendrerit lobortis. Nam interdum, tortor vel dignissim ultricies, enim ipsum elementum nisi, tincidunt condimentum lectus eros in dui."));
        curiosities.add(new Curiosity("Pellentesque viverra luctus erat vitae vulputate. Nulla pretium viverra sem a dapibus. Maecenas elit arcu, posuere eget tortor quis, suscipit efficitur nibh. Sed congue, lectus quis rutrum sollicitudin, eros nisl fringilla massa, non imperdiet elit sapien vitae tellus."));

        return new Simulator(materials, gases, curiosities);
    }
}
