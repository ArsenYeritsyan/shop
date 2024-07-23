<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Products</title>
</head>
<body>
<h1>Products</h1>
<p>${flash.message}</p>

<!-- Product List -->
<h2>Product List</h2>
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

<!-- Create Product Form -->
<h2>Create Product</h2>
<g:form action="save" method="POST">
    <label for="code">Code:</label>
    <g:textField name="code" required="true"/><br/>
    <label for="name">Name:</label>
    <g:textField name="name" required="true"/><br/>
    <label for="price">Price:</label>
    <g:textField name="price" required="true"/><br/>
    <label for="dateOfManufacture">Date of Manufacture:</label>
    <g:datePicker name="dateOfManufacture"/><br/>
    <label for="deadline">Deadline:</label>
    <g:datePicker name="deadline"/><br/>
    <g:submitButton name="create" value="Create"/>
</g:form>

<!-- Link to Storage and Store pages -->
<p>
    <g:link controller="storage" action="index">Manage Storages</g:link> |
    <g:link controller="store" action="index">Manage Stores</g:link>
</p>
</body>
</html>
