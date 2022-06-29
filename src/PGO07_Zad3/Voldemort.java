package PGO07_Zad3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Voldemort extends Character {
    private List<String> horcruxes;
    private Set<Character> targets;

    protected Voldemort(Riddle riddle) {
        super("Lord Voldemort", riddle.getLocation());

        Character.removeCharacter(riddle);

        this.horcruxes = new ArrayList<>();
        this.targets = new HashSet<>();
    }

    public void createHorcruxes(int number) {
        var current = horcruxes.size();
        for (int i = 0; i < number; i++) {
            var name = String.format("horcrux %d", i + current + 1);
            horcruxes.add(name);
        }

    }

    public void printHorcruxes() {
        System.out.println("Created horcruxes:");

        for (String h : this.horcruxes) {
            System.out.println(
                    String.format("\t %s", h));
        }
    }

    public void castSpell(Spell spell) {
        if (spell == Spell.AvadaKedavra) {
            for (var c : targets) {
                if (c.getName().equals("Harry")) {
                    this.die();
                    System.out.println(
                            String.format("%s goes LOL...", c.getName()));
                } else {
                    c.die();
                }

            }
        }
    }

    @Override
    public void moveTo(Location location) {
        if (location == Location.Hogwarts) {
            throw new StoryViolationException("You konw who can not go to Hogwarts!");
        }

        super.moveTo(location);
    }

    public void target(Character character) {
        Character.validateCharacter(character);
        this.targets.add(character);
    }
}
