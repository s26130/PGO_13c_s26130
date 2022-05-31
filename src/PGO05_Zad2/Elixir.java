package PGO05_Zad2;

import java.util.ArrayList;
import java.util.List;

class Elixir {
    private String name;
    private boolean isCreated;
    private int power;
    private Liquid catalyst;
    private List<Ingredient> ingredients = new ArrayList<>();

    Elixir(String name) {
        this.name = name;
    }

    void addIngredient(Ingredient i) {
        if (i == null) {
            System.out.println("You can not add null ingredient!");
            return;
        }
        if (this.isCreated) {
            System.out.println("You can not add more ingredients. Elixir has been made");
        }
        {
            System.out.println("Adding " + i.name + " to " + this.name);
            this.ingredients.add(i);
        }
    }

    void removeIngredient(Ingredient i) {
        if (i == null) {
            System.out.println("You can not add null ingredient!");
            return;
        }
        if (this.isCreated) {
            System.out.println("You can not remove an ingredient. Elixir has been made");
        }
        {
            System.out.println("Removing " + i.name + " from " + this.name);
            this.ingredients.remove(i);
        }
    }

    void create() {
        if (this.isCreated) {
            System.out.println("You can not create this elixir another time!");
            return;
        }

        this.isCreated = true;

        for (Ingredient i :ingredients) {
            power += i.getReagent();
        }

        if (catalyst != null && catalyst.getReagent() != 0) {
            power = power / catalyst.getReagent();
        }
    }

    int getPower() {
        if (!this.isCreated) {
            System.out.println("You must create an elixir first");
            return 0;
        } else {
            return power;
        }
    }

    public void setCatalyst(Liquid catalyst) {
        if (catalyst == null) {
            System.out.println("You can not add null catalyst!");
            return;
        }
        if (this.isCreated) {
            System.out.println("You can not change a catalyst anymore");
        } else {
            this.catalyst = catalyst;
        }
    }

    public String getName() {
        return name;
    }
}

