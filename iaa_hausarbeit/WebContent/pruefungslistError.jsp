<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg --%>

<h2><s:text name="txtHeadingPruefungslistError" /></h2>

<div class="errorMessage">
	<s:text name="error.no.pruefungsfach.selected" />
</div>

<div class="buttons">
	<div class="button">
		<a href="/iaa_hausarbeit" class="btnBack"><s:text name="btnPruefungsfaecher" /></a>
	</div>
	<div class="clear"></div>
</div>