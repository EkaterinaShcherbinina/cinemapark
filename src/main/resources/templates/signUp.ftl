<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
      <div>
      <#if logout ??>
          You have been logged out.
      </#if>
      </div>
      <form action="/sign-up" method="post" name="user">
          <div><label> First Name: <input type="text" name="firstName"/></label></div>
          <div><label> Last Name: <input type="text" name="lastName"/></label></div>
          <div><label> Email: <input type="text" name="email"/></label></div>
          <div><label> Password: <input type="password" name="password"/></label></div>
          <div><input type="submit" value="Sign Up"/></div>
      </form>
            <#if error ??>
                <p>${error}</p>
            </#if>
</body>
</html>
