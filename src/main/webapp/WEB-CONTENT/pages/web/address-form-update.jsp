<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Add address</title>
<body>
<section class="py-5 bg-light">
    <div class="container">
        <div class="row px-4 px-lg-5 py-lg-4 align-items-center">
            <div class="col-lg-6">
                <h1 class="h2 text-uppercase mb-0">Address</h1>
            </div>
            <div class="col-lg-6 text-lg-end">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb justify-content-lg-end mb-0 px-0 bg-light">
                        <li class="breadcrumb-item"><a class="text-dark" href="/">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Add Address</li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>
</section>
<section class="py-5">
    <!-- BILLING ADDRESS-->
    <h2 class="h5 text-uppercase mb-4">Add address</h2>
    <div class="row">
        <div class="col-lg-8">
            <form action="${pageContext.request.contextPath}/address/edit?id=${address.id}" method="post">
                <div class="row gy-3">
                    <div class="col-lg-12">
                        <label class="form-label text-sm text-uppercase" for="address">Address</label>
                        <input class="form-control form-control-lg" type="text"
                               id="address"
                               placeholder="House number and street name"
                               value="${address.address}"
                               name="address">
                        <span style="color: red">${violations.get("address")}</span>

                    </div>
                    <div class="col-lg-6">
                        <label class="form-label text-sm text-uppercase" for="district">District</label>
                        <input class="form-control form-control-lg" type="text" id="district"
                               name="district"
                               value="${address.district}">
                        <span style="color: red">${violations.get("district")}</span>

                    </div>
                    <div class="col-lg-6">
                        <label class="form-label text-sm text-uppercase" for="cityOrProvince">City/Province</label>
                        <input class="form-control form-control-lg" type="text" id="cityOrProvince"
                               name="cityOrProvince"
                               value="${address.cityOrProvince}"
                        >
                        <span style="color: red">${violations.get("cityOrProvince")}</span>

                    </div>
                    <div class="col-lg-12 form-group">
                        <button class="btn btn-dark" type="submit">Add Order</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
</body>