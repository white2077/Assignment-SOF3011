<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Checkout</title>
<body>
<section class="py-5 bg-light">
    <div class="container">
        <div class="row px-4 px-lg-5 py-lg-4 align-items-center">
            <div class="col-lg-6">
                <h1 class="h2 text-uppercase mb-0">Checkout</h1>
            </div>
            <div class="col-lg-6 text-lg-end">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb justify-content-lg-end mb-0 px-0 bg-light">
                        <li class="breadcrumb-item"><a class="text-dark" href="index.html">Home</a></li>
                        <li class="breadcrumb-item"><a class="text-dark" href="cart.html">Cart</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Checkout</li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>
</section>
<section class="py-5">
    <!-- BILLING ADDRESS-->
    <h2 class="h5 text-uppercase mb-4">Billing details</h2>
    <div class="row">
        <div class="col-lg-8">
            <form action="#">
                <div class="row gy-3">
                    <div class="col-lg-6">
                        <label class="form-label text-sm text-uppercase" for="firstName">First name </label>
                        <input class="form-control form-control-lg" type="text" id="firstName" placeholder="Enter your first name">
                    </div>
                    <div class="col-lg-6">
                        <label class="form-label text-sm text-uppercase" for="lastName">Last name </label>
                        <input class="form-control form-control-lg" type="text" id="lastName" placeholder="Enter your last name">
                    </div>
                    <div class="col-lg-6">
                        <label class="form-label text-sm text-uppercase" for="email">Email address </label>
                        <input class="form-control form-control-lg" type="email" id="email" placeholder="e.g. Jason@example.com">
                    </div>
                    <div class="col-lg-6">
                        <label class="form-label text-sm text-uppercase" for="phone">Phone number </label>
                        <input class="form-control form-control-lg" type="tel" id="phone" placeholder="e.g. +02 245354745">
                    </div>
                    <div class="col-lg-12">
                        <label class="form-label text-sm text-uppercase" for="address">Address</label>
                        <input class="form-control form-control-lg" type="text" id="address" placeholder="House number and street name">
                    </div>
                    <div class="col-lg-6">
                        <label class="form-label text-sm text-uppercase" for="city">District </label>
                        <input class="form-control form-control-lg" type="text" id="city">
                    </div>
                    <div class="col-lg-6">
                        <label class="form-label text-sm text-uppercase" for="state">City/Province</label>
                        <input class="form-control form-control-lg" type="text" id="state">
                    </div>
                    <div class="col-lg-12 form-group">
                        <button class="btn btn-dark" type="submit">Place order</button>
                    </div>
                </div>
            </form>
        </div>
        <!-- ORDER SUMMARY-->
        <div class="col-lg-4">
            <div class="card border-0 rounded-0 p-lg-4 bg-light">
                <div class="card-body">
                    <h5 class="text-uppercase mb-4">Your order</h5>
                    <ul class="list-unstyled mb-0 mb-5">
                        <c:forEach items="${sessionScope.cart}" var="x">
                            <li class="d-flex align-items-center justify-content-between me-3">
                                <strong class="small fw-bold">${x.productVariant.variantName}</strong>
                                <span class="price" class="text-muted small">${x.productVariant.price} đ</span>
                                <span class="text-muted small">${x.quantity}</span>
                            </li>
                        </c:forEach>
                    </ul>
                    <h5 class="text-uppercase mb-4" id="total"> </h5>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    const priceElements = document.getElementsByClassName("price");
    const quantityElements = document.getElementsByClassName("text-muted small");
    let totalPrice = 0;
    let totalQuantity = 0;
    for (let i = 0; i < priceElements.length; i++) {
        const priceText = priceElements[i].textContent;
        const price = parseFloat(priceText.replace(/[^\d.]/g, ""));

        const quantityText = quantityElements[i].textContent;
        const quantity = parseInt(quantityText);

        const subtotal = price * quantity;
        totalPrice += subtotal;
        totalQuantity += quantity;
    }
    const totalElement = document.getElementById("total");
    totalElement.textContent = "Total: " + totalPrice + " đ";
</script>
</body>