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
        <h5>Available movies</h5>
      </div>
      <div class="col s2 offset-s3">
        <a class="waves-effect waves-light btn" href="/admin-movie/new">
          <i class="material-icons right">add</i>Add new</a>
      </div>
    </div>
    <table class="centered" id="centeredElement">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Premiere Date</th>
        </tr>
      </thead>
      <tbody>
        <#list movies as movie>
          <tr>
            <td>${movie.id}</td>
            <td>${movie.name}</td>
            <td>${movie.premiereDate}</td>
            <td><a href="/admin-movie/edit${movie.id}" <i class="material-icons">edit</i></a></td>
          </tr>
        </#list>
      </tbody>
    </table>
  </div>
</body>
</html>
