
<jsp:useBean id="librodp" class="modelLibro.LibroDP"/>

<jsp:setProperty name="librodp" property="*" />



<%
String titulo=request.getParameter("titulo");
String autor=request.getParameter("autor");
String editorial=request.getParameter("editorial");

%>

<html>
   <head>
   	  <title>Bibilioteca</title>
   </head>
   <body>
   	   <h2>DATOS DEL LIBRO CAPTURADO</h2>

       <table border=1>
      <tr>
        <td>Titulo</td>
        <td>Autor</td>
        <td>Editorial</td>
      </tr>

      <tr>
      <td><%=titulo%></td>
      <td><%=autor%></td>
       <td><%=editorial%></td>
     </tr>


   </body>
</html>
