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
        
        
        String opt = JOptionPane.showInputDialog("Pulse una opcion");
        switch(opt){
            case "a":
                metodos.list.add(new Alumnos("Pedro",7));
                metodos.list.add(new Alumnos("Pepe",4));
                metodos.engadir("notas.dat");
            case "b":
                metodos.ler("notas.dat");
        }
        

    }
    
}
