<jsp:include page="templates/cabecalho.jsp" />
<jsp:include page="templates/menu.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Div do Botão Cadastrar -->
<div class="" style="margin-left: 15%; margin-top: 2%; margin-right: 1%">
	<a href="usuController?acao=Cadastrar"> <input
		class="w3-button w3-card-4 w3-green w3-border w3-border-green w3-round"
		type="submit" value="Novo" /></a>
</div>

<!-- Div do Buscar por  -->
<div class=""
	style="margin-left: 15%; margin-top: 1%; margin-right: 35%">
	<form action="usuController">
	
	<!-- 	Select do BuscarPor -->
	<select class="w3-quarter w3-input w3-border w3-round" name="buscarPor" id="buscarPor">
		<option value="id">ID</option>
		<option value="nome" selected>Nome</option>
		<option value="login">Login</option>
		<option value="senha">Senha</option>
		<option value="nivel">Nivel</option>
	</select>
	
	<!-- 		input LIKE -->
		<input class="w3-quarter w3-input w3-border w3-round" type="text"
			name="like" /> 
		
	<!-- 		Botão Buscar			 -->
		<input class="w3-button w3-card-4 w3-green w3-border w3-border-green w3-round"
			type="submit" name="acao" value="Buscar" />
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

				<!--  Pagina Anterior -->
				<c:if test="${param.numPagina>=2}">
					<a href="usuController?numPagina=${paginaAnterior}
					&like=${param.like}&buscarPor=${param.buscarPor}"> Anterior</a>
				</c:if>


				<!-- 		Paginação -->
				<c:forEach begin="1" end="${paginacao}" var="i">
					<a href="usuController?numPagina=${i}
					&like=${param.like}&buscarPor=${param.buscarPor}"
						class="w3-button w3-hover-green">${i}</a>
				</c:forEach>


				<!-- 	proxima Pagina -->
				<c:if test="${param.numPagina<paginacao}">
					<a href="usuController?numPagina=${proximaPagina}
					&like=${param.like}&buscarPor=${param.buscarPor}">Proxima</a>
				</c:if>
		</div>
	</div>

</div>
<jsp:include page="templates/rodape.jsp" />
