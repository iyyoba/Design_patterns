package com.game.state;

class NoviceState implements CharacterState {

    public void train(GameCharacter character) {
        System.out.println("Training hard... +20 XP");
        character.addExperience(20);
    }

    public void meditate(GameCharacter character) {
        System.out.println("Meditation is not available at Novice level.");
    }

    public void fight(GameCharacter character) {
        System.out.println("Fighting is not available at Novice level.");
    }

    public String getName() {
        return "Novice";
    }
}