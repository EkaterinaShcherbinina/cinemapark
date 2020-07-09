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
    <#if sessions?has_content>
    <ul>
        <#list sessions as session>
            <table>
                <tr>
                    <img src=${session.movie.imageUrl} width="125" height="200" class="card-img-top">
                    <td>${session.movie.name}</td>
                    <td>${session.time}</td>
                    <td>${session.cost}</td>
                    <td>${session.cinemaHallId}</td>
                </tr>
            </table>
        </#list>
    </ul>
    <#else>
        <p>No sessions available at this time</p>
    </#if>
</body>
</html>