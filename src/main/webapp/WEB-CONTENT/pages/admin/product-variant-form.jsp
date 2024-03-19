<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <p class="card-description"> Add new product </p>
                        <form class="forms-sample" action="${pageContext.request.contextPath}/admin/products/add-new" method="post">
                            <div class="form-group">
                                <label for="productName">Product name</label>
                                <input type="text" class="form-control text-dark" id="productName" name="productName" value="${productName}" disabled>
                            </div>
                            <div class="form-group">
                                <label for="variantName">VariantName name</label>
                                <input type="text" class="form-control" id="variantName" name="variantName" placeholder="Product Name">
                                <code>${violations.get("productName")}</code>
                            </div>
                            <c:forEach items="${productAttribute}" var="x">
                                <div class="form-group">
                                    <label for="exampleSelectGender">${x.attributeName}</label>
                                    <select class="form-control" id="exampleSelectGender">
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
                                    <input type="file" class="form-control file-upload-info" placeholder="Upload Image">
                                </div>
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
                                    <th>User</th>
                                    <th>Product</th>
                                    <th>Sale</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Jacob</td>
                                    <td>Photoshop</td>
                                    <td class="text-danger"> 28.76% <i class="mdi mdi-arrow-down"></i></td>
                                    <td><label class="badge badge-danger">Pending</label></td>
                                </tr>
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


