/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyk;

/**
 *
 * @author Arylate
 */
public class Node1
{
    public int counter;
    public String[] origin, finalOrg;
    public Node2[] destination;
    
    public Node1()
    {
        counter = 0;
        destination = new Node2[10];
        finalOrg = new String[100];
        
        for (int i = 0; i < 10; i++)
        {
            destination[i] = new Node2();
        }
        for (int i = 0; i < 100; i++)
        {
            finalOrg[i] = new String();
        }
    }
    
    public void setOrigin(String des, int index)
    {
        destination[index].setGrammer(des);
    }
    
    public void setFinalOrigin(String org)
    {
        finalOrg[counter] = org;
        counter++;
    }
}
