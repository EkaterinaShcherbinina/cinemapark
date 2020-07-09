<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="header">
  <h5 class="Title">Cinemapark</h5>
  <nav class="navigation">
    <a class="option" href="#">Movies</a>
    <a class="option" href="#">Soon in the cinema</a>
    <a class="option" href="#">Schedule</a>
  </nav>
  <a class="sign-up-button" href="#">Sign up</a>
</div>
    <img src=${movie.imageUrl} width="225" height="400" class="card-img-top">
        <div class="card-body">
            <td><br>${movie.name}</td>
            <td><br>${movie.description}</td>
            <td><br>${movie.actors}</td>
            <td><br>${movie.duration}</td>
            <td><br>${movie.genre}</td>
            <td><br>${movie.producer}</td>
            <form action="http://localhost:8080/movie-schedule/2020-07-08" method="GET">
                <input type="submit" value="Schedule">
            </form>
        </div>
</body>
</html>