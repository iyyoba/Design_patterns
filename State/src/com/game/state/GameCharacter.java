package com.game.state;

class GameCharacter {

    private String name;
    private int experience;
    private int health;
    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState();
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public CharacterState getState() {
        return state;
    }

    public void addExperience(int xp) {
        experience += xp;
        checkLevelUp();
    }

    public void addHealth(int hp) {
        health += hp;
    }

    public void reduceHealth(int hp) {
        health -= hp;
        if (health < 0) health = 0;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }

    private void checkLevelUp() {
        if (experience >= 500 && !(state instanceof MasterState)) {
            setState(new MasterState());
            System.out.println("🎉 You have reached MASTER level!");
        }
        else if (experience >= 250 && !(state instanceof ExpertState)) {
            setState(new ExpertState());
            System.out.println("🔥 You advanced to EXPERT level!");
        }
        else if (experience >= 100 && !(state instanceof IntermediateState)) {
            setState(new IntermediateState());
            System.out.println("⭐ You advanced to INTERMEDIATE level!");
        }
    }

    public void displayStatus() {
        System.out.println("\n==============================");
        System.out.println("Name: " + name);
        System.out.println("Level: " + state.getName());
        System.out.println("XP: " + experience);
        System.out.println("HP: " + health);
        System.out.println("==============================");
    }
}
