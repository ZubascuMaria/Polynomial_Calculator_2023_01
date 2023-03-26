package org.example.GUI;
import org.example.Data.Polynom;
import org.example.Logic.Operatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator extends JFrame implements ActionListener {
   JButton add,sub,multiply,divide,inte,deri,cButton;
   JTextField p1,p2,res;
   Operatie op=new Operatie();
  Polynom polynom1;
  Polynom polynom2;
    public Calculator()
    {
       JFrame frame= new JFrame("Polynomial Calculator");
        frame.getContentPane().setBackground(new Color(224,224,224));
        frame.setBounds(500,50,450,600);
        frame.setLayout(null);

        JLabel t1=new JLabel("Polynom 1:");
        t1.setBounds(10,50,150,35);
        t1.setFont(new Font("A",Font.ITALIC,25));
        frame.add(t1);

        p1=new JTextField();
        p1.setBounds(150,50,270,35);
        p1.setFont(new Font("A",Font.ITALIC,20));
        frame.add(p1);
        p1.addActionListener(this);

        JLabel t2=new JLabel("Polynom 2:");
        t2.setBounds(10,100,150,35);
        t2.setFont(new Font("A",Font.ITALIC,25));
        frame.add(t2);

        p2=new JTextField();
        p2.setBounds(150,100,270,35);
        p2.setFont(new Font("A",Font.ITALIC,20));
        frame.add(p2);
        p2.addActionListener(this);

        add= new JButton("ADD");
        add.setBounds(50, 170, 150, 50);
        add.setFont(new Font("T", Font.ITALIC, 20));
        add.setBackground(new Color(145, 139, 202));
        add.setForeground(Color.black);
        frame.add(add);
        add.setEnabled(true);
        add.addActionListener(this);

        sub= new JButton("SUB");
        sub.setBounds(230, 170, 150, 50);
        sub.setFont(new Font("T", Font.ITALIC, 20));
        sub.setBackground(new Color(145, 139, 202));
        sub.setForeground(Color.black);
        frame.add(sub);
        sub.setEnabled(true);
        sub.addActionListener(this);

        multiply= new JButton("MULTIPLICATE");
        multiply.setBounds(50, 240, 150, 50);
        multiply.setFont(new Font("T", Font.ITALIC, 15));
        multiply.setBackground(new Color(145, 139, 202));
        multiply.setForeground(Color.black);
        frame.add(multiply);
        multiply.setEnabled(true);
        multiply.addActionListener(this);

        divide= new JButton("DIVIDE");
        divide.setBounds(230,240, 150, 50);
        divide.setFont(new Font("T", Font.ITALIC, 20));
        divide.setBackground(new Color(145, 139, 202));
        divide.setForeground(Color.black);
        frame.add(divide);
        divide.setEnabled(true);
        divide.addActionListener(this);

        inte= new JButton("INTEGRATION");
        inte.setBounds(50, 310, 150, 50);
        inte.setFont(new Font("T", Font.ITALIC, 15));
        inte.setBackground(new Color(145, 139, 202));
        inte.setForeground(Color.black);
        frame.add(inte);
        inte.setEnabled(true);
        inte.addActionListener(this);

        deri= new JButton("DERIVATION");
        deri.setBounds(230, 310, 150, 50);
        deri.setFont(new Font("T", Font.ITALIC, 15));
        deri.setBackground(new Color(145, 139, 202));
        deri.setForeground(Color.black);
        frame.add(deri);
        deri.setEnabled(true);
        deri.addActionListener(this);

        cButton= new JButton("C");
        cButton.setBounds(50, 380, 80, 50);
        cButton.setFont(new Font("T", Font.ITALIC, 30));
        cButton.setBackground(new Color(145, 139, 202));
        cButton.setForeground(Color.black);
        frame.add(cButton);
        cButton.setEnabled(true);
        cButton.addActionListener(this);

        res=new JTextField("RESULT:");
        res.setBounds(30,450,370,35);
        res.setFont(new Font("A",Font.ITALIC,20));
        frame.add(res);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

     polynom1=new Polynom(p1.getText());
     polynom2=new Polynom(p2.getText());

     if(e.getSource()==add)
     {
       Polynom result=op.addPoli(polynom1,polynom2);
      res.setText("RESULT: "+op.HashToString(result));
     }
     else if(e.getSource()==sub)
     {
      Polynom result=op.subPoli(polynom1,polynom2);
      res.setText("RESULT: "+op.HashToString(result));
     }
     else if(e.getSource()==multiply)
     {
      Polynom result=op.multiply(polynom1,polynom2);
      res.setText("RESULT: "+op.HashToString(result));
     }
     else if(e.getSource()==divide)
     {
      Polynom[] result=op.divide(polynom1,polynom2);
      if(result[1].polynom.isEmpty())
       res.setText("RESULT: Q:"+op.HashToString(result[0])+"   R: 0");
      else
      res.setText("RESULT: Q:"+op.HashToString(result[0])+" R: "+op.HashToString(result[1]));
     }
     else if(e.getSource()==inte)
     {
     // p2.setText("");
      Polynom result=op.integral(polynom1);
      res.setText("RESULT: "+op.HashToString(result));
     }
     else if(e.getSource()==deri)
     {
     // p2.setText("");
      Polynom result=op.derivation(polynom1);
      res.setText("RESULT: "+op.HashToString(result));
     }
     else if(e.getSource()==cButton)
     {
      p1.setText("");
      p2.setText("");
      res.setText("RESULT");
     }

    }
    public static void main(String[] args)
    {
        new Calculator();
    }

}
