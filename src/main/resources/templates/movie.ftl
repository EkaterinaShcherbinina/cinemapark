<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
  <div class="container" style="padding-top: 30px;">
    <section class="sectionMovieReview">
      <img src="/resources/movieImage/${movie.id}" width="200" height="300">
    </section>
    <section class="sectionMovieReview">
      <h5>${movie.name} (${movie.productionYear})</h5>
      <p>${movie.genre}  ${movie.duration}</p>
      <p><b>Description:</b> ${movie.description}</p>
      <p><b>Actors:</b> ${movie.actors}</p>
      <p><b>Producer:</b> ${movie.producer}</p>
    </section>
  </div>
  <section style="width: 100%; padding-top: 20px">
    <div class="container">
      <form action="/movie/schedule" method="POST">
        <div class="row" style="margin: auto;">
          <div class="input-field col s2">
            <label for="date_inline">Schedule</label>
            <input id="date_inline" type="text" name="schedule" class="datepicker">
            <input type="hidden" name="movieId" value="${movie.id}"/>
            <input type="submit" id="sendButton" style="display: none;" />
          </div>
        </div>
      </form>
      <div class="divider"></div>
        <div class="row" style="background-color: #eeeeee;margin: auto;">
          <#if sessions?has_content>
            <#list sessions as session>
              <a href="/booking/session${session.id}" style="color: #000000">
                <div class="col">
                  <p class="timeSchedule">
                    ${session.time}
                  </p>
                  <p class="textAlign">${session.cinemaHall.hallName}</p>
                  <p class="textAlign">${session.cost} $</p>
                </div>
              </a>
            </#list>
          <#else>
            No sessions available at this time
          </#if>
        </div>
        <div class="divider"></div>
      </div>
    </section>
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
