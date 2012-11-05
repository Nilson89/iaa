<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm --%>

<h2><s:text name="txtHeadingMdlPruefungsleistungsanlage" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>
<div class="textBox">
	<p><s:text name="txtAnweisungMdlPruefungsleistungsanlage" /></p>
</div>
<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
	<div class="form">
		<div class="field">
			<span class="label"><s:text name="txtLabelMdlPLMatrikelnummer" /></span>
			<s:textfield name="pruefungsleistung.student.matrikelnummer" label="Matrikelnummer"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label"><s:text name="txtLabelMdlPLName" /></span>
			<s:textfield name="pruefungsleistung.student.person.name" label="Studentenname"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label"><s:text name="txtLabelMdlPLVorname" /></span>
			<s:textfield name="pruefungsleistung.student.person.vorname" label="Studentenvorname"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label"><s:text name="txtLabelMdlPLLetzterVersuch" /></span>
			<s:textfield name="pruefungsleistung.versuch" label="PruefungsVersuch"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label"><s:text name="txtLabelMdlPLAktuelleNote" /></span>
			<s:textfield name="pruefungsleistung.note" label="Pruefungsnote"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label"><s:text name="txtLabelMdlPLNeueNote" /></span>
			<s:select label="NeueNote" headerKey="none" headerValue="Bitte wählen..." list="notenList" listKey="id" listValue="note" 
				name="selectedNote" value="selectedNote"/>
			<div class="clear"></div>
		</div>	
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnCreatePruefungsleistung" action="saveMdlPruefungsleistung" />
			<s:submit key="btnAbbrechen" action="showPruefungsleistungen" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>