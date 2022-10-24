package com.example.sudoku;

import java.util.Arrays;

public class SudokuModel {
    private static int[][] matriu=new int[9][9];

    private int getVal(int fila,int columna){
        return matriu[fila][columna];
    };
    private int setVal(int valor,int fila,int columna){
        if(valor<0||valor>9){
            this.matriu[fila][columna]=valor;
            return matriu[fila][columna];
        }
        return matriu[fila][columna];
    }
    private boolean comprovaFila(int fila){
        int[] temp=new int[9];
        for(int i=0;i<matriu.length;i++){
            if(Arrays.asList(temp).contains(matriu[fila][i]) ){
                return false;
            }

            temp[i]=(matriu[fila][i]);

        }
        return true;
    }
    private boolean comprovaCol(int columna){

        int[] temp=new int[9];
        for(int i=0;i<matriu.length;i++){
            if(Arrays.asList(temp).contains(matriu[i][columna]) ){
                return false;
            }

            temp[i]=(matriu[i][columna]);

        }
        return true;
    }
    private boolean comprovaQuad(int columna,int fila){
        if(comprovaCol(columna) && comprovaFila(fila)){

            return true;
        }
        return false;
    }
    private void creaPartida(){
        boolean bucle=true;
        int contador=0;
        while(bucle){
            int i= (int) (Math.random()*9);
            int j = (int) (Math.random()*9);
            int v=(int) (Math.random()*9);
            if(getVal(i,j)==0 && v>0){

                setVal(v,i,j);
                if(comprovaFila(i) && comprovaCol(j)){
                    contador++;
                }
                else{
                    setVal(0,i,j);
                }
        }
                if(contador==20){
                    bucle=false;
                }
        }
    }
}
