package com.game.state;

class ExpertState implements CharacterState {

    public void train(GameCharacter character) {
        System.out.println("Expert training... +40 XP");
        character.addExperience(40);
    }

    public void meditate(GameCharacter character) {
        System.out.println("Deep meditation... +30 HP");
        character.addHealth(30);
    }

    public void fight(GameCharacter character) {
        System.out.println("Engaging in battle... +50 XP, -30 HP");
        character.addExperience(50);
        character.reduceHealth(30);
    }

    public String getName() {
        return "Expert";
    }
}