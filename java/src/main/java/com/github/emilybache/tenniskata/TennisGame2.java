package com.github.emilybache.tenniskata;

public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String namedPoints(int point) {
        switch (point) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                throw new IllegalArgumentException("No name for " + point);
        }
    }

    public String getScore() {
        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            return "Win for player1";
        }

        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            return "Win for player2";
        }

        if (P1point > P2point && P2point >= 3) {
            return "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            return "Advantage player2";
        }

        if (P1point == P2point) {
            if (P1point >= 3) {
                return "Deuce";
            }
            String namedPoints = this.namedPoints(P1point);
            return namedPoints + "-All";
        }

        return this.namedPoints(P1point) + "-" + namedPoints(P2point);

    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
