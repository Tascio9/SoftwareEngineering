/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jmsserver;

/**
 *
 * @author biar
 */
public class StockMarketServer {

	public static void main(String args[]) throws Exception {

	NotifyPurchase n = new NotifyPurchase();
                n.start();	
            
            ProductQuotation q = new ProductQuotation();
		q.start();
                
                
	}
}
