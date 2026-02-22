package com.game.state;

class MasterState implements CharacterState {

    public void train(GameCharacter character) {
        System.out.println("You are already a Master. No further training needed.");
    }

    public void meditate(GameCharacter character) {
        System.out.println("You are already a Master.");
    }

    public void fight(GameCharacter character) {
        System.out.println("You are already a Master.");
    }

    public String getName() {
        return "Master";
    }
}

