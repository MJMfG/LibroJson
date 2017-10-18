<%@ page import="java.util.StringTokenizer" %>
<%
String datos=request.getParameter("datos");
%>
<!--%=datos%-->

<%

if(!datos.equals("NO_LOCALIZADO"))
{

StringTokenizer st1= new StringTokenizer(datos,"*");
String titulo=datos;
String autor="";
String editorial="";
String clave="";
String existencia="";
String imagen="";



%>

<html>
   <head>
   	  <title>Biblioteca2</title>
   </head>
   <body>
   	   <h2>DATOS DE LIBROS</h2>

       <table border=1>
      <tr>
        <td>Clave</td>
        <td>Titulo</td>
        <td>Autor</td>
        <td>Editorial</td>
        <td>Existencia</td>
        <td>Imagen</td>
      </tr>
<%

    while(st1.hasMoreTokens())
    {
      StringTokenizer st2= new StringTokenizer(st1.nextToken(),"_");

      while(st2.hasMoreTokens())
      {
        clave=st2.nextToken();
        titulo=st2.nextToken();
        autor=st2.nextToken();
        editorial=st2.nextToken();
        existencia=st2.nextToken();
        imagen=titulo+".jpg";

        %>

        <tr>
          <td><%=clave%></td>
           <td><%=titulo%></td>
           <td><%=autor%></td>
            <td><%=editorial%></td>
            <td><%=existencia%></td>
            <td>

              <img src="images/<%=imagen%>" onerror="this.src='images/default.jpg'">
            </td>

      <%
      }
    }

%>

          </tr>
        </table>
      </body>
</html>
<%
}


else
{
  %>
 No encontrado

  <%
}
%>
