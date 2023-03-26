package org.example;

import org.example.Data.Polynom;
import org.example.Logic.Operatie;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
           Polynom p1 = new Polynom("x^3-2x^2+6x-5");
           Polynom p2=new Polynom("x^2-1");
           Operatie a=new Operatie();
         Polynom[] rez2=a.divide(p1,p2);
          System.out.println("Q: "+ a.HashToString(rez2[0])+ " R: "+a.HashToString(rez2[1]));

      // System.out.println(p2.polynom);
    }
}
