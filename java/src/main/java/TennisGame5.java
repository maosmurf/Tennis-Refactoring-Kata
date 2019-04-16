import game5.GameState;
import game5.Player;
import game5.PointsGameState;

import java.util.HashMap;
import java.util.Map;

public class TennisGame5 implements TennisGame {

    private final Map<String, Player> players = new HashMap<>();
    private final Map<Player, String> names = new HashMap<>();

    private GameState state = PointsGameState.LOVE_ALL;

    public TennisGame5(String name1, String name2) {
        players.put(name1, Player.PLAYER_1);
        players.put(name2, Player.PLAYER_2);
        names.put(Player.PLAYER_1, name1);
        names.put(Player.PLAYER_2, name2);
    }

    @Override
    public void wonPoint(String playerName) {
        var player = players.get(playerName);
        state = player.wonPoint(state);
    }

    @Override
    public String getScore() {
        return this.state.getScore(names);
    }
}
