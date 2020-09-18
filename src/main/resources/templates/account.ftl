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
      <div class="col s12">
        <ul class="collection with-header" style="float:left; width:300px;">
          <li class="collection-header"><h4>Hello, ${userInfo.firstName}!</h4></li>
            <a href="/account/settings" <li class="collection-item" style="height:43px;">Settings</li></a>
            <a href="/account/balance" <li class="collection-item" style="height:43px;">My balance</li></a>
        </ul>
        <ul class="collection with-header">
          <li class="collection-header"><h4>Your History</h4></li>
          <li class="collection-item" style="height:86px;">
            <div class="row">
              <p>
                <div class="col s3">Purchased tickets: ${history.purchasedTickets}</div>
                <div class="col s3">Total spent money: ${history.totalSpend} $</div>
              </p>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <main>
      <section>
      <div class="watchedMovies" style="text-align:center;">
        <h5>Your watched movies</h5></div>
        <div class="container">
              <div class="row">
                <#if history.movies??>
                  <#list history.movies as movie>
                      <div class="col s3">
                          <a href="/movie/${movie.secondaryKey}">
                          <div class="card">
                              <div class="card-image" style="width: 100px;margin: auto;padding-top: 10px;">
                                  <img src="/resources/movieImage/${movie.id}">
                              </div>
                              <div class="card-content">
                                  <span class="card-title">${movie.name}</span>
                                  <p>${movie.genre}</p>
                              </div>
                          </div>
                          </a>
                      </div>
                  </#list>
                <#else> <p>No watched movies</p>
                </#if>
              </div>
              </div>
           </section>
 		</main>
</body>
</html>
