<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
  <ul class="collection collectionCenter">
      <a href="/admin-movie/movies"
      <li class="collection-item avatar">
        <i class="material-icons circle">local_movies</i>
        <span class="title">Movie service</span>
        <p>Select this service to manage movies</p>
      </li>
      </a>
      <a href="/admin-hall/halls"
      <li class="collection-item avatar">
        <i class="material-icons circle green">event_seat</i>
        <span class="title">Cinema hall service</span>
        <p>Select this service to manage cinema halls</p>
      </li>
      </a>
      <a href="/admin-session/sessions"
      <li class="collection-item avatar">
        <i class="material-icons circle red">movie_filter</i>
        <span class="title">Movie session service</span>
        <p>Select this service to manage movie sessions</p>
      </li>
      </a>
    </ul>
</body>
</html>
