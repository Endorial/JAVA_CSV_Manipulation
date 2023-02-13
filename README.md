# JAVA_CSV_Manipulation

This code is in the Java programming language and has the purpose of reading data from two .csv files ("familias.csv" and "articulos.csv"), processing this data, and writing the result to an .dat file ("articulos.dat"). The .dat file is a binary file format for storing objects.

The crearDat() method is used to create an object serialization file from two CSV files: "familias.csv" and "articulos.csv". The method starts by creating two BufferedReader objects, entrada and entrada2, to read the contents of the two CSV files. The contents of the files are stored in two separate arrays, listFamilias and listArticulos.

The method then splits the contents of each line in the arrays into separate strings using the split method and the delimiter ";". The contents of listArticulos are processed one by one and stored in an ArrayList of Articulos objects, listArticulosObject. This is done by checking if the value at index 8 of the split string is equal to "0". If it is, the method will search for a matching string in listFamilias by comparing the value at index 1 of the split string from listArticulos with the value at index 0 of the split string from listFamilias. If a match is found, a new Articulos object is created and added to the listArticulosObject list.

Finally, the method uses an ObjectOutputStream object, salida, to write the objects in the listArticulosObject list to a serialization file "articulos.dat". The stream is closed after the writing is done. The method also includes try-catch blocks to handle exceptions and ensure proper resource management.


## The code does the following:

    1. Reads the contents of both .csv files and stores them in two arrays, listFamilias and listArticulos.

    2. Splits the contents of the arrays into arrays of individual data fields using the "split" method and the ";" separator.

    3. Processes the data in listArticulos to create Articulos objects. An Articulos object is created for each element in listArticulos for which the value of the 8th field is "0". This new Articulos object consists of 5 fields from both listArticulos and listFamilias arrays.

    4. Writes the Articulos objects to the "articulos.dat" file using an ObjectOutputStream.

    5. Reads the Articulos objects from the "articulos.dat" file using an ObjectInputStream and stores them in a list called "articulosList".

    6. Writes all the objects in the "articulosList" to the console.

    7. Filters the objects in the "articulosList" and writes only the objects whose cost is greater than 50 to the console.

    8. Calculates the total cost of all objects in the "articulosList" and writes it to the console.

    9. Writes the objects in the "articulosList" back to the "articulos.dat" file.
    
    
 ## Code OUTPUT 
    
![image](https://user-images.githubusercontent.com/57392686/218467590-729a4e72-0e9b-40c6-b248-bfc389aec957.png)
