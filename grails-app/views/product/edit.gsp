<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Edit Product</h1>
    <g:form controller="product" action="update" method="POST" class="form">
        <g:hiddenField name="id" value="${product.id}"/>
        <div class="form-group">
            <label for="code">Code:</label>
            <g:textField name="code" value="${product.code}" required="true" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <g:textField name="name" value="${product.name}" required="true" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <g:textField name="price" value="${product.price}" required="true" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="dateOfManufacture">Date of Manufacture:</label>
            <g:datePicker name="dateOfManufacture" value="${product.dateOfManufacture}" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="deadline">Deadline:</label>
            <g:datePicker name="deadline" value="${product.deadline}" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="store">Store:</label>
            <g:select name="storeId" from="${storeList}" optionKey="id" optionValue="name" value="${product.store?.id}" class="form-control"/>
        </div>
        <g:submitButton name="update" value="Update" class="btn btn-primary"/>
    </g:form>
</div>
</body>
</html>
