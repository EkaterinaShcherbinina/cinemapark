<!-- FreeMarker Macros -->

<#import "/spring.ftl" as spring/>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title
    <#include "materializedConfig.ftl">
</head>
<body>
      <script type="text/javascript" src="/js/materialize.min.js"></script>
      <#include "header.ftl">
      <h1>Soon in the cinema</h1>
    <div class="row">
     <#list movies as movie>
        <div class="col s12 m2">
                <div class="card">
                    <div class="card-image" width="50%" height="70%">
                        <img src="${movie.imageUrl}">
                    </div>
                    <div class="card-content">
                        <span class="card-title">${movie.name}</span>
                        <p>${movie.genre}</p>
                    </div>
                    <div class="card-action">
                        <a href="#">This is a link</a>
                    </div>
                </div>
        </div>
         </#list>
    </div>
</body>
</html>