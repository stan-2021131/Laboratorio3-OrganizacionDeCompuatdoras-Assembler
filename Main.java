/*
 * Laboratorio 3 - Conversor de binario a decimal y de decimal a binario
 * Alejandra Avilés - 24722
 * Jackelyn Girón - 24737
 * Sergio Tan - 24759
 * 
 * Fecha de creación y última modificación: 27/02/2025
 */
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //Escaner y array para el manejo de datos
        Scanner sc = new Scanner(System.in);
        String[] datos = new String[8];
        boolean x = true;

        //Menú principal
        System.out.println("Laboratorio 3 - Conversión de binario -> decimal/decimal -> binario");
        while(x==true){
            System.out.println("Ingrese una de las opciones: \n1) De decimal a binario\n2) De binario a decimal\n3) Salir");
            int opcion = sc.nextInt();
            if(opcion == 1){
                System.out.println("Ingrese una cantidad entre 0 y 128");
                int valor = sc.nextInt();
                //Ciclo en el que le saca módulo al valor y luego lo divide entre 2 para repetir el proceso
                for(int i = 0; i<datos.length; i++){
                    datos[i] = String.valueOf(valor%2);
                    valor = valor/2;
                }
                System.out.println();
                //Ciclo que empieza desde la última posición y va hasta el primero para mostrar de forma correcta el valor
                for(int i = (datos.length-1); i>=0; i--){
                    if(datos[i] == null)
                        System.out.print("0");
                    if(i==3)
                        System.out.print("-");
                    System.out.print(datos[i]);
                }
                System.out.println("");
            }else if(opcion == 2){
                int resultado = 0;
                sc.nextLine();
                System.out.println("Ingrese la cantidad en binario, debe ser de 8 bits y solo tener 1 o 0, sin espacios");
                String valor = sc.nextLine();
                //Revisa si la cantidad es solo de 8 bits
                if(valor.split("").length>8)
                    throw new ArrayIndexOutOfBoundsException("El valor ingresado es mayor de 8 bits");
                datos = valor.split("");
                //Ciclo para revisión y operación del valor
                for(int i=0; i<datos.length;i++){
                    //Revisa si la cantidad es 1 o 0
                    if(!datos[i].equals("1")&&!datos[i].equals("0"))
                        throw new ArithmeticException("Solo pueden ingresarse 1 y 0");
                    if(datos[i].equals("1")){
                        double sum = Math.pow(2, i);
                        resultado = resultado + (int)sum;
                    }
                }
                System.out.println("El número convertido a decimal es: " + resultado);
            }
            else if(opcion == 3){
                x = false;
            }
            else{
                System.out.println("Ingrese una de las opciones correcta");
            }
        }
        sc.close();
    }
}