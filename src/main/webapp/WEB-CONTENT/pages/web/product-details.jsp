<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Product - ${product.productName}</title>
<body>
<section class="py-5" ng-app="myApp">
    <div class="container">
        <div class="row mb-5">
            <div class="col-lg-6">
                <!-- PRODUCT SLIDER-->
                <div class="row m-sm-0">
                    <div class="col-sm-2 p-sm-0 order-2 order-sm-1 mt-2 mt-sm-0 px-xl-2">
                        <div class="swiper product-slider-thumbs swiper-initialized swiper-vertical swiper-pointer-events swiper-thumbs">
                            <div class="swiper-wrapper" id="swiper-wrapper-a03678580e263997" aria-live="polite" style="transform: translate3d(0px, 0px, 0px);">
                                <c:forEach items="${product.productVariants}" var="productVariant">
                                    <div class="swiper-slide h-auto swiper-thumb-item mb-3 swiper-slide-visible swiper-slide-active swiper-slide-thumb-active" role="group" aria-label="1 / 4" style="height: 371px;"><img class="w-100" src="/assets/uploads/product-thumbnail/${productVariant.image}" alt="..."></div>
                                </c:forEach>
                            </div>
                            <span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span></div>
                    </div>
                    <div class="col-sm-10 order-1 order-sm-2">
                        <div class="swiper product-slider swiper-initialized swiper-horizontal swiper-pointer-events">
                            <div class="swiper-wrapper" id="swiper-wrapper-2dd217597a4bd2fa" aria-live="polite" style="transform: translate3d(0px, 0px, 0px);">
                                <c:forEach items="${product.productVariants}" var="productVariant">
                                    <div class="swiper-slide h-auto swiper-thumb-item mb-3 swiper-slide-visible swiper-slide-active swiper-slide-thumb-active" role="group" aria-label="1 / 4" style="height: 371px;"><img class="w-100" src="/assets/uploads/product-thumbnail/${productVariant.image}" alt="..."></div>
                                </c:forEach>
                            </div>
                            <span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span></div>
                    </div>
                </div>
            </div>
            <!-- PRODUCT DETAILS-->
            <div class="col-lg-6">
                <ul class="list-inline mb-2 text-sm">
                    <li class="list-inline-item m-0"><i class="fas fa-star small text-warning"></i></li>
                    <li class="list-inline-item m-0 1"><i class="fas fa-star small text-warning"></i></li>
                    <li class="list-inline-item m-0 2"><i class="fas fa-star small text-warning"></i></li>
                    <li class="list-inline-item m-0 3"><i class="fas fa-star small text-warning"></i></li>
                    <li class="list-inline-item m-0 4"><i class="fas fa-star small text-warning"></i></li>
                </ul>
                <h1>${product.productName}</h1>
                <p class="text-muted lead">${product.minMaxPrices.get("min")} $ - ${product.minMaxPrices.get("max")} $ </p>
                <p class="text-sm mb-4">
                    ${product.description}
                </p>
                <div class="row align-items-stretch mb-4">
                    <div class="col-sm-3 pl-sm-0">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            View Variants
                        </button>
                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog  modal-dialog-centered">
                                <div class="modal-content m-auto">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">All Variant</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <form method="post" action="${pageContext.request.contextPath}/checkout-page" ng-controller="addToCartCtrl">
                                        <div class="modal-body">
                                            <div class="col-sm-5 pr-sm-0 w-auto">
                                                <c:forEach items="${product.productVariants}" var="x" varStatus="i">
                                                    <div class="form-control">
                                                        <input type="radio" class="btn-check" name="productVariantId" ng-model="productVariantId" value="${x.id}" id="option${i.index}" ${i.index == 0?'checked':''} autocomplete="off">
                                                        <label class="btn d-flex" for="option${i.index}">
                                                            <img src="/assets/uploads/product-thumbnail/${x.image}" class="m-auto" style="width: 150px;height: 150px" alt="">
                                                            <div>
                                                                <ul>
                                                                    <li> Name:${x.variantName}</li>
                                                                    <c:forEach items="${x.productVariantAttributes}" var="attribute">
                                                                        <li>${attribute.attributeParent.attributeName} : ${attribute.attributeName}</li>
                                                                    </c:forEach>
                                                                </ul>
                                                            </div>
                                                        </label>
                                                    </div>
                                                </c:forEach>
                                                <div class="border d-flex align-items-center justify-content-between py-1 px-3 bg-white border-white"><span class="small text-uppercase text-gray mr-4 no-select">Quantity</span>
                                                    <div class="quantity">
                                                        <button type="button" class="dec-btn p-0"><i class="fas fa-caret-left"></i></button>
                                                        <input class="form-control border-0 shadow-0 p-0" id="quantity" name="quantity" type="text" value="1">
                                                        <button type="button" class="inc-btn p-0"><i class="fas fa-caret-right"></i></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" ng-click="addToCart()" class="btn btn-secondary" data-bs-dismiss="modal">Add to cart</button>
                                            <button type="submit" class="btn btn-primary">Buy now</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><a class="text-dark p-0 mb-4 d-inline-block" href="#!"><i class="far fa-heart me-2"></i>Add to wish list</a><br>
                <ul class="list-unstyled small d-inline-block">
                    <li class="px-3 py-2 mb-1 bg-white"><strong class="text-uppercase">SKU:</strong><span class="ms-2 text-muted">039</span></li>
                    <li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">Category:</strong><a class="reset-anchor ms-2" href="#!">Demo Products</a></li>
                    <li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">Tags:</strong><a class="reset-anchor ms-2" href="#!">Innovation</a></li>
                </ul>
            </div>
        </div>
        <!-- DETAILS TABS-->
        <!-- RELATED PRODUCTS-->
        <h2 class="h5 text-uppercase mb-4">Related products</h2>
        <div class="row">
            <!-- PRODUCT-->
            <div class="col-lg-3 col-sm-6">
                <div class="product text-center skel-loader">
                    <div class="d-block mb-3 position-relative"><a class="d-block" href="detail.html"><img class="img-fluid w-100" src="img/product-1.jpg" alt="..."></a>
                        <div class="product-overlay">
                            <ul class="mb-0 list-inline">
                                <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#!"><i class="far fa-heart"></i></a></li>
                                <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="#!">Add to cart</a></li>
                                <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-bs-toggle="modal"><i class="fas fa-expand"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <h6> <a class="reset-anchor" href="detail.html">Kui Ye Chen’s AirPods</a></h6>
                    <p class="small text-muted">$250</p>
                </div>
            </div>
            <!-- PRODUCT-->
            <div class="col-lg-3 col-sm-6">
                <div class="product text-center skel-loader">
                    <div class="d-block mb-3 position-relative"><a class="d-block" href="detail.html"><img class="img-fluid w-100" src="img/product-2.jpg" alt="..."></a>
                        <div class="product-overlay">
                            <ul class="mb-0 list-inline">
                                <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#!"><i class="far fa-heart"></i></a></li>
                                <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="#!">Add to cart</a></li>
                                <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-bs-toggle="modal"><i class="fas fa-expand"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <h6> <a class="reset-anchor" href="detail.html">Air Jordan 12 gym red</a></h6>
                    <p class="small text-muted">$300</p>
                </div>
            </div>
            <!-- PRODUCT-->
            <div class="col-lg-3 col-sm-6">
                <div class="product text-center skel-loader">
                    <div class="d-block mb-3 position-relative"><a class="d-block" href="detail.html"><img class="img-fluid w-100" src="img/product-3.jpg" alt="..."></a>
                        <div class="product-overlay">
                            <ul class="mb-0 list-inline">
                                <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#!"><i class="far fa-heart"></i></a></li>
                                <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="#!">Add to cart</a></li>
                                <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-bs-toggle="modal"><i class="fas fa-expand"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <h6> <a class="reset-anchor" href="detail.html">Cyan cotton t-shirt</a></h6>
                    <p class="small text-muted">$25</p>
                </div>
            </div>
            <!-- PRODUCT-->
            <div class="col-lg-3 col-sm-6">
                <div class="product text-center skel-loader">
                    <div class="d-block mb-3 position-relative"><a class="d-block" href="detail.html"><img class="img-fluid w-100" src="img/product-4.jpg" alt="..."></a>
                        <div class="product-overlay">
                            <ul class="mb-0 list-inline">
                                <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#!"><i class="far fa-heart"></i></a></li>
                                <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="#!">Add to cart</a></li>
                                <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-bs-toggle="modal"><i class="fas fa-expand"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <h6> <a class="reset-anchor" href="detail.html">Timex Unisex Originals</a></h6>
                    <p class="small text-muted">$351</p>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.8.3/angular.min.js"
        integrity="sha512-KZmyTq3PLx9EZl0RHShHQuXtrvdJ+m35tuOiwlcZfs/rE7NZv29ygNA8SFCkMXTnYZQK2OX0Gm2qKGfvWEtRXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    var app = angular.module('myApp', []);
    app.controller('addToCartCtrl', function($scope, $http) {
        $scope.addToCart = function() {
            $http.post("${pageContext.request.contextPath}/add-to-cart", {
                productVariantId: $scope.productVariantId,
                quantity: document.getElementById("quantity").value
            }).then(function(response) {
                console.log(response.data)
            }).catch(function(error) {
                console.log(error)
            });
        }
    });
</script>
</body>

