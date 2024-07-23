<h2>Create Product</h2>
<g:form controller="product" action="save" method="POST">
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
    <label for="store">Store:</label>
    <g:select name="store" from="${storeList}" optionKey="id" optionValue="name"/><br/>
    <g:submitButton name="create" value="Create"/>
</g:form>
