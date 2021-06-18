package org.rolland;

import java.util.Scanner;

public class PersonaMain {
    public static void main(String[] args) {
        Persona p = new Persona();
        Scanner entrada = new Scanner(System.in);

        System.out.println("============= EXAMEN JAVA =============");

        System.out.print("Ingrese su nombre: ");
        p.setNombre(entrada.nextLine());

        System.out.print("Ingrese su edad: ");
        p.setEdad(entrada.nextInt());

        boolean sexoCorrecto = false;
        char sexo = 'A';

        while (!sexoCorrecto) {
            System.out.print("Ingrese su sexo [H, M]: ");
            sexo = entrada.next().charAt(0);
            sexoCorrecto = p.comprobarSexo(sexo);
        }

        System.out.print("Ingrese su peso en kilos: ");
        p.setPeso(entrada.nextDouble());

        System.out.print("Ingrese su altura en metros: ");
        p.setAltura(entrada.nextDouble());

        System.out.println("=======================================");

        retornarImc(p);

        mensajeEdad(p);

        System.out.println(p);

        System.out.println("=======================================");
        System.out.println("Objeto persona creado con constructor y get");

        Persona persona = new Persona("eduardo", 19, 'H', 71.2, 1.63);

        retornarImc(persona);
        mensajeEdad(persona);
        System.out.println(persona);
    }

    public static void retornarImc(Persona p) {
        byte imc = p.calcularImc();

        if (imc == -1) {
            System.out.println("Su IMC responde que: Se encuentra debajo de su peso ideal");
        }
        else if (imc == 0) {
            System.out.println("Su IMC responde que: Se encuentra en su peso ideal");
        }
        else if (imc == 1) {
            System.out.println("Su IMC responde que: Tiene sobrepeso");
        }
    }

    public static void mensajeEdad(Persona p) {
        if (p.esMayorDeEdad()) {
            System.out.println("Usted es mayor de edad");
        }
        else {
            System.out.println("Usted es menor de edad");
        }
    }
}
