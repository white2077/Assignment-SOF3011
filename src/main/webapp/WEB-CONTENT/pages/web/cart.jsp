<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Cart</title>
<body>
<section class="py-5 bg-light">
    <div class="container">
        <div class="row px-4 px-lg-5 py-lg-4 align-items-center">
            <div class="col-lg-6">
                <h1 class="h2 text-uppercase mb-0">Cart</h1>
            </div>
            <div class="col-lg-6 text-lg-end">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb justify-content-lg-end mb-0 px-0 bg-light">
                        <li class="breadcrumb-item"><a class="text-dark" href="index.html">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Cart</li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>
</section>
<section class="py-5" ng-app="myApp" ng-controller="cartCtrl">
    <h2 class="h5 text-uppercase mb-4">Shopping cart</h2>
    <div class="row">
        <div class="col-lg-8 mb-4 mb-lg-0">
            <!-- CART TABLE-->
            <div class="table-responsive mb-4" >
                <table class="table text-nowrap">
                    <thead class="bg-light">
                    <tr>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Product</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Price</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Quantity</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Total</strong></th>
                        <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase"></strong></th>
                    </tr>
                    </thead>
                    <tbody class="border-0">
                        <tr ng-repeat="cartItem in cart">
                            <th class="ps-0 py-3 border-light" scope="row">
                                <div class="d-flex align-items-center"><a class="reset-anchor d-block animsition-link" href="detail.html"><img src="/assets/uploads/product-thumbnail/{{cartItem.productVariant.image}}" alt="..." width="70"></a>
                                    <div class="ms-3"><strong class="h6"><a class="reset-anchor animsition-link" href="detail.html">{{cartItem.productVariant.variantName}}</a></strong></div>
                                </div>
                            </th>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">{{cartItem.productVariant.price}}</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <div class="border d-flex align-items-center justify-content-between px-3"><span class="small text-uppercase text-gray headings-font-family">Quantity</span>
                                    <div class="quantity">
                                        <button class="dec-btn p-0" ng-click="removeItems(cartItem.productVariant.id)"><i class="fas fa-caret-left"></i></button>
                                        <input class="form-control form-control-sm border-0 shadow-0 p-0" type="text" ng-model="cartItem.quantity"/>
                                        <button class="inc-btn p-0" ng-click="addItems(cartItem.productVariant.id)"><i class="fas fa-caret-right"></i></button>
                                    </div>
                                </div>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">{{total}}</p>
                            </td>
                            <c:choose>
                                <c:when test="${not empty sessionScope.user}">
                                    <td class="p-3 align-middle border-light"><a class="reset-anchor"><i ng-click="removeCartProduct(cartItem.id)" class="fas fa-trash-alt small text-muted"></i></a></td>
                                </c:when>
                                <c:otherwise>
                                    <td class="p-3 align-middle border-light"><a class="reset-anchor"><i ng-click="removeCartProduct(cartItem.productVariant.id)" class="fas fa-trash-alt small text-muted"></i></a></td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- CART NAV-->
            <div class="bg-light px-4 py-3">
                <div class="row align-items-center text-center">
                    <div class="col-md-6 mb-3 mb-md-0 text-md-start"><a class="btn btn-link p-0 text-dark btn-sm" href="shop.html"><i class="fas fa-long-arrow-alt-left me-2"> </i>Continue shopping</a></div>
                    <form method="post" action="${pageContext.request.contextPath}/checkout-cart">
                        <div class="col-md-6 text-md-end"><button type="submit" class="btn btn-outline-dark btn-sm">Procceed to checkout<i class="fas fa-long-arrow-alt-right ms-2"></i></button></div>
                    </form>
                </div>
            </div>
        </div>
        <!-- ORDER TOTAL-->
        <div class="col-lg-4">
            <div class="card border-0 rounded-0 p-lg-4 bg-light">
                <div class="card-body">
                    <h5 class="text-uppercase mb-4">Cart total</h5>
                    <ul class="list-unstyled mb-0">
                        <li class="d-flex align-items-center justify-content-between"><strong class="text-uppercase small font-weight-bold">Subtotal</strong><span class="text-muted small">{{total}}</span></li>
                        <li class="border-bottom my-2"></li>
                        <li class="d-flex align-items-center justify-content-between mb-4"><strong class="text-uppercase small font-weight-bold">Total</strong><span>{{total}}</span></li>
                        <li>
                            <form action="#">
                                <div class="input-group mb-0">
                                    <input class="form-control" type="text" placeholder="Enter your coupon">
                                    <button class="btn btn-dark btn-sm w-100" type="submit"> <i class="fas fa-gift me-2"></i>Apply coupon</button>
                                </div>
                            </form>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    let myApp = angular.module('myApp', []);
    myApp.controller('cartCtrl', function ($scope, $http) {
        $scope.cart = [];
        let cartItemPost = {
            productVariantId: 0,
            quantity: 0
        };
        $scope.total = 0;
        getCart();
        function getCart() {
            $http.get('${pageContext.request.contextPath}/get-cart').then(function (response) {
                $scope.cart = response.data;
                console.log(response.data)
            }).then(total).catch(function (error) {
                total();
            });
        }
         function total () {
            let total = 0;
            $scope.cart.forEach(function (cartItem) {
                total += cartItem.productVariant.price * cartItem.quantity;
            });
             console.log(total)
            $scope.total = total;
        }
        $scope.addItems = function (productId) {
            $scope.cart.forEach(function (cartItem) {
                if (cartItem.productVariant.id === productId) {
                    cartItem.quantity++;
                }
            });
            cartItemPost.productVariantId = productId;
            cartItemPost.quantity = 1;
            $http.post('${pageContext.request.contextPath}/add-to-cart', cartItemPost).then(function (response) {
                $scope.cart = response.data;
                getCart();
            }).catch(function (error) {
                getCart();
            });
        }
        $scope.removeItems = function (productId) {
            $scope.cart.forEach(function (cartItem) {
                if (cartItem.productVariant.id === productId) {
                    cartItem.quantity--;
                }
            });
            cartItemPost.productVariantId = productId;
            cartItemPost.quantity = -1;
            $http.post('${pageContext.request.contextPath}/add-to-cart', cartItemPost).then(function (response) {
                $scope.cart = response.data;
                getCart();
            }).catch(function (error) {
                getCart();
            });
        }
        $scope.removeCartProduct = function (id) {
            console.log(123)
            const API = 'http://localhost:8080/remove-cart-item?id='+id;
            $http.delete(API).then(function (response) {
                $scope.cart = response.data;
                getCart();
            }).catch(function (error) {
                getCart();
            });
        }
    });
</script>
</body>


