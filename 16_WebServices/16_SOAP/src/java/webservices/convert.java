/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.util.Arrays;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Jose Sanchez
 */
@WebService(serviceName = "convert")
@Stateless()
public class convert {

    public double[] ratesUSD = {0.92, 1.39, 23.76}; //EURO, CAN Y MXN
    public String[] coins = {"EURO", "CAN", "MXN"};

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public Double operation(@WebParam(name = "amount") Double amount, @WebParam(name = "coin") String coin, @WebParam(name = "newCoin") String newCoin) {
        double ans = 1;
        int coinIndex = Arrays.asList(coins).indexOf(coin);
        int newCoinIndex = Arrays.asList(coins).indexOf(newCoin);
        double coinRate = ratesUSD[coinIndex];
        double newCoinRate = ratesUSD[newCoinIndex];
      
        return (coinRate * newCoinRate) * amount;
    }
}
