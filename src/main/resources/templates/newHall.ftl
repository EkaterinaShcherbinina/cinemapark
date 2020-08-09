<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
  <div class="container">
    <@form.form action="/admin-hall/new" method="post" modelAttribute="hall">
      <input type="hidden" id="hallId" name="id" value="${hall.id}"/>
      <div class="row">
        <div class="col s6">
          Hall name:
          <div class="input-field inline">
            <@form.label path="hallName">Hall Name:</@form.label>
            <@form.input path="hallName" value=""/>
            <@form.errors path="hallName"/>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col s6">
          Rows amount:
          <div class="input-field inline">
            <@form.label path="rowsAmount">Rows amount:</@form.label>
            <@form.input path="rowsAmount" onblur="blurFunction()" id="rowsAmount" value=""/>
            <@form.errors path="rowsAmount"/>
          </div>
        </div>
      </div>
      <div id="content">
        <#assign size = hall.rowsAmount>
        <#list 0..<size as i>
          <#assign rowNumber = i + 1>
            <div class="row" id="item${rowNumber}">
              <div class="col s6">
                Places amount in the ${rowNumber} row:
                <div class="input-field inline">
                  <@form.label path="placesAmountInRow[${i}]">Places amount</@form.label>
                  <@form.input path="placesAmountInRow[${i}]" value=""/>
                  <@form.errors path="placesAmountInRow[${i}]"/>
                </div>
              </div>
            </div>
        </#list>
      </div>
      <button class="btn waves-effect waves-light" type="submit" name="action">Submit
          <i class="material-icons right">send</i>
      </button>
    </@form.form>
  </div>
</body>
</html>

<script type="text/javascript">
var sizeValue = Number(${size});
function blurFunction() {
    var inputAmount = Number(document.getElementById("rowsAmount").value);
    if(inputAmount < sizeValue) {
        var count = sizeValue - inputAmount;
        for(let i = 0; i < count; i++) {
            let value = Number(inputAmount) + i + 1;
            var elem = document.getElementById("item" + value);
            elem.parentNode.removeChild(elem);
        }
    } else if(inputAmount > sizeValue) {
        var count = inputAmount - sizeValue;
        for(let i = 0; i < count; i++) {

            var row = document.createElement('div');
            row.className = "row";
            document.getElementById("content").appendChild(row);

            var firstDiv = document.createElement('div');
            firstDiv.className = "col s6";
            let value = Number(sizeValue) + i + 1;
            firstDiv.setAttribute("id", "item" + value);
            firstDiv.innerHTML="Places amount in the " + value + " row:";
            row.appendChild(firstDiv);

            var secondDiv = document.createElement('div');
            secondDiv.className = "input-field inline";
            firstDiv.appendChild(secondDiv);

            var newInput = document.createElement("INPUT");
            newInput.setAttribute("type", "text");
            newInput.setAttribute("name", "placesAmountInRow");
            newInput.setAttribute("value", "");
            secondDiv.appendChild(newInput);

            var newlabel = document.createElement("LABEL");
            newlabel.setAttribute("for",newInput);
            newlabel.innerHTML = "Places amount";
            secondDiv.appendChild(newlabel);
        }
    }
    sizeValue = inputAmount;
}
</script>
