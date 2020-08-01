<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
  <#if movie??>
<div class="row">
    <form class="col s12" action="/admin-movie/new" id="movieDTO" name="movieDTO" method="POST" enctype="multipart/form-data">
      <div class="row">
       <div class="col s12">
           Fill all movie fields for update:
       </div>
              <div class="col s12">
                Movie name:
                <div class="input-field inline">
                <input id="name" name="name" type="text" class="validate">
                <label for="name">Name</label>
                </div>
             </div>
              <div class="col s12">
                Description:
                 <div class="input-field inline">
                 <input id="description" name="description" type="text" class="validate">
                  <label for="description">Description</label>
                   </div>
              </div>
             <div class="col s12">
               Actors:
                <div class="input-field inline">
                 <input id="actors" name="actors" type="text" class="validate">
                <label for="actors">Actors</label>
                 </div>
           </div>
           <div class="col s12">
              Duration:
              <div class="input-field inline">
               <input id="duration" name="duration" type="text" class="validate">
               <label for="duration">Duration</label>
                </div>
             </div>
             <div class="col s12">
                Genre:
              <div class="input-field inline">
               <input id="genre" name="genre" type="text" class="validate">
               <label for="genre">Genre</label>
               </div>
             </div>
             <div class="col s12">
               Producer:
               <div class="input-field inline">
               <input id="producer" name="producer" type="text" class="validate">
                 <label for="producer">Producer</label>
                 </div>
              </div>
              <div class="col s12">
                Production year:
                <div class="input-field inline">
                <input id="productionYear" name="productionYear" type="text" class="validate">
                 <label for="productionYear">Production year</label>
                  </div>
                </div>
                 <div class="col s12">
                   Premiere date:
                   <div class="input-field inline">
                    <label for="premiereDate">Premiere date</label>
                     <input id="premiereDate" type="text" name="premiereDate" class="datepicker">
                    </div>
                  </div>
                  <div class="col s12">
                      <div class="file-field input-field">
                        <div class="btn">
                          <span>add file</span>
                          <input type="file" name="file" id="file">
                        </div>
                        <div class="file-path-wrapper">
                          <input class="file-path validate" type="text">
                        </div>
                      </div>
                  </div>
           </div>
            <button class="btn waves-effect waves-light" type="submit" name="action">Submit
               <i class="material-icons right">send</i>
             </button>
      </form>
   </div>
  <#else>
   <p>Movie has not found</p>
   </#if>
</body>
</html>

<script type="text/javascript">
      $(document).ready(function () {
          $('.datepicker').datepicker({
              selectMonths: true, // Enable Month Selection
              selectYears: 10, // Creates a dropdown of 10 years to control year
              format: 'mm-dd-yyyy',
          });
      });
  </script>
