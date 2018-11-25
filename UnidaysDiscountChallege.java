/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testunidaysdiscountschallege;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author luizacomanescu
 */
class UnidaysDiscountChallege 
{

    
    private ArrayList<Item> pricingRules = new ArrayList<>();
    private final HashMap<String, Integer> basket = new  HashMap<>();
    

    public UnidaysDiscountChallege(ArrayList<Item> otherPricingRules)
    {
        pricingRules = otherPricingRules;
    }
    public void AddToBasket(String otherItem) 
    {
    
           int count = basket.containsKey(otherItem) ? basket.get(otherItem) : 0;
            basket.put(otherItem, count + 1);
       
    }

    public Result CalculateTotalPrice(double freeDelivery, double deliveryCharge) 
    {
        
        Result result = new Result();
        
        Iterator it = basket.entrySet().iterator();
         while (it.hasNext()) {
        Map.Entry currentItem = (Map.Entry)it.next();
            for(Item ruleItem : pricingRules)
                if(currentItem .getKey()== ruleItem.type)
                    result.Total +=  result.getTotal(ruleItem.price, ruleItem.discount, (int)currentItem.getValue());
            if(result.Total >= freeDelivery)
                result.DeliveryCharge = 0;
            else
                result.DeliveryCharge = deliveryCharge;  
             it.remove();
        }
        return result;
    }
}
