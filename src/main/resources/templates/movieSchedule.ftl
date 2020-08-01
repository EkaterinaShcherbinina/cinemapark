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
             <div class="row"> Choose the date:
                        <div class="input-field col s2 offset-s1">
                            <label for="date_inline">Schedule</label>
                            <input id="date_inline" type="text" name="date" class="datepicker">
                            <input type="submit" id="sendButton" style="display: none;" />
                        </div>
                    </div>
                    </form>

    <#if sessions?has_content>
    <ul>
    <table class="highlight">
        <#list sessions as session>
            <tbody>
                <tr>
                        <td>
                            <img src="/resources/getMovieImage/${session.movie.imageId}" width="125" height="200" class="card-img-top">
                            <p>${session.movie.name}</p>
                            <a href="/booking/session${session.id}">
                             <button class="btn waves-effect waves-light" type="submit" name="session">To book
                            </button>
                            </a>
                        </td>
                        <td>${session.time}</td>
                        <td>${session.cost}</td>
                        <td>${session.cinemaHall.id}</td>
                </tr>
                </tbody>
              </form>
        </#list>
         </table>
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