<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
  <div class="container containerPadding">
    <div class="row">
      <div class="col s3 offset-s2">
        <h5>Available halls</h5>
      </div>
      <div class="col s2 offset-s3">
        <a class="waves-effect waves-light btn" href="/admin-hall">
            <i class="material-icons right">add</i>Add new</a>
      </div>
    </div>
    <table class="centered" id="centeredElement">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Rows amount</th>
        </tr>
      </thead>
      <tbody>
        <#list halls as hall>
          <tr>
            <td>${hall.id}</td>
            <td>${hall.hallName}</td>
            <td>${hall.rowsAmount}</td>
            <td><a href="/admin-hall/edit${hall.id}" <i class="material-icons">edit</i></a></td>
          </tr>
        </#list>
      </tbody>
    </table>
  </div>
</body>
</html>
