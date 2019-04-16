package game5;

import java.util.Map;

import static game5.AdvantageGameState.ADVANTAGE_1;
import static game5.AdvantageGameState.ADVANTAGE_2;

public enum DeuceGameState implements GameState {
    DEUCE;

    @Override
    public GameState wonPoint1() {
        return ADVANTAGE_1;
    }

    @Override
    public GameState wonPoint2() {
        return ADVANTAGE_2;
    }

    @Override
    public String getScore(Map<Player, String> names) {
        return "Deuce";
    }
}
