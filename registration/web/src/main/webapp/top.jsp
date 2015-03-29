<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Course planner</title>
<link href="/web/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div id="wrapper">
		<div id="content">
			<div id="header">
				<div id="logo">
					<h1>Registration</h1>
				</div>
				<div id="links">
					<ul>
						<li><a href=/web>Home</a></li>
						<c:if test="${is_login eq null || is_login eq false}">
							<li><a href=/web/login>Login</a></li>
						</c:if>
						<c:if test="${is_login ne null && is_login eq true}">
							<li><a href=/web/logout>Logout</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div id="mainimg"></div>