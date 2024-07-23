<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Store Management</title>
    <style>
    .tab {
        overflow: hidden;
        border: 1px solid #ccc;
        background-color: #f1f1f1;
    }

    .tab button {
        background-color: inherit;
        float: left;
        border: none;
        outline: none;
        cursor: pointer;
        padding: 14px 16px;
        transition: 0.3s;
    }

    .tab button:hover {
        background-color: #ddd;
    }

    .tab button.active {
        background-color: #ccc;
    }

    .tabcontent {
        display: none;
        padding: 6px 12px;
        border: 1px solid #ccc;
        border-top: none;
    }
    </style>
    <script>
        function openTab(evt, tabName) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(tabName).style.display = "block";
            evt.currentTarget.className += " active";
        }
    </script>
</head>
<body>
<h1>Store Management</h1>

<!-- Tab links -->
<div class="tab">
    <button class="tablinks" onclick="openTab(event, 'Products')">Products</button>
    <button class="tablinks" onclick="openTab(event, 'Storages')">Storages</button>
    <button class="tablinks" onclick="openTab(event, 'Stores')">Stores</button>
</div>

<!-- Tab content -->
<div id="Products" class="tabcontent">
    <h2>Products</h2>
    <g:render template="/product/productList" model="[productList: productList]"/>
    <g:render template="/product/productForm" model="[storeList: storeList]"/>
</div>

<div id="Storages" class="tabcontent">
    <h2>Storages</h2>
    <g:render template="/storage/storageList" model="[storageList: storageList]"/>
    <g:render template="/storage/storageForm"/>
</div>

<div id="Stores" class="tabcontent">
    <h2>Stores</h2>
    <g:render template="/store/storeList" model="[storeList: storeList]"/>
    <g:render template="/store/storeForm"/>
</div>

<script>
    // Default open tab
    document.getElementsByClassName("tablinks")[0].click();
</script>

</body>
</html>
