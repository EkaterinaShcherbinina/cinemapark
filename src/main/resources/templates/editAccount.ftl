<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
<div class="row">
    <form class="col s12" action="/account/edit-account" id="userDTO" name="userDTO" method="POST">
    <input type="hidden" id="id" name="id" value="${user.id}"/>
    <div class="container">
        <h4>Edit settings</h4>
        <span class="title">About me</span>
      <div class="row" id="content">
              <div class="col s6">
                First name:
                 <div class="input-field inline">
                 <input value="${user.firstName}" id="firstName" name="firstName" type="text" class="validate">
                  <label for="firstName">first name</label>
                   </div>
              </div>
              <div class="col s6">
                 Last name:
                  <div class="input-field inline">
                   <input value="${user.lastName}" id="lastName" name="lastName" type="text" class="validate">
                   <label for="lastName">last name</label>
                    </div>
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
           </div>
      </form>
   </div>
</body>
</html>
