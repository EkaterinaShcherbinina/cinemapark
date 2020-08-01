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
   <div class="row">
        <a class="waves-effect waves-light btn" id="movie" href="/admin-movie/movies">Movie service</a>
        <label for="movie">Movie service for edit and adding new movies</label>
    </div>
    <div class="row">
        <a class="waves-effect waves-light btn" id="hall" href="/admin-hall/halls">Hall service</a>
        <label for="hall">Hall service for edit and adding new halls</label>
    </div>
    <div class="row">
        <a class="waves-effect waves-light btn" id="session" href="/admin-session/sessions">Movie session service</a>
        <label for="session">Movie session service for edit and adding new sessions</label>
     </div>
  </div>
</body>
</html>
