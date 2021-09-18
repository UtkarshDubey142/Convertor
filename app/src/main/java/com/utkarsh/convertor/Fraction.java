package com.utkarsh.convertor;

import android.util.Log;
import android.widget.TextView;

public class Fraction extends IsValid{

    // public variables -->
    String beforeDecimalInt = "";
    float afterDecimalFloat = 0.0f;

    // For Final-Result (Converted Value)
    @Override
    public String getResult()
    {
        return beforeDecimalInt;
    }

    // Checking Decimal-Fraction Input and Converting
    public void decimalFraction (String decimalFractionInput , String resultType)
    {
        if (!(decimalFractionInput.matches("[0.0-9.0]*")) ||  (decimalFractionInput.isEmpty()) || (decimalFractionInput.indexOf(".") == -1) || (decimalFractionInput.indexOf(".") == decimalFractionInput.length()-1))
        {
            return;
        }

        beforeDecimalInt = "";
        // checking the input -->
        if (decimalFractionInput.startsWith("."))
        {
            afterDecimalFloat = valueAfterDecimal(decimalFractionInput);
            switch (resultType)
            {
                case "Hexadecimal":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 16 , "Hexadecimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Octal":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 8 , "Octal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Binary":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 2 , "Binary"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                default:
                    return;
            }
        }
        else
        {
            switch (resultType)
            {
                case "Hexadecimal":
                    beforeDecimalInt = valueBeforeDecimal(decimalFractionInput);
                    beforeDecimalInt = decimalToBinary(beforeDecimalInt);
                    beforeDecimalInt = addAdditionalZero(beforeDecimalInt , beforeDecimalInt.length() , 4);
                    beforeDecimalInt = binaryToOthers("Hexadecimal" , beforeDecimalInt);
                    afterDecimalFloat = valueAfterDecimal(decimalFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 16 , "Hexadecimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Octal":
                    beforeDecimalInt = valueBeforeDecimal(decimalFractionInput);
                    beforeDecimalInt = decimalToBinary(beforeDecimalInt);
                    beforeDecimalInt = addAdditionalZero(beforeDecimalInt , beforeDecimalInt.length() , 3);
                    beforeDecimalInt = binaryToOthers("Octal" , beforeDecimalInt);
                    afterDecimalFloat = valueAfterDecimal(decimalFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 8 , "Octal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Binary":
                    beforeDecimalInt = valueBeforeDecimal(decimalFractionInput);
                    beforeDecimalInt = decimalToBinary(beforeDecimalInt);
                    afterDecimalFloat = valueAfterDecimal(decimalFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 2 , "Binary"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                default:
                    return;
            }
        }
        //Log.i("decimalFraction" , beforeDecimalInt);
    }

    // Checking Octal-Fraction Input and Converting
    public void octalFraction (String octalFractionInput , String resultType)
    {
        if (!(octalFractionInput.matches("[0.0-7.0]*")) ||  (octalFractionInput.isEmpty()) || (octalFractionInput.indexOf(".") == -1) || (octalFractionInput.indexOf(".") == octalFractionInput.length()-1))
        {
            return;
        }

        beforeDecimalInt = "";
        // checking the input -->
        if (octalFractionInput.startsWith("."))
        {
            afterDecimalFloat = valueAfterDecimal(octalFractionInput);
            switch (resultType)
            {
                case "Hexadecimal":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 16 , "Hexadecimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Decimal":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 10 , "Decimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Binary":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 2 , "Binary"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                default:
                    return;
            }
        }
        else
        {
            switch (resultType)
            {
                case "Hexadecimal":
                    beforeDecimalInt = valueBeforeDecimal(octalFractionInput);
                    beforeDecimalInt = decimalToBinary(beforeDecimalInt);
                    beforeDecimalInt = addAdditionalZero(beforeDecimalInt , beforeDecimalInt.length() , 4);
                    beforeDecimalInt = binaryToOthers("Hexadecimal" , beforeDecimalInt);
                    afterDecimalFloat = valueAfterDecimal(octalFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 16 , "Hexadecimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Decimal":
                    beforeDecimalInt = valueBeforeDecimal(octalFractionInput);
                    beforeDecimalInt = octalToBinary( "Octal" , beforeDecimalInt);
                    beforeDecimalInt = toDecimal(beforeDecimalInt);
                    afterDecimalFloat = valueAfterDecimal(octalFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 10 , "Decimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Binary":
                    beforeDecimalInt = valueBeforeDecimal(octalFractionInput);
                    beforeDecimalInt = octalToBinary( "Octal" , beforeDecimalInt);
                    afterDecimalFloat = valueAfterDecimal(octalFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 2 , "Binary"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                default:
                    return;
            }
        }
        //Log.i("octalFraction" , beforeDecimalInt);
    }

    // Checking Binary-Fraction Input and Converting
    public void binaryFraction (String binaryFractionInput , String resultType)
    {
        if (!(binaryFractionInput.matches("[0.0-1.0]+")) || (binaryFractionInput.isEmpty()) || (binaryFractionInput.indexOf(".") == -1) || (binaryFractionInput.indexOf(".") == binaryFractionInput.length()-1))
        {
            return;
        }

        beforeDecimalInt = "";
        // checking the input -->
        if (binaryFractionInput.startsWith("."))
        {
            afterDecimalFloat = valueAfterDecimal(binaryFractionInput);
            switch (resultType)
            {
                case "Hexadecimal":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 16 , "Hexadecimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Decimal":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 10 , "Decimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Octal":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 8 , "Octal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                default:
                    return;
            }
        }
        else
        {
            switch (resultType)
            {
                case "Hexadecimal":
                    beforeDecimalInt = valueBeforeDecimal(binaryFractionInput);
                    beforeDecimalInt = addAdditionalZero(beforeDecimalInt , beforeDecimalInt.length() , 4);
                    beforeDecimalInt = binaryToOthers("Hexadecimal" , beforeDecimalInt);
                    afterDecimalFloat = valueAfterDecimal(binaryFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 16 , "Hexadecimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Decimal":
                    beforeDecimalInt = valueBeforeDecimal(binaryFractionInput);
                    beforeDecimalInt = toDecimal(beforeDecimalInt);
                    afterDecimalFloat = valueAfterDecimal(binaryFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 10 , "Decimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Octal":
                    beforeDecimalInt = valueBeforeDecimal(binaryFractionInput);
                    beforeDecimalInt = addAdditionalZero(beforeDecimalInt , beforeDecimalInt.length() , 3);
                    beforeDecimalInt = binaryToOthers("Octal" , beforeDecimalInt);
                    afterDecimalFloat = valueAfterDecimal(binaryFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 8 , "Octal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                default:
                    return;
            }
        }
        //Log.i("binaryFraction" , beforeDecimalInt);
    }

    public void hexaFraction (String hexaFractionInput , String resultType)
    {
        if (!(hexaFractionInput.matches("[0.0-9.0A-F]*")) || hexaFractionInput.isEmpty()  )
        {
            return;
        }
        if ((hexaFractionInput.indexOf(".") == -1) || (hexaFractionInput.indexOf(".") == hexaFractionInput.length()-1) )
        {
            return;
        }

        beforeDecimalInt = "";
        // checking the input -->
        if (hexaFractionInput.startsWith("."))
        {
            afterDecimalFloat = hexaAfterDecimalValue(hexaFractionInput);
            switch (resultType)
            {
                case "Binary":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 2 , "Binary"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Decimal":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 10 , "Decimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Octal":
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 8 , "Octal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                default:
                    return;
            }
        }
        else
        {
            switch (resultType)
            {
                case "Binary":
                    beforeDecimalInt = valueBeforeDecimal(hexaFractionInput);
                    beforeDecimalInt = hexaToBinary( "Hexadecimal" , beforeDecimalInt , resultType);
                    afterDecimalFloat = hexaAfterDecimalValue(hexaFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 2 , "Binary"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Decimal":
                    beforeDecimalInt = valueBeforeDecimal(hexaFractionInput);
                    beforeDecimalInt = hexaToBinary( "Hexadecimal" , beforeDecimalInt , resultType);
                    beforeDecimalInt = toDecimal(beforeDecimalInt);
                    afterDecimalFloat = hexaAfterDecimalValue(hexaFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 10 , "Decimal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                case "Octal":
                    beforeDecimalInt = valueBeforeDecimal(hexaFractionInput);
                    beforeDecimalInt = hexaToBinary( "Hexadecimal" , beforeDecimalInt , resultType);
                    beforeDecimalInt = addAdditionalZero(beforeDecimalInt , beforeDecimalInt.length() , 3);
                    beforeDecimalInt = binaryToOthers("Octal" , beforeDecimalInt);

                    // for removing extra zero -->
                    if (beforeDecimalInt.length() > 1)
                    {
                        char fChar = beforeDecimalInt.charAt(0);
                        char sChar = beforeDecimalInt.charAt(1);

                        int fCharInt = Integer.parseInt(String.valueOf(fChar));
                        int sCharInt = Integer.parseInt(String.valueOf(sChar));

                        if ((fCharInt == 0) && (sCharInt > fCharInt))
                        {
                            beforeDecimalInt = beforeDecimalInt.replaceFirst("0" , "");
                        }
                    }

                    afterDecimalFloat = hexaAfterDecimalValue(hexaFractionInput); // << -- getting Value After Decimal
                    beforeDecimalInt = beforeDecimalInt + fractionMultiplication( afterDecimalFloat , 8 , "Octal"); // << -- Adding before Decimal & Multiply Decimal result
                    break;
                default:
                    return;
            }
        }
        //Log.i("hexaFraction" , beforeDecimalInt);
    }

    // To get value Before Decimal (46.22) >> (46) -->
    public String valueBeforeDecimal (String inputValue)
    {
        String tempFraction = "";
        for (int i = 0 ; i < inputValue.indexOf('.') ; i++)
        {
            tempFraction =  tempFraction + inputValue.charAt(i);
        }

        // value before ( . ) "Decimal point" -->
        Log.i("valueBeforeDecimal"  , tempFraction);
        return tempFraction;
    }

    // To get value After Decimal (46.22) >> (.22) -->
    public float valueAfterDecimal (String inputValue)
    {
        String tempFraction = "";
        for (int i = inputValue.indexOf('.') ; i < inputValue.length() ; i++)
        {
            tempFraction = tempFraction + inputValue.charAt(i);
        }

        // value after ( . ) "Decimal point" -->
        afterDecimalFloat = Float.parseFloat(tempFraction);

        Log.i("valueAfterDecimal" , tempFraction);
        return afterDecimalFloat;
    }

    // To get value After Decimal (46.22) >> (.22) [For hexaFraction Function() ] -->
    public float hexaAfterDecimalValue (String inputValue)
    {
        String tempFraction = "";
        String tempFractionCon = "";
        for (int i = inputValue.indexOf('.')+1 ; i < inputValue.length() ; i++)
        {
            if (inputValue.charAt(i) >= 'A' || inputValue.charAt(i) <= 'F')
            {
                tempFractionCon = hexaToBinary( "Hexadecimal" , Character.toString(inputValue.charAt(i)) , "Binary");
                tempFraction = tempFraction + toDecimal(tempFractionCon);
                Log.i("hexaAfterDecimalValue" , tempFraction);
                continue;
            }
            tempFraction = tempFraction + inputValue.charAt(i);
        }

        // value after ( . ) "Decimal point" -->
        tempFraction = "." + tempFraction;
        afterDecimalFloat = Float.parseFloat(tempFraction);

        return afterDecimalFloat;
    }

    // Multiply the values after Decimal (.432)
    public String fractionMultiplication (float afterDecimalValue , int multiplyTypeValue , String multiplyType)
    {
        int value = 0;
        String fractionMutilResult = ".0";
        for (byte i = 0 ; i < 3 ; i++)
        {
            afterDecimalValue = afterDecimalValue * multiplyTypeValue;
            value = Integer.parseInt(valueBeforeDecimal(String.valueOf(afterDecimalValue)));
            Log.i("fractionMultiplication" , fractionMutilResult + "  " +String.valueOf(value));
            if (multiplyType.equals("Hexadecimal") && (value >= 10 && value <= 15))
            {
                fractionMutilResult = fractionMutilResult + relativeHexaChar(value);
                afterDecimalValue = valueAfterDecimal(String.valueOf(afterDecimalValue));
                continue;
            }
            fractionMutilResult = fractionMutilResult + valueBeforeDecimal(String.valueOf(afterDecimalValue));
            afterDecimalValue = valueAfterDecimal(String.valueOf(afterDecimalValue));
        }

        return  fractionMutilResult;
    }
}
