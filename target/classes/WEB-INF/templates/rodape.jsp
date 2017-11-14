<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="w3-right-align w3-bottom">
	<div
		class="w3-container w3-card-4 w3-round-large w3-green w3-padding w3-margin"
		style="text-shadow: 1px 1px 0 #444">

		<div class="w3-text-yellow">
			<c:if test="${nomeUsuario!=null}">
				<label>
					<h5>
						Usuario : ${nomeUsuario}
					</h5>
				</label>
			</c:if>
		</div>

	</div>
</div>
</body>
</html>