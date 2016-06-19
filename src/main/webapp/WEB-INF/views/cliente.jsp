<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD</title>
<link href='<c:out value="resources/css/style.css"/>' rel="stylesheet"/>
</head>
<body>
<h1>
	Inserir novo cliente
</h1>

<c:url var="addAction" value="/cliente/incluir" ></c:url>

<form:form action="${addAction}" commandName="cliente">
<table>
	<c:if test="${!empty cliente.nome}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="nome">
				<spring:message text="Nome"/>
			</form:label>
		</td>
		<td>
			<form:input path="nome" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="cpf">
				<spring:message text="CPF"/>
			</form:label>
		</td>
		<td>
			<form:input path="cpf" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="rg">
				<spring:message text="RG"/>
			</form:label>
		</td>
		<td>
			<form:input path="rg" />
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty cliente.nome}">
				<input type="submit"
					value="<spring:message text="Editar Cliente"/>" />
			</c:if>
			<c:if test="${empty cliente.nome}">
				<input type="submit"
					value="<spring:message text="Inserir Cliente"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de clientes</h3>
<c:if test="${!empty listaClientes}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Nome</th>
		<th width="120">CPF</th>
		<th width="120">RG</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listaClientes}" var="cliente">
		<tr>
			<td>${cliente.id}</td>
			<td>${cliente.nome}</td>
			<td>${cliente.cpf}</td>
			<td>${cliente.rg}</td>
			<td><a href="<c:url value='/editar/${cliente.id}' />" >Editar</a></td>
			<td><a onclick="return confirm('Tem certeza que deseja excluir?')" href="<c:url value='/deletar/${cliente.id}' />" >Deletar</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

</body>
</html>