<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
<script type="text/javascript" src="/js/materialize.min.js"></script>
  <#include "header.ftl">
    <img src="/resources/getMovieImage/${movie.imageId}" width="225" height="400" class="card-img-top">
        <div class="card-body">
            <td><br>${movie.name}</td>
            <td><br>${movie.description}</td>
            <td><br>${movie.actors}</td>
            <td><br>${movie.duration}</td>
            <td><br>${movie.genre}</td>
            <td><br>${movie.producer}</td>
        </div>
        <p>Schedule today</p>
            <#if sessions?has_content>
            <ul>
            <table class="highlight">
                <#list sessions as session>
                    <tbody>
                        <tr>
                         <td>${session.cinemaHall.hallName}</td>
                         <td>${session.time}</td>
                         <td>${session.cost}</td>
                        </tr>
                        </tbody>
                </#list>
                 </table>
            </ul>
            <#else>
                <p>No sessions available at this time</p>
            </#if>
</body>
</html>
