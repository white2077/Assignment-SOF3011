<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Your order</title>
<body>
<section class="py-5 bg-light">
    <div class="container">
        <div class="row px-4 px-lg-5 py-lg-4 align-items-center">
            <div class="col-lg-6">
                <h1 class="h2 text-uppercase mb-0">Your address</h1>
            </div>
            <div class="col-lg-6 text-lg-end">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb justify-content-lg-end mb-0 px-0 bg-light">
                        <li class="breadcrumb-item"><a class="text-dark" href="index.html">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Address</li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>
</section>
<section class="py-5">
    <h2 class="h5 text-uppercase mb-4">Your Address</h2>
    <a href="${pageContext.request.contextPath}/address/add-page" class="btn btn-outline-dark btn-sm">Add address</a>

    <div class="row">
        <div class="col-lg-12 mb-8 mb-lg-0">
            <!-- CART TABLE-->
            <div class="table-responsive mb-4" >
                <table class="table text-nowrap">
                    <thead class="bg-light">
                    <tr>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Address</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">District</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">City Or Province</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Created Date</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Update Date</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Is default ?</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Update</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Set Default</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Delete</strong></th>
                    </tr>
                    </thead>
                    <tbody class="border-0">
                    <c:forEach items="${address}" var="address">
                        <tr>
                            <td class="p-3">${address.address}</td>
                            <td class="p-3">${address.district}</td>
                            <td class="p-3">${address.cityOrProvince}</td>
                            <td class="p-3"><fmt:formatDate value="${address.createdDate}"/></td>
                            <td class="p-3"> <fmt:formatDate value="${address.modifiedDate}"/></td>
                            <td class="p-3">${address.defaultAddress}</td>
                            <td class="p-3"><a href="${pageContext.request.contextPath}/address/edit-page?id=${address.id}">Update</a></td>
                            <td class="p-3"><a href="${pageContext.request.contextPath}/address/set-default?id=${address.id}">Set Default</a></td>
                            <td class="p-3"><a href="${pageContext.request.contextPath}/address/delete?id=${address.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- CART NAV-->
        </div>
    </div>
</section>
</body>


