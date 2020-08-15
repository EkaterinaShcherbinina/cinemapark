<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
    <@form.form action="/admin-session/edit" method="post" modelAttribute="session">
      <input type="hidden" id="id" name="id" value="${session.id}"/>
      <input type="hidden" id="movieDate" name="movieDate" value="${session.movieDate}"/>
      <div class="container">
        <div class="row" id="content">
          <div class="col s12">
            Movie name:
            <div class="input-field inline">
              <@form.label path="movieName">Movie name</@form.label>
              <@form.input path="movieName" value="${session.movieName}"/>
              <@form.errors class="errorRed" path="movieName"/>
            </div>
          </div>
          <div class="col s12">
            Hall name:
            <div class="input-field inline">
              <@form.label path="hallName">Movie name</@form.label>
              <@form.input path="hallName" value="${session.hallName}"/>
              <@form.errors class="errorRed" path="hallName"/>
            </div>
          </div>
          <div class="col s12">
            Cost:
            <div class="input-field inline">
              <@form.label path="cost">Cost</@form.label>
              <@form.input path="cost" value="${session.cost}"/>
              <@form.errors class="errorRed" path="cost"/>
            </div>
          </div>
          <div class="col s12">
            Date:
            <div class="input-field inline">
              <@form.label path="wishDate">date</@form.label>
              <@form.input class="datepicker" path="wishDate"/>
              <@form.errors class="errorRed" path="wishDate"/>
            </div>
          </div>
          <div class="col s12">
            Time:
            <div class="input-field inline">
              <@form.label path="time">time</@form.label>
              <@form.input class="timepicker" path="time"/>
              <@form.errors class="errorRed" path="time"/>
            </div>
          </div>
        </div>
        <button class="btn waves-effect waves-light" type="submit" name="action">Update
            <i class="material-icons right">send</i>
        </button>
      </div>
    </@form.form>
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