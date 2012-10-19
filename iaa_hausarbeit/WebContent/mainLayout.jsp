<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
	</head>
	<body>
		<%--Head --%>
		<tiles:insertAttribute name="header" />
		<%--Content --%>
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>
	</body>
</html>