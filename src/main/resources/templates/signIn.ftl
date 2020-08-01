<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
      <form action="/login/process" method="post">
          <div><label> User Name: <input type="text" name="email"/> </label></div>
          <div><label> Password: <input type="password" name="password"/> </label></div>
          <div><input type="submit" value="Sign In"/></div>
      </form>
      <li><a href="/sign-up">Create your new account</a></li>
       <div>
            <#if error ??>
                <p>Invalid username or password.</p>
            </#if>
            </div>
       <div>
            <#if logout ??>
                <p>You have been logged out.</p>
            </#if>
       </div>
</body>
</html>
