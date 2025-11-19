import java.util.*;

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            return b.score - a.score;
        }
        return a.name.compareTo(b.name);
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Solution {
    public static void main(String[] args) {
        // Criando os jogadores diretamente com os valores do exemplo
        Player[] players = {
                new Player("amy", 100),
                new Player("david", 100),
                new Player("heraldo", 50),
                new Player("aakansha", 75),
                new Player("aleksa", 150)
        };

        Checker checker = new Checker();
        Arrays.sort(players, checker);

        // Imprimindo o resultado
        for (Player p : players) {
            System.out.println(p.name + " " + p.score);
        }
    }
}