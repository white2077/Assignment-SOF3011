<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title><sitemesh:write property="title"/></title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Electro - HTML Ecommerce Template</title>
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/web/css/bootstrap.min.css"/>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/web/css/slick.css"/>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/web/css/slick-theme.css"/>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/web/css/nouislider.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/web/css/font-awesome.min.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/web/css/style.css"/>
</head>
<body>
<%@include file="../../WEB-CONTENT/layouts/web/header.jsp"%>

<sitemesh:write property="body"/>

<%@include file="../../WEB-CONTENT/layouts/web/footer.jsp"%>
</body>
<script src="${pageContext.request.contextPath}/assets/web/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/web/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/web/js/slick.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/web/js/nouislider.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/web/js/jquery.zoom.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/web/js/main.js"></script>
</html>
