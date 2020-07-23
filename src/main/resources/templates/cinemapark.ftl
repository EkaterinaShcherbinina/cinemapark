<!-- FreeMarker Macros -->

<#import "/spring.ftl" as spring/>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
    <#include "header.ftl">
    <h1>Now in the cinema</h1>
    <div class="row">
        <#list movies as movie>
            <div class="col s12 m2">
            <a href="/movie/${movie.secondaryKey}">
            <div class="card">
                <div class="card-image" width="50%" height="70%">
                    <img src="/resources/getMovieImage/${movie.imageId}">
                </div>
                <div class="card-content">
                    <span class="card-title">${movie.name}</span>
                    <p>${movie.genre}</p>
                </div>
            </div>
            </a>
            </div>
        </#list>
    </div>
</body>
</html>