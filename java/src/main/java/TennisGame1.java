import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

    private static Map<Integer, String> POINTS = new HashMap<>();

    static {
        POINTS.put(0, "Love");
        POINTS.put(1, "Fifteen");
        POINTS.put(2, "Thirty");
        POINTS.put(3, "Forty");
    }

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        int tempScore;
        if (m_score1 == m_score2) {
            if (POINTS.containsKey(m_score1) && m_score1 < POINTS.size() - 1) {
                return POINTS.get(m_score1) + "-All";
            }
            return "DeuceGameState";
        }
        if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1) return "Advantage " + player1Name;
            if (minusResult == -1) return "Advantage " + player2Name;
            if (minusResult >= 2) return "Win for " + player1Name;
            return "Win for " + player2Name;
        }

        String score = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = m_score1;
            else {
                score += "-";
                tempScore = m_score2;
            }

            score += POINTS.get(tempScore);
        }
        return score;
    }
}
