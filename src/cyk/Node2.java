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
public class Node2
{
    public int counter2;
    public String[] finalDestination;
    
    public Node2()
    {
        counter2 = 0;
        finalDestination = new String[100];
    }
    
    public void setGrammer(String des)
    {
        finalDestination[counter2] = des;
        counter2++;
    }
}
