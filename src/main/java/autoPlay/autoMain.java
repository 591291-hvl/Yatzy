package autoPlay;


import main.Player;

public class autoMain {

    public static void main(String[] args) {
        String[] playerNames = {"Daniel", "Harald", "Per", "Petter"};
        Player[] players = new Player[4];
        for(int i = 0; i < players.length; i = -~i){
            players[i] = new Player(playerNames[i]);
        }

        autoPlayYatzy yatzy = new autoPlayYatzy(5, 4, players);

        yatzy.display();

        yatzy.playGame();

    }

}
