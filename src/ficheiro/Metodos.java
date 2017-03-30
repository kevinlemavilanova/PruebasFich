package ficheiro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author klemavilanova
 */
public class Metodos {

    ArrayList<Alumnos> list = new ArrayList<Alumnos>();
    ArrayList<Alumnos> aprobados = new ArrayList<Alumnos>();
    ArrayList<Alumnos> suspensos = new ArrayList<Alumnos>();

    File fichero;
    FileReader lectura;
    Scanner sc;

    public void engadir(String nomefich) {
        PrintWriter fichero = null;
        try {
            fichero = new PrintWriter(new FileWriter(nomefich, true));

            if (nomefich.equals("aprobados.dat")) {
                for (Alumnos a : aprobados) {
                    fichero.println(a.getNome() + ' ' + a.getNota());
                }
            } else if (nomefich.equals("suspensos.dat")) {
                for (Alumnos a : suspensos) {
                    fichero.println(a.getNome() + ' ' + a.getNota());
                }
            } else if (nomefich.equals("notas.dat")) {
                for (Alumnos a : list) {
                    fichero.println(a.getNome() + ' ' + a.getNota());
                }
            }

        } catch (IOException ex) {
            System.out.println("Erro2" + ex.getMessage());
        } finally {
            fichero.close();
        }
    }

    public void ler(String nomefich) {
        String[] Alumnos;
        try {
            sc = new Scanner(new File(nomefich));

            while (sc.hasNextLine()) {
                String Alumno = sc.nextLine();
                Alumnos = Alumno.split(" ");

                if (Integer.parseInt(Alumnos[1]) >= 5) {
                    aprobados.add(new Alumnos(Alumnos[0], Integer.parseInt(Alumnos[1])));
                } else {
                    suspensos.add(new Alumnos(Alumnos[0], Integer.parseInt(Alumnos[1])));
                }
                list.add(new Alumnos(Alumnos[0], Integer.parseInt(Alumnos[1])));
            }
            this.engadir("suspensos.dat");
            this.engadir("aprobados.dat");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
