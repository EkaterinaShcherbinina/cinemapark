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
  <@form.form action="/account/add-money" method="post" modelAttribute="moneyAccount">
    <div class="container containerPadding">
      <div class="row">
        <div class="col s4 offset-s4">
          Enter amount:
          <div class="input-field inline">
            <@form.label path="amountMoney">amount</@form.label>
            <@form.input path="amountMoney"/>
            <@form.errors class="errorRed" class="errorRed" path="amountMoney"/>
          </div>
        </div>
        </div>
        <div class="row">
         <div class="col s4 offset-s4">
      <button class="btn waves-effect waves-light" type="submit" name="action">Submit
           <i class="material-icons right">send</i>
      </button>
      </div>
     </div>
     </div>
  </@form.form>
</body>
</html>
