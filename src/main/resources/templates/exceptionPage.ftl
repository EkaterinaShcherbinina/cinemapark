<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
<div style="padding-left: 50px">
<h3>Error</h3>
 <p>
  Status:<br/>${exception.status}
  </p>
  <p>
  <br/><b>${exception.message}</b>
  </p>
  <p>
    Please try again:<br/><a href="/cinemapark">Home page</a>
    </p>
    </div>
</body>
</html>