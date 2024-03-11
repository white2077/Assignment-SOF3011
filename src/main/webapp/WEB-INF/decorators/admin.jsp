<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><sitemesh:write property="title"/></title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/admin/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../../assets/admin/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/admin/vendors/jvectormap/jquery-jvectormap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/admin/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/admin/vendors/owl-carousel-2/owl.carousel.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/admin/vendors/owl-carousel-2/owl.theme.default.min.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/admin/images/favicon.png"/>
</head>
<body>
<div class="container-scroller">
    <jsp:include page="../../WEB-CONTENT/layouts/admin/header-side-bar.jsp"/>
    <sitemesh:write property="body"/>

</div>

<script src="${pageContext.request.contextPath}/assets/admin/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<script src="${pageContext.request.contextPath}/assets/admin/vendors/chart.js/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/vendors/progressbar.js/progressbar.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/vendors/jvectormap/jquery-jvectormap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/vendors/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/vendors/owl-carousel-2/owl.carousel.min.js"></script>
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="${pageContext.request.contextPath}/assets/admin/js/off-canvas.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/hoverable-collapse.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/misc.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/settings.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page -->
<script src="${pageContext.request.contextPath}/assets/admin/js/dashboard.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.8.3/angular.min.js" integrity="sha512-KZmyTq3PLx9EZl0RHShHQuXtrvdJ+m35tuOiwlcZfs/rE7NZv29ygNA8SFCkMXTnYZQK2OX0Gm2qKGfvWEtRXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
