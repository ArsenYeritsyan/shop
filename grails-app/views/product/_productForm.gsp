<h2>Create Product</h2>
<g:form controller="product" action="save" method="POST" class="form">
    <div class="form-group">
        <label for="code">Code:</label>
        <g:textField name="code" required="true" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="name">Name:</label>
        <g:textField name="name" required="true" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="price">Price:</label>
        <g:textField name="price" required="true" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="dateOfManufacture">Date of Manufacture:</label>
        <g:datePicker name="dateOfManufacture" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="deadline">Deadline:</label>
        <g:datePicker name="deadline" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="store">Store:</label>
        <g:select name="store.id" from="${storeList}" optionKey="id" optionValue="name" class="form-control"/>
    </div>
    <g:submitButton name="create" value="Create" class="btn btn-success"/>
</g:form>
