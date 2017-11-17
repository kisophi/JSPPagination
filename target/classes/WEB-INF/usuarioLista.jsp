<jsp:include page="templates/cabecalho.jsp" />
<jsp:include page="templates/menu.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Div do Botão Cadastrar -->
<div class="" style="margin-left: 15%; margin-top: 2%; margin-right: 1%">
	<a href="usuController?acao=Cadastrar" > 
	<input class="w3-button w3-card-4 w3-green w3-border w3-border-green w3-round"
	type="submit" value="Novo" /></a>
</div>

<!-- Div do Buscar por nome -->
<div class="" style="margin-left: 15%; margin-top: 1%; margin-right: 35%">
	<form action="usuController">
		<input class="w3-quarter w3-input w3-border w3-round"
		type="text" name="nome"/>
		<input class="w3-button w3-card-4 w3-green w3-border w3-border-green w3-round" 
		type="submit" name="acao" value="Buscar"/>
	</form>
</div>


<!-- Div da tabela -->
<div class="" style="margin-left: 15%; margin-top: 1%; margin-right: 1%">
	<form action="usuController" method="get">
		<table class="w3-table-all w3-hoverable w3-card-4">

			<!-- cabeçalho da tabela -->
			<tr class="w3-blue">
				<th width="10px">ID</th>
				<th width="">Nome</th>
				<th width="20px">Login</th>
				<th width="15px">Senha</th>
				<th width="10px">Nivel</th>
				<th width="10px">Editar</th>
				<th width="10px">Excluir</th>
			</tr>


			<!--Dados do Usuarios -->
			<c:forEach items="${lista}" var="usuario">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.login}</td>
					<td>${usuario.senha}</td>
					<td>${usuario.nivel}</td>
					<td><a href="usuController?acao=Editar&id=${usuario.id}">-E-</a></td>
					<td><a href="usuController?acao=Excluir&id=${usuario.id}">-X-</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	
	<div class="w3-center">
	<div class="w3-bar">
	<p>
		<c:forEach begin="1" end="${paginacao}" var="i">
				<a href="usuController?numPagina=${i}" class="w3-button w3-hover-green" >${i}</a>
		</c:forEach>
	</div>
	</div>
	
</div>
<jsp:include page="templates/rodape.jsp" />
