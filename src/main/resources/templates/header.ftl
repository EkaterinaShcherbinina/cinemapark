<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<!-- Dropdown -->
<ul id="dropdown" class="dropdown-content">
    <li><a href="/account">Account</a></li>
    <li><a href="/logout">Logout</a></li>
</ul>

<nav>
    <div class="nav-wrapper">
        <a href="/cinemapark" class="brand-logo">Cinemapark</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="/cinemapark">Movies</a></li>
            <li><a href="/cinemapark/soon">Soon in the cinema</a></li>
            <li><a href="/movie-schedule">Schedule</a></li>
            <@security.authorize access="isAuthenticated()">
            <@security.authorize access="hasAuthority('ADMIN')">
                <li><a href="/admin">Admin</a></li>
            </@security.authorize>
            <@security.authentication var="userInfo" property="principal"/>
                <li><a class="dropdown-trigger" href="#!" data-target="dropdown">${userInfo.firstName}<i class="material-icons right">arrow_drop_down</i></a></li>
            </@security.authorize>
            <@security.authorize access="! isAuthenticated()">
                <li><a href="/login">Sign in</a></li>
            </@security.authorize>
        </ul>
    </div>
</nav>

<!--JavaScript at end of body for optimized loading-->
<script type="text/javascript">
    $(document).ready(function(){
        $('.modal').modal();
        $('.dropdown-trigger').dropdown();
    });
</script>

