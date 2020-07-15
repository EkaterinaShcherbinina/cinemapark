<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
    <script type="text/javascript" src="/js/materialize.min.js"></script>
    <#include "header.ftl">
    <#if sessions?has_content>
    <ul>
    <table class="highlight">
        <#list sessions as session>
            <tbody>
                <tr>
                        <td>
                            <img src=${session.movie.imageUrl} width="125" height="200" class="card-img-top">
                            <p>${session.movie.name}</p>
                            <a href="/booking/session${session.id}">
                             <button class="btn waves-effect waves-light" type="submit" name="session">To book
                            </button>
                            </a>
                        </td>
                        <td>${session.time}</td>
                        <td>${session.cost}</td>
                        <td>${session.cinemaHall.hallName}</td>
                </tr>
                </tbody>
              </form>
        </#list>
         </table>
    </ul>
    <#else>
        <p>No sessions available at this time</p>
    </#if>
</body>
</html>