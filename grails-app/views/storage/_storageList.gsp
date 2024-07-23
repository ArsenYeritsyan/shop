<p>${flash.message}</p>
<table>
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
                <g:link action="edit" id="${storage.id}">Edit</g:link> |
                <g:link action="delete" id="${storage.id}">Delete</g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
