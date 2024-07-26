<h2>Create Storage</h2>
<g:form controller="storage" action="save" method="POST" class="form">
    <div class="form-group">
        <label for="code">Code:</label>
        <g:textField name="code" required="true" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="name">Name:</label>
        <g:textField name="name" required="true" class="form-control"/>
    </div>
    <g:submitButton name="create" value="Create" class="btn btn-success"/>
</g:form>

<h2>Add Product to Storage</h2>
<g:form controller="storage" action="addProduct" method="POST" class="form">
    <div class="form-group">
        <label for="storageId">Storage ID:</label>
        <g:textField name="storageId" required="true" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="productId">Product ID:</label>
        <g:textField name="productId" required="true" class="form-control"/>
    </div>
    <g:submitButton name="add" value="Add" class="btn btn-success"/>
</g:form>

<h2>Remove Product from Storage</h2>
<g:form controller="storage" action="removeProduct" method="POST" class="form">
    <div class="form-group">
        <label for="storageId">Storage ID:</label>
        <g:textField name="storageId" required="true" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="productId">Product ID:</label>
        <g:textField name="productId" required="true" class="form-control"/>
    </div>
    <g:submitButton name="remove" value="Remove" class="btn btn-danger"/>
</g:form>
