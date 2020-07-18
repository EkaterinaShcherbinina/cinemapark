<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
    <script type="text/javascript" src="/js/materialize.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/placeCenter.css">
    <#include "header.ftl">
    <div class="container">
        <h5>Please choose a place</h5>
        <form action="/booking/new" id="movieBooking" name="reservation" method="POST">
        <input type="hidden" name="sessionId" value="${sessionId}"/>
        <input type="hidden" id="rowId" name="rowId" value="0"/>
        <input type="hidden" id="placeId" name="place" value="0"/>
        <div id="hallId" name="hall">
        <#list rows as row>
            <#assign rowNumber = row?index + 1>
            <div class="row">
                <div class="col">${rowNumber}</div>
                <#assign n = row.reservedPlaces?size + row.freePlaces?size>
                <#list 0..<n as i>
                    <#assign placeNumber = i?index + 1>
                    <#if row.freePlaces?seq_contains(placeNumber)?string("yes", "no") == "yes">
                        <div class="col">
                        <div class="placeContainer" onclick="imageClick(${placeNumber}, ${rowNumber})">
                                <img src="/images/green.png" id="green${rowNumber}${placeNumber}" width="20" height="20" class="card-img-top">
                                <div class="centered">${placeNumber}</div>
                        </div>
                        </div>
                    <#else>
                        <div class="col"><img src="/images/red.png" width="20" height="20" class="card-img-top"></div>
                    </#if>
                </#list>
            </div>
        </#list>
        </div>
        <h5>Do you want to deduct money from your account?</h5>
        <p>
        <label>
            <input name="isPaid" type="radio" value="true"/>
            <span>yes</span>
        </label>
        </p>
        <p>
        <label>
            <input name="isPaid" type="radio" value="false" checked/>
            <span>no</span>
        </label>
        </p>
        <button class="btn waves-effect waves-light" type="submit" name="action">Submit
            <i class="material-icons right">send</i>
        </button>
        <#if errorMessage?has_content>
            <div class="error">${errorMessage}</div>
        </#if>
        </form>
    </div>
</body>
</html>

<script>
var selectedPlace="none";
function imageClick(placeNumber, rowNumber) {
    M.toast({html: 'You have chosen ' + rowNumber + 'th row ' + placeNumber + 'th place'});

    if(selectedPlace != "none") {
        document.getElementById(selectedPlace).src="/images/green.png";
    }
    document.getElementById("green" + rowNumber + placeNumber).src="/images/red.png";
    selectedPlace = "green" + rowNumber + placeNumber;
    document.getElementById("rowId").value=rowNumber;
    document.getElementById("placeId").value=placeNumber;
}
</script>