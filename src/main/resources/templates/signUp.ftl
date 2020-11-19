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
        <@form.form action="/sign-up" method="post" modelAttribute="user">
        <input type="hidden" name="amountMoney" value="0.00"/>
        <div class="row">
          <div class="input-field col s6 offset-s3">
            <h5>Create your account</h5>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6 offset-s3">
            <@form.label path="firstName">First Name:</@form.label>
            <@form.input path="firstName"/>
            <@form.errors class="errorRed" path="firstName"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6 offset-s3">
            <@form.label path="lastName">Last Name:</@form.label>
            <@form.input path="lastName"/>
            <@form.errors class="errorRed" path="lastName"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6 offset-s3">
            <@form.label path="email">Email:</@form.label>
            <@form.input path="email"/>
            <@form.errors class="errorRed" path="email"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6 offset-s3">
            <@form.label path="firstName">Password:</@form.label>
            <@form.password path="password"/>
            <@form.errors class="errorRed" path="password"/>
          </div>
        </div>
        <div class="row">
          <div class="col s6 offset-s3">
            <button class="btn waves-effect waves-light" type="submit" name="action">Sign Up
                <i class="material-icons right">send</i>
          </div>
        </div>
        </@form.form>
      </div>
</body>
</html>
