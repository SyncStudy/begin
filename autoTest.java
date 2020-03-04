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
    public static int[] descendingID(int n)
    {
        int descendingIDs[]=new int[n];
        for(int i=0;i<n;i++)
        {
            Random r= new Random();
            descendingIDs[0]=999999999;
            if(i==n-1)
            {
                descendingIDs[n-1]=descendingIDs[n-2]-10;
            }
            else
            {
                descendingIDs[i+1]=descendingIDs[i]-r.nextInt(10)-200;
            }
        }
        return descendingIDs;
    }
        public static int[] randomID(int n)
    {
        int alpha=3;

        int randomIDs[]=new int[n];
                
        List<Integer> digits = IntStream.range(1,(alpha*n+1)).boxed().collect(Collectors.toList());

        Collections.shuffle (digits);

        for(int i=0;i<n;i++)
        {
            randomIDs[i]=digits.get(i);
        }
        return randomIDs;
    }

    
    public static void main(String[] args) {
        System.out.println("This is LCR");
   
        for(int k=1;k<100;k++)
        {
                      
        int numbers[] = new int[k];
        
        int sendID[] = new int[k];
        int buffer[] = new int[k];
        String status[] = new String[k];
     
        for(int i=0;i<k;i++)
        {
            numbers[i]=randomID(k)[i];
        }
           for (int i=0;i<k;i++)
        {
            status[i]="unknown";
            sendID[i]=numbers[i];
            System.out.println("status initialization "+sendID[i] );
        }
        boolean leaderFlag=false;
        int round=1;
        int[] inBox = new int[k];
        int leaderID=0;
        int numOfMes=0;
        int count=100;
        int idIni=2;
        int[] resN= new int[count];
        int[] resLeader=new int[count];
        int[] resRound= new int[count];
        int[] resMes= new int[count];
        

            System.out.println("This is test " +k);
            while(leaderFlag==false)
        {
            //This is generating sendID
            for(int i=0;i<k;i++)
            {
                buffer[0]=sendID[k-1];
                if(i!=k-1)
                {
                    buffer[i+1]=sendID[i];
                }
            }
            for(int i=0;i<k;i++)
            {
                if(buffer[i]!=0)
                {
                    inBox[i]=buffer[i];
                    numOfMes++;
                }
            }
            //State transformation
            for(int i=0;i<k;i++)
            {   
                if(round==1)
                {   
                    sendID[0]=numbers[k-1];
                    if(i!=k-1)
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
                        if(i==k-1)
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

        System.out.println("Number of nodes: "+k+", "+"K of rounds: "+round+" , leader is "+leaderID+" , num of messages"+numOfMes);
        resN[k]=k;
        resLeader[k]=leaderID;
        resRound[k]=round;
        resMes[k]=numOfMes;
        k=k+1;
        }

        
        //System.out.println("Number of nodes: "+number+", "+"Number of rounds: "+round+" , leader is "+leaderID+" , num of messages"+numOfMes);
       
        
        System.out.println("This is HS");
        // TODO code application logic here
        
    }
    
}
