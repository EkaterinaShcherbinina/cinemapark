<!-- FreeMarker Macros -->

<#import "/spring.ftl" as spring/>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
      <script type="text/javascript" src="/js/materialize.min.js"></script>
      <#include "header.ftl">
      <h5>${exception}!</h5>
</body>
</html>