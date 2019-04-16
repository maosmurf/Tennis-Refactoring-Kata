package game5;

import java.util.Map;

import static game5.Player.PLAYER_1;
import static game5.Player.PLAYER_2;

public enum WonGameState implements GameState {
    WIN_1(PLAYER_1),
    WIN_2(PLAYER_2),
    ;

    private final Player player;

    WonGameState(Player player) {
        this.player = player;
    }

    @Override
    public String getScore(Map<Player, String> names) {
        return "Win for " + names.get(player);
    }


    @Override
    public final GameState wonPoint1() {
        throw new IllegalStateException("Cannot score in game already won");
    }

    @Override
    public final GameState wonPoint2() {
        throw new IllegalStateException("Cannot score in game already won");
    }
}
