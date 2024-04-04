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
                                <th>View Items</th>
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
                                   <c:choose>
                                       <c:when test="${x.status eq 'PENDING'}">
                                           <td>
                                               <button type="button" class="btn btn-warning">Pending</button>
                                           </td>
                                       </c:when>
                                       <c:when test="${x.status eq 'SUCCESS'}">
                                           <td>
                                               <button type="button" class="btn btn-success">Success</button>
                                           </td>
                                       </c:when>
                                       <c:when test="${x.status eq 'CANCEL'}">
                                           <td>
                                               <button type="button" class="btn btn-danger">Cancel</button>
                                           </td>
                                       </c:when>
                                       <c:when test="${x.status eq 'SHIPPING'}">
                                             <td>
                                                  <button type="button" class="btn btn-info">Shipping</button>
                                             </td>
                                       </c:when>
                                       <c:when test="${x.status eq 'FAILED'}">
                                             <td>
                                                  <button type="button" class="btn btn-danger">Failed</button>
                                             </td>
                                        </c:when>
                                   </c:choose>
                                      <td>
                                          <a href="${pageContext.request.contextPath}/admin/order-details/view-items?id=${x.id}" class="btn btn-success">View</a>
                                      </td>
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
