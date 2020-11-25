/*
 * Este programa permite ingresar nombres y guardarlos en una lista.
 * La lista se guarda en un archivo de texto, en el directorio archivo
 * dentro de el directorio raiz del proyecto.
 * El programa tambien permite eliminar nombres de la lista.
 * */
package principal;

import java.util.Scanner;

public class Main {
	static Scanner entrada = new Scanner(System.in);
	static Carpeta carpeta = new Carpeta();
	static Lista lista = new Lista( );
	static int opcionMenu = 0;
	static String datoIngresadoPorUsuario = ""; 
	
	public static void main(String[] args) {
		System.out.println("Bienvenido a tus listas\n");
		do {
				presentarMenuSeleccionLista();
				obtenerOpcionSeleccionada();
				ejecutarOpcionSeleccionadaMenuSeleccionLista(carpeta);
		} while ((lista.obtnerRuta() == null) && opcionMenu != 5);
		if(opcionMenu != 5){
			do {
					presentarMenuEdicionLista();
					obtenerOpcionSeleccionada();
					ejecutarOpcionSeleccionadaMenuEdicionLista(lista);
			}
			while(opcionMenu != 5);
		}
		entrada.close();
	}
	public static void presentarMenuSeleccionLista(){
		System.out.println("***********************************************************");
		System.out.println("* Ingresa el numero de la opcion deseada y presiona enter *");
		System.out.println("*                                                         *");
		System.out.println("* 	1-> Mostrar listas disponibles                    *");
		System.out.println("* 	2-> Seleccionar lista                             *");
		System.out.println("* 	3-> Crear lista nueva                             *");
		System.out.println("* 	4-> Eliminar lista                                *");
		System.out.println("* 	5-> Terminar                                      *");
		System.out.println("***********************************************************");
	}
	public static void obtenerOpcionSeleccionada() {
		opcionMenu = entrada.nextInt();
		entrada.nextLine();//Limpiamos el Scanner despues de leer entero.
		System.out.println();
	}	
	public static void ejecutarOpcionSeleccionadaMenuSeleccionLista(Carpeta carpeta) {
		switch(opcionMenu) {
		case 1:
			carpeta.actualizarListas();
			carpeta.obtenerListas();
			break;
		case 2:
			obtnerDatoIngresadoPorUsuario("Introduce el nombre de la lista que deseas seleccionar");
			if(carpeta.encontrarLista(datoIngresadoPorUsuario)) {
				carpeta.seleccionarLista(datoIngresadoPorUsuario);
				lista = new Lista(carpeta.obtenerRutaListaSeleccionada());
			}
			break;
		case 3:
			obtnerDatoIngresadoPorUsuario("Introduce el nombre para la lista nueva");
			carpeta.crearLista(datoIngresadoPorUsuario);
			break;
		case 4:
			obtnerDatoIngresadoPorUsuario("Introduce el nombre de la lista que quieres eliminar");
			carpeta.eliminarLista(datoIngresadoPorUsuario);
			break;
		case 5:
			System.out.println("Terminamos por hoy, hasta pronto");
			break;
		default:
			System.out.println("La opción ingresada no esta en la lista");
		}
	}
	public static void presentarMenuEdicionLista() {
		System.out.println("***********************************************************");
		System.out.println("* Ingresa el numero de la opcion deseada y presiona enter *");
		System.out.println("*                                                         *");
		System.out.println("* 	1-> Imprimir la lista en pantalla                 *");
		System.out.println("* 	2-> Agregar un elemento a la lista                *");
		System.out.println("* 	3-> Eliminar un elemento de la lista              *");
		System.out.println("* 	4-> Imprimir los datos del archivo                *");
		System.out.println("* 	5-> Terminar                                      *");
		System.out.println("***********************************************************");		
	}
	public static void ejecutarOpcionSeleccionadaMenuEdicionLista(Lista lista) {
		switch(opcionMenu) {
		case 1:
			System.out.println(lista.obtenerContenido());
			break;
		case 2:
			obtnerDatoIngresadoPorUsuario("Introduce el nombre del trabajor que deseas agregar");
			lista.agregarElemento(datoIngresadoPorUsuario);
			break;
		case 3:
			obtnerDatoIngresadoPorUsuario("Introduce el nombre del trabajor que deseas borrar");
			lista.borrarElemento(datoIngresadoPorUsuario);
			System.out.println();
			break;
		case 4:
			lista.datosDelArchivo();
			break;
		case 5:
			System.out.println("Terminamos por hoy, hasta pronto");
			break;
		default:
			System.out.println("La opción ingresada no esta en la lista");
		}
	}
	public static void obtnerDatoIngresadoPorUsuario(String mensaje) {
		System.out.println(mensaje);
		datoIngresadoPorUsuario = entrada.nextLine();
	}
}
	
