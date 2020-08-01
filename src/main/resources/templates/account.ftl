<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
  <aside style="float:left; width:300px;">
      <ul class="collection with-header">
          <li class="collection-header"><h4>Hello, User!</h4></li>
          <a href="/account/settings" <li class="collection-item">Settings</li></a>
          <a href="#!" <li class="collection-item">Add money</li></a>
      </ul>
  </aside>
  <main>
      <section style="height:200px;">
          <h5>Your history</h5>
          <div class="row">
                <div class="col s12 m6 l3">Purchased tickets: ${history.purchasedTickets}</div>
                <div class="col s12 m6 l3">Total spent money: ${history.totalSpend} $</div>
          </div>
      </section>
      <section>
      <h1>Your watched movies</h1>
              <div class="row">
                <#if history.movies??>
                  <#list history.movies as movie>
                      <div class="col s12 m2">
                          <a href="/movie/${movie.secondaryKey}">
                          <div class="card">
                              <div class="card-image" width="50%" height="70%">
                                  <img src="/resources/getMovieImage/${movie.imageId}">
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
           </section>
 		</main>
</body>
</html>
