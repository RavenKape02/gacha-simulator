package gacha;

public class Game extends Thread {
    private String playerName;
    private Rolling rolling;

    public Game(String playerName, Rolling rolling) {
        this.playerName = playerName;
        this.rolling = rolling;
    }

    @Override
    public void run() {
    	rolling.diceRoll(playerName);
    }
}
