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
    <div class="container">
      <@form.form action="${(movie.id == 0)?then('/admin-movie','/admin-movie/edit')}" method="post" modelAttribute="movie" enctype="multipart/form-data">
        <div class="row">
          <input value="${movie.id}" id="id" name="id" type="hidden">
          <input value="${(movie.secondaryKey?has_content)?then(movie.secondaryKey,'')}" id="secondaryKey" name="secondaryKey" type="hidden">
          <input value="${(movie.rating?has_content)?then(movie.rating,'0.0')}" id="rating" name="rating" type="hidden">
          <div class="input-field col s6">
            <@form.label path="name">Movie Name:</@form.label>
            <@form.input path="name" value="${(movie.name?has_content)?then(movie.name,'')}"/>
            <@form.errors class="errorRed" path="name"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <@form.label path="description">Movie description:</@form.label>
            <@form.input path="description" value="${(movie.description?has_content)?then(movie.description,'')}"/>
            <@form.errors class="errorRed" path="description"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <@form.label path="actors">Actors:</@form.label>
            <@form.input path="actors" value="${(movie.actors?has_content)?then(movie.actors,'')}"/>
            <@form.errors class="errorRed" path="actors"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <@form.label path="duration">Duration:</@form.label>
            <@form.input path="duration" value="${(movie.duration?has_content)?then(movie.duration,'')}"/>
            <@form.errors class="errorRed" path="duration"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <@form.label path="genre">Genre:</@form.label>
            <@form.input path="genre" value="${(movie.genre?has_content)?then(movie.genre,'')}"/>
            <@form.errors class="errorRed" path="genre"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <@form.label path="producer">Producer:</@form.label>
            <@form.input path="producer" value="${(movie.producer?has_content)?then(movie.producer,'')}"/>
            <@form.errors class="errorRed" path="producer"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <@form.label path="productionYear">Production year:</@form.label>
            <@form.input path="productionYear" value="${(movie.productionYear?has_content)?then(movie.productionYear,'')}"/>
            <@form.errors class="errorRed" path="productionYear"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <@form.label path="premiereDate">Premiere date:</@form.label>
            <@form.input path="premiereDate" class="datepicker"/>
            <@form.errors class="errorRed" path="premiereDate"/>
          </div>
        </div>
        <#if movie.id != 0>
        <div class="row">
          <div class="input-field col s6">
            <img src="/resources/movieImage/${movie.id}" width="125" height="200" class="card-img-top">
          </div>
        </div>
        </#if>
        <div class="row">
          <div class="file-field input-field">
            <div class="btn">
              <span>Add file</span>
              <@form.input type="file" name="image" id="image"/>
              <@form.errors class="errorRed" path="image"/>
            </div>
            <div class="file-path-wrapper">
              <input class="file-path validate" type="text">
            </div>
          </div>
        </div>
        <button class="btn waves-effect waves-light" type="submit" name="action">Update
          <i class="material-icons right">send</i>
        </button>
      </@form.form>
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
              defaultDate: new Date('${(movie.producer?has_content)?then(movie.producer,'')}'),
          });
      });
  </script>
