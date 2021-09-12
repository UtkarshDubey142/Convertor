package com.utkarsh.convertor;

import android.util.Log;

public class IsValid extends MainActivity{

    // public variable -->
    int inputStringLength;
    String resultString = "";

    // Functions for Checking Valid Input -->
    // Function 01 -->
    public void isHexadecimal (String hexaInput , String resultType)
    {
        if (!(hexaInput.matches("[A-F0-9]*")) || hexaInput.isEmpty())
        {
            return;
        }

        switch (resultType)
        {
            case "Decimal":
                resultString = hexaToBinary( "Hexadecimal" , hexaInput , resultType);
                resultString = toDecimal(resultString);
                break;
            case "Binary":
                resultString = hexaToBinary( "Hexadecimal" , hexaInput , resultType);
                break;
            case "Octal":
                resultString = hexaToBinary( "Hexadecimal" , hexaInput , resultType);
                resultString = addAdditionalZero(resultString , resultString.length() , 3);
                resultString = binaryToOthers("Octal" , resultString);

                // for removing extra zero -->
                if (resultString.length() > 1)
                {
                    char fChar = resultString.charAt(0);
                    char sChar = resultString.charAt(1);

                    int fCharInt = Integer.parseInt(String.valueOf(fChar));
                    int sCharInt = Integer.parseInt(String.valueOf(sChar));

                    if ((fCharInt == 0) && (sCharInt > fCharInt))
                    {
                        resultString = resultString.replaceFirst("0" , "");
                    }
                }
                break;
        }
        Log.i("isHexadecimal" , resultString + " " + resultType);
        resultString = "";
    }

    // Function 02 -->
    public void isOctal (String octalInput , String resultType)
    {
        if (!(octalInput.matches("[0-7]*")) || octalInput.isEmpty())
        {
            return;
        }

        switch (resultType)
        {
            case "Decimal":
                resultString = octalToBinary( "Octal" , octalInput);
                resultString = toDecimal(resultString);
                break;
            case "Hexadecimal":
                resultString = octalToBinary( "Octal" , octalInput);
                resultString = addAdditionalZero(resultString , resultString.length() , 4);
                resultString = binaryToOthers("Hexadecimal" , resultString);
                break;
            case "Binary":
                resultString = octalToBinary( "Octal" , octalInput);
                break;
        }
        Log.i("isOctal" ,  resultString);
        resultString = "";
    }

    // Function 03 -->
    public void isBinary (String binaryInput , String resultType)
    {
        if (!(binaryInput.matches("[0-1]+")) || binaryInput.isEmpty())
        {
            return;
        }
        inputStringLength = binaryInput.length();

        switch (resultType)
        {
            case "Hexadecimal":
                binaryInput = addAdditionalZero(binaryInput , inputStringLength , 4);
                resultString = binaryToOthers("Hexadecimal" , binaryInput);
                break;
            case "Octal":
                binaryInput = addAdditionalZero(binaryInput , inputStringLength , 3);
                resultString = binaryToOthers("Octal" , binaryInput);
                break;
            case "Decimal":
                resultString = toDecimal(binaryInput);
                break;
        }
        Log.i("isBinary" , resultString);
        resultString = "";
    }

    // Function 04 -->
    public void isDecimal (String decimalInput , String resultType)
    {
        if (!(decimalInput.matches("[0-9]*")) || decimalInput.isEmpty())
        {
            return;
        }

        switch (resultType)
        {
            case "Hexadecimal":
                resultString = decimalToBinary(decimalInput);
                resultString = addAdditionalZero(resultString , resultString.length() , 4);
                resultString = binaryToOthers("Hexadecimal" , resultString);
                break;
            case "Octal":
                resultString = decimalToBinary(decimalInput);
                resultString = addAdditionalZero(resultString , resultString.length() , 3);
                resultString = binaryToOthers("Octal" , resultString);
                break;
            case "Binary":
                resultString = decimalToBinary(decimalInput);
                break;
        }
        Log.i("isDecimal" , resultString);
        resultString = "";
    }

    // Additional Function for adding zeros -->
    public String addAdditionalZero (String inputString , int stringLength , int divideValue)
    {
        while (stringLength % divideValue != 0)
        {
            inputString = "0" + inputString;
            stringLength += 1;
        }
        return inputString;
    }

