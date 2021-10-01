import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner archivo = new Scanner(new File("personas.txt"));
        Scanner teclado = new Scanner(System.in);

        archivo.useDelimiter("[;\\n]");
        ArrayList<Persona>  listaPersona = new ArrayList<>();



        int edadMayor =0, cantidadApellidoDado= 0;


        while (archivo.hasNextInt()) {

            int documento = archivo.nextInt();
            String nombre = archivo.next();
            String apellido = archivo.next();
            int edad = archivo.nextInt();

            Persona nueva = new Persona(documento, nombre, apellido, edad);

            listaPersona.add(nueva);
        }
            archivo.close();

            for (Persona p : listaPersona) {

                if (p.getEdad()>= 18) {
                    edadMayor++;
                }
            }
            System.out.println("Cantidad de mayores: "+edadMayor);

        System.out.print("Ingrese el apellido a buscar: ");
        String n = teclado.next();

        while (!n.equals(".")){
            for (Persona p: listaPersona) {
                if (p.getApellido().equalsIgnoreCase(n)) {
                    System.out.println(p.getEdad() + " " + p.getApellido());
                }
            }
            n = teclado.next();
        }
    }
}
