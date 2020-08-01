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
    <h4>Edit settings</h4>
    <span class="title">Contact preferences<br><br></span>
    <h5>Email<br><br></h5>
    <span class="title">Current email address:<br></span>
    <p>"${user.email}"</p>
    <div class="row">
    <form class="col s12" action="/account/edit-email" id="userDTO" name="userDTO" method="POST">
      <input type="hidden" id="id" name="id" value="${user.id}"/>
     <div class="col s12">
         Email address:
         <div class="input-field inline">
            <input value="" id="email" name="email" type="email" class="validate">
            <label for="email">email</label>
         </div>
     </div>
        <div class="col s6">
           <button class="btn waves-effect waves-light" type="submit" name="action">Save
              <i class="material-icons right">send</i>
           </button>
        </div>
        <div class="col s6">
           <button class="btn waves-effect waves-light" href="/account/settings" type="button" name="action">Cancel
                <i class="material-icons right">cancel</i>
           </button>
       </div>
     </form>
   </div>
 </div>
</body>
</html>