package org.example.Data;

import com.sun.jdi.DoubleValue;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynom {
    public HashMap<Integer,Double> polynom=new HashMap<>();

    public Polynom(String input) {
       Pattern p = Pattern.compile( "([+-]?[\\d\\.]*)([a-zA-Z]?)\\^?(\\d*)");
        Matcher m = p.matcher( input );
        while (m.find()) {
                if (m.group(1) != "" && m.group() != "" && m.group(3) != "") //group 1,2,3
                {
                    if (m.group(1).equals("-"))
                        this.polynom.put(Integer.valueOf(m.group(3)), Double.valueOf(-1));  //cazul -x^
                    else if (m.group(1).equals("+"))
                        this.polynom.put(Integer.valueOf(m.group(3)), Double.valueOf(1)); //cazul x^
                    else
                        this.polynom.put(Integer.valueOf(m.group(3)), Double.valueOf(m.group(1)));
                } else if (m.group(1) != "" && m.group(2) != "" && m.group(3) == "") //group 1 2
                {
                    if (m.group(1).equals("-")) this.polynom.put(1, Double.valueOf(-1));  //cazul -x
                    else if (m.group(1).equals("+")) this.polynom.put(1, Double.valueOf(1)); //cazul +x
                    else this.polynom.put(1, Double.valueOf(m.group(1)));
                } else if (m.group(1) != "" && m.group(2) == "" && m.group(3) == "") //group 1
                {
                    this.polynom.put(0, Double.valueOf(m.group(1)));
                } else if (m.group(1) == "" && m.group(2) != "" && m.group(3) != "")
                    this.polynom.put(Integer.valueOf(m.group(3)), Double.valueOf(1));
        }
    }
    public Polynom(){}

}
