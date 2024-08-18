<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<link type="text/css" href="resources/css/bootstrap.css" rel="stylesheet">
<link type="text/css" href="resources/css/bootstrap-theme.css" rel="stylesheet">
<link type="text/css" href="resources/css/bootstrap-theme.min.css" rel="stylesheet">
<link type="text/css" href="resources/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="resources/css/jquery-ui.css" rel="stylesheet">
    <script type="text/javascript"  src="resources/js/jquery.js"></script>
    <script type="text/javascript"  src="resources/js/jquery-ui.js"></script>
<script type="text/javascript"  src="resources/js/bootstrap.js"></script>
<script type="text/javascript"  src="resources/js/bootstrap.min.jss"></script>
</head>
<body>
  <h3>Adicionar tarefas</h3>
  <form:errors path="tarefa.descricao"/>
  <form action="adicionaTarefa" method="post">
    Descrição:
            <br/>
    <textarea rows="5" cols="100" name="descricao"></textarea> 
            <br/>     
    
            <br/>
    <input type="submit" value="Adicionar"/>
    

    
  </form>
</body>
</html>