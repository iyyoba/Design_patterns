package com.game.state;

class IntermediateState implements CharacterState {

    public void train(GameCharacter character) {
        System.out.println("Advanced training... +30 XP");
        character.addExperience(30);
    }

    public void meditate(GameCharacter character) {
        System.out.println("Meditating... +20 HP");
        character.addHealth(20);
    }

    public void fight(GameCharacter character) {
        System.out.println("Fighting is not available at Intermediate level.");
    }

    public String getName() {
        return "Intermediate";
    }
}
