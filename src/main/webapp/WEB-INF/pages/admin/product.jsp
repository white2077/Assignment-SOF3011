<title>All Product</title>
<body>
<div class="main-panel">
    <div class="content-wrapper">
<div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">All Product</h4>
            <button type="button" class="btn btn-success btn-fw"> + Add Product</button>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th> Thumbnail </th>
                        <th> ProductName </th>
                        <th> Quantity </th>
                        <th> Price </th>
                        <th> Creation date</th>
                        <th> Modified date</th>
                        <th> Add Variant </th>
                        <th> Edit </th>
                        <th> Delete </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="py-1">
                            <img src="${pageContext.request.contextPath}/assets/admin/images/avt.jpg" alt="image" />
                        </td>
                        <td> Cute girl </td>
                        <td> 69 </td>
                        <td> $ 77.99 </td>
                        <td> May 15, 2015 </td>
                        <td> May 15, 2015 </td>
                        <td><a  class="btn-sm btn-success btn-fw"><i class="mdi mdi-window-restore"></i>Add variant</a></td>
                        <td><a  class="btn-sm btn-warning btn-fw"><i class="mdi mdi-border-color"></i>Edit</a></td>
                        <td><a  class="btn-sm btn-danger btn-fw"><i class="mdi mdi-bitbucket"></i>Delete</a> </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
    </div>
</div>
</body>
