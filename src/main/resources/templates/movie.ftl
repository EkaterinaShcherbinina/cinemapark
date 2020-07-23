<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
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
<form action="/movie/schedule" id="movieBooking" name="reservation" method="POST">
         <div class="row">
                    <div class="input-field col s2 offset-s1">
                        <label for="date_inline">Schedule</label>
                        <input id="date_inline" type="text" name="schedule" class="datepicker">
                        <input type="hidden" name="movieId" value="${movie.secondaryKey}"/>
                        <input type="submit" id="sendButton" style="display: none;" />
                    </div>
                </div>
                </form>
                            <#if sessions?has_content>
                            <ul>
                                <#list sessions as session>
                                         <p>${session.cinemaHall.hallName}</p>
                                         <p>${session.time}</p>
                                         <p>${session.cost}</p>
                                </#list>
                            </ul>
                            <#else>
                                <p>No sessions available at this time</p>
                            </#if>

</body>
</html>
  <script type="text/javascript">
      $(document).ready(function () {
          $('.datepicker').datepicker({
              selectMonths: true, // Enable Month Selection
              selectYears: 10, // Creates a dropdown of 10 years to control year
              format: 'mm-dd-yyyy',
              setDefaultDate: true,
              defaultDate: new Date('${date}'),
              onClose : function() {
                  $("#sendButton").click();
              }
          });
      });
  </script>
