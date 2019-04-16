package game5;

public enum Player {
    PLAYER_1 {
        @Override
        public GameState wonPoint(GameState state) {
            return state.wonPoint1();
        }
    },
    PLAYER_2 {
        @Override
        public GameState wonPoint(GameState state) {
            return state.wonPoint2();
        }
    },
    ;

    public abstract GameState wonPoint(GameState state);
}
