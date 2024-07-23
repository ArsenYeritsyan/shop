<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Login</title>
</head>

<body>
<h2>Login</h2>
<g:form action="auth" method="POST">
    <div>
        <label for="username">Username</label>
        <g:textField name="username" id="username"/>
    </div>

    <div>
        <label for="password">Password</label>
        <g:passwordField name="password" id="password"/>
    </div>

    <div>
        <g:submitButton name="login" value="Login"/>
    </div>
</g:form>
</body>
</html>
