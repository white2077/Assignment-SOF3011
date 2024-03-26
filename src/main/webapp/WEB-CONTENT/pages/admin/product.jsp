<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>Admin - All Products</title>
<body>
<div class="main-panel">
    <div class="content-wrapper">
<div class="col-lg-12 grid-margin stretch-card" ng-app="app">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">All Product</h4>
            <a type="button" href="${pageContext.request.contextPath}/admin/products/add-product" class="btn btn-success btn-fw"> + Add Product</a>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th> Thumbnail  </th>
                        <th> ProductName </th>
                        <th> Creation date</th>
                        <th> Modified date</th>
                        <th> Category </th>
                        <th> Status </th>
                        <th> Add Variant</th>
                        <th> Edit </th>
                        <th> Delete </th>
                    </tr>
                    </thead>
                    <tbody>
                   <c:forEach items="${products}" var="x">
                       <tr>
                           <td class="py-1">
                               <img src="${pageContext.request.contextPath}/assets/uploads/product-thumbnail/${x.thumbnail}" alt="image" />
                           </td>
                           <td> ${x.productName} </td>
                           <td><fmt:formatDate value="${x.createdDate}"/> </td>
                           <c:choose>
                               <c:when test="${x.modifiedDate == null}"><td>No modified</td></c:when>
                               <c:otherwise>
                                   <td> <fmt:formatDate value="${x.modifiedDate}"/> </td>
                               </c:otherwise>
                           </c:choose>
                           <td>
                               <c:forEach items="${x.productAttribute}" var="c">
                                   ${c.attributeName},
                               </c:forEach>
                           </td>
                           <c:choose>
                               <c:when test="${x.status}">
                                   <td><label class="badge badge-success">Available</label></td>
                               </c:when>
                               <c:otherwise>
                                   <td><label class="badge badge-danger">Unavailable</label></td>
                               </c:otherwise>
                           </c:choose>
                           <td>
                               <a href="${pageContext.request.contextPath}/admin/product/add-product-variant-page?product=${x.slug}"
                                  class="btn-sm btn-success btn-fw"><i class="mdi mdi-window-restore">
                           </i>Add variant
                               </a>
                           </td>
                           <td>
                               <a href="${pageContext.request.contextPath}/admin/products/update-product?product=${x.slug}" class="btn-sm btn-warning btn-fw"><i class="mdi mdi-border-color">
                               </i>Edit
                               </a>
                           </td>
                           <td>
                               <form method="post" action="${pageContext.request.contextPath}/admin/products/delete?productId=${x.id}">
                                   <button type="submit"  class="btn-sm btn-danger btn-fw"><i class="mdi mdi-bitbucket"></i>Delete</button>
                               </form>
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