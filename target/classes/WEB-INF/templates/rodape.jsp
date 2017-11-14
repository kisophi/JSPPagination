<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="w3-right-align w3-bottom">
	<div
		class="w3-container w3-card-4 w3-round-large w3-green w3-padding w3-margin"
		style="text-shadow: 1px 1px 0 #444">
		<c:if test="${nomeUsuario!=null}">
			<label>
				<h5>
					<b>Usuario : ${nomeUsuario}</b>
				</h5>
			</label>
		</c:if>
	</div>
</div>
</body>
</html>