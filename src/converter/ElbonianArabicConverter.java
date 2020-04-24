package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Integer.parseInt;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        // TODO check to see if the number is valid, then set it equal to the string
        number = number.trim();

        try {
            int a = Integer.parseInt(number);
            checkInRange(number);
        } catch(NumberFormatException e) {
            // Not arabic number, check if it is Elbonian
            checkValidCharacters(number);
            checkDuplicates(number);
            checkOrder(number);

        }

        this.number = number;
    }

    private void checkInRange(String number) throws ValueOutOfBoundsException {
        int n = Integer.parseInt(number);
        if(n > 0 && n <= 2999) {}
        else {
            throw new ValueOutOfBoundsException("Number must be between 0 and 2999");
        }
    }

    public void checkValidCharacters(String number) throws MalformedNumberException {
        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
          if(c != 'M' && c != 'C' && c != 'X' && c != 'I' && c != 'D' && c != 'E' && c != 'Y' && c != 'Z' && c != 'J' && c != 'K') {
              throw new MalformedNumberException("Number should only contain valid characters");
          }
        }
    }

    public void checkDuplicates(String number) throws MalformedNumberException {
        int m = 0;
        int c = 0;
        int x = 0;
        int i = 0;
        int d = 0;
        int e = 0;
        int y = 0;
        int z = 0;
        int j = 0;
        int k = 0;
        for(int a = 0; a < number.length(); a++) {
            char ch = number.charAt(a);
            switch(ch) {
                case 'M':
                    m++;
                    break;
                case 'C':
                    c++;
                    break;
                case 'X':
                    x++;
                    break;
                case 'I':
                    i++;
                    break;
                case 'D':
                    d++;
                    break;
                case 'E':
                    e++;
                    break;
                case 'Y':
                    y++;
                    break;
                case 'Z':
                    z++;
                    break;
                case 'J':
                    j++;
                    break;
                case 'K':
                    k++;
            }
        }

        if(m > 2 || c > 2 || x > 2 || i > 2) {
            throw new MalformedNumberException("M, C, X, and I can only appear a maximum of 2 times in a number");
        }

        if(d > 1 || e > 1 || y > 1 || z > 1 || j > 1 || k > 1) {
            throw new MalformedNumberException("D, E, Y, Z, J, and K can only appear once in a number");
        }

        if(d == 1 && e == 1 && c != 0) {
            throw new MalformedNumberException("C cannot appear if D and E are in the number");
        }

        if(y == 1 && z == 1 && x != 0) {
            throw new MalformedNumberException("X cannot appear if Y and Z are in the number");
        }

        if(j == 1 && k == 1 && i != 0) {
            throw new MalformedNumberException("I cannot appear if J and K are in the number");
        }
    }

    public void checkOrder(String number) throws MalformedNumberException {
        int m = 0;
        int c = 0;
        int x = 0;
        int i = 0;
        int d = 0;
        int e = 0;
        int y = 0;
        int z = 0;
        int j = 0;
        int k = 0;
        for(int a = 0; a < number.length(); a++) {
            char ch = number.charAt(a);
            switch(ch) {
                case 'M':
                    if(c != 0 || x != 0 || i != 0 || d != 0 || e != 0 || y != 0 || z != 0 || j != 0 || k != 0){
                        throw new MalformedNumberException("Numbers not in proper order");
                    }
                    m++;
                    break;
                case 'C':
                    if(x != 0 || i != 0 || y != 0 || z != 0 || j != 0 || k != 0){
                        throw new MalformedNumberException("Numbers not in proper order");
                    }
                    c++;
                    break;
                case 'X':
                    if(i != 0 || j != 0 || k != 0){
                        throw new MalformedNumberException("Numbers not in proper order");
                    }

                    x++;
                    break;
                case 'I':
                    i++;
                    break;
                case 'D':
                    if(c != 0 || x != 0 || i != 0 || y != 0 || z != 0 || j != 0 || k != 0){
                        throw new MalformedNumberException("Numbers not in proper order");
                    }
                    d++;
                    break;
                case 'E':
                    if(c != 0 || x != 0 || i != 0 || d != 0 || y != 0 || z != 0 || j != 0 || k != 0){
                        throw new MalformedNumberException("Numbers not in proper order");
                    }

                    e++;
                    break;
                case 'Y':
                    if(x != 0 || i != 0 || j != 0 || k != 0){
                        throw new MalformedNumberException("Numbers not in proper order");
                    }
                    y++;
                    break;
                case 'Z':
                    if(x != 0 || i != 0 || y != 0 || j != 0 || k != 0){
                        throw new MalformedNumberException("Numbers not in proper order");
                    }
                    z++;
                    break;
                case 'J':
                    if(i != 0){
                        throw new MalformedNumberException("Numbers not in proper order");
                    }
                    j++;
                    break;
                case 'K':
                    if(i != 0 || j != 0 ){
                        throw new MalformedNumberException("Numbers not in proper order");
                    }
                    k++;
            }
        }
    }



    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        int result = 0;
        try {
          return Integer.parseInt(number);
        } catch(NumberFormatException e) {
            for(int a = 0; a < number.length(); a++) {
                char ch = number.charAt(a);
                switch(ch) {
                    case 'M':
                        result += 1000;
                        break;
                    case 'C':
                        result += 100;
                        break;
                    case 'X':
                        result += 10;
                        break;
                    case 'I':
                        result += 1;
                        break;
                    case 'D':
                        result += 300;
                        break;
                    case 'E':
                        result += 600;
                        break;
                    case 'Y':
                        result += 30;
                        break;
                    case 'Z':
                        result += 60;
                        break;
                    case 'J':
                        result += 3;
                        break;
                    case 'K':
                        result += 6;
                }
            }
        }
        return result;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        String result = "";
        try {
            checkValidCharacters(number);
            checkDuplicates(number);
            checkOrder(number);
            return number;
        } catch(MalformedNumberException e) {
            int n = Integer.parseInt(number);
            while(n > 0) {
                if(n / 1000 > 0) {
                    result += "M";
                    n -= 1000;
                }

                else if(n / 600 > 0) {
                    result += "E";
                    n -= 600;
                }

                else if(n / 300 > 0) {
                    result += "D";
                    n -= 300;
                }

                else if(n / 100 > 0) {
                    result += "C";
                    n -= 100;
                }

                else if(n / 60 > 0) {
                    result += "Z";
                    n -= 60;
                }

                else if(n / 30 > 0) {
                    result += "Y";
                    n -= 30;
                }

                else if(n / 10 > 0) {
                    result += "X";
                    n -= 10;
                }

                else if(n / 6 > 0) {
                    result += "K";
                    n -= 6;
                }

                else if(n / 3 > 0) {
                    result += "J";
                    n -= 3;
                }

                else {
                    result += "I";
                    n--;
                }
            }
        }

        return result;
    }

}
