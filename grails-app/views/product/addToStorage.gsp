<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Add Product to Storage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Add Product to Storage</h1>
    <g:form controller="product" action="addProductToStorage" method="POST" class="form">
        <g:hiddenField name="productId" value="${product.id}"/>
        <div class="form-group">
            <label for="storage">Storage:</label>
            <g:select name="storageId" from="${storageList}" optionKey="id" optionValue="name" class="form-control"/>
        </div>
        <g:submitButton name="add" value="Add" class="btn btn-success"/>
    </g:form>
</div>
</body>
</html>
