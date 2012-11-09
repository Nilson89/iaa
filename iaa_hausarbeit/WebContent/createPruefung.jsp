<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%-- Sabrina Schramm --%>

<h2><s:text name="txtHeadingPruefungsanlage" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>
<div class="textBox">
	<p><s:text name="txtAnweisungPruefungsanlage" /></p>
</div>
<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
	<div class="form">
		<div class="field">
			<span class="label"><s:text name="txtDatum" />:</span>
			<sj:datepicker id="datum" name="selectedDatum"  value="selectedDatum" timepicker="false" displayFormat="dd.mm.yy" readonly="true" />
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label"><s:text name="txtDozent" />:</span>
			<s:select label="Dozent" headerKey="none" headerValue="Bitte wählen..." list="dozentenList" listKey="id" listValue="person.getFullName()" 
				name="selectedDozent" value="selectedDozent"/>
			<div class="clear"></div>
		</div>	
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnCreatePruefung" action="savePruefung" cssClass="save" />
			<s:submit key="btnCancel" action="pruefungslist" cssClass="cancel" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>