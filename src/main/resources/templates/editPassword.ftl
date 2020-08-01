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
    <span class="title">Sign in / security</span>
    <div class="row">
    <form class="col s12" action="/account/edit-password" id="userDTO" name="userDTO" method="POST">
      <input type="hidden" id="id" name="id" value="${user.id}"/>
     <div class="col s12">
         Current password:
         <div class="input-field inline">
            <input value="" id="oldPassword" name="oldPassword" type="password" class="validate">
            <label for="oldPassword">current password</label>
         </div>
     </div>
     <div class="col s12">
        New password:
           <div class="input-field inline">
              <input value="" id="newPassword" name="newPassword" type="password" class="validate">
              <label for="newPassword">new password</label>
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