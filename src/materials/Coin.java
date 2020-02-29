package materials;

public class Coin {

  private CoinState coinState;

  public Coin() {
  }

  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin() {
    /**
     * 0 = Head
     * 1= Tails
     */
    // TODO : Votre code ici
      int randomInt = (int)(2 * Math.random());

      if(randomInt == 0){
        coinState = CoinState.HEADS;
      }else{
        coinState = CoinState.TAILS;
      }


  }

  public CoinState getState() {
    return coinState;
  }


}
