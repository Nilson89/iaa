<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg, Sabrina Schramm --%>

<h2><s:text name="txtHeadingEditPruefungsleistung" /> "<s:property value="%{pruefungsfach.titel}" />"</h2>

<s:form>
	<s:hidden name="selectedPruefungsleistungId" value="%{selectedPruefungsleistungId}" />
	<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
	
	<div class="form">
		<div class="field">
			<span class="label"><s:text name="txtMatrikelnummer" />:</span>
			<span><s:property value="%{pruefungsleistung.getStudent().getMatrikelnummer()}" /></span>
			<div class="clear"></div>
		</div>
		
		<div class="field">
			<span class="label"><s:text name="txtName" />:</span>
			<span><s:property value="%{pruefungsleistung.getStudent().getPerson().getName()}" /></span>
			<div class="clear"></div>
		</div>
		
		<div class="field">
			<span class="label"><s:text name="txtVorname" />:</span>
			<span><s:property value="%{pruefungsleistung.getStudent().getPerson().getVorname()}" /></span>
			<div class="clear"></div>
		</div>
		
		<div class="field">
			<span class="label"><s:text name="txtLetzterVersuch" />:</span>
			<span><s:property value="%{pruefungsleistung.versuch}" />. <s:text name="txtVersuch" /></span>
			<div class="clear"></div>
		</div>
		
		<div class="field">
			<span class="label"><s:text name="txtNote" />:</span>
			<span><s:property value="%{pruefungsleistung.note}" /></span>
			<div class="clear"></div>
		</div>
		
		<s:if test="pruefungsleistung.ergaenzungspruefung != null">
			<div class="field">
				<span class="label"><s:text name="txtNoteErgaenzungspruefung" />:</span>
				<span><s:property value="%{pruefungsleistung.ergaenzungspruefung.note}" /></span>
				<div class="clear"></div>
			</div>
		</s:if>
		
		<div class="field">
			<span class="label"><s:text name="txtAktuelleNote" />:</span>
			<span><s:property value="%{pruefungsleistung.getEndNote()}" /></span>
			<div class="clear"></div>
		</div>
		
		<div class="field">
			<span class="label"><s:text name="txtNeueNote" />:</span>
			<span>
				<s:select list="noteList" headerKey="none" headerValue="Bitte wählen..." name="selectedNote" value="selectedNote" />
			</span>
			<div class="clear"></div>
		</div>
	</div>
	
	<div class="textBox">
		<p><s:text name="txtNoteFuenfDescription"/></p>
		<p><s:text name="txtNoteSechsDescription"/></p>
	</div>
	
	<div class="buttons">
		<div class="button">
			<s:submit key="btnSave" action="editPruefungsleistungSave" cssClass="save" />
		</div>
		<div class="button">
			<s:submit key="btnCancel" action="showPruefungsleistungen" cssClass="cancel" />
		</div>
		<div class="button">
			<s:submit key="btnReverse" action="editPruefungsleistungReverse" cssClass="reverse" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>