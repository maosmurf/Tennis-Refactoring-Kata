import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TennisTest {

    private static final String ANDRE_AGASSI = "Andre Agassi";
    private static final String BJOERN_BORG = "Björn Borg";
    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public TennisTest(int player1Score, int player2Score, String expectedScore) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;
    }
    
    @Parameters
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][] {
                { 0, 0, "Love-All" },
                { 1, 1, "Fifteen-All" },
                { 2, 2, "Thirty-All"},
                { 3, 3, "Deuce"},
                { 4, 4, "Deuce"},
                { 5, 5, "Deuce"},

                { 1, 0, "Fifteen-Love"},
                { 0, 1, "Love-Fifteen"},
                { 2, 0, "Thirty-Love"},
                { 0, 2, "Love-Thirty"},
                { 3, 0, "Forty-Love"},
                { 0, 3, "Love-Forty"},
                { 4, 0, "Win for " + ANDRE_AGASSI},
                { 0, 4, "Win for " + BJOERN_BORG},

                { 2, 1, "Thirty-Fifteen"},
                { 1, 2, "Fifteen-Thirty"},
                { 3, 1, "Forty-Fifteen"},
                { 1, 3, "Fifteen-Forty"},
                { 4, 1, "Win for " + ANDRE_AGASSI},
                { 1, 4, "Win for " + BJOERN_BORG},

                { 3, 2, "Forty-Thirty"},
                { 2, 3, "Thirty-Forty"},
                { 4, 2, "Win for " + ANDRE_AGASSI},
                { 2, 4, "Win for " + BJOERN_BORG},

                { 4, 3, "Advantage " + ANDRE_AGASSI},
                { 3, 4, "Advantage " + BJOERN_BORG},
                { 5, 4, "Advantage " + ANDRE_AGASSI},
                { 4, 5, "Advantage " + BJOERN_BORG},
                { 15, 14, "Advantage " + ANDRE_AGASSI},
                { 14, 15, "Advantage " + BJOERN_BORG},

                { 6, 4, "Win for " + ANDRE_AGASSI},
                { 4, 6, "Win for " + BJOERN_BORG},
                { 16, 14, "Win for " + ANDRE_AGASSI},
                { 14, 16, "Win for " + BJOERN_BORG},
        });
    }

    public void checkAllScores(TennisGame game) {
        int highestScore = Math.max(this.player1Score, this.player2Score);
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                game.wonPoint(ANDRE_AGASSI);
            if (i < this.player2Score)
                game.wonPoint(BJOERN_BORG);
        }
        assertEquals(this.expectedScore, game.getScore());
    }

    @Test
    public void checkAllScoresTennisGame1() {
        TennisGame1 game = new TennisGame1(ANDRE_AGASSI, BJOERN_BORG);
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame2() {
        TennisGame2 game = new TennisGame2(ANDRE_AGASSI, BJOERN_BORG);
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame3() {
        TennisGame3 game = new TennisGame3(ANDRE_AGASSI, BJOERN_BORG);
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame4() {
        TennisGame4 game = new TennisGame4(ANDRE_AGASSI, BJOERN_BORG);
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame5() {
        TennisGame5 game = new TennisGame5(ANDRE_AGASSI, BJOERN_BORG);
        checkAllScores(game);
    }

}
