package ficheiro;

import javax.swing.JOptionPane;

/**
 *
 * @author klemavilanova
 */
public class Ficheiro {

    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        Alumnos alumnos = new Alumnos();
        Boolean seguir = true;

        while (seguir == true) {
            String opt = JOptionPane.showInputDialog("Pulse una opcion");
            switch (opt) {
                case "a":
                    metodos.list.add(new Alumnos("Pedro", 7));
                    metodos.list.add(new Alumnos("Pepe", 4));
                    metodos.engadir("notas.dat");
                    metodos.engadir("aprobados.dat");
                    metodos.engadir("suspensos.dat");

                    break;
                case "b":
                    metodos.ler("notas.dat");
                    break;
                case "c":
                    seguir = false;
                    break;
            }
        }

    }

}
