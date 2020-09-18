<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
  <div style="width:50%; margin: auto; padding-top: 30px;">
        <ul class="collection with-header">
          <li class="collection-header">
          <div class="row">
              <div class="col s4"><h4>My Balance</h4></div>
              <div class="col s3 offset-s5">
              <a class="waves-effect waves-light btn" href="/account/money">Add money</a>
            </div>
            </div>
          </li>
          <li class="collection-item">
                <p><h5>Available balance:</h5></p>
                <p style="font-size: 20px">$ ${moneyAccount.amountMoney} USD</p>
              </p>
          </li>
        </ul>
        </div>
</body>
</html>
