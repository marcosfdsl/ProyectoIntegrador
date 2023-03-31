package inmueble;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);

		System.out.println("MENÚ DE INMUEBLES");
		System.out.println("------------------");
		System.out.println("1. Crear Vivienda.");
		System.out.println("2. Crear Local.");
		System.out.println("------------------");
		
		int respuesta = sc.nextInt();
		
		while (respuesta!=1&&respuesta!=2) {
			System.out.println("Introduce una opción válida (1 o 2).");
			respuesta = sc.nextInt();
		}
		
		if (respuesta==1) {
			System.out.println("------------------");
			System.out.println("1. Crear casa.");
			System.out.println("2. Crear apartamento.");
			System.out.println("------------------");
			
			respuesta = sc.nextInt();
			
			while (respuesta!=1&&respuesta!=2) {
				System.out.println("Introduce una opción válida (1 o 2).");
				respuesta = sc.nextInt();
			}
			
			if (respuesta==1) {
				System.out.println("Se ha creado una casa.");
			}
			
			else if (respuesta==2) {
				System.out.println("Se ha creado un apartamento.");
			}
		}
		
		else if (respuesta==2) {
			System.out.println("------------------");
			System.out.println("1. Crear comercial.");
			System.out.println("2. Crear oficina.");
			System.out.println("------------------");
			
			respuesta = sc.nextInt();
			
			while (respuesta!=1&&respuesta!=2) {
				System.out.println("Introduce una opción válida (1 o 2).");
				respuesta = sc.nextInt();
			}
			
			if (respuesta==1) {
				System.out.println("Se ha creado un local comercial.");
			}
			
			else if (respuesta==2) {
				System.out.println("Se ha creado una oficina.");
			}
		}

	}

}
