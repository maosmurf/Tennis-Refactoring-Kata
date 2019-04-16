package game5;

import java.util.Map;

import static game5.DeuceGameState.DEUCE;
import static game5.Points.*;
import static game5.WonGameState.WIN_1;
import static game5.WonGameState.WIN_2;

public enum PointsGameState implements GameState {
    THIRTY_FORTY(THIRTY, FORTY, DEUCE, WIN_2),
    FORTY_THIRTY(FORTY, THIRTY, WIN_1, DEUCE),
    FIFTEEN_FORTY(FIFTEEN, FORTY, THIRTY_FORTY, WIN_2),
    FORTY_FIFTEEN(FORTY, FIFTEEN, WIN_1, FORTY_THIRTY),
    LOVE_FORTY(LOVE, FORTY, FIFTEEN_FORTY, WIN_2),
    FORTY_LOVE(FORTY, LOVE, WIN_1, FORTY_FIFTEEN),
    THIRTY_ALL(THIRTY, THIRTY, FORTY_THIRTY, THIRTY_FORTY),
    FIFTEEN_THIRTY(FIFTEEN, THIRTY, THIRTY_ALL, FIFTEEN_FORTY),
    THIRTY_FIFTEEN(THIRTY, FIFTEEN, FORTY_FIFTEEN, THIRTY_ALL),
    LOVE_THIRTY(LOVE, THIRTY, FIFTEEN_THIRTY, LOVE_FORTY),
    THIRTY_LOVE(THIRTY, LOVE, FORTY_LOVE, THIRTY_FIFTEEN),
    FIFTEEN_ALL(FIFTEEN, FIFTEEN, THIRTY_FIFTEEN, FIFTEEN_THIRTY),
    LOVE_FIFTEEN(LOVE, FIFTEEN, FIFTEEN_ALL, LOVE_THIRTY),
    FIFTEEN_LOVE(FIFTEEN, LOVE, THIRTY_LOVE, FIFTEEN_ALL),
    LOVE_ALL(LOVE, LOVE, FIFTEEN_LOVE, LOVE_FIFTEEN);

    private final Points p1;
    private final Points p2;
    private final GameState next1;
    private final GameState next2;

    PointsGameState(Points p1, Points p2, GameState next1, GameState next2) {
        this.p1 = p1;
        this.p2 = p2;
        this.next1 = next1;
        this.next2 = next2;
    }

    @Override
    public GameState wonPoint1() {
        return next1;
    }

    @Override
    public GameState wonPoint2() {
        return next2;
    }

    @Override
    public String getScore(Map<Player, String> names) {
        return p1.equals(p2) ? p1 + "-All" : p1 + "-" + p2;
    }

}