    // Converts Hexadecimal value into Binary -->
    public String hexaToBinary (String inputType , String inputString , String resultType)
    {
        int i = 0;
        char charValue;
        if (inputType.equals("Hexadecimal"))
        {
            while (i < inputString.length())
            {
                charValue = inputString.charAt(i);
                switch (charValue)
                {
                    case '0':
                        if (resultString.isEmpty())
                        {
                            resultString = "0000";
                            break;
                        }
                        resultString = resultString + "0000";
                        break;
                    case '1':
                        if (resultString.isEmpty())
                        {
                            resultString = "0001";
                            break;
                        }
                        resultString = resultString + "0001";
                        break;
                    case '2':
                        if (resultString.isEmpty())
                        {
                            resultString = "0010";
                            break;
                        }
                        resultString = resultString + "0010";
                        break;
                    case '3':
                        if (resultString.isEmpty())
                        {
                            resultString = "0011";
                            break;
                        }
                        resultString = resultString + "0011";
                        break;
                    case '4':
                        if (resultString.isEmpty())
                        {
                            resultString = "0100";
                            break;
                        }
                        resultString = resultString + "0100";
                        break;
                    case '5':
                        if (resultString.isEmpty())
                        {
                            resultString = "0101";
                            break;
                        }
                        resultString = resultString + "0101";
                        break;
                    case '6':
                        if (resultString.isEmpty())
                        {
                            resultString = "0110";
                            break;
                        }
                        resultString = resultString + "0110";
                        break;
                    case '7':
                        if (resultString.isEmpty())
                        {
                            resultString = "0111";
                            break;
                        }
                        resultString = resultString + "0111";
                        break;
                    case '8':
                        if (resultString.isEmpty())
                        {
                            resultString = "1000";
                            break;
                        }
                        resultString = resultString + "1000";
                        break;
                    case '9':
                        if (resultString.isEmpty())
                        {
                            resultString = "1001";
                            break;
                        }
                        resultString += "1001";
                        break;
                    case 'A':
                        if (resultString.isEmpty())
                        {
                            resultString = "1010";
                            break;
                        }
                        resultString = resultString + "1010";
                        break;
                    case 'B':
                        if (resultString.isEmpty())
                        {
                            resultString = "1011";
                            break;
                        }
                        resultString = resultString + "1011";
                        break;
                    case 'C':
                        if (resultString.isEmpty())
                        {
                            resultString = "1100";
                            break;
                        }
                        resultString = resultString + "1100";
                        break;
                    case 'E':
                        if (resultString.isEmpty())
                        {
                            resultString = "1110";
                            break;
                        }
                        resultString = resultString + "1110";
                        break;
                    case 'F':
                        if (resultString.isEmpty())
                        {
                            resultString = "1111";
                            break;
                        }
                        resultString = resultString + "1111";
                        break;
                }
                i = i + 1;
            }
        }
        return resultString;
    }

    // Function Converts Octal value into Binary
    public String octalToBinary (String inputType , String inputString )
    {
        int i = 0;
        char charValue;
        if (inputType.equals("Octal"))
        {
            while (i < inputString.length())
            {
                charValue = inputString.charAt(i);
                switch (charValue)
                {
                    case '0':
                        if (resultString.isEmpty())
                        {
                            resultString = "000";
                            break;
                        }
                        resultString = resultString + "000";
                        break;
                    case '1':
                        if (resultString.isEmpty())
                        {
                            resultString = "001";
                            break;
                        }
                        resultString = resultString + "001";
                        break;
                    case '2':
                        if (resultString.isEmpty())
                        {
                            resultString = "010";
                            break;
                        }
                        resultString = resultString + "010";
                        break;
                    case '3':
                        if (resultString.isEmpty())
                        {
                            resultString = "011";
                            break;
                        }
                        resultString = resultString + "011";
                        break;
                    case '4':
                        if (resultString.isEmpty())
                        {
                            resultString = "100";
                            break;
                        }
                        resultString = resultString + "100";
                        break;
                    case '5':
                        if (resultString.isEmpty())
                        {
                            resultString = "101";
                            break;
                        }
                        resultString = resultString + "101";
                        break;
                    case '6':
                        if (resultString.isEmpty())
                        {
                            resultString = "110";
                            break;
                        }
                        resultString = resultString + "110";
                        break;
                    case '7':
                        if (resultString.isEmpty())
                        {
                            resultString = "111";
                            break;
                        }
                        resultString = resultString + "111";
                        break;
                }
                i = i + 1;
            }
        }
        return resultString;
    }

