<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="jumbotron mt-5">
    <h1>Thanks for order</h1>
    <p>We will contract with you when order delivered.</p>
    <p>
        <a class="btn btn-primary btn-large" href="/">Continue Shopping</a>
        <a class="btn btn-outline-primary btn-large" href="/cart">Back To Cart</a>
    </p>
    <h1>Order ID: #${order.id}</h1>
    <div class="table-responsive mb-4" >
        <table class="table text-nowrap">
            <thead class="bg-light">
            <tr>
                <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Product</strong></th>
                <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Price</strong></th>
                <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Quantity</strong></th>
                <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">Total</strong></th>
            </tr>
            </thead>
            <tbody class="border-0">
            <c:forEach items="${order.orderItems}" var="x">
                <tr>
                    <th class="ps-0 py-3 border-light" scope="row">
                        <div class="d-flex align-items-center"><a class="reset-anchor d-block animsition-link" href="detail.html"><img src="/assets/uploads/product-thumbnail/${x.productVariant.image}" alt="..." width="70"></a>
                            <div class="ms-3"><strong class="h6"><a class="reset-anchor animsition-link" href="detail.html">${x.productVariant.variantName}</a></strong></div>
                        </div>
                    </th>
                    <td class="p-3 align-middle border-light">
                        <p class="mb-0 small">${x.productVariant.price}</p>
                    </td>
                    <td class="p-3 align-middle border-light">
                        <div class="border d-flex align-items-center justify-content-between px-3"><span class="small text-uppercase text-gray headings-font-family">Quantity</span>
                            <div class="quantity">
                                <input class="form-control form-control-sm border-0 shadow-0 p-0" type="text" value="${x.quantity}"/>
                            </div>
                        </div>
                    </td>
                    <td class="p-3 align-middle border-light">
                        <p class="mb-0 small">${x.price * x.quantity}</p>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <h3>Total ${order.total}</h3>
    </div>
</div>