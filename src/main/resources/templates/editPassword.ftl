<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

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
     <@form.form action="/account/edit-password" method="post" modelAttribute="password">
     <div class="row">
     <div class="col s12">
         Current password:
         <div class="input-field inline">
         <@form.label path="oldPassword">current password</@form.label>
         <@form.input path="oldPassword" value=""/>
         <@form.errors class="errorRed" path="oldPassword"/>
         </div>
     </div>
     </div>
     <div class="row">
     <div class="col s12">
        New password:
           <div class="input-field inline">
               <@form.label path="newPassword">new password</@form.label>
               <@form.input path="newPassword" value=""/>
                <@form.errors class="errorRed" path="newPassword"/>
            </div>
            </div>
         </div>
        <div class="row">
        <div class="col s6">
           <button class="btn waves-effect waves-light" type="submit" name="action">Save
              <i class="material-icons right">send</i>
           </button>
        </div>
        <div class="col s6">
          <a class="waves-effect waves-light btn" href="/account/settings">
                            <i class="material-icons right">cancel</i>Cancel</a>
       </div>
       </div>
     </@form.form>
   </div>
</body>
</html>