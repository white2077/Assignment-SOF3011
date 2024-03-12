<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Admin - Add Product</title>
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
                        <form class="forms-sample" action="${pageContext.request.contextPath}/admin/products/add-new"
                              enctype="multipart/form-data" method="post" accept="image/png, image/gif, image/jpeg">
                            <div class="form-group">
                                <label for="productName">Product name</label>
                                <input type="text" class="form-control" id="productName" name="productName" placeholder="Product Name">
                                <code>${violations.get("productName")}</code>
                            </div>
                            <c:forEach items="${productAttribute}" var="x">
                                <div class="form-group">
                                    <label for="exampleSelectGender">${x.attributeName}</label>
                                    <select class="form-control" name="${x.slug}" id="exampleSelectGender">
                                        <option value="">--Please select</option>
                                        <c:forEach items="${x.childAttributes}" var="child">
                                            <option value="${child.id}">${child.attributeName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </c:forEach>
                            <div class="form-group">
                                <label for="exampleSelectGender">${categories.attributeName}</label>
                                <c:forEach items="${categories.childAttributes}" var="x">
                                    <div class="form-check form-check-flat form-check-primary mr-3">
                                        <label class="form-check-label">
                                            <input type="checkbox" class="form-check-input">${x.attributeName}<i class="input-helper"></i></label>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="form-group">
                                <label>Thumbnail upload</label>
                                <input type="file" class="file-upload-default">
                                <div class="input-group col-xs-12">
                                    <input type="file"
                                           class="form-control file-upload-info" placeholder="Upload Image" name="thumbnail">
                                </div>
                                <code>${violations.get("thumbnail")}</code>
                            </div>
                            <div class="form-group">
                                <label for="exampleTextarea1">Description</label>
                                <textarea class="form-control" id="exampleTextarea1" name="description" rows="4"></textarea>
                                <code>${violations.get("description")}</code>
                            </div>
                            <button type="submit" class="btn btn-primary mr-2">Submit</button>
                            <button type="button" class="btn btn-dark">Cancel</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-4 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Add Category</h4>
                        <p class="card-description"> Add new category </p>
                        <form class="forms-sample" method="post" action="">
                            <div class="form-group">
                                <label for="parentAttributeName">PCategory Name</label>
                                <input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="Category Name">
                                <code>${violations.get("attributeName")}</code>
                            </div>
                            <button type="submit" class="btn btn-primary mr-2">Submit</button>
                            <button class="btn btn-dark">Cancel</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-4 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Add parent product attribute</h4>
                        <p class="card-description"> Add new parent attribute </p>
                        <form class="forms-sample" method="post" action="${pageContext.request.contextPath}/admin/attribute/add-parent-product-attribute">
                            <div class="form-group">
                                <label for="parentAttributeName">Parent Attribute Name</label>
                                <input type="text" class="form-control" id="parentAttributeName" name="parentAttributeName" placeholder="Attribute Name">
                                <code>${violations.get("attributeName")}</code>
                            </div>
                            <button type="submit" class="btn btn-primary mr-2">Submit</button>
                            <button class="btn btn-dark">Cancel</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-4 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Add child product attribute</h4>
                        <p class="card-description"> Add new attribute </p>
                        <form class="forms-sample" method="post" action="${pageContext.request.contextPath}/admin/attribute/add-child-product-attribute">
                            <div class="form-group">
                                <label for="parentAttribute">Product Parent Attribute</label>
                                <select class="form-control" id="parentAttribute" name="parentAttribute">
                                    <option value="">--Please select</option>
                                    <c:forEach items="${productAttribute}" var="x">
                                        <option value="${x.id}">${x.attributeName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="childAttributeName">Child Attribute Name</label>
                                <input type="text" class="form-control" id="childAttributeName" name="childAttributeName" placeholder="Attribute Name">
                                <code>${violations.get("attributeName")}</code>
                            </div>
                            <button type="submit" class="btn btn-primary mr-2">Submit</button>
                            <button class="btn btn-dark">Cancel</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">All Category</h4>
                        <p class="card-description">All product</p>
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Attribute Name</th>
                                    <th>Created Date</th>
                                    <th>Modifier Date</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Jacob</td>
                                    <td>53275531</td>
                                    <td>12 May 2017</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">All Attribute</h4>
                        <p class="card-description">All Child</p>
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Profile</th>
                                    <th>VatNo.</th>
                                    <th>Created</th>
                                    <th>Status</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Jacob</td>
                                    <td>53275531</td>
                                    <td>12 May 2017</td>
                                    <td><label class="badge badge-danger">Pending</label></td>
                                </tr>
                                <tr>
                                    <td>Messsy</td>
                                    <td>53275532</td>
                                    <td>15 May 2017</td>
                                    <td><label class="badge badge-warning">In progress</label></td>
                                </tr>
                                <tr>
                                    <td>John</td>
                                    <td>53275533</td>
                                    <td>14 May 2017</td>
                                    <td><label class="badge badge-info">Fixed</label></td>
                                </tr>
                                <tr>
                                    <td>Peter</td>
                                    <td>53275534</td>
                                    <td>16 May 2017</td>
                                    <td><label class="badge badge-success">Completed</label></td>
                                </tr>
                                <tr>
                                    <td>Dave</td>
                                    <td>53275535</td>
                                    <td>20 May 2017</td>
                                    <td><label class="badge badge-warning">In progress</label></td>
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


