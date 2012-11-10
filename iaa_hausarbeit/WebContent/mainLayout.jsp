<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%-- Niels Maseberg, Stefan Hauschildt --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="/iaa_hausarbeit/styles/reset.css" />
		<link rel="stylesheet" type="text/css" href="/iaa_hausarbeit/styles/layout.css" />
		<link rel="stylesheet" type="text/css" href="/iaa_hausarbeit/styles/print.css" media="print" />
		<link rel="icon" type="image/gif" href="/iaa_hausarbeit/images/nak.gif" />
		<sj:head/>
	</head>
	<body>
		<%--NoScript --%>
		<noscript>
			<div class="noscript">
				<h1><s:text name="txtNoScriptHeading" /></h1>
				<p>
					<s:text name="txtNoScriptText" />
				</p>
			</div>
		</noscript>
	
		<%--Head --%>
		<tiles:insertAttribute name="header" />
		<%--Navi --%>
		<tiles:insertAttribute name="navigation" />
		<%--Content --%>
		<div id="Content">
			<tiles:insertAttribute name="content" />
		</div>
		<%--Foot --%>
		<tiles:insertAttribute name="footer" />
	</body>
</html>