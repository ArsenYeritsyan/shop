<h2>Create Storage</h2>
<g:form controller="storage" action="save" method="POST">
    <label for="code">Code:</label>
    <g:textField name="code" required="true"/><br/>
    <label for="name">Name:</label>
    <g:textField name="name" required="true"/><br/>
    <g:submitButton name="create" value="Create"/>
</g:form>

<h2>Add Product to Storage</h2>
<g:form controller="storage" action="addProduct" method="POST">
    <label for="storageId">Storage ID:</label>
    <g:textField name="storageId" required="true"/><br/>
    <label for="productId">Product ID:</label>
    <g:textField name="productId" required="true"/><br/>
    <g:submitButton name="add" value="Add"/>
</g:form>

<h2>Remove Product from Storage</h2>
<g:form controller="storage" action="removeProduct" method="POST">
    <label for="storageId">Storage ID:</label>
    <g:textField name="storageId" required="true"/><br/>
    <label for="productId">Product ID:</label>
    <g:textField name="productId" required="true"/><br/>
    <g:submitButton name="remove" value="Remove"/>
</g:form>
