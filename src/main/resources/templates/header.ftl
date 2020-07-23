<!-- Dropdown -->
<ul id="dropdown" class="dropdown-content">
    <li><a href="/logout">Logout</a></li>
</ul>

<nav>
    <div class="nav-wrapper">
        <a href="/cinemapark" class="brand-logo">Cinemapark</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="/cinemapark">Movies</a></li>
            <li><a href="/cinemapark/soon">Soon in the cinema</a></li>
            <li><a href="/movie-schedule/today">Schedule</a></li>
            <#if userInfo ??>
                <li><a class="dropdown-trigger" href="#!" data-target="dropdown">${userInfo}<i class="material-icons right">arrow_drop_down</i></a></li>
            <#else>
                <li><a href="/sign-up">Sign up</a></li>
            </#if>
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

