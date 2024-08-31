/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arreglosp;
import java.util.Arrays;
import java.util.Comparator;
/**
 *
 * @author strdh
 */
public class ArreglosP {

    public static String arreglosp(String[] frases) {
        Pair[] pairs = new Pair[frases.length];
        for (int i = 0; i < frases.length; i++){
            String frase = frases[i];
            int let = frase.length();
            int j = let - 1;
            while (j >= 0 && Character.isDigit(frase.charAt(j))){
                j--;
            }
            String palabra = frase.substring(0, j + 1);
            int num = Integer.parseInt(frase.substring(j + 1));
            pairs[i] = new Pair(palabra, num);
        }
        Arrays.sort(pairs, Comparator.comparingInt(Pair::getNum));
        StringBuilder result = new StringBuilder();
        for (Pair pair : pairs){
            if(result.length() > 0){
                result.append(" ");
            }
            result.append(pair.getPalabra());
        }
        return result.toString();
    }
        static class Pair {
        private final String palabra;
        private final int num;

        public Pair(String palabra, int num) {
            this.palabra = palabra;
            this.num = num;
        }

        public String getPalabra() {
            return palabra;
        }

        public int getNum() {
            return num;
        }
    }
    public static void main(String[] args) {
        String[] frases = {"Estamos1", "practicando2", "la3", "programacion4", "orientada5", "a6", "objetos7"};
        String result = arreglosp(frases);
        System.out.println(result);
    }
}

