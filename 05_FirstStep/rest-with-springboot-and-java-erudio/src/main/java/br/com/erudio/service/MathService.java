// Pacote: br.com.erudio.service
package br.com.erudio.service;

import org.springframework.stereotype.Service;
import br.com.erudio.exceptions.UnsuportedMathOperationException;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {
        verifyNumber(numberOne, numberTwo);
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        verifyNumber(numberOne, numberTwo);
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double mult(String numberOne, String numberTwo) {
        verifyNumber(numberOne, numberTwo);
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {
        verifyNumber(numberOne, numberTwo);
        if (convertToDouble(numberTwo) == 0) {
            throw new UnsuportedMathOperationException("Cannot divide by zero!");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public Double sqrt(String numberOne) {
        verifyNumber(numberOne);
        return Math.sqrt(convertToDouble(numberOne));
    }

    private void verifyNumber(String... numbers) {
        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new UnsuportedMathOperationException("Please set a numeric value!");
            }
        }
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
