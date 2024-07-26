<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'application.label', default: 'Application')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" />
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'custom.css')}" />
    <script src="${resource(dir: 'js', file: 'jquery.min.js')}"></script>
    <script src="${resource(dir: 'js', file: 'bootstrap.min.js')}"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark">
    <a class="navbar-brand" href="#">My Shop</a>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#products">Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#stores">Stores</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#storages">Storages</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <!-- Products Section -->
    <div id="products" class="mb-5">
        <h2>Products</h2>
        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Price</th>
                <th>Date of Manufacture</th>
                <th>Deadline</th>
                <th>Store</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${productList}" var="product">
                <tr>
                    <td>${product.code}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.dateOfManufacture}</td>
                    <td>${product.deadline}</td>
                    <td>${product.store.name}</td>
                    <td>
                        <g:link class="btn btn-warning" action="edit" id="${product.id}">Edit</g:link>
                        <g:link class="btn btn-danger" action="delete" id="${product.id}">Delete</g:link>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <g:form action="save" method="post" class="form-inline">
            <input type="text" name="code" placeholder="Code" class="form-control mr-2"/>
            <input type="text" name="name" placeholder="Name" class="form-control mr-2"/>
            <input type="text" name="price" placeholder="Price" class="form-control mr-2"/>
            <input type="date" name="dateOfManufacture" placeholder="Date of Manufacture" class="form-control mr-2"/>
            <input type="date" name="deadline" placeholder="Deadline" class="form-control mr-2"/>
            <select name="store.id" class="form-control mr-2">
                <g:each in="${storeList}" var="store">
                    <option value="${store.id}">${store.name}</option>
                </g:each>
            </select>
            <button type="submit" class="btn btn-success">Add Product</button>
        </g:form>
    </div>

    <!-- Stores Section -->
    <div id="stores" class="mb-5">
        <h2>Stores</h2>
        <table class="table table-dark table-striped">
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
                        <g:link class="btn btn-warning" action="edit" id="${store.id}">Edit</g:link>
                        <g:link class="btn btn-danger" action="delete" id="${store.id}">Delete</g:link>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <g:form action="save" method="post" class="form-inline">
            <input type="text" name="code" placeholder="Code" class="form-control mr-2"/>
            <input type="text" name="name" placeholder="Name" class="form-control mr-2"/>
            <input type="text" name="address" placeholder="Address" class="form-control mr-2"/>
            <button type="submit" class="btn btn-success">Add Store</button>
        </g:form>
    </div>

    <!-- Storages Section -->
    <div id="storages" class="mb-5">
        <h2>Storages</h2>
        <table class="table table-dark table-striped">
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
                        <g:link class="btn btn-warning" action="edit" id="${storage.id}">Edit</g:link>
                        <g:link class="btn btn-danger" action="delete" id="${storage.id}">Delete</g:link>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <g:form action="save" method="post" class="form-inline">
            <input type="text" name="code" placeholder="Code" class="form-control mr-2"/>
            <input type="text" name="name" placeholder="Name" class="form-control mr-2"/>
            <button type="submit" class="btn btn-success">Add Storage</button>
        </g:form>
    </div>
</div>
</body>
</html>