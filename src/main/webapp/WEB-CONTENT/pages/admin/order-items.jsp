<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Oder</title>
<body>
<div class="main-panel">
    <div class="content-wrapper">
        <form method="post" action="${pageContext.request.contextPath}/admin/order-details/update-status?id=${orderDetail.id}">
        <div class="col-md-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Orders #${orderDetail.id}</h4>
                        <p class="card-description"> Order Information</p>
                        <form class="forms-sample">
                            <div class="form-group">
                                <label >Customer name: ${orderDetail.customerName}</label>
                            </div>
                            <div class="form-group">
                                <label >Phone number:   ${orderDetail.phoneNumber} </label>
                            </div>
                            <div class="form-group">
                                <label >City Or Province: ${orderDetail.cityOrProvince}  </label>
                            </div>
                            <div class="form-group">
                                <label >District: ${orderDetail.district}</label>
                            </div>
                            <div class="form-group">
                                <label >Address: ${orderDetail.address}</label>
                            </div>
                            <div class="form-group">
                                <label for="exampleFormControlSelect2">Order Status</label>
                                <select class="form-control" id="exampleFormControlSelect2" name="orderStatus">
                                    <c:forEach items="${orderStatus}" var="x">
                                        <option value="${x.name()}">${x.name()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary mr-2">Submit</button>
                            <button class="btn btn-dark">Cancel</button>
                        </form>
                    </div>
                </div>
        </div>
        </form>
        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Items</h4>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th> Image </th>
                                <th> Items name </th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orderDetail.orderItems}" var="x">
                                <tr>
                                    <td class="py-1">
                                        <img src="${pageContext.request.contextPath}/assets/uploads/product-thumbnail/${x.productVariant.image}" alt="image" />
                                    </td>
                                    <td>${x.productVariant.variantName}</td>
                                    <td>${x.productVariant.price}</td>
                                    <td>${x.productVariant.quantity}</td>
                                    <td>${x.productVariant.price * x.productVariant.quantity}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>