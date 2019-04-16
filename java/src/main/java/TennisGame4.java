import java.util.HashMap;
import java.util.Map;

public class TennisGame4 implements TennisGame {

    private final static HashMap<Integer, String> words = new HashMap<>();
    private static final int NAMED_POINTS = 3;

    static {
        words.put(0, "Love");
        words.put(1, "Fifteen");
        words.put(2, "Thirty");
        words.put(3, "Forty");
    }

    private final String player1name;
    private final String player2name;

    private Map<String, Integer> points = new HashMap<>();

    public TennisGame4(String player1name, String player2name) {
        this.player1name = player1name;
        this.player2name = player2name;
        points.put(player1name, 0);
        points.put(player2name, 0);
    }

    @Override
    public void wonPoint(String playerName) {
        int newPoint = points.get(playerName) + 1;
        points.put(playerName, newPoint);
    }

    @Override
    public String getScore() {
        final int player1points = points.get(player1name);
        final int player2points = points.get(player2name);

        final var player1word = words.get(player1points);
        final var player2word = words.get(player2points);

        if (player1points == player2points) {
            if (player1points >= NAMED_POINTS) {
                return "DeuceGameState";
            }
            return player1word + "-All";
        }

        if (player1points <= 3 && player2points <= NAMED_POINTS) {
            return player1word + "-" + player2word;
        }

        int diff = player1points - player2points;
        String betterPlayer = diff > 0 ? player1name : player2name;

        if (Math.abs(diff) == 1) {
            return "Advantage " + betterPlayer;
        }

        return "Win for " + betterPlayer;
    }

}
