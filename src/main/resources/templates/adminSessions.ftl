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
            <h5>Available sessions</h5>
        </div>
        <div class="col s2 offset-s3">
          <a class="waves-effect waves-light btn" href="/admin-session">
            <i class="material-icons right">add</i>Add new</a>
        </div>
      </div>
    <form action="/admin-session/sessions/date" id="dateSessions" name="dateSessions" method="POST">
      <div class="row">
        <div class="input-field col s2 offset-s2">
          <label for="date_inline">date</label>
          <input id="date_inline" type="text" name="date" class="datepicker">
          <input type="submit" id="sendButton" style="display: none;" />
        </div>
      </div>
    </form>
    <#if sessions?has_content>
      <table class="centered" id="centeredElement">
        <thead>
          <tr>
            <th>Id</th>
            <th>Movie name</th>
            <th>Cost</th>
            <th>Date</th>
            <th>Time</th>
            <th>Hall</th>
          </tr>
        </thead>
        <tbody>
          <#list sessions as session>
            <tr>
              <td>${session.id}</td>
              <td>${session.movie.name}</td>
              <td>${session.cost}</td>
              <td>${session.movieDate}</td>
              <td>${session.time}</td>
              <td>${session.cinemaHall.hallName}</td>
              <td><a href="/admin-session/edit${session.id}" <i class="material-icons">edit</i></a></td>
            </tr>
          </#list>
        </tbody>
      </table>
    <#else>
      <p id="centeredElement">No sessions available at this time</p>
    </#if>
  </div>
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
