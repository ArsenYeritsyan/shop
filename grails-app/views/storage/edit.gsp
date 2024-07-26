<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Edit Storage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Edit Storage</h1>
    <g:form controller="storage" action="update" method="POST" class="form">
        <g:hiddenField name="id" value="${storage.id}"/>
        <div class="form-group">
            <label for="code">Code:</label>
            <g:textField name="code" value="${storage.code}" required="true" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <g:textField name="name" value="${storage.name}" required="true" class="form-control"/>
        </div>
        <g:submitButton name="update" value="Update" class="btn btn-primary"/>
    </g:form>
</div>
</body>
</html>
