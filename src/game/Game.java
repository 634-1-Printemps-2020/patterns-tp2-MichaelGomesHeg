package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules;
    private Coin coin = Coin.getInstance();
    private Map<Player, List<CoinState>> history;

    public Game() {
        history = new HashMap<>();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
      // TODO: Votre code ici
        history.put(player, null);

    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
      // TODO: Votre code ici
        List<CoinState> list;
        rules = Rules.getInstance();

        for(Player player : history.keySet()){
            list = new ArrayList<>();
            while(rules.checkWin(list)==false){
                coin.getInstance();
                player.play(coin);
                list.add(coin.getState());
            }
            history.put(player, list);
        }

    }

    /***
     * Méthode qui vérifie si l'utilsiateur a gagné
     * @param list
     * @return
     */
    public Boolean ListComplete(List<CoinState> list){
        Integer cpt = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)==CoinState.HEADS){
                cpt += 1;
                if (cpt==3){
                    return true;
                }
            }
           else{
                    cpt = 0;
           }
        }
        return false;
    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
      // TODO: Votre code ici
        return new Statistics(averageToWin(),fewerMoves(), MostMoves(), TotalTir());
    }

    public Integer TotalTir(){
        int totalTir = 0;
        for(Player player: history.keySet()){
           totalTir += history.get(player).size();
        }
        return totalTir;
    }

    public Integer MostMoves(){
        int totalTir = 0;
        for(Player player: history.keySet()){
            int TirJoueur = history.get(player).size();
            if(totalTir<TirJoueur){
                totalTir = TirJoueur;
            }
        }
        return totalTir;
    }

    public Integer fewerMoves(){
        int totalTir = 0;
        for(Player player: history.keySet()){
            int TirJoueur = history.get(player).size();
            if(totalTir == 0){
                totalTir = 100000000;
            }
            if(totalTir>TirJoueur){
                totalTir = TirJoueur;
            }
        }
        return totalTir;
    }


    public int averageToWin(){
        return TotalTir() / history.size();
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
      // TODO: Votre code ici
      return history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      // TODO: Votre code ici
      return history.get(player);
    }

}
