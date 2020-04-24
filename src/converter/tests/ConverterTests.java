package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.*;

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
    public void ElbonianToElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMDZYJI");
        assertEquals(converter.toElbonian(), "MMDZYJI");
    }

    @Test
    public void ElbonianToAribicTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter(" MMDZYJI");
        assertEquals(converter.toArabic(), 2394);
    }

    @Test
    public void ElbonianToAribicTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MXXK ");
        assertEquals(converter.toArabic(), 1026);
    }

    @Test
    public void ElbonianToAribicTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter(" I ");
        assertEquals(converter.toArabic(), 1);
    }

    @Test
    public void ElbonianToAribicTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMEDZYKJ");
        assertEquals(converter.toArabic(), 2999);
    }

    @Test
    public void AribicToAribicTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1026");
        assertEquals(converter.toArabic(), 1026);
    }

    @Test
    public void AribicToElbonianTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter(" 1026 ");
        assertEquals(converter.toElbonian(), "MXXK");
    }

    @Test
    public void AribicToElbonianTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter(" 2394");
        assertEquals(converter.toElbonian(), "MMDZYJI");
    }

    @Test
    public void AribicToElbonianTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2999 ");
        assertEquals(converter.toElbonian(), "MMEDZYKJ");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3000");;
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-10000");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("10000");
    }

    @Test
    public void valueInBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        try {
            ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        } catch(ValueOutOfBoundsException e) {
            fail();
        }
    }

    @Test
    public void valueInBoundsTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        try {
            ElbonianArabicConverter converter = new ElbonianArabicConverter("2999");
        } catch(ValueOutOfBoundsException e) {
            fail();
        }
    }

    @Test
    public void valueInBoundsTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        try {
            ElbonianArabicConverter converter = new ElbonianArabicConverter("1500");
        } catch(ValueOutOfBoundsException e) {
            fail();
        }
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberDuplicate() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMM");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberDuplicate2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DD");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberSpace() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MM DZYJI");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberLowerCase() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("mmdzyji");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumber() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("ABC");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberJKandI() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("KJI");
    }
    @Test(expected = MalformedNumberException.class)
    public void malformedNumberEDandC() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("EDC");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberZYandX() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("ZYX");
    }

    @Test
    public void correctFormedNumber() throws MalformedNumberException, ValueOutOfBoundsException {
        try {
            ElbonianArabicConverter converter = new ElbonianArabicConverter("MM");
        } catch(MalformedNumberException e) {
            fail();
        }
    }

    @Test
    public void correctFormedNumber2() throws MalformedNumberException, ValueOutOfBoundsException {
        try {
            ElbonianArabicConverter converter = new ElbonianArabicConverter("D");
        } catch(MalformedNumberException e) {
            fail();
        }
    }

    @Test
    public void correctFormedNumber3() throws MalformedNumberException, ValueOutOfBoundsException {
        try {
            ElbonianArabicConverter converter = new ElbonianArabicConverter("MMDZYJI");
        } catch(MalformedNumberException e) {
            fail();
        }
    }

//    @Test
//    public void valueOutOfBoundsTest4() throws MalformedNumberException, ValueOutOfBoundsException {
//        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");;
//    }

//    @Test
//    public void outofOrder() throws MalformedNumberException, ValueOutOfBoundsException {
//        boolean b = false;
//        try {
//            ElbonianArabicConverter converter = new ElbonianArabicConverter("MDE");
//        } catch(MalformedNumberException e) {
//            b = true;
//        }
//
//        assertTrue(b);
//    }

//    @Test
//    public void convertElbonian() {
//        String s = "";
//        try {
//            ElbonianArabicConverter converter = new ElbonianArabicConverter("1026");
//            s = converter.toElbonian();
//        } catch(MalformedNumberException | ValueOutOfBoundsException e) {
//            e.printStackTrace();
//        }
//
//        boolean b = s.equals("MXXK");
//        //System.out.print(s);
//        assertTrue(b);
//    }

}