    // Function converts Binary to Octal, Hexadecimal -->
    public String binaryToOthers (String inputType , String inputString)
    {
        int finalValue = 0;
        int i  = inputString.length()-1;
        int value = 1;
        short itration = 0;
        String convertedValue = "";
        char charValue;

        // Converting Binary value into Hexadecimal
        if (inputType.equals("Hexadecimal"))
        {
            while (i >= 0)
            {
                if (inputString.charAt(i) == '1')
                {
                    finalValue = finalValue + value;
                    i--;
                    value = value * 2;
                    itration += 1;
                }
                else
                {
                    finalValue = finalValue + 0;
                    i--;
                    value = value * 2;
                    itration += 1;
                }

                if (itration == 4)
                {
                    itration = 0;
                    value = 1;
                    // if addition goes > 9 (In Range A,B,C,D,E,F)
                    if (finalValue > 9)
                    {
                        if (convertedValue.isEmpty())
                        {
                            convertedValue = Character.toString(relativeHexaChar(finalValue));
                        }
                        else
                        {
                            charValue = relativeHexaChar(finalValue);
                            convertedValue = charValue + convertedValue;
                        }
                    }
                    else
                    {
                        if (convertedValue.isEmpty())
                        {
                            convertedValue = convertedValue + finalValue;
                        }
                        else
                        {
                            convertedValue = finalValue + convertedValue;
                        }
                    }
                    finalValue = 0;
                }
            }
        }

        // Converting Binary value into Octal
        if (inputType.equals("Octal"))
        {
            while (i >= 0)
            {
                if (inputString.charAt(i) == '1')
                {
                    finalValue = finalValue + value;
                    i--;
                    value = value * 2;
                    itration += 1;
                }
                else
                {
                    finalValue = finalValue + 0;
                    i--;
                    value = value * 2;
                    itration += 1;
                }

                if (itration == 3)
                {
                    itration = 0;
                    value = 1;
                    if (convertedValue.isEmpty())
                    {
                        convertedValue = convertedValue + finalValue;
                    }
                    else
                    {
                        convertedValue = finalValue + convertedValue;
                    }
                    finalValue = 0;
                }
            }
        }
        return  convertedValue;
    }

    // relative Char to hexadecimal Value
    public char relativeHexaChar (int hexaInt)
    {
        switch (hexaInt)
        {
            case 10:
                return  'A';
            case 11:
                return  'B';
            case 12:
                return  'C';
            case 13:
                return  'D';
            case 14:
                return  'E';
            case 15:
                return  'F';
        }
        return 'G';
    }

    // Function converts Binary value --> Decimal Value
    public String toDecimal (String inputString)
    {
        int finalValue = 0;
        int i  = inputString.length()-1;
        int value = 1;
        String convertedValue = "";

        // {..32,16,8,4,2} Not include '1'
        while (i > 0)
        {
            value = value * 2;
            i--;
        }

        // Traversing the converted input value -->
        while (i < inputString.length()-1)
        {
            if (inputString.charAt(i) == '1')
            {
                finalValue = finalValue + value;
                i++;
                value = value / 2;
            }
            else
            {
                finalValue = finalValue + 0;
                i++;
                value = value / 2;
            }
        }

        // For the last Value '1' -->
        if (inputString.charAt(i) == '1')
        {
            finalValue = finalValue + 1;
            i++;
        }
        else
        {
            finalValue = finalValue + 0;
            i++;
        }

        convertedValue = String.valueOf(finalValue);
        return  convertedValue;
    }

    public String decimalToBinary (String inputString)
    {
        int temp  = 0;
        int value = 1;
        String convertedValue = "";

        // Constraint
        if (inputString.length() == 1 && inputString.equals("1"))
        {
            return inputString;
        }
        if (inputString.length() == 1 && inputString.equals("0"))
        {
            return inputString;
        }

        // inputString --> integer value
        int decimalInt = Integer.parseInt(inputString);
        // {..32,16,8,4,2} Not include '1'
        while (true)
        {
            value = value * 2;
            if (value > decimalInt)
            {
                break;
            }
        }

        value = value/2;
        // Converting Decimal --> Binary
        while (value > 0) // temp != decimalInt
        {
            temp = temp + value;
            if (temp > decimalInt)
            {
                temp = temp - value;
                convertedValue = convertedValue + "0";
                value = value/2;
                continue;
            }
            convertedValue = convertedValue + "1";
            value = value/2;
        }

        return convertedValue;
    }

}
