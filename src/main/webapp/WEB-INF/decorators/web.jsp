<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title><sitemesh:write property="title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Electro - HTML Ecommerce Template</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="/assets/web/css/bootstrap.min.css"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="/assets/web/css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/web/css/slick-theme.css"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href="/assets/web/css/nouislider.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="/assets/web/css/font-awesome.min.css">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="/assets/web/css/style.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

   <jsp:include page="../layouts/web/header.jsp"/>
   <sitemesh:write property="body"/>
   <jsp:include page="../layouts/web/footer.jsp"/>

<script src="../../assets/web/js/jquery.min.js"></script>
<script src="../../assets/web/js/bootstrap.min.js"></script>
<script src="../../assets/web/js/slick.min.js"></script>
<script src="../../assets/web/js/nouislider.min.js"></script>
<script src="../../assets/web/js/jquery.zoom.min.js"></script>
<script src="../../assets/web/js/main.js"></script>
</html>
