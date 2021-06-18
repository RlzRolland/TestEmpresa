package org.rolland;

import java.util.Random;

public class Persona {
    private String nombre = "";
    private int edad = 0;
    private String NSS;
    private char sexo = 'H';
    private double peso = 0.0;
    private double altura = 0.0;

    private final String CARACTERES_DISPONIBLES = "0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVv" +
            "WwXxYyZz";

    //constructor por defecto y constructor por atributos
    public Persona() {
        this.NSS = this.generaNSS();
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this();
        this.nombre = nombre;
        this.edad = edad;
        this.NSS = this.generaNSS();
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    //getter y setter para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNSS() {
        return NSS;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    //metodos de la clase persona

    public byte calcularImc() {
        byte dato = 0;
        double imc = (this.peso / (Math.pow(this.altura, 2)));

        if (this.sexo == 'H') {
            if (imc < 20) {
                System.out.println("Su imc es de: " + imc);
                dato = -1;
            }
            else if (imc >= 20 && imc <= 25) {
                System.out.println("Su imc es de: " + imc);
                dato = 0;
            }
            else if (imc > 25) {
                System.out.println("Su imc es de: " + imc);
                dato = 1;
            }
        }
        else if (this.sexo == 'M') {
            if (imc < 19) {
                System.out.println("Su imc es de: " + imc);
                dato = -1;
            }
            else if (imc >= 19 && imc <= 24) {
                System.out.println("Su imc es de: " + imc);
                dato = 0;
            }
            else if (imc > 24) {
                System.out.println("Su imc es de: " + imc);
                dato = 1;
            }
        }

        return dato;
    }

    public boolean esMayorDeEdad() {
        if (this.edad >= 18) {
            return true;
        }

        return false;
    }

    public boolean comprobarSexo(char sexo) {
        if (sexo == 'M' || sexo == 'H') {
            return true;
        }

        return false;
    }

    public String generaNSS() {
        final byte longitud = 8;
        byte i = 0;
        Random r = new Random();

        StringBuilder sb = new StringBuilder();

        while (i < longitud) {
            sb.append(CARACTERES_DISPONIBLES.charAt(r.nextInt(CARACTERES_DISPONIBLES.length())));
            i++;
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Persona {" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", NSS='" + getNSS() + '\'' +
                ", sexo=" + getSexo() +
                ", peso=" + getPeso() +
                ", altura=" + getAltura() +
                '}';
    }
}
