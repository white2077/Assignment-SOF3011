<header class="header bg-white">
    <div class="container px-lg-3">
        <nav class="navbar navbar-expand-lg navbar-light py-3 px-lg-0"><a class="navbar-brand" href="index.html"><span class="fw-bold text-uppercase text-dark">Ecommerce</span></a>
            <button class="navbar-toggler navbar-toggler-end" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <!-- Link--><a class="nav-link active" href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <!-- Link--><a class="nav-link" href="shop.html">Shop</a>
                    </li>
                    <li class="nav-item">
                        <!-- Link--><a class="nav-link" href="detail.html">Product detail</a>
                    </li>
                </ul>
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/cart"> <i class="fas fa-dolly-flatbed me-1 text-gray"></i>Cart<small class="text-gray fw-normal">(2)</small></a></li>
                    <li class="nav-item"><a class="nav-link" href="#!"> <i class="far fa-heart me-1"></i><small class="text-gray fw-normal"> (0)</small></a></li>
                    <c:choose>
                        <c:when test="${sessionScope.user == null}">
                            <li class="nav-item"><a class="nav-link" href="/login"> <i class="fas fa-user me-1 text-gray fw-normal"></i>Login</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="pagesDropdown" href="#" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${sessionScope.user.name}</a>
                                <div class="dropdown-menu mt-3 shadow-sm" aria-labelledby="pagesDropdown">
                                    <a class="dropdown-item border-0 transition-link" href="${pageContext.request.contextPath}/address">Your Address</a>
                                    <a class="dropdown-item border-0 transition-link" href="${pageContext.request.contextPath}/order-detail">Orders detail</a>
                                    <a class="dropdown-item border-0 transition-link" href="${pageContext.request.contextPath}/cart">Shopping cart</a>
                                    <a class="dropdown-item border-0 transition-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                                </div>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </nav>
    </div>
</header>