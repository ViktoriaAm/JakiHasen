/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jakihasenproject;

import frameapi.*;
import java.util.Scanner;
//import javax.swing.JOptionPane;

/**
 *
 * @author viktoria.amroudi
 */

public class JakiHasenProject 
{
    public static String[][] meinArray = new String [14][14];
    public static void Ausgabe(int [][] meinArray)
    {
        for(int i=0; i<14; i++)
        {
            for(int j=0; j<14; j++)
            {   
                System.out.print(meinArray[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<14; i++)
        {
            for(int j=0; j<14; j++)
            {
                meinArray[i][j]=".";
            }
        }
         
        FrameAPI.initFrame();
    
        meinArray[0][13]="H";
        meinArray[11][6]="H";
        meinArray[5][8]="H";
        meinArray[12][12]="H";
        meinArray[5][5]="H";
        meinArray[7][12]="H";
        meinArray[1][1]="H";
        meinArray[7][6]="H";
        meinArray[2][6]="H";
        meinArray[3][12]="H";
        meinArray[1][12]="H";
        meinArray[7][0]="H";
         
        meinArray[5][3]="F";
        meinArray[0][5]="F";
        meinArray[9][4]="F";
        meinArray[6][10]="F";
        meinArray[3][5]="F";
        meinArray[1][11]="F";
        meinArray[0][10]="F";
        meinArray[12][5]="F";
        meinArray[9][12]="F";
        meinArray[10][13]="F";
        meinArray[10][9]="F";
        meinArray[4][1]="F";
          
        meinArray[13][3]="J";
        meinArray[12][2]="J";
        meinArray[11][1]="J";
        meinArray[10][0]="J";
          
        FrameAPI.initString(meinArray.length, meinArray);
        FrameAPI.setPlayground();
        
        do
        {
            //JOptionPane.showMessageDialog(null, "Neue Runde?");
            if(FrameAPI.newRound)
            {
                move();
                FrameAPI.initString(meinArray.length, meinArray);
                FrameAPI.setPlayground();
            }
        }while(!FrameAPI.allDead);
          
        for (int t = 0; t< 10; t++)
        {           
            System.out.print("Spielfeldausgabe t = " + t);
            System.out.println();
            sc.nextLine();
        }    
    }
    public static void move()
    {
        String[][] HilfsArray = new String[14][14];
        for (int i=0; i<HilfsArray.length; i++)
        {
            for (int j=0; j<HilfsArray.length; j++)
            {
                HilfsArray[i][j] = meinArray[i][j];
            }        
        }
        
        for (int i=0; i<meinArray.length; i++)
        {
            for (int j=0; j<meinArray.length; j++)
            {
                if(HilfsArray[i][j].equals("H"))
                { 
                    double x = 4*Math.random();
                    if(x>=0 && x<1) // nach unten
                    {
                        if(i==13)
                        {
                            meinArray[13][j] = ".";
                            meinArray[0][j] = "H";
                        }else if(meinArray[i+1][j].equals("."))
                        {
                            meinArray[i][j] = ".";
                            meinArray[i+1][j] = "H";   
                        }
                    }
                    
                    if(x>=1 && x<2) // nach rechts
                    {
                        if(j==13)
                        {
                            meinArray[i][13] = ".";
                            meinArray[i][0] = "H";
                        }else if(meinArray[i][j+1].equals("."))
                        {
                            meinArray[i][j] = ".";
                            meinArray[i][j+1] = "H";
                        }
                    }
                    
                    if(x>=2 && x<3) // nach oben
                    {
                        if(i==0)
                        {
                            meinArray[0][j] = ".";
                            meinArray[1][j] = "H";
                        }else if(meinArray[i-1][j].equals("."))
                        {
                            meinArray[i][j] = ".";
                            meinArray[i-1][j] = "H";
                        }
                    }
                    
                    if(x>=3 && x<4) // nach links
                    {
                        if(j==0)
                        {
                            meinArray[i][0] = ".";
                            meinArray[i][1] = "H";
                        }else if(meinArray[i][j-1].equals("."))
                        {
                            meinArray[i][j] = ".";
                            meinArray[i][j-1] = "H";
                        }
                    }
                    
                    if(j<13 && j>0)
                    {
                        if(HilfsArray[i][j+1].equals("H")) // Baby kommt unten
                        {
                            if(i==13)
                            {
                                meinArray[13][j] = ".";
                                meinArray[0][j] = "h";
                            }else if(meinArray[i+1][j].equals("."))
                            {   
                                meinArray[i+1][j] = "h";
                            }
                        }
                    }
                    
                    if(i<13 && i>0)
                    {    
                        if(HilfsArray[i+1][j].equals("H")) // Baby kommt rechts
                        {
                            if(j==13)
                            {
                                meinArray[i][13] = ".";
                                meinArray[i][0] = "h";
                            }else if(meinArray[i][j+1].equals("."))
                            {
                                meinArray[i][j+1] = "h";
                            }
                        }
                    }
                }
            }
        }
        
        for (int i=0; i<meinArray.length; i++)
        {
            for (int j=0; j<meinArray.length; j++)
            {
                if(HilfsArray[i][j].equals("h"))
                {
                    if(j==13)
                    {
                        meinArray[i][13] = ".";
                        meinArray[i][0] = "H";
                    }else if(meinArray[i][j+1].equals("."))
                    {
                        meinArray[i][j] = ".";
                        meinArray[i][j+1] = "H";
                    }
                }
            }
        }
                
        for (int i=0; i<meinArray.length; i++)
        {
            for (int j=0; j<meinArray.length; j++)
            {
                if(HilfsArray[i][j].equals("F"))
                { 
                    double y = 4*Math.random();
                    if(y>=0 && y<1) // nach unten
                    {
                        if(i==13)
                        {
                            meinArray[13][j] = ".";
                            meinArray[0][j] = "F";
                        }else if(!meinArray[i+1][j].equals("F"))
                        {
                            meinArray[i][j] = ".";
                            meinArray[i+1][j] = "F";
                        }
                    }
                    
                    if(y>=1 && y<2) // nach rechts
                    {
                        if(j==13)
                        {
                            meinArray[i][13] = ".";
                            meinArray[i][0] = "F";
                        }else if(!meinArray[i][j+1].equals("F"))
                        {
                            meinArray[i][j] = ".";
                            meinArray[i][j+1] = "F";
                        }
                    }
                    
                    if(y>=2 && y<3) // nach oben
                    {
                        if(i==0)
                        {
                            meinArray[0][j] = ".";
                            meinArray[1][j] = "F";
                        }else if(!meinArray[i-1][j].equals("F"))
                        {
                            meinArray[i][j] = ".";
                            meinArray[i-1][j] = "F";
                        }
                    }
                    
                    if(y>=3 && y<4) // nach links
                    {
                        if(j==0)
                        {
                            meinArray[i][0] = ".";
                            meinArray[i][1] = "F";
                        }else if(!meinArray[i][j-1].equals("F"))
                        {
                            meinArray[i][j] = ".";
                            meinArray[i][j-1] = "F";
                        }
                    }
                }
            }
        }
        
        for (int i=0; i<meinArray.length; i++)
        {
            for (int j=0; j<meinArray.length; j++)
            {
                if(HilfsArray[i][j].equals("J"))
                {
                    if(j==13)
                    {
                        meinArray[i][13] = ".";
                        meinArray[i][0] = "J";
                    }
                    else if(i==0)
                    {
                        meinArray[0][j] = ".";
                        meinArray[13][j] = "J";
                    
                    }else
                    {
                        meinArray[i][j] = ".";
                        meinArray[i-1][j+1] = "J";
                    }
                }
            }
        }
    }
}
        

   

    
    
