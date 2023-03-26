package org.example.Logic;
import org.example.Data.Polynom;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Operatie {


    public Polynom addPoli(Polynom a, Polynom b)
    {
        for(Map.Entry<Integer, Double> entry: b.polynom.entrySet())
        {
            if(a.polynom.containsKey(entry.getKey()))
            {
                Double s= a.polynom.get(entry.getKey());
                s+=entry.getValue();
                if(s.compareTo(0.0)==0)
                    a.polynom.remove(entry.getKey());
                else
                    a.polynom.put(entry.getKey(),s);
            }
            else a.polynom.put(entry.getKey(),entry.getValue());
        }
        return a;
    }

    public Polynom subPoli(Polynom a, Polynom b)
    {
        for(Map.Entry<Integer, Double> entry: b.polynom.entrySet())
        {
            if(a.polynom.containsKey(entry.getKey()))
            {
                Double s= a.polynom.get(entry.getKey());
                s-=entry.getValue();
                s=Math.round(s*100)/100.0;
                if(s.compareTo(0.0)==0)
                    a.polynom.remove(entry.getKey());
                else
                    a.polynom.put(entry.getKey(),s);
            }
            else a.polynom.put(entry.getKey(),-entry.getValue());
        }
        return a;
    }

    public Polynom derivation(Polynom a)
    {
        Polynom rez=new Polynom();

        for(Map.Entry<Integer,Double> entry : a.polynom.entrySet())
        {
            Integer k=entry.getKey();
            Double val=entry.getValue();
            rez.polynom.put(k-1,k*val);
        }

        return rez;
    }
    public Polynom integral(Polynom a)
    {
        Polynom rez=new Polynom();
        a.polynom.forEach((k,val) ->
        {
            Double s=val/(k+1);
            s=Math.round(s*100)/100.0;
            rez.polynom.put(k+1,s);
        });
        return rez;
    }

    public Polynom multiply(Polynom a, Polynom b)
    {
        Polynom rez=new Polynom();

        a.polynom.forEach((ka,va) ->
        {
            b.polynom.forEach((kb,vb) ->
            {
                Integer pow=ka+kb;
                Double coef=va*vb;
                if(rez.polynom.containsKey(pow))
                {
                    Double s=coef+rez.polynom.get(pow);
                    rez.polynom.replace(pow,s);
                }
                else rez.polynom.put(pow,coef);
            });
        });
        return rez;
    }

    ////////////////////////////////////////
    static Integer degre(Polynom a)
    {
        Integer c = 0;
        for (Map.Entry<Integer, Double> entry : a.polynom.entrySet()) {
            c= entry.getKey();
        }

        return c;
    }

    static Polynom divLead(Polynom r, Polynom d)
    {
        Polynom t=new Polynom();
        Integer key =degre(r)-degre(d);
        Double val=r.polynom.get(degre(r)) / d.polynom.get(degre(d));
        val=Math.round(val*100)/100.0;
        t.polynom.put(key,val);
        return t;
    }
    //////////////////////////////////////////////
    public Polynom[] divide(Polynom n, Polynom d)
    {
        Polynom q =new Polynom();
        Polynom r=n;

        while(r.polynom.size()!=0 && degre(r)>=degre(d))
        {
            Polynom t=divLead(r,d);
            q=addPoli(q,t);
            r=subPoli(r,multiply(t,d));
        }
        Polynom[] result={q,r};
        return result;
    }
    public String HashToString(Polynom p)
    {
        String s="";
        for(Map.Entry<Integer, Double> entry: p.polynom.entrySet())
        {
            if(entry.getValue()>0)
            s+="+"+entry.getValue() + "X^" + entry.getKey();
            else s+=entry.getValue() + "X^" + entry.getKey();
        }
        char c=s.charAt(0);
        if(Character.compare(c, '+')==0)
            s=s.substring(1);

        return s;
    }

}

