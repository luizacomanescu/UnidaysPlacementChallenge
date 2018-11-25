/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testunidaysdiscountschallege;



/**
 *
 * @author luizacomanescu
 */
class Result {

    double Total;
    double DeliveryCharge;
    
    
   double getTotal(double otherPrice, String otherDiscount, int countItem)
    {
        double result = 0;
        if(otherDiscount == null)
        {
            return otherPrice * countItem;
        }
        
        
        
        int numberItem;
        String[] splited = otherDiscount.split("\\s+");
        if(otherDiscount.indexOf('£') != -1)
        {  
          
            if(isInteger(splited[0]))
            {
                numberItem = Integer.parseInt(splited[0]);
                if(countItem < numberItem)
                    return otherPrice * countItem;
                else if(countItem == numberItem)
                {
                    for(String currentToken : splited)
                       if(currentToken.indexOf('£') != -1)
                       {
                           String[] split_price = currentToken.split("£");
                           try{
                               
                               double new_price = Double.parseDouble(split_price[1]);
                               return  new_price;
                               
                           }catch(NumberFormatException e){}
                               
                       }
                }
               else 
              {
                    for(String currentToken : splited)
                       if(currentToken.indexOf('£') != -1)
                       {
                           String[] split_price = currentToken.split("£");
                           try{
                               double new_price = Double.parseDouble(split_price[1]);
                               if(countItem%numberItem == 0)
                                    return new_price *(countItem/numberItem);
                               else
                                   return new_price *((countItem - countItem%numberItem)/numberItem) + (countItem%numberItem)*otherPrice;
                           }catch(NumberFormatException e){}
                        }
                }
            }
       }
        if(otherDiscount.contains("free"))
        {
            int noFree= -1;
            int noBuy = -1;
            for(String currentToken : splited )
                if(isInteger(currentToken))
                    if(noBuy  == -1)
                        noBuy = Integer.parseInt(currentToken);
                       else
                            noFree = Integer.parseInt(currentToken);
            if(noFree + noBuy == countItem)
                return otherPrice * noBuy;
            else if(noFree + noBuy <  countItem)
                return otherPrice * countItem;
            else
            {
                
                     return otherPrice *(countItem/(noFree+noBuy)*noBuy + countItem%(noFree+noBuy));
            }
        }
        
        if(otherDiscount.contains("price"))
        {int noBought= -1;
            int noBuy = -1;
            for(String currentToken : splited )
                if(isInteger(currentToken))
                    if(noBuy  == -1)
                        noBuy = Integer.parseInt(currentToken);
                       else
                            noBought = Integer.parseInt(currentToken);
            if( noBuy == countItem)
                return otherPrice * noBought;
            else if(countItem < noBuy)
                return countItem * otherPrice;
            else
                return (countItem/noBuy)*noBought*otherPrice + (countItem%noBuy)*otherPrice;
            }
        
        return 0;
    }
   
       public  boolean isInteger(String str) {
    if (str == null) {
        return false;
    }
    if (str.isEmpty()) {
        return false;
    }
    int i = 0;
    if (str.charAt(0) == '-') {
        if (str.length() == 1) {
            return false;
        }
        i = 1;
    }
    for (; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c < '0' || c > '9') {
            return false;
        }
    }
    return true;
}
    
}
