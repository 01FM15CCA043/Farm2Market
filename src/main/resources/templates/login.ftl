<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
    <!-- CUSTOM STYLE -->
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

    <link rel="stylesheet" href="css/style.css">
</head>

<style>
    html, html * {
        font-family: Roboto;
    }
</style>
<body>
<header>
    <nav>
        <div class="line">
            <div class="s-12 l-2">
                <p class="logo"><strong>FARM</strong><span style="color:green;font-family:bold;font-size:50px">2</span><strong>MARKET</strong></p>
            </div>
            <div class="top-nav s-12 l-10">
                <ul class="right">
                    <li class="active-item"><a href="home.html">HOME</a></li>
                    <li><a href="signin.html">LOG IN</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<br/><br/><br/><br/><br/><br/>
<div class="form">
    <ul class="tab-group">
        <li class="tab active" style="float:left;width:50%"><a href="#Farmersignin">Farmer</a></li>
        <li class="tab " style="float:left;width:50%"><a href="#Tradersignin" >Trader</a></li>

    </ul>
    <div class="tab-content">
        <div id="Farmersignin">
            <form action="/" method="post">
                <div class="field-wrap">
                    <input style="margin-top:50px;" class="logintextbox" id="#sub" type="tel" name="phone" placeholder="Phone Number..." maxlength="10"  pattern="[0-9]{10}" title="Enter your mobile number" required/>
                </div>
                <div class="field-wrap">
                    <input class="logintextbox" type="password" placeholder="Password" required/>
                </div>
                <input class="loginbtn" type="submit" value="Login">
            </form>
        </div>
        <div id="Tradersignin">
            <form action="" method="post">
                <div class="field-wrap">
                    <input style="margin-top:50px;" class="logintextbox" type="email" placeholder="Email" required/>
                </div>
                <div class="field-wrap">
                    <input class="logintextbox" type="password" placeholder="Password" required/>
                </div>
                <input class="loginbtn" type="submit" value="Login">
            </form>
        </div>
    </div><!-- tab-content -->
    <p class="forgot" style="text-align:center"><a href="signup.html">Create New Account</a></p>
</div> <!-- /form -->

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="js/index.js"></script>
</body>
</html>
