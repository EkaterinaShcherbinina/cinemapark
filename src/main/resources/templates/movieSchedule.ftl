<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
    <form action="/movie-schedule/schedule" id="schedule" name="schedule" method="POST">
      <div class="container">
        <div class="row">
          <div class="input-field col s3">
            <h5>Choose the date:</h5>
          </div>
          <div class="input-field col s2">
            <label for="date_inline">Schedule</label>
            <input id="date_inline" type="text" name="date" class="datepicker">
            <input type="submit" id="sendButton" style="display: none;" />
          </div>
        </div>
        </div>
    </form>
    <#if sessions?has_content>
      <ul>
        <table class="highlight centered" id="centeredElement">
          <thead>
            <tr style="text-align: center">
              <th>Movie</th>
              <th>Time session</th>
              <th>Price</th>
              <th>Hall</th>
            </tr>
        </thead>
        <#list sessions as session>
          <tbody>
            <tr>
              <td class="colSchedule">
                <img src="/resources/movieImage/${session.movie.id}" width="90" height="130" class="card-img-top">
                <p>${session.movie.name}</p>
                <a href="/booking/session${session.id}">
                  <button class="btn waves-effect waves-light">To book</button>
                </a>
              </td>
              <td class="colSchedule">${session.time}</td>
              <td class="colSchedule">${session.cost}$</td>
              <td class="colSchedule">${session.cinemaHall.hallName}</td>
            </tr>
          </tbody>
        </#list>
        </table>
      </ul>
    <#else>
        <p id="centeredElement">No sessions available at this time</p>
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