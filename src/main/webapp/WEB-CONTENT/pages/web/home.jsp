<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Laptop - Ecommerce</title>
<body>
<section class="hero pb-3 bg-cover bg-center d-flex align-items-center" style="background: url(/assets/web/img/hero-banner-alt.jpg)">
    <div class="container py-5">
        <div class="row px-4 px-lg-5">
            <div class="col-lg-6">
                <p class="text-muted small text-uppercase mb-2">New Inspiration 2020</p>
                <h1 class="h2 text-uppercase mb-3">20% off on new season</h1><a class="btn btn-dark" href="shop.html">Browse collections</a>
            </div>
        </div>
    </div>
</section>
<section class="py-5">
    <header>
        <p class="small text-muted small text-uppercase mb-1">Made the hard way</p>
        <h2 class="h5 text-uppercase mb-4">Top trending products</h2>
    </header>
    <div class="row">
        <!-- PRODUCT-->
        <c:forEach items="${top8Product}" var="product">
            <div class="col-xl-3 col-lg-4 col-sm-6">
                <div class="product text-center">
                    <div class="position-relative mb-3">
                        <div class="badge text-white bg-"></div><a class="d-block" href="${pageContext.request.contextPath}/product/detail?product=${product.slug}"><img class="img-fluid w-100" src="/assets/uploads/product-thumbnail/${product.thumbnail}" alt="..."></a>
                        <div class="product-overlay">
                            <ul class="mb-0 list-inline">
                                <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#!"><i class="far fa-heart"></i></a></li>
                                <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="">Add to cart</a></li>
                                <li class="list-inline-item me-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-bs-toggle="modal"><i class="fas fa-expand"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <h6> <a class="reset-anchor" href="${pageContext.request.contextPath}/product/detail?product=${product.slug}">${product.productName}</a></h6>
                    <p class="small text-muted">${product.minMaxPrices.get("min")} $ - ${product.minMaxPrices.get("max")} $ </p>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>