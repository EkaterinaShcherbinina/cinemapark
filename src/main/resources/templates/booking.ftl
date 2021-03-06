<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
    <link rel="stylesheet" type="text/css" href="/css/placeCenter.css">
    <#include "header.ftl">
    <div class="container">
      <h5>Please choose a place</h5>
      <@form.form action="/booking" method="post" modelAttribute="reservation">
        <input type="hidden" name="sessionId" value="${sessionId}"/>
        <input type="hidden" id="rowId" name="rowId" value="0"/>
        <div>
          <@form.input type="hidden" path="place" value="0"/>
          <@form.errors class="errorRed" type="text" path="place"/>
        </div>
        <div id="hallId" name="hall">
        <#list rows as row>
          <#assign rowNumber = row?index + 1>
            <div class="flexbox">
              <div class="row" style="margin: auto; padding-top: 10px;">
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
            </div>
        </#list>
        </div>
        <@security.authorize access="isAuthenticated()">
        <h5>Do you want to deduct money from your account?</h5>
        <p>
          <label>
            <@form.radiobutton path="isPaid" value="true"/>
            <span>yes</span>
          </label>
        </p>
        <p>
          <label>
            <@form.radiobutton path="isPaid" value="false" checked="checked"/>
            <span>no</span>
          </label>
        </p>
        </@security.authorize>
        <@security.authorize access="! isAuthenticated()">
          <input type="hidden" id="isPaid" name="isPaid" value="false"/>
        </@security.authorize>
        <button class="btn waves-effect waves-light" type="submit" name="action">Submit
            <i class="material-icons right">send</i>
        </button>
        <#if errorMessage?has_content>
            <div class="error">${errorMessage}</div>
        </#if>
        </@form.form>
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
    document.getElementById("place").value=placeNumber;
}
</script>