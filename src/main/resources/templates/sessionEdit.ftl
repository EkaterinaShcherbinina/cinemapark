<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
<div class="row">
    <form class="col s12" action="/admin-session/edit" id="sessionDTO" name="sessionDTO" method="POST">
     <input type="hidden" id="id" name="id" value="${session.id}"/>
     <input type="hidden" id="movieDate" name="movieDate" value="${session.movieDate}"/>
      <div class="row" id="content">
              <div class="col s12">
                Movie name:
                 <div class="input-field inline">
                 <input value="${session.movieName}" id="movieName" name="movieName" type="text" class="validate">
                  <label for="movieName">movie name</label>
                   </div>
              </div>
              <div class="col s12">
                 Hall name:
                  <div class="input-field inline">
                   <input value="${session.hallName}" id="hallName" name="hallName" type="text" class="validate">
                   <label for="hallName">hall name</label>
                    </div>
                  </div>
               <div class="col s12">
                 Cost:
                  <div class="input-field inline">
                  <input value="${session.cost}" id="cost" name="cost" type="text" class="validate">
                   <label for="cost">cost</label>
                    </div>
                  </div>
                  <div class="col s12">
                    Date:
                    <div class="input-field inline">
                     <label for="date">date</label>
                      <input id="date" type="text" name="wishDate" class="datepicker">
                        </div>
                  </div>
                   <div class="col s12">
                     Time:
                     <div class="input-field inline">
                      <label for="time">time</label>
                      <input id="time" type="text" name="time" class="timepicker">
                      </div>
                    </div>
           </div>
            <button class="btn waves-effect waves-light" type="submit" name="action">Update
               <i class="material-icons right">send</i>
             </button>
      </form>
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
              defaultDate: new Date('${session.wishDate}'),
          });
      });

      $(document).ready(function(){
          $('.timepicker').timepicker({
            defaultTime: '${session.time}'
          });
        });
  </script>