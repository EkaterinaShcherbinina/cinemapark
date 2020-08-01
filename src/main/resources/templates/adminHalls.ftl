<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinemapark</title>
    <#include "materializedConfig.ftl">
</head>
<body>
  <#include "header.ftl">
      <table>
             <thead>
               <tr>
                   <th>Id</th>
                   <th>Name</th>
                   <th>Rows amount</th>
               </tr>
             </thead>
             <tbody>
             <#list halls as hall>
               <tr>
                 <td>${hall.id}</td>
                 <td>${hall.hallName}</td>
                 <td>${hall.rowsAmount}</td>
                 <td><a href="/admin-hall/edit${hall.id}" <i class="material-icons">edit</i></a></td>
               </tr>
             </#list>
             </tbody>
           </table>
           <a class="waves-effect waves-light btn" href="/admin-hall/new"><i class="material-icons right">add</i>Add new</a>
</body>
</html>
