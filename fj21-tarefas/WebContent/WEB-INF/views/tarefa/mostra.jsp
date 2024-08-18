<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>  
<link type="text/css" href="resources/css/bootstrap.css" rel="stylesheet">
<link type="text/css" href="resources/css/bootstrap-theme.css" rel="stylesheet">
<link type="text/css" href="resources/css/bootstrap-theme.min.css" rel="stylesheet">
<link type="text/css" href="resources/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="resources/css/jquery-ui.css" rel="stylesheet">
    <script type="text/javascript"  src="resources/js/jquery.js"></script>
    <script type="text/javascript"  src="resources/js/jquery-ui.js"></script>
<script type="text/javascript"  src="resources/js/bootstrap.js"></script>
<script type="text/javascript"  src="resources/js/bootstrap.min.jss"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h3>Alterar tarefa - ${tarefa.id}</h3>
  <form action="alteraTarefa" method="post">

    <input type="hidden" name="id" value="${tarefa.id}" />
  
    Descrição:<br />
    <textarea name="descricao" cols="100" rows="5">
      ${tarefa.descricao}
    </textarea>
    <br />      

    Finalizado? <input type="checkbox" name="finalizado" 
      value="true" ${tarefa.finalizado? 'checked' : '' }/> <br />      

       Data de finalização: <br />
<%--          <input type="text" name="dataFinalizacao" value="<fmt:formatDate  
            value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />"/>  
 --%>
       <fmt:formatDate value='${tarefa.dataFinalizacao.time}' pattern='dd/MM/yyyy' var="dataFormatada" />

<caelum:campoData id="dataFinalizacao" val="${dataFormatada}"/>
    <br />
  
    <input type="submit" value="Alterar"/>
  </form>
</body>
</html>