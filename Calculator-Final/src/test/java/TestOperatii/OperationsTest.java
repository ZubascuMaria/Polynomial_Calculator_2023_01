package TestOperatii;
import org.example.Data.Polynom;
import org.example.Logic.Operatie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperationsTest {
    @Test
    public void addTest(){
        Operatie op=new Operatie();
        Polynom result=op.addPoli(new Polynom("3x^2"), new Polynom("-4x^2"));
        String actualResult= op.HashToString(result);
        assertEquals("-1.0X^2", actualResult);
    }
    @Test
    public void addTestFail(){
        Operatie op=new Operatie();
        Polynom result=op.addPoli(new Polynom("5x^2"), new Polynom("x^3"));
        String actualResult= op.HashToString(result);
        assertEquals("-1.0X^2", actualResult);
    }
    @Test
    public void subTest(){
        Operatie op=new Operatie();
        Polynom result=op.subPoli(new Polynom("5x^2+5"), new Polynom("x^3+7"));
        String actualResult= op.HashToString(result);
        assertEquals("-2.0X^0+5.0X^2-1.0X^3", actualResult);
    }
    @Test
    public void subTestFail(){
        Operatie op=new Operatie();
        Polynom result=op.subPoli(new Polynom("5x^2+5"), new Polynom("x^3+7"));
        String actualResult= op.HashToString(result);
        assertEquals("-2.0X^0", actualResult);
    }
    @Test
    public void derivationTest(){
        Operatie op=new Operatie();
        Polynom result=op.derivation(new Polynom("5x^2+5x"));
        String actualResult= op.HashToString(result);
        assertEquals("5.0X^0+10.0X^1", actualResult);
    }
    @Test
    public void derivationTestFail(){
        Operatie op=new Operatie();
        Polynom result=op.derivation(new Polynom("5x^2+5x"));
        String actualResult= op.HashToString(result);
        assertEquals("5.0X^0+30.0X^1", actualResult);
    }
    @Test
    public void integralTest(){
        Operatie op=new Operatie();
        Polynom result=op.integral(new Polynom("8x^3+5x^2"));
        String actualResult= op.HashToString(result);
        assertEquals("1.67X^3+2.0X^4", actualResult);
    }
    @Test
    public void integralTestFail(){
        Operatie op=new Operatie();
        Polynom result=op.integral(new Polynom("8x^3+5x^2"));
        String actualResult= op.HashToString(result);
        assertEquals("1.67X^3+2.0X^3", actualResult);
    }
    @Test
    public void multiplyTest(){
        Operatie op=new Operatie();
        Polynom result=op.multiply(new Polynom("3x^2-x+1"),new Polynom("+x-2"));
        String actualResult= op.HashToString(result);
        assertEquals("-2.0X^0+3.0X^1-7.0X^2+3.0X^3", actualResult);
    }
    @Test
    public void multiplyTestFail(){
        Operatie op=new Operatie();
        Polynom result=op.multiply(new Polynom("3x^2-x+1"),new Polynom("+x-2"));
        String actualResult= op.HashToString(result);
        assertEquals("-2.0X^0+3.0X^1-7.0X^2", actualResult);
    }
    @Test
    public void divideTest(){
        Operatie op=new Operatie();
        Polynom[] result=op.divide(new Polynom("x^3-2x^2+6x-5"),new Polynom("x^2-1"));
        String actualResultQ= op.HashToString(result[0]);
        String actualResultR= op.HashToString(result[1]);
        String actualResult="Q: "+actualResultQ+" R: "+actualResultR;
        assertEquals("Q: -2.0X^0+1.0X^1 R: -7.0X^0+7.0X^1", actualResult);
    }
    @Test
    public void divideTestFail(){
        Operatie op=new Operatie();
        Polynom[] result=op.divide(new Polynom("x^3-2x^2+6x-5"),new Polynom("x^2-1"));
        String actualResultQ= op.HashToString(result[0]);
        String actualResultR= op.HashToString(result[1]);
        String actualResult="Q: "+actualResultQ+" R: "+actualResultR;
        assertEquals("Q: -2.0X^0 R: 7.0X^1", actualResult);
    }

}