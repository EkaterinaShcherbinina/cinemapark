<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
 <#include "header.ftl">
   <div class="container">
     <form action="/login/process" method="post">
       <div class="row">
         <div class="col s4 offset-s4">
           <div><label> User Name: <input type="text" name="email"/> </label></div>
         </div>
       </div>
       <div class="row">
         <div class="col s4 offset-s4">
           <div><label> Password: <input type="password" name="password"/> </label></div>
         </div>
       </div>
       <div class="row">
         <div class="col s4 offset-s4">
           <#if error ??>
             <p class="errorRed">Invalid username or password</p>
           </#if>
         </div>
       </div>
       <div class="row">
         <div class="col s4 offset-s4">
           <button class="btn waves-effect waves-light" type="submit" name="action">Submit
             <i class="material-icons right">send</i>
           </button>
         </div>
       </div>
       <div class="row">
         <div class="col s4 offset-s4">
           <a href="/sign-up" style="color:#004d40"><br>Create your new account</a>
         </div>
       </div>
     </form>
   </div>
</body>
</html>
