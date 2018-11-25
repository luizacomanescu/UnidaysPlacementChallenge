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
class Item {
    
    String type;
    double price;
    String discount;

    public Item(String otherType, double otherPrice, String otherDiscount) 
    {
        type = otherType;
        price = otherPrice;
        discount = otherDiscount;
    }
    
}
