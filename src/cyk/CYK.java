/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyk;

import java.util.Scanner;

/**
 *
 * @author Arylate
 */
public class CYK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String[] alphaGramm = {"S", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
        int numberOfRules, numberOfAlphaRule ;
        int[] flag1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String des;
        String org;
        String[] temp = new String[2];
        String[] str = new String[10];
        Node1[] grammer = new Node1[10];
        Node1[][] matrix;
        
        for (int i = 0; i < 10; i++)
        {
            grammer[i] = new Node1();
        }
        System.out.print("enter numberOfRules: ");//number of rules in chamski grammar
        numberOfRules = scan2.nextInt();
        
        System.out.println("Enter grammer in Chamski Format:");
        for (int i = 0; i < numberOfRules; i++)
        {
            System.out.print("origin: ");//origin of each grammar
            org = scan1.next();
            for (int j = 0; j < alphaGramm.length; j++)
            {
                if (org.equals(alphaGramm[j]))
                {
                    System.out.print("enter number of your alphabets's rule: ");//number of variables and letter of origin grammar
                    numberOfAlphaRule = scan2.nextInt();
                    for (int z = 0; z < numberOfAlphaRule; z++)
                    {
                        System.out.print("enter alphabet or valuable " + (z + 1) + " : "); 
                        des = scan1.next();
                        grammer[j].setOrigin(des, flag1[j]);
                    }
                    flag1[j]++;
                }
            }
        }
        
        System.out.println("enter length of inputed string");//lenght of input string
        int n = scan2.nextInt();
        for (int i = 0; i < n; i++)//receiving input
        {
            str[i] = scan1.next();
        }
        
        matrix = new Node1[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = new Node1();
            }
        }
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int z = 0; z < flag1[j]; z++)
                {
                    for (int l = 0; (l < grammer[j].destination[z].counter2 && grammer[j].destination[z].counter2 == 1); l++)
                    {
                        if (str[i].equals(grammer[j].destination[z].finalDestination[l]))
                        {
                            matrix[0][i].setFinalOrigin(alphaGramm[j]);
                        }
                    }
                }
            }
        }
        
        int k, l, flag2, flag3;
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < n - i; j++)
            {
                k = 0; l = j + i;
                while (k < i && l > j)
                {
                    for (int z = 0; z < matrix[i - k - 1][j].counter; z++)
                    {
                        for (int s = 0; s < matrix[k][l].counter; s++)
                        {
                            temp[0] = matrix[i - k - 1][j].finalOrg[z];
                            temp[1] = matrix[k][l].finalOrg[s];
                            
                            for (int o = 0; o < 3; o++)//alpha
                            {
                                for (int p = 0; p < flag1[o]; p++)
                                {
                                    if (grammer[o].destination[p].counter2 > 1)
                                    {
                                        flag2 = 0;
                                        for (int q = 0; q < grammer[o].destination[p].counter2; q++)
                                        {
                                            if (temp[flag2].equals(grammer[o].destination[p].finalDestination[q]))
                                            {
                                                flag2++;
                                            }
                                        }
                                        if (flag2 == 2)
                                        {
                                            flag3 = 0;
                                            if (matrix[i][j].counter == 0)
                                            {
                                                matrix[i][j].setFinalOrigin(alphaGramm[o]);
                                                flag3 = 1;
                                            }
                                            else
                                            {
                                                for (int h = 0; h < matrix[i][j].counter; h++)
                                                {
                                                    if (matrix[i][j].finalOrg[h].equals(alphaGramm[o]))
                                                    {
                                                        flag3 = 1;
                                                    }
                                                }
                                            }
                                            if (flag3 != 1)
                                                matrix[i][j].setFinalOrigin(alphaGramm[o]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    l--;
                    k++;
                }
            }
        }
        //output
        System.out.println("CYK's Table: ");
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = n - i - 1; j >= 0; j--)
            {
                if (matrix[i][j].counter == 0)
                    System.out.print("NULL");
                else
                {
                    for (int z = 0; z < matrix[i][j].counter; z++)
                        System.out.print(matrix[i][j].finalOrg[z]);
                }
                System.out.print("\t");
            }
            System.out.println();
        }
        
        System.out.println("Final Answer:");
        int a = 0;
        for (int z = 0; z < matrix[4][0].counter; z++)
        {
            if (matrix[4][0].finalOrg[z].equals("S"));
            {
                System.out.println("exist :)");
                a = 1;
                break;
            }
        }
        
        if (a != 1)
            System.out.println("not exist :(");
        
    }  
}
