<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

</head>
<body>

<script type="text/javascript">
  function finalizaAgora(id) {
    $.post("finalizaTarefa", {'id' : id}, function(resposta) {
      $("#tarefa_"+id).html(resposta);
    });
  }
</script>

<div class="col-md-4">
  <a href="adicionaTarefa">Criar nova tarefa</a> 
 </div>
<div class="col-md-4">
 <a href="loginForm" class="span9">Sair</a> 

  </div>

  <br /> <br />        
<div class="container">
  <table class="table table-striped">
  <thead>
  
  <tr>
    <th>Id</th>
    <th>Descrição</th>
    <th>Finalizado?</th>
    <th>Data de finalização</th>
  </tr>
  </thead>
   <tbody>
	<c:forEach items="${tarefas}" var="tarefa">
				<tr>
					<td>${tarefa.id}</td>
					<td>${tarefa.descricao}</td>
						<c:if test="${tarefa.finalizado eq false}">
							<td id="tarefa_${tarefa.id}">
								<a href="#" onClick="finalizaAgora(${tarefa.id})">
									Finaliza agora!
								</a>
							</td>
						</c:if>
						<c:if test="${tarefa.finalizado eq true}">
							<td id="tarefa_${tarefa.id}">
								Finalizado!
							</td>
						</c:if>
					<td>
	        			<fmt:formatDate 
	            			value="${tarefa.dataFinalizacao.time}" 
	          	    		pattern="dd/MM/yyyy"/>
	        		</td>
	        		<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
	        		<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
				</tr>
			</c:forEach>
 </tbody>
  </table>
  </div>
</body>
</html>