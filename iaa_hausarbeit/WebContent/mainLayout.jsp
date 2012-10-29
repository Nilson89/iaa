<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%-- Niels Maseberg --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<link rel="stylesheet" type="text/css" href="/iaa_hausarbeit/styles/reset.css" />
		<link rel="stylesheet" type="text/css" href="/iaa_hausarbeit/styles/layout.css" />
	</head>
	<body>
		<%--Head --%>
		<tiles:insertAttribute name="header" />
		<%--Navi --%>
		<tiles:insertAttribute name="navigation" />
		<%--Content --%>
		<div id="Content">
			<tiles:insertAttribute name="breadcrumb" />
			<tiles:insertAttribute name="content" />
		</div>
		<%--Foot --%>
		<tiles:insertAttribute name="footer" />
	</body>
</html>