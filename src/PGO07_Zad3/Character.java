package PGO07_Zad3;

import java.util.HashSet;
import java.util.Set;

abstract class Character {
    private static Set<Character> characters = new HashSet<>();

    private String name;
    private Location location;
    private int health;

    protected Character(String name, Location location) {
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Character must have name. Please provide it");
        }

        validateLocation(location);

        this.name = name;
        this.location = location;
        this.health = 100;

        joinToCharacters(this);
    }

    public static void MoveAllTo(Location location, Character ... characters) {
        validateLocation(location);

        if (characters == null) {
            throw new IllegalArgumentException("Provide characters to move");
        }

        for (Character c:characters) {
            c.moveTo(location);
        }
    }

    public static void doSth(String action, Character ... characters) {
        if (characters == null) {
            throw new IllegalArgumentException("Provide characters to act");
        }

        for (Character c:characters) {
            c.doSth(action);
        }
    }

    public static void status() {
        System.out.println("====Status====");
        for (var c:characters) {
            System.out.println(String.format("%s: %d", c.getName(), c.getHealth()));
        }
    }

    public void introduce() {
        System.out.println(
                String.format("Hello, I am %s",name));
    }

    public void moveTo(Location location){
        validateLocation(location);

        System.out.println(
                String.format("%s moves to %s",name, location));

        this.location = location;
    }

    public void moveTo(Orphanage orphanage) {
        if (orphanage == null) {
            throw new IllegalArgumentException("Character must have location. Please provide");
        }

        this.moveTo(orphanage.getLocation());
    }

    public void joinToCharacters(Character character) {
        validateCharacter(character);
        characters.add(character);
    }

    public static void removeCharacter(Character character) {
        validateCharacter(character);
        characters.remove(character);
    }

    public void say(String message, Character to) {
        if (message == null) {
            throw new IllegalArgumentException("Message can not be null");
        }

        if (to == null) {
            throw new IllegalArgumentException("You must provide interlocutor");
        }

        System.out.println(String.format("%s to %s", this.name, to.name));
        System.out.println(String.format("\t %s", message));
    }

    public void die() {
        this.health = 0;
        System.out.println(String.format("%s died", this.name));
    }

    public void doSth(String action) {
        System.out.println(String.format("I am %s, I am %s", this.name, action));
    }

    private static void validateLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Character must have location. Please provide");
        }
    }

    private static void validateCharacter(Character c) {
        if (c == null) {
            throw new IllegalArgumentException("Character must not be null");
        }
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public int getHealth() {
        return health;
    }

}
