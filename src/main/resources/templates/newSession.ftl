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
    <form class="col s12" action="/admin-session/new" id="sessionDTO" name="sessionDTO" method="POST">
      <div class="row" id="content">
              <div class="col s12">
                Movie name:
                 <div class="input-field inline">
                 <input value="" id="movieName" name="movieName" type="text" class="validate">
                  <label for="movieName">movie name</label>
                   </div>
              </div>
              <div class="col s12">
                 Hall name:
                  <div class="input-field inline">
                   <input value="" id="hallName" name="hallName" type="text" class="validate">
                   <label for="hallName">hall name</label>
                    </div>
                  </div>
               <div class="col s12">
                 Cost:
                  <div class="input-field inline">
                  <input value="" id="cost" name="cost" type="text" class="validate">
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
              format: 'mm-dd-yyyy'
          });
      });

      $(document).ready(function(){
          $('.timepicker').timepicker({
          });
        });
  </script>