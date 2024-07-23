<p>${flash.message}</p>
<table>
    <thead>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Price</th>
        <th>Date of Manufacture</th>
        <th>Deadline</th>
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
            <td>
                <g:link action="edit" id="${product.id}">Edit</g:link> |
                <g:link action="delete" id="${product.id}">Delete</g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
