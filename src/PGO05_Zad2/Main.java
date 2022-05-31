package PGO05_Zad2;

public class Main {

    public static void main(String[] args) {
        var ethanol = new Alcohol("Ethanol", 10, 80, 94);
        var h2o2 = new Water("H2O2", 1, 3, true);
        var amethyst = new Crystal("Amethyst", 3, 24, 74);
        var aconite = new Flower("Aconite", 65, 666);

        System.out.println("\n=======");
        var instantDeathPoison = new Elixir("Instant Death Poison");

        instantDeathPoison.addIngredient(ethanol);
        instantDeathPoison.addIngredient(amethyst);
        instantDeathPoison.addIngredient(aconite);

        instantDeathPoison.create();

        var power = instantDeathPoison.getPower();
        System.out.println(instantDeathPoison.getName() + " : power = " + instantDeathPoison.getPower());

        instantDeathPoison.create();

        System.out.println("\n=======");
        var immortality = new Elixir("Immortality");
        var pentanol = new Alcohol("Pentanol",25, 75, 99);
        var bismuth = new Ore("Bismuth",70,128,true);
        var carrionFlower = new Flower("Carrion Flower",78,130);

        immortality.addIngredient(pentanol);
        immortality.addIngredient(bismuth);
        immortality.addIngredient(carrionFlower);
        immortality.create();
        power = immortality.getPower();
        System.out.println(immortality.getName() + " : power = " + immortality.getPower());


        System.out.println("\n=======");
        var healing = new Elixir("Healig elixir");
        healing.addIngredient(ethanol);
        healing.addIngredient(bismuth);
        healing.addIngredient(amethyst);
        healing.removeIngredient(amethyst);
        healing.setCatalyst(h2o2);
        healing.getPower();
        healing.create();
        healing.getPower();

        power = healing.getPower();
        System.out.println(healing.getName() + " : power = " + healing.getPower());

    }
}
