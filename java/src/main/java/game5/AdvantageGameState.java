package game5;

import java.util.Map;

import static game5.DeuceGameState.DEUCE;
import static game5.Player.PLAYER_1;
import static game5.Player.PLAYER_2;
import static game5.WonGameState.WIN_1;
import static game5.WonGameState.WIN_2;

public enum AdvantageGameState implements GameState {
    ADVANTAGE_1(PLAYER_1) {
        @Override
        public GameState wonPoint1() {
            return WIN_1;
        }

        @Override
        public GameState wonPoint2() {
            return DEUCE;
        }
    },
    ADVANTAGE_2(PLAYER_2) {
        @Override
        public GameState wonPoint1() {
            return DEUCE;
        }

        @Override
        public GameState wonPoint2() {
            return WIN_2;
        }
    },
    ;

    private final Player player;

    AdvantageGameState(Player player) {

        this.player = player;
    }

    @Override
    public String getScore(Map<Player, String> names) {
        return "Advantage " + names.get(player);
    }

}
