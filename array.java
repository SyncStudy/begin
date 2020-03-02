/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Scanner;
/**
 *
 * @author dequn_teng_local
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number=0;
        String[] cars ={"Volvo", "BMW", "Ford", "Mazda"};
        int[] myNum={10,20,30,40};
        // TODO code application logic here
        System.out.println("Please input the number of nodes");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt())
        {
            number = scanner.nextInt();
        }
        else
        {
            System.out.println("Please input integer only");
        }
        System.out.println(cars[0]);
        cars[0]="Opel";
        System.out.println(cars[0]);
        System.out.println(cars.length);
        for(int j =0; j <cars.length;j++)
        {
            System.out.println(cars[j]);
        }
        int [][]myNumbers={{1,2,3,4},{5,6,7}};
        int x=myNumbers[0][0];
        System.out.println(x);
        for (int i=0;i<myNumbers.length;++i){
            for(int j=0;j<myNumbers[i].length;++j){
                System.out.println(myNumbers[i][j]);
            }
        }
    }
    
}
