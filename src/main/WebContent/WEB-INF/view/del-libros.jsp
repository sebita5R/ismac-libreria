<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
           <title>boton eliminar</title>
           <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
            <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-table.min.css" />
            
</head>
<body>
 
 <div class="container" style="text-align: center;">
 	<h1>Eliminar Libro </h1>

         <form action="del" method="get">
         
               <input type="hidden" id="idLibro" name="idLibro" value="${libro.idLibro}" />
               
               <strong>¿Desea Eliminar el dato?</strong>
               <br>
               <br/>
               <button class="btn btn-danger" type="submit">Eliminar</button>
               
               <button class="btn btn-success" onclick="window.location.href='/ismac-libreria-web-matutino/libros/findAll';return false ;">
               Cancelar
               </button>
               
               
               <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap-table-es-MX.min.js"></script>
               
         </form>
 </div>



</body>
</html>