package game5;

import java.util.Map;

public interface GameState {

    GameState wonPoint1();

    GameState wonPoint2();

    String getScore(Map<Player, String> names);
}
