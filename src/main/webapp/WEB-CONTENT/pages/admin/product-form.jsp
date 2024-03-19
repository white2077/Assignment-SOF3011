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
                            <div class="form-group">
                                <label for="categoryName">${categories.attributeName}</label>
                                <c:forEach items="${categories.childAttributes}" var="x">
                                    <div class="form-check form-check-flat form-check-primary mr-3">
                                        <label class="form-check-label">
                                            <input type="checkbox" value="${x.id}" name="categoriesId"
                                                   class="form-check-input">${x.attributeName}
                                            <i class="input-helper"></i></label>
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
            <div class="col-md-6 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Add Category</h4>
                        <p class="card-description"> Add new category </p>
                        <form class="forms-sample" method="post" action="${pageContext.request.contextPath}/admin/attribute/add-category">
                            <div class="form-group">
                                <label for="categoryName">Category Name</label>
                                <input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="Category Name">
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
                        <h4 class="card-title">Hoverable Table</h4>
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


