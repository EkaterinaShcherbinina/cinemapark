<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
    <script type="text/javascript" src="/js/materialize.min.js"></script>
    <#include "header.ftl">
    <h5>Your reservation:</h5>
    <div>
        <td><br>Reservation ID: ${booked.reservationId}</td>
        <td><br>Movie Name: ${booked.movieName}</td>
        <td><br>Hall: ${booked.hallName}</td>
        <td><br>Row: ${booked.rowId}</td>
        <td><br>Place: ${booked.place}</td>
        <td><br>Date: ${booked.date}</td>
        <td><br>Time: ${booked.time}</td>
        <#if booked.status == true>
            <td><br>Status: paid</td>
        <#else>
            <td><br>Status: not paid</td>
        </#if>
     </div>
</body>
</html>