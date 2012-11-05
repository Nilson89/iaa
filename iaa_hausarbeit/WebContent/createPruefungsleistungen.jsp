<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm --%>

<h2><s:text name="txtHeadingPruefungsleistungsanlage" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>
<div class="textBox">
	<p><s:text name="txtAnweisungPruefungsleistungsanlage" /></p>
</div>
<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
	<div class="form">
		<div class="field">
			<span class="label"><s:text name="txtLabelPLMatrikelnummer" /></span>
			<s:textfield name="pruefungsleistung.student.matrikelnummer" label="Matrikelnummer"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label"><s:text name="txtLabelPLName" /></span>
			<s:textfield name="pruefungsleistung.student.person.name" label="Studentenname"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label"><s:text name="txtLabelPLVorname" /></span>
			<s:textfield name="pruefungsleistung.student.person.vorname" label="Studentenvorname"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label"><s:text name="txtLabelPLErsterVersuch" /></span>
			<s:select label="ErsterVersuch" headerKey="none" headerValue="Bitte wählen..." list="notenList" listKey="id" listValue="note" 
				name="selectedNoteEins" value="selectedNoteEins"/>
			<div class="clear"></div>
		</div>	
		<div class="field">
			<span class="label"><s:text name="txtLabelPLZweiterVersuch" /></span>
			<s:select label="ZweiterVersuch" headerKey="none" headerValue="Bitte wählen..." list="notenList" listKey="id" listValue="note" 
				name="selectedNoteZweiter" value="selectedNoteZweiter"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label"><s:text name="txtLabelPLDritterVersuch" /></span>
			<s:select label="DritterVersuch" headerKey="none" headerValue="Bitte wählen..." list="notenList" listKey="id" listValue="note" 
				name="selectedNoteDritter" value="selectedNoteDritter"/>
			<div class="clear"></div>
		</div>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnCreatePruefungsleistung" action="savePruefungsleistung" />
			<s:submit key="btnAbbrechen" action="showPruefungsleistungen" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>