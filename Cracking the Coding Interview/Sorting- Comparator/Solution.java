import java.util.*;

//Code for class Checker
class Checker implements Comparator<Player> {

public int compare(Player P1, Player P2){
if (P1.score < P2.score) {
      return 1;
    } else if (P1.score > P2.score) {
      return -1;
    } else {
      return P1.name.compareTo(P2.name);
    }
  }

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
