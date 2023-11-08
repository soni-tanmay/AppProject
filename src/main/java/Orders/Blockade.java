package Orders;

import Models.*;

import java.util.HashMap;
import java.util.Map;

public class Blockade implements IOrders{

    /**
     * worldmap variable
     */
    private WorldMap d_WorldMap;

    /**
     * target country
     */
    private Country d_sourceCountry;

    /**
     * country ID
     */
    private int d_TargetID;

    private Player d_player;

    private String d_sourceCountryName;

    private HashMap<Country,Player> d_countryOwnerMap;

    /**
     * Parameterized Constructor for blockade card
     * @param p_sourceConuntryName target country ID
     */
    public Blockade(String p_sourceConuntryName, Player p_player, HashMap<Country,Player> p_countryOwnerMap){
        Card card = new Card();
        card.setCardType(CardType.BLOCKADE);
        d_sourceCountryName = p_sourceConuntryName;
        d_player = p_player;
        d_countryOwnerMap = p_countryOwnerMap;
    }


    /**
     * method to apply blockade to a country
     * parameter of player object
     */
    @Override
    public void execute() {
        while (!d_player.getD_PlayerCards().isEmpty()){
//            if (validateCard(d_player,this.d_TargetCountry)){
//                //if select country pass all the conditions
//                //triple the armies
//                d_TargetCountry.setD_Armies(d_TargetCountry.getD_Armies() * 3);
//                d_TargetCountry.setD_NeutralCountry(true);
//                //d_TargetCountry.addNeutralCountry(d_TargetCountry);
//
////                d_countryOwnerMap.remove(d_TargetCountry);
////                d_player.removeCard(CardType.BLOCKADE);
//                break;
//            }

        }
    }

    /**
     * this is a method to validate correctness of blockade card
     * @param p_player variable of the current player
     * @param p_TargetCountry country that current want to blockade
     * @return true if pass all the conditions else return false
     */
    public boolean validateCard(Player p_player, Country p_TargetCountry) {


        boolean sourceCountryFind=false;
        for (Map.Entry<Country, Player> entry : d_countryOwnerMap.entrySet()) {
            Country temp=entry.getKey();
            if (temp.getName().equals(d_sourceCountryName)){
                d_sourceCountry=temp;
                sourceCountryFind=true;
                break;
            }
        }
        //validate if the player exist
        if (p_player == null) {
            System.err.println("This player is not valid.");
            return false;
        }

        //validate if this country is onwed by the plater
//        for (Map.Entry<Country, Player> entry : d_countryOwnerMap.entrySet()) {
//            Country l_country=entry.getKey();
//            if (l_country.getName().equals(d_TargetCountry.getName())){
//                System.err.println("Current country is not belong to you!");
//                return false;
//            }
//        }

            //validate if the player's card is bomb type
        if (!p_player.checkIfCardExists(CardType.BLOCKADE)) {
            System.err.println("You do not have the Blockade card.");
            return false;
        }

        return true;
        }

    /**
     * boolean method to check the game state
     * @return if it's a valid game state
     */
    @Override
    public boolean valid() {
        return false;
    }

    /**
     * override method to print the order from players
     */
    @Override
    public void printOrder() {

    }

    /**
     * override method to get the order name
     * @return order name
     */
    @Override
    public String getOrderName() {
        return null;
    }

    /**
     * override method to get country name
     * @return country name
     */
    @Override
    public String getTargetCountryName() {
        return null;
    }

    /**
     * override method to get target country id
     * @return target country ID
     */
    @Override
    public String getTargetCountryID() {
        return null;
    }

    /**
     * override method to get number of armies for current country
     * @return number of armies
     */
    @Override
    public int getNumberOfArmies() {
        return 0;
    }
}
