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
<@form.form action="/account/edit-name" method="post" modelAttribute="user">
    <div class="container">
        <h4>Edit settings</h4>
        <span class="title">About me</span>
      <div class="row">
              <div class="col s6">
                First name:
                 <div class="input-field inline">
                 <@form.label path="firstName">first name</@form.label>
                 <@form.input path="firstName" value="${user.firstName}"/>
                 <@form.errors class="errorRed" path="firstName"/>
                   </div>
              </div>
              <div class="col s6">
                 Last name:
                  <div class="input-field inline">
                  <@form.label path="lastName">last name</@form.label>
                 <@form.input path="lastName" value="${user.lastName}"/>
                   <@form.errors class="errorRed" path="lastName"/>
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
        </div>
     </@form.form>
</body>
</html>
