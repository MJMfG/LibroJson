package modelLibro;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cedarsoftware.util.io.JsonWriter;

public class LibroAD
{
    private Connection conexion;
    private Statement statement;

    private LibroDP librodp;

    public LibroAD()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca?user=root");
            System.out.println("Conexion exitosa a la BD en MySQL...");
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("Error: "+cnfe);
        }
        catch(InstantiationException ie)
        {
            System.out.println("Error: "+ie);
        }
        catch(IllegalAccessException iae)
        {
            System.out.println("Error: "+iae);
        }
        catch(SQLException sqle)
        {
            System.out.println("Error: "+sqle);
        }
    }




	public String capturarLibro(String libro)
    {

      String resultado="";
	    String insert = "INSERT INTO Libros VALUES("+ libro+")";

	    try {

	      statement = conexion.createStatement();
	      statement.executeUpdate(insert);
	      statement.close();
	      resultado = "Captura Correcta de Datos: \n" + libro;

	      System.out.println(insert);
	    }
	    catch(SQLException sqle) {
	      System.out.println("Error: " + sqle);
	      resultado = "Error En Captura\n" + sqle;
	    }

	    return resultado;
    }




    public String consultarLibros()
	{
		String datos = "[";
		String query = "SELECT * FROM Libros";
		ResultSet tr = null;
		boolean encontrado=false;


		  // 1.- Crear Conexion

          librodp = new LibroDP();
try {
  statement = conexion.createStatement();

  // 1.1.- Ejecutar Query
  tr = statement.executeQuery(query);
		  while(tr.next())
		  {
            librodp.setClave(tr.getString(5));
            librodp.setTitulo(tr.getString(1));
            librodp.setAutor(tr.getString(2));
            librodp.setEditorial(tr.getString(3));
            librodp.setExistencia(tr.getString(4));



            //datos = datos + librodp.toString()+ "*";
            //datos = datos + librodp.toStringJson()+ ",";
            //Adiciona tipo de objeto
            datos=datos+JsonWriter.objectToJson(librodp)+",";

            encontrado = true;
		  }
		  // 3.- Cerrar archivo
		  statement.close();
      //datos=datos+"]";
      //Quitar comita
      datos=datos.substring(0,datos.length()-1)+"]";
		  System.out.println(datos);
		}
		catch(SQLException sqle) {
		  System.out.println("Error: " + sqle);
		  datos = "Error En Consulta" + sqle;
		}
		if(!encontrado)
            datos = "NO_LOCALIZADO";

		return datos;
	}

  public String consultarEditorial(String edit)
  {
    String datos = "[";
    String query = "SELECT * FROM Libros WHERE Editorial='"+edit+"'";
    ResultSet tr = null;
    boolean encontrado=false;

    try {
      // 1.- Crear Conexion
      statement = conexion.createStatement();

      // 1.1.- Ejecutar Query
      tr = statement.executeQuery(query);
          librodp = new LibroDP();

      while(tr.next())
      {
            librodp.setClave(tr.getString(5));
            librodp.setTitulo(tr.getString(1));
            librodp.setAutor(tr.getString(2));
            librodp.setEditorial(tr.getString(3));
            librodp.setExistencia(tr.getString(4));



            //datos = datos + librodp.toString()+ "*";
            datos = datos + librodp.toStringJson()+ ",";


            encontrado = true;
      }
      // 3.- Cerrar archivo
      statement.close();
      datos=datos.substring(0,datos.length()-1)+"]";
      System.out.println(datos);
    }
    catch(SQLException sqle) {
      System.out.println("Error: " + sqle);
      datos = "Error En Consulta" + sqle;
    }
    if(!encontrado)
            datos = "NO_LOCALIZADO";
            //datos=query;
    return datos;
  }

      public String consultarTitulo(String tit){
        String datos = "[";
        String query = "SELECT * FROM Libros WHERE Titulo='"+tit+"'";
        ResultSet tr = null;
        boolean encontrado=false;

        try {
          // 1.- Crear Conexion
          statement = conexion.createStatement();

          // 1.1.- Ejecutar Query
          tr = statement.executeQuery(query);
              librodp = new LibroDP();

          while(tr.next())
          {
                librodp.setClave(tr.getString(5));
                librodp.setTitulo(tr.getString(1));
                librodp.setAutor(tr.getString(2));
                librodp.setEditorial(tr.getString(3));
                librodp.setExistencia(tr.getString(4));



                //datos = datos + librodp.toString()+ "*";
                datos = datos + librodp.toStringJson()+ ",";

                encontrado = true;
          }
          // 3.- Cerrar archivo
          statement.close();
          datos=datos.substring(0,datos.length()-1)+"]";
          System.out.println(datos);
        }
        catch(SQLException sqle) {
          System.out.println("Error: " + sqle);
          datos = "Error En Consulta" + sqle;
        }
        if(!encontrado)
                datos = "NO_LOCALIZADO";
                //datos=query;

        return datos;
      }

      public String consultarAutor(String autor){
        String datos = "[";
        String query = "SELECT * FROM Libros WHERE Autor='"+autor+"'";
        ResultSet tr = null;
        boolean encontrado=false;

        try {
          // 1.- Crear Conexion
          statement = conexion.createStatement();

          // 1.1.- Ejecutar Query
          tr = statement.executeQuery(query);
              librodp = new LibroDP();

          while(tr.next())
          {
                librodp.setClave(tr.getString(5));
                librodp.setTitulo(tr.getString(1));
                librodp.setAutor(tr.getString(2));
                librodp.setEditorial(tr.getString(3));
                librodp.setExistencia(tr.getString(4));



                //datos = datos + librodp.toString()+ "*";
                datos = datos + librodp.toStringJson()+ ",";


                encontrado = true;
          }
          // 3.- Cerrar archivo
          statement.close();
          datos=datos.substring(0,datos.length()-1)+"]";
          System.out.println(datos);
        }
        catch(SQLException sqle) {
          System.out.println("Error: " + sqle);
          datos = "Error En Consulta" + sqle;
        }
        if(!encontrado)
                datos = "NO_LOCALIZADO";
                //datos=query;

        return datos;
      }

}
