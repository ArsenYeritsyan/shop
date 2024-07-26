<table class="table table-striped">
    <thead>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Price</th>
        <th>Date of Manufacture</th>
        <th>Deadline</th>
        <th>Store</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${productList}" var="product">
        <tr>
            <td>${product.code}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.dateOfManufacture}</td>
            <td>${product.deadline}</td>
            <td>${product.store?.name}</td>
            <td>
                <g:link action="edit" id="${product.id}" class="btn btn-primary btn-sm">Edit</g:link>
                <g:link action="delete" id="${product.id}" class="btn btn-danger btn-sm">Delete</g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
