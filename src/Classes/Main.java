
package Classes;

import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private static void crearDat() {
        //Create a BufferedReader object to read from "familias.csv" file
        BufferedReader entrada = null;

        try {
            // Create a BufferedReader object to read from "familias.csv" file
            entrada = new BufferedReader(new FileReader("familias.csv"));

            // Create a BufferedReader object to read from "articulos.csv" file
            BufferedReader entrada2 = new BufferedReader(new FileReader("articulos.csv"));

            // Create an ObjectOutputStream object to write to "articulos.dat" file
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("articulos.dat"));

            // Create an ArrayList to store the lines from the "familias.csv" file
            ArrayList<String>listFamilias = new ArrayList<String>();

            // Create an ArrayList to store the lines from the "articulos.csv" file
            ArrayList<String>listArticulos = new ArrayList<String>();

            // Variables to store the lines read from the files
            String lineaFamilias="";
            String lineaArticulos="";

            // Variables to store the split values of the lines read from the files
            String [] splitFamilias;
            String [] splitArticulos;

            // Create an ArrayList to store the Articulos objects
            ArrayList<Articulos> listArticulosObject = new ArrayList<Articulos>();

            // Read the lines from the "familias.csv" file and add them to the listFamilias ArrayList
            while((lineaFamilias=entrada.readLine())!=null){
                listFamilias.add(lineaFamilias);

                // Read the lines from the "articulos.csv" file and add them to the listArticulos ArrayList
            }   while((lineaArticulos=entrada2.readLine())!=null){
                listArticulos.add(lineaArticulos);

                // Close the BufferedReader objects
            }   entrada.close();
            entrada2.close();

            // Loop through the listArticulos ArrayList
            for (int i = 1; i < listArticulos.size(); i++) {
                // Split the line read from the "articulos.csv" file
                splitArticulos=listArticulos.get(i).split(";");
                if(splitArticulos[8].equals("0")){
                    for (int j = 1; j < listFamilias.size(); j++) {
                        splitFamilias=listFamilias.get(j).split(";");
                        if(splitArticulos[1].equals(splitFamilias[0])){
                            listArticulosObject.add(new Articulos(splitArticulos[0],splitFamilias[1],splitArticulos[2],splitArticulos[6],splitArticulos[5]));

                        }

                    }
                }

            }   for (int i = 0; i < listArticulosObject.size(); i++) {
                salida.writeObject(listArticulosObject.get(i));
            }
            salida.writeObject(null);
            salida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    public static void main(String[] args) {
        //metodo que crea el .dat
        crearDat();
        
        ObjectInputStream entrada = null;
        try {
            
            entrada = new ObjectInputStream(new FileInputStream("articulos.dat"));
            ArrayList<Articulos> articulosList = new ArrayList<Articulos>();
            Articulos articulo;
            int coste=0;
            int coste2=0;
            
            //Aquí guardamos los objetos del dat en una lista y los mostramos todos
            while((articulo=(Articulos) entrada.readObject())!=null){
                articulosList.add(articulo);
                System.out.println(articulo.toString());
            }   entrada.close();
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("articulos.dat"));
            
            System.out.println();
            
            //Mostrar la información de todos los artículo con coste mayor de 50 y sumar los costes despues del for muestro la suma
            for (int i = 0; i <articulosList.size() ; i++) {
                coste= Integer.parseInt(articulosList.get(i).getCoste());
                coste2+=coste;
                if(coste>50){
                    System.out.println(articulosList.get(i).toString());
                }

            }
            System.out.println("coste total: "+coste2);


            //en el siguiente for vuelo a introducir los objetos en el .dat introduciendo solo los que tienen un coste mayor a 50
//         for (int i = 0; i <articulosList.size() ; i++) {
//           coste= Integer.parseInt(articulosList.get(i).getCoste());
//           if(coste>=50){
//               salida.writeObject(articulosList.get(i));
//           }
//
//        }
salida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    
}
