<jsp:include page="templates/cabecalho.jsp" />
<jsp:include page="templates/menu.jsp" />

<!-- div do formulario de cadastro -->
<div class="w3-container w3-card-4 w3-light-grey"
	style="margin-left: 15%; margin-top: 2%; margin-right: 1%">


	<!--div do Cabeçalho do Formulario -->
	<div class="w3-panel w3-blue w3-round">
		<h2>Cadastro de Usuario</h2>
	</div>


	<!-- div do Form -->
	<form action="usuController" method="post">
		<div class="w3-quarter">
			<label><b>ID</b></label> <input
				class="w3-input w3-border w3-blue w3-round" type="text" name="id"
				value="0" readonly="readonly" />
		</div>
		<div class="w3-col">
			<label><b>Nome </b></label> <input
				class="w3-input w3-border w3-round" type="text" name="nome" required
				autofocus />
		</div>
		<div class="w3-col">
			<label><b>Login</b></label> <input
				class="w3-input w3-border w3-round" type="text" name="login" required />
		</div>
		<div class="w3-col">
			<label><b>Senha</b></label> <input
				class="w3-input w3-border w3-round" type="password" name="senha" required />
		</div>
		<div class="w3-quarter">
			<label><b>Nivel</b></label> <select
				class="w3-select w3-border w3-round" name="nivel" id=nivel>
				<option value="1" selected="selected">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
			</select>
		</div>
		<div class="w3-col">
			<p>
				<input class="w3-btn w3-red w3-round" type="reset" value="Cancelar">
				<input class="w3-btn w3-green w3-round" type="submit" value="Salvar">
			</p>
		</div>
	</form>
</div>


<jsp:include page="templates/rodape.jsp" />