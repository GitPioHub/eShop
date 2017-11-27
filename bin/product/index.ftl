<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
    <h1>From FREEMARKER !!</h1>

    <table style="border: solid 1px black;">
        <tr><td>Name</td><td>Stock</td><td>Price</td></tr>
        <#list products as product>
        <tr><td>${product.name}</td><td>${product.quantity}</td><td>${product.price}</td></tr>
        </#list>
    </table>

</body>
</html>