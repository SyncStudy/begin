/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author dequn_teng_local
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    
    public static int[] ascendingID(int n)
    {
        
        int ascendingIDs[] = new int[n];
        for (int i=0;i<n;i++)
        {
            Random r= new Random();
            ascendingIDs[0]=1;
            if(i==n-1)
            {
                ascendingIDs[n-1]=ascendingIDs[n-2]+10;
            }
            else
            {
                ascendingIDs[i+1]=ascendingIDs[i]+r.nextInt(10)+200;
            }
        }
         
        return ascendingIDs;
    }
    public static void main(String[] args) {
        System.out.println("This is LCR");
        int number=0;
        int alpha=3;
        for (int i=0;i<99;i++)
        {
            System.out.println(ascendingID(99)[i]);
        }
        
        //Get user input
        System.out.println("Please input the number of nodes");
        Scanner scanner = new Scanner(System.in);
        //Check input
        if (scanner.hasNextInt())
        {
            number = scanner.nextInt();
        }
        else
        {
            System.out.println("Please input integer only");
        }
        int numbers[] = new int[number];
        int sendID[] = new int[number];
        int buffer[] = new int[number];
        String status[] = new String[number];
     
        
        List<Integer> digits = IntStream.range(1,(alpha*number+1)).boxed().collect(Collectors.toList());

        Collections.shuffle (digits);

        for(int i=0;i<number;i++)
        {
            numbers[i]=digits.get(i);
            System.out.println(numbers[i]);
        }
           for (int i=0;i<number;i++)
        {
            status[i]="unknown";
            sendID[i]=numbers[i];
            System.out.println("status initialization "+sendID[i] );
        }
        boolean leaderFlag=false;
        int round=1;
        int[] inBox = new int[number];
        int leaderID=0;
        int numOfMes=0;
        
        while(leaderFlag==false)
        {
            //This is generating sendID
            for(int i=0;i<number;i++)
            {
                buffer[0]=sendID[number-1];
                if(i!=number-1)
                {
                    buffer[i+1]=sendID[i];
                }
            }
            for(int i=0;i<number;i++)
            {
                if(buffer[i]!=0)
                {
                    inBox[i]=buffer[i];
                    numOfMes++;
                }
            }
            //State transformation
            for(int i=0;i<number;i++)
            {   
                if(round==1)
                {   
                    sendID[0]=numbers[number-1];
                    if(i!=number-1)
                    {
                        inBox[i+1]=numbers[i];
                    }
                    else
                    {
                        
                    }
                    
                }
                else
                {
                    if(inBox[i]>numbers[i])
                    {
                        sendID[i]=inBox[i];
                        if(i==number-1)
                        {
                            buffer[0]=sendID[i];
                        }
                        else
                        {
                            buffer[i+1]=sendID[i];
                        }
                    }
                    else if(inBox[i]==numbers[i])
                    {
                        status[i]="leader";
                        leaderFlag=true;
                        leaderID=numbers[i];
                        round--;
                    }
                    else
                    {
                        buffer[i]=0;
                    }
                }
                System.out.println("This is the "+ i  +" processor"+" , "+"inBox: "+inBox[i]+" number: "+numbers[i]+" outID: "+sendID[i]);
            }
            
            
  
           
            System.out.println("The current round is "+round);
            round=round+1;
        }
        System.out.println("Number of nodes: "+number+", "+"Number of rounds: "+round+" , leader is "+leaderID+" , num of messages"+numOfMes);
       
        
        System.out.println("This is HS");
        // TODO code application logic here
        
    }
    
}
