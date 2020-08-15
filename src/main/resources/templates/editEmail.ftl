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
    <span class="title">Contact preferences<br><br></span>
    <h5>Email<br><br></h5>
    <@form.form action="/account/edit-email" method="post" modelAttribute="email">
     <div class="row">
     <div class="col s12">
         Email address:
         <div class="input-field inline">
         <@form.label path="email">email</@form.label>
         <@form.input path="email" value="${email.email}"/>
         <@form.errors class="errorRed" path="email"/>
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