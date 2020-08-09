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
    <div class="container">
      <h4>Now in the cinema</h4>
      <#include "moviesTemplate.ftl">
    </div>
</body>
</html>