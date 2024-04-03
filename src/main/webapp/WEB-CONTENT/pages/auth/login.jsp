<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/admin/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/vendors/css/vendor.bundle.base.css">
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
<form action="${pageContext.request.contextPath}/login" method="post">
    <div class="content-wrapper" style="height: 100%">
        <div class="row d-flex justify-content-center">
            <div class="col-md-6 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Horizontal Form</h4>
                        <p class="card-description"> Horizontal form layout </p>
                        <form class="forms-sample">
                            <div class="form-group row">
                                <label for="exampleInputUsername2" class="col-sm-3 col-form-label">Email</label>
                                <br>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="exampleInputUsername2" placeholder="Username"
                                           name="username">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="exampleInputEmail2" class="col-sm-3 col-form-label">Password</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="exampleInputEmail2" placeholder="password"
                                           name="password">
                                </div>
                            </div>
                            <div class="form-check form-check-flat form-check-primary">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input"> Remember me <i class="input-helper"></i></label>
                            </div>
                            <button type="submit" class="btn btn-primary w-100 ">Login</button>
<%--                            <button class="btn btn-dark">Cancel</button>--%>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
    <!-- plugins:js -->
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

</body>
</html>
