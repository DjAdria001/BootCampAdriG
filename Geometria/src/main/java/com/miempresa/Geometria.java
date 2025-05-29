package com.miempresa;

public class Geometria {

    public int areacuadrado(int lado) {
        return lado * lado;
    }

    public double areacirculo(int radio) {
        return Math.PI * radio * radio;
    }

    public int areatriangulo(int base, int altura) {
        return (base * altura) / 2;
    }

    public int arearectangulo(int base, int altura) {
        return base * altura;
    }

    public int areapentagono(int perimetro, int apotema) {
        return (perimetro * apotema) / 2;
    }
}
