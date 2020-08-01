<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
<div class="row">
    <form class="col s12" action="/admin-hall/edit" id="hallDTO" name="hallDTO" method="POST">
      <div class="row" id="content">
              <div class="col s12">
                Hall name:
                 <div class="input-field inline">
                 <input value="" id="hallName" name="hallName" type="text" class="validate">
                  <label for="hallName">Name</label>
                   </div>
              </div>
              <div class="col s12">
                 Rows amount:
                 <div class="input-field inline">
                  <input value="" onblur="blurFunction()" id="rowsAmount" name="rowsAmount" type="text" class="validate">
                  <label for="rowsAmount">Rows amount</label>
                  </div>
                </div>
                <#assign size = hall.rowsAmount>
                <#list 0..<size as i>
                    <#assign rowNumber = i + 1>
                     <#if i < hall.placesAmountInRow?size>
                        <#assign placesAmount = hall.placesAmountInRow[i]>
                     <#else> <#assign placesAmount = "">
                     </#if>
                     <div class="col s12" id="item${rowNumber}">
                      Places amount in the ${rowNumber} row:
                      <div class="input-field inline">
                      <input value="${placesAmount}" id="placesAmountInRow" name="placesAmountInRow" type="text" class="validate">
                      <label for="placesAmountInRow">Places amount</label>
                     </div>
                    </div>
                   </#list>
           </div>
            <button class="btn waves-effect waves-light" type="submit" name="action">Submit
               <i class="material-icons right">send</i>
             </button>
      </form>
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
            var firstDiv = document.createElement('div');
            firstDiv.className = "col s12";
            let value = Number(sizeValue) + i + 1;
            firstDiv.setAttribute("id", "item" + value);
            firstDiv.innerHTML="Places amount in the " + value + " row:";
            document.getElementById("content").appendChild(firstDiv);

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
