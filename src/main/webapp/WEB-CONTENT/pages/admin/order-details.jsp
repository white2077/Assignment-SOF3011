<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Admin - Order Details</title>
<body>
<div class="main-panel">
    <div class="content-wrapper">
        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">All Orders</h4>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th> Avatar </th>
                                <th> Customer name </th>
                                <th> Order ID </th>
                                <th> Total order </th>
                                <th> Order date </th>
                                <th> Phone Number</th>
                                <th> Address </th>
                                <th> Status </th>
                            </tr>
                            </thead>
                            <tbody>
                           <c:forEach items="${orderDetails}" var="x">
                               <tr>
                                   <td class="py-1">
                                       <img src="${pageContext.request.contextPath}/assets/admin/images/avt.jpg" alt="image" />
                                   </td>
                                   <td>${x.customerName}</td>
                                   <td>${x.id}</td>
                                   <td>${x.total}</td>
                                   <td>${x.createdDate}</td>
                                   <td>${x.phoneNumber}</td>
                                   <td>${x.address} - ${x.district} - ${x.cityOrProvince}</td>
                                   <td><label class="badge badge-success">Completed</label></td>
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
