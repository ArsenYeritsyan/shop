<h2>Create Store</h2>
<g:form controller="store" action="save" method="POST">
    <label for="code">Code:</label>
    <g:textField name="code" required="true"/><br/>
    <label for="name">Name:</label>
    <g:textField name="name" required="true"/><br/>
    <label for="address">Address:</label>
    <g:textField name="address" required="true"/><br/>
    <g:submitButton name="create" value="Create"/>
</g:form>

<h2>Add Product to Store</h2>
<g:form controller="store" action="addProduct" method="POST">
    <label for="storeId">Store ID:</label>
    <g:textField name="storeId" required="true"/><br/>
    <label for="productId">Product ID:</label>
    <g:textField name="productId" required="true"/><br/>
    <g:submitButton name="add" value="Add"/>
</g:form>

<h2>Remove Product from Store</h2>
<g:form controller="store" action="removeProduct" method="POST">
    <label for="storeId">Store ID:</label>
    <g:textField name="storeId" required="true"/><br/>
    <label for="productId">Product ID:</label>
    <g:textField name="productId" required="true"/><br/>
    <g:submitButton name="remove" value="Remove"/>
</g:form>
