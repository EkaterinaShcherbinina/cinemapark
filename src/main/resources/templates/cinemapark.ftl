<!-- FreeMarker Macros -->

<#import "/spring.ftl" as spring/>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
     <!--Import Google Icon Font-->
          <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
          <!--Import materialize.css-->
          <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

          <!--Let browser know website is optimized for mobile-->
          <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        </head>
</head>
<body>
 <!--JavaScript at end of body for optimized loading-->
      <script type="text/javascript" src="js/materialize.min.js"></script>
<div class="header">
  <h5 class="Title">Cinemapark</h5>
  <a href="#">Movies</a>
  <a href="#">Soon in the cinema</a>
  <a href="#">Schedule</a>
  <a href="#">Sign up</a>
</div>
<div class="row">
    <ul>
        <#list movies as movie>
            <div class="column">
                <a href="http://localhost:8080/movie/${movie.secondaryKey}">
                    <div class="card">
                        <img src=${movie.imageUrl} width="125" height="200" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">${movie.name}</h5>
                            <p class="card-text">${movie.description}</p>
                        </div>
                    </div>
                </a>
            </div>
        </#list>
    </ul>
</div>
</body>
</html>