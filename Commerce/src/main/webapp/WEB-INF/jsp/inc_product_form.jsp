<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<label for="nameProduct">Nom<span class="requis">*</span></label>
<input type="text" id="nameProduct" name="nameProduct"
	value="<c:out value="${product.name}"/>" size="30" maxlength="30" />
<span class="erreur">${form.erreurs['nameProduct']}</span>
<br />
<label for="descriptionProduct">description<span class="requis">*</span></label>
<textarea id="descriptionProduct" name="descriptionProduct" rows="4" cols="50">
	<c:out value="${product.description}"/>
</textarea>
<span class="erreur">${form.erreurs['descriptionProduct']}</span>
<br />
<label for="priceProduct">prix<span class="requis">*</span></label>
<textarea id="priceProduct" name="priceProduct" rows="4" cols="50">
	<c:out value="${product.price}"/>
</textarea>
<span class="erreur">${form.erreurs['priceProduct']}</span>
<br />