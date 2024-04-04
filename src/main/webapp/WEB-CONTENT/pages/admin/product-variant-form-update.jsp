<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<title>Admin - Add Product Variant</title>
<body>
<div class="main-panel">
    <div class="content-wrapper">
        <div class="page-header">
            <h3 class="page-title"> Add product </h3>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/products">Products</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Add Product</li>
                </ol>
            </nav>
        </div>
        <div class="row">
            <div class="col-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Add product</h4>
                        <p class="card-description"> Add new product variant for ${productVariant.variantName}</p>
                        <form class="forms-sample"
                              action="${pageContext.request.contextPath}/admin/product-variant/update?id=${productVariant.id}"
                              method="post"
                              enctype="multipart/form-data" method="post" accept="image/png, image/gif, image/jpeg">
                            <div class="form-group">
                                <label for="variantName">Variant Name</label>
                                <input type="text" class="form-control" id="variantName" name="variantName" value="${productVariant.variantName}" placeholder="Product Name">
                                <code>${violations.get("variantName")}</code>
                            </div>
                            <div class="form-group">
                                <label for="price">Price</label>
                                <input type="text" class="form-control" id="price" name="price" value="${productVariant.price}" placeholder="Product Name">
                                <code>${violations.get("price")}</code>
                            </div>
                            <div class="form-group">
                                <label for="quantity">Quantity</label>
                                <input type="text" class="form-control" id="quantity" name="quantity" value="${productVariant.quantity}" placeholder="Product Name">
                                <code>${violations.get("quantity")}</code>
                            </div>
                            <c:forEach items="${productAttribute}" var="x">
                                <div class="form-group">
                                    <label for="exampleSelectGender">${x.attributeName}</label>
                                    <select class="form-control" name="${x.slug}" id="exampleSelectGender">
                                        <option value="">--Please Select</option>
                                        <c:forEach items="${x.childAttributes}" var="child">
                                            <option value="${child.id}">${child.attributeName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </c:forEach>
                            <div class="form-group">
                                <label>Thumbnail upload</label>
                                <input type="file" class="file-upload-default">
                                <div class="input-group col-xs-12">
                                    <input type="file" class="form-control file-upload-info"
                                           placeholder="Upload Image" name="image">
                                </div>
                                <code>${violations.get("image")}</code>
                            </div>
                            <button type="submit" class="btn btn-primary mr-2">Submit</button>
                            <button type="button" class="btn btn-dark">Cancel</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">All Variant</h4>
                        <p class="card-description"> Add class
                        </p>
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Image</th>
                                    <th>Variant Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Created Date</th>
                                    <th>Updated Date</th>
                                    <th>Status</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${product.productVariants}" var="productVariant">
                                    <tr>
                                        <td class="py-1">
                                            <img src="${pageContext.request.contextPath}/assets/uploads/product-thumbnail/${productVariant.image}" alt="image" />
                                        </td>                                        <td>${productVariant.variantName}</td>
                                        <td>${productVariant.price}</td>
                                        <td>${productVariant.quantity}</td>
                                        <td> <fmt:formatDate value="${productVariant.createdDate}"/></td>
                                        <td> ${productVariant.modifiedDate != null ? productVariant.modifiedDate :'No modified'} </td>
                                        <c:choose>
                                            <c:when test="${productVariant.status}">
                                                <td><label class="badge badge-success">Available</label></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><label class="badge badge-danger">Unavailable</label></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td>
                                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/product-variant/update-page?id=${productVariant.id}">Edit</a>
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/product-variant/delete?id=${productVariant.id}">Delete</a>
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
</div>
</body>


