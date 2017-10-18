<%@ page import="java.io.PrintWriter"%>

<jsp:useBean id="librodp" class="modelLibro.LibroDP"/>
<jsp:useBean id="libroad" class="modelLibro.LibroAD"/>

<jsp:setProperty name="librodp" property="*"/>

<%


  if(request.getParameter("bCapturar")!=null)
      {

        libroad.capturarLibro(librodp.toStringSql());

        String datos="[";
        datos=datos+librodp.toStringJson()+"]";

        PrintWriter salida=response.getWriter();
        response.setContentType("text/plain\n\n");
        salida.println(datos);
        salida.close();
      %><%=datos%>
      <%



      }




  if(request.getParameter("bConsultar").equals("consultar"))
      {
        String respuesta=libroad.consultarLibros();
        PrintWriter salida=response.getWriter();
        response.setContentType("text/plain\n\n");
        salida.println(respuesta);
        salida.close();
      %><%=respuesta%>
      <%







//response.sendRedirect("RespuestaServer.jsp?datos="+clientedp.toString());
        }


  if(request.getParameter("bConsultar").equals("consultarEditorial"))
      {
        String editorial=request.getParameter("editorial");
        String datos= libroad.consultarEditorial(editorial);

        PrintWriter salida=response.getWriter();
        response.setContentType("text/plain\n\n");
        salida.println(datos);
        salida.close();
      %><%=datos%>
      <%







//response.sendRedirect("RespuestaServer.jsp?datos="+clientedp.toString());
      }

  if(request.getParameter("bConsultar").equals("consultarTitulo"))
      {
        String titulo=request.getParameter("titulo");
        String datos= libroad.consultarTitulo(titulo);


        PrintWriter salida=response.getWriter();
        response.setContentType("text/plain\n\n");
        salida.println(datos);
        salida.close();
      %><%=datos%>
      <%


//response.sendRedirect("RespuestaServer.jsp?datos="+clientedp.toString());
    }

    if(request.getParameter("bConsultar").equals("consultarAutor"))
        {
          String autor=request.getParameter("autor");
          String datos= libroad.consultarAutor(autor);


          PrintWriter salida=response.getWriter();
          response.setContentType("text/plain\n\n");
          salida.println(datos);
          salida.close();
        %><%=datos%>
        <%


  //response.sendRedirect("RespuestaServer.jsp?datos="+clientedp.toString());
      }


%>
