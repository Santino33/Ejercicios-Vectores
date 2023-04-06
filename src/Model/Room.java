package Model;

import java.util.Arrays;

public class Room {

    //Su objetivo en este kata es implementar una función de diferencia, que resta una lista de otra y devuelve el resultado.
    //
    //Debe eliminar todos los valores de la lista a, que están presentes en la lista b manteniendo su orden.
    public int[] arrayDiff(int[] arrayA, int[] arrayB){
        String StArrayA = ArraytoString(arrayA);
        String StArrayB = ArraytoString(arrayB);
        String StArrayC = deleteChars(StArrayA, StArrayB);

        return stringToIntArray(StArrayC);
    }

    public String ArraytoString(int[] arrayA){
        String numbers = "";

        for (int j : arrayA) {
            numbers += j;
        }
        return numbers;
    }

    public int[] stringToIntArray(String numbers) {
        int[] intArray = new int[numbers.length()]; // Crear un nuevo array de tipo int con la misma longitud que el String de entrada
        int index = 0; // Inicializar el índice del array de ints
        boolean isNegative = false; // Variable booleana para indicar si el número es negativo

        // Recorrer cada carácter en el String de entrada
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i); // Obtener el carácter actual

            if (c == '-') { // Si el carácter actual es un signo menos, el número es negativo
                isNegative = true;
            } else if (Character.isDigit(c)) { // Si el carácter actual es un dígito, convertirlo a un int y agregarlo al array de ints
                int num = Character.getNumericValue(c);
                if (isNegative) {
                    num = -num;
                    isNegative = false;
                }
                intArray[index++] = num;
            }
        }
        // Redimensionar el array de ints si no se han utilizado todas las posiciones
        if (index < intArray.length) {
            int[] resizedArray = new int[index];
            System.arraycopy(intArray, 0, resizedArray, 0, index);
            intArray = resizedArray;
        }

        return intArray; // Devolver el array de ints resultante
    }

    public String deleteChars(String text, String chars){
        String safeDeleted = "";

        for(int i = 0; i < text.length(); i++){
            boolean isInside = false; // Establecer isInside en false en cada iteración del bucle externo
            for (int j = 0; j < chars.length(); j++){
                if (text.charAt(i) == chars.charAt(j)) {
                    isInside = true;
                    break;
                }
            }
            if (!isInside) {
                safeDeleted += text.charAt(i);
            }
            System.out.println("sf: " + safeDeleted);
        }
        return safeDeleted;
    }

    public String highestAndLowestArray(int[] myArray){
        int comparatorHighest = myArray[0];
        int comparatorLowest = myArray[0];

        for(int i=0;i<myArray.length;i++){
            if(myArray[i] > comparatorHighest) comparatorHighest = myArray[i];
            if(myArray[i] < comparatorLowest) comparatorLowest = myArray[i];
        }
        return ""+comparatorHighest + ", " + comparatorLowest;
    }

    public int[] larguestNumbers(int n, int [] myArray){
        int[] topNumbers = new int[n];
        int comparator = 0;
        for (int i =0; i < n; i++){
            for (int j =0; j<myArray.length;j++){
                if(myArray[j] > comparator) comparator = myArray[j];
            }
            myArray = deleteIntFromArray(comparator, myArray);
            topNumbers[i] = comparator;
            comparator = -1000;
        }
        return topNumbers;
    }

    public int[] deleteIntFromArray(int num, int[] myArray){

        int[] exitArray = new int[myArray.length-1];
        int j =0;
        for(int i =0; i<myArray.length;i++){
            if(myArray[i] != num) {
                exitArray[j] = myArray[i];
                j++;
            }
        }
        return exitArray;
    }



}
