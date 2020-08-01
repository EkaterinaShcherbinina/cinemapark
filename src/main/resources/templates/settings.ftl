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
     <h4>Settings</h4>
    <div class="row">
     <div class="col s6">
      <ul class="collection with-header">
          <li class="collection-header">
            <h4>About me</h4>
            <span class="title">${user.firstName} ${user.lastName}</span>
          </li>
          <a href="/account/edit-account" <li class="collection-item">Edit</li></a>
      </ul>
     </div>
     <div class="col s6">
      <ul class="collection with-header">
           <li class="collection-header">
            <h4>Contact preferences</h4>
            <span class="title">${user.email}</span>
           </li>
           <a href="/account/edit-email" <li class="collection-item">Edit</li></a>
      </ul>
     </div>
     <div class="col s6">
         <ul class="collection with-header">
            <li class="collection-header">
              <h4>Sign in and security</h4>
              <span class="title">Password*******</span>
            </li>
             <a href="/account/edit-password" <li class="collection-item">Edit</li></a>
           </ul>
          </div>
    </div>
   </div>
</body>
</html>
