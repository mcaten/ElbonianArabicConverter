package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    // TODO Add more test cases
    @Test
    public void outofOrder() throws MalformedNumberException, ValueOutOfBoundsException {
        boolean b = false;
        try {
            ElbonianArabicConverter converter = new ElbonianArabicConverter("MDE");
        } catch(MalformedNumberException e) {
            b = true;
        }

        assertTrue(b);
    }

    @Test
    public void convertElbonian() {
        String s = "";
        try {
            ElbonianArabicConverter converter = new ElbonianArabicConverter("1026");
            s = converter.toElbonian();
        } catch(MalformedNumberException | ValueOutOfBoundsException e) {
            e.printStackTrace();
        }

        boolean b = s.equals("MXXK");
        //System.out.print(s);
        assertTrue(b);
    }

}
