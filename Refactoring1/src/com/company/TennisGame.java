package com.company;

public class TennisGame {
    private static final int TEMP_SCORE = 0;
    private static final int FIRST_POINT = 1;
    private static final int LAST_POINT = 3;

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        String score = "";
        int tempScore = TEMP_SCORE;
        if (point_comparison((int) scorePlayer1, (int) scorePlayer2)) {
            switch (scorePlayer1) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            int minusResult = scorePlayer1 - scorePlayer2;
            if (minusResult == 1) {
                score = "Advantage player1";
            } else if (minusResult == -1) {
                score = "Advantage player2";
            } else if (minusResult >= 2) {
                score = "Win for player1";
            } else {
                score = "Win for player2";
            }
        } else {
            for (int i = FIRST_POINT; i < LAST_POINT; i++) {
                if (i == FIRST_POINT) {
                    tempScore = scorePlayer1;
                } else {
                    score += "-";
                    tempScore = scorePlayer2;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }

    public static boolean point_comparison(int scorePlayer1, int scorePlayer2) {
        if (scorePlayer1 == scorePlayer2) {
            return true;
        } else {
            return false;
        }
    }
}
