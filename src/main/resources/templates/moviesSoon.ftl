<!-- FreeMarker Macros -->

<#import "/spring.ftl" as spring/>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div class="header">
  <h5 class="Title">Cinemapark</h5>
  <nav class="navigation">
    <a class="option" href="#">Movies</a>
    <a class="option" href="#">Soon in the cinema</a>
    <a class="option" href="#">Schedule</a>
  </nav>
  <a class="sign-up-button" href="#">Sign up</a>
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