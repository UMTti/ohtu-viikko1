package ohtu;

public class TennisGame {

    private int scores1 = 0;
    private int scores2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            scores1 += 1;
        } else {
            scores2 += 1;
        }
    }

    public String getScore() {
        String result = "";
        int tempScore = 0;
        if (scores1 == scores2) {
            result = switchTasapeli();
        } else if (scores1 >= 4 || scores2 >= 4) {
            result = switchVoitto();
        } else {
            result = switchEro(scores1) + "-" + switchEro(scores2);
        }
        return result;
    }

    public String switchEro(int singleScore) {
        String result = "";
        switch (singleScore) {
            case 0:
                result += "Love";
                break;
            case 1:
                result += "Fifteen";
                break;
            case 2:
                result += "Thirty";
                break;
            case 3:
                result += "Forty";
                break;
        }
        return result;
    }

    public String switchTasapeli() {
        String result = "";
        switch (scores1) {
            case 0:
                result = "Love-All";
                break;
            case 1:
                result = "Fifteen-All";
                break;
            case 2:
                result = "Thirty-All";
                break;
            case 3:
                result = "Forty-All";
                break;
            default:
                result = "Deuce";
                break;
        }
        return result;
    }

    public String switchVoitto() {
        int difference = scores1 - scores2;
        String result = "";
        if (difference == 1) {
            result = "Advantage player1";
        } else if (difference == -1) {
            result = "Advantage player2";
        } else if (difference >= 2) {
            result = "Win for player1";
        } else {
            result = "Win for player2";
        }
        return result;
    }
}
