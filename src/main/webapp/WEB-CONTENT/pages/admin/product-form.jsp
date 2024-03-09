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
                        <form class="forms-sample" action="${pageContext.request.contextPath}/admin/products/add-new" method="post">
                            <div class="form-group">
                                <label for="productName">Product name</label>
                                <input type="text" class="form-control" id="productName" name="productName" placeholder="Product Name">
                            </div>
                            <div class="form-group">
                                <label for="exampleSelectGender">Product Attribute</label>
                                <select class="form-control" id="exampleSelectGender">
                                    <option>Cute</option>
                                    <option>Female</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Thumbnail upload</label>
                                <input type="file" name="img[]" class="file-upload-default">
                                <div class="input-group col-xs-12">
                                    <input type="file" class="form-control file-upload-info" placeholder="Upload Image">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="exampleTextarea1">Description</label>
                                <textarea class="form-control" id="exampleTextarea1" rows="4"></textarea>
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
                        <h4 class="card-title">Add parent product attribute</h4>
                        <p class="card-description"> Add new parent attribute </p>
                        <form class="forms-sample">
                            <div class="form-group">
                                <label for="exampleInputUsername1">Parent Attribute Name</label>
                                <input type="text" class="form-control" id="exampleInputUsername1" placeholder="Attribute Name">
                            </div>
                            <button type="submit" class="btn btn-primary mr-2">Submit</button>
                            <button class="btn btn-dark">Cancel</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-6 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Add child product attribute</h4>
                        <p class="card-description"> Add new parent attribute </p>
                        <form class="forms-sample">
                            <div class="form-group">
                                <label for="exampleInputUsername1">Child Attribute Name</label>
                                <input type="text" class="form-control" id="childAttributeName" placeholder="Attribute Name">
                            </div>
                            <div class="form-group">
                                <label for="parentAttribute">Product Parent Attribute</label>
                                <select class="form-control" id="parentAttribute">
                                    <option>Cute</option>
                                    <option>Female</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary mr-2">Submit</button>
                            <button class="btn btn-dark">Cancel</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

