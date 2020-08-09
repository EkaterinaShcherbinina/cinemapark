<div class="row">
        <#list movies as movie>
            <div class="col s3">
            <a href="/movie/${movie.secondaryKey}">
                <div class="movieCenter">
                    <img src="/resources/getMovieImage/${movie.id}" width="180" height="260">
                    <p class="title" style="color:#00695c">
                      <span style="color:#00695c;font-size: small">${movie.genre}<br></span>
                      ${movie.name}
                    </p>
                </div>
            </a>
            </div>
        </#list>
    </div>