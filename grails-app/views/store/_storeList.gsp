<p>${flash.message}</p>
<table>
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
                <g:link action="edit" id="${store.id}">Edit</g:link> |
                <g:link action="delete" id="${store.id}">Delete</g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
