import java.util.*;


class Player {
    String nome;
    int score;

    Player (String nome, int score){
        this.nome = nome;
        this.score = score;
    }
}

class Checar implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b){

        if(a.score != b.score){
            return b.score - a.score;
        }

        return a.nome.compareTo(b.nome);
    }
}

public class Solution {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Player[] players = new Player[n];
        Checar checar = new Checar();

        for (int i = 0; i < n; i++){
            String nome = scan.next();
            int score = scan.nextInt();
            players[i] = new Player(nome, score);
        }
        scan.close();

        Arrays.sort(players, checar);

        for (Player p : players){
            System.out.println(p.nome + " " + p.score);
        }
    }
}

