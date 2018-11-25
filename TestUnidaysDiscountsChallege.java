/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testunidaysdiscountschallege;

import java.util.ArrayList;

/**
 *
 * @author luizacomanescu
 */


public class TestUnidaysDiscountsChallege {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Item> pricingRules = new ArrayList<>();
        
        pricingRules.add(new Item("camal", 23.00,null));
        pricingRules.add(new Item("cake", 3.00, "3 for £10.00"));
        pricingRules.add(new Item("lamb", 6.00, "buy 1 get 1 free"));
         pricingRules.add(new Item("cactus", 12.00, "3 for the price of 1"));
        
        
        UnidaysDiscountChallege example = new UnidaysDiscountChallege(pricingRules);
        
        String itemOne = "camal";
        example.AddToBasket(itemOne);
        
        String itemTwo = "cake";
        example.AddToBasket(itemTwo);
        
        String itemThree = "cake";
        example.AddToBasket(itemThree);
        
        Result result = example.CalculateTotalPrice(50.00,7.00);
        
        double totalPrice = result.Total;
        double deliveryCharge = result.DeliveryCharge;
        double overallTotal = totalPrice + deliveryCharge;
        
        System.out.println("Total: "+ totalPrice);
        System.out.println("Delivery Charge: " + deliveryCharge);
    }
    
}
