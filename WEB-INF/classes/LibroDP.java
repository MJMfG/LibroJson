package modelLibro;

import java.util.StringTokenizer;

public class LibroDP
{
	// Atributos
	private String titulo, autor, editorial,clave,existencia;


	// Constructores
	public LibroDP()
	{
		this.titulo  = "";
		this.autor = "";
		this.editorial  = "";
		this.clave="";
		this.existencia="";

	}

	public LibroDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");

		this.titulo  = st.nextToken();
		this.editorial = st.nextToken();
		this.autor   = st.nextToken();
		this.editorial  = st.nextToken();
		this.clave= st.nextToken();
		this.existencia= st.nextToken();
	}

	// Metodos: Accesors (geter's)
	public String getTitulo()
	{
		return this.titulo;
	}

	public String getAutor()
	{
		return this.autor;
	}

	public String getEditorial()
	{
		return this.editorial;
	}

	public String getExistencia()
	{
		return this.existencia;
	}

	public String getClave()
	{
		return this.clave;
	}


	// Metodos: Mutators (seter's)
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	public void setAutor(String autor)
	{
		this.autor = autor;
	}

	public void setEditorial(String editorial)
	{
		this.editorial = editorial;
	}

	public void setExistencia(String existencia)
	{
		this.existencia = existencia;
	}

	public void setClave(String clave)
	{
		this.clave = clave;
	}



	public String toString()
	{
		return this.clave+"_"+this.titulo+"_"+this.autor+"_"+this.editorial+"_"+this.existencia;
	}

	public String toStringSql()
	{
		return "'"+this.titulo+"','"+this.autor+"','"+this.editorial+this.existencia+","+this.clave+"'";
	}
/*
	public String toStringJson()
	{
		return "{titulo:'"+this.titulo+"',autor:'"+this.autor+"'editorial:'"+this.editorial+this.editorial+"'}";
	}

	public String toStringJSON()
	{
		return "{'titulo':'"+getTitulo()+"','autor':'"+getAutor()+"','editorial':'"+getEditorial()+"','imagen':'"+getImagen()+"'}";
	}
*/
	public String toStringJson()
	{
		return "{\"clave\":\""+getClave()+"\","+"\"titulo\":\""+getTitulo()+"\",\"autor\":\""+getAutor()+"\",\"editorial\":\""+getEditorial()+"\",\"existencia\":\""+getExistencia()+"\"}";
	}


}
