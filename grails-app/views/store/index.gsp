<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Stores</title>
</head>

<body>
<h1>Stores</h1>

<p>${flash.message}</p>

<!-- Store List -->
<h2>Store List</h2>
<table>
    <thead>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Address</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${storeList}" var="store">
        <tr>
            <td>${store.code}</td>
            <td>${store.name}</td>
            <td>${store.address}</td>
            <td>
                <g:link action="edit" id="${store.id}">Edit</g:link> |
                <g:link action="delete" id="${store.id}">Delete</g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>

<!-- Create Store Form -->
<h2>Create Store</h2>
<g:form action="save" method="POST">
    <label for="code">Code:</label>
    <g:textField name="code" required="true"/><br/>
    <label for="name">Name:</label>
    <g:textField name="name" required="true"/><br/>
    <label for="address">Address:</label>
    <g:textField name="address" required="true"/><br/>
    <g:submitButton name="create" value="Create"/>
</g:form>

<!-- Add Product to Store Form -->
<h2>Add Product to Store</h2>
<g:form action="addProduct" method="POST">
    <label for="storeId">Store ID:</label>
    <g:textField name="storeId" required="true"/><br/>
    <label for="productId">Product ID:</label>
    <g:textField name="productId" required="true"/><br/>
    <g:submitButton name="add" value="Add"/>
</g:form>

<!-- Remove Product from Store Form -->
<h2>Remove Product from Store</h2>
<g:form action="removeProduct" method="POST">
    <label for="storeId">Store ID:</label>
    <g:textField name="storeId" required="true"/><br/>
    <label for="productId">Product ID:</label>
    <g:textField name="productId" required="true"/><br/>
    <g:submitButton name="remove" value="Remove"/>
</g:form>

<!-- Link to Product and Storage pages -->
<p>
    <g:link controller="product" action="index">Manage Products</g:link> |
    <g:link controller="storage" action="index">Manage Storages</g:link>
</p>
</body>
</html>
