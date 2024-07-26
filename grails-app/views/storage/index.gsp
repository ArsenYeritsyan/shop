<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Storages</title>
</head>

<body>
<h1>Storages</h1>

<p>${flash.message}</p>

<!-- Storage List -->
<h2>Storage List</h2>
<table>
    <thead>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${storageList}" var="storage">
        <tr>
            <td>${storage.code}</td>
            <td>${storage.name}</td>
            <td>
                <g:link action="edit" id="${storage.id}">Edit</g:link> |
                <g:link action="delete" id="${storage.id}">Delete</g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>

<!-- Create Storage Form -->
<h2>Create Storage</h2>
<g:form action="save" method="POST">
    <label for="code">Code:</label>
    <g:textField name="code" required="true"/><br/>
    <label for="name">Name:</label>
    <g:textField name="name" required="true"/><br/>
    <g:submitButton name="create" value="Create"/>
</g:form>

<!-- Add Product to Storage Form -->
<h2>Add Product to Storage</h2>
<g:form action="addProduct" method="POST">
    <label for="storageId">Storage ID:</label>
    <g:textField name="storageId" required="true"/><br/>
    <label for="productId">Product ID:</label>
    <g:textField name="productId" required="true"/><br/>
    <g:submitButton name="add" value="Add"/>
</g:form>

<!-- Remove Product from Storage Form -->
<h2>Remove Product from Storage</h2>
<g:form action="removeProduct" method="POST">
    <label for="storageId">Storage ID:</label>
    <g:textField name="storageId" required="true"/><br/>
    <label for="productId">Product ID:</label>
    <g:textField name="productId" required="true"/><br/>
    <g:submitButton name="remove" value="Remove"/>
</g:form>

<!-- Link to Product and Store pages -->
<p>
    <g:link controller="product" action="index">Manage Products</g:link> |
    <g:link controller="store" action="index">Manage Stores</g:link>
</p>
</body>
</html>
