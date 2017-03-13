<#--<html>-->
<#--<head>-->
    <#--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>-->

    <#--<script>-->
        <#--$(document).ready(function(){-->
            <#--$("#submit").click(function (e) {-->
                <#--debugger;-->
              <#--e.preventDefault()-->
                <#--var data1={-->
                    <#--type:$('#type').val(),-->
                    <#--imageUrl:$('#imageUrl').val(),-->
                    <#--date:$('#date').val(),-->
                    <#--name:$('#name').val(),-->
                    <#--phone_no:$('#phone').val(),-->
                    <#--password:$('#password').val(),-->
                    <#--cnfpassword:$('#cnfpassword').val(),-->
                    <#--address:$('#adress').val()-->
                <#--}-->

                <#--var url = 'http://localhost:8080/register/farmer';-->
                <#--debugger;-->
                <#--$.ajax({-->
                    <#--type:"POST",-->
                    <#--url: url,-->
                    <#--dataType: "json",-->
                    <#--data : JSON.stringify(data1),-->
                    <#--contentType: 'application/json; charset=utf-8',-->
                    <#--success: function(data) {-->
                        <#--alert("success"+data);-->
                    <#--}-->

                <#--});-->
            <#--});-->

        <#--});-->
    <#--</script>-->
<#--</head>-->
<#--<body>-->
    <#--<form >-->
    <#--<input type="text" id="name" placeholder="name"/><br>-->
    <#--<input type="password" id="password" placeholder="password"/><br>-->
    <#--<input type="password" id="cnfpassword" placeholder="cnfpassword"/><br>-->
    <#--<input type="number" id="phone" placeholder="phone"/><br>-->
    <#--<input type="text" id="adress" placeholder="adress"/><br>-->
    <#--<input type="text" id="type" placeholder="type"/><br>-->
    <#--<input type="text" id="imageUrl" placeholder="url"/><br>-->
    <#--<input type="text" id="date" placeholder="date"/><br>-->
    <#--<input type="submit" id="submit" value="submit"/><br>-->

    <#--</form>-->

<#--</body>-->
<#--</html>-->
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <!-- <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
   <link rel="stylesheet" href="css/home-responsee.css">
         <link rel="stylesheet" href="owl-carousel/owl.carousel.css">
        -->
    <!-- CUSTOM STYLE -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <link rel="stylesheet" href="style.css">
<script>
    $(document).ready(function(){
        var d = new Date();
        $("#submit").click(function (e) {
            debugger;
            e.preventDefault()
            var data1={
            type:"Farmer",
            imageUrl:"abc.com",
            date:d.getFullYear() + "-" + (d.getMonth()+1) + "-" + d.getDate(),
            name:$('#name').val(),
            phone_no:$('#phone').val(),
            password:$('#password').val(),
            cnfpassword:$('#cnfpassword').val(),
            address:$('#adress').val()
        }

        var url = 'http://localhost:8080/register/farmer';
        debugger;
        $.ajax({
            type:"POST",
            url: url,
            dataType: "json",
            data : JSON.stringify(data1),
            contentType: 'application/json; charset=utf-8',
            success: function(data) {
            alert("success"+data);
        }

        });
        });

    });
</script>
</head>
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
        <li class="tab active" style="float:left;width:50%"><a href="#Farmersignup">Farmer Sign In</a></li>
        <li class="tab " style="float:left;width:50%"><a href="#Tradersignup" >Trader Sign In</a></li>

    </ul>
    <div class="tab-content">
        <div id="Farmersignup">
            <form action="" method="post">
                <input style="margin-top:30px;" class="logintextbox" type="text" placeholder="name" title="Enter your Name" id="name" required/>
                <input class="logintextbox" type="tel" id="phone" placeholder="Phone Number" maxlength="10"  pattern="[0-9]{10}" title="Enter your mobile number" required/>
                <input class="logintextbox" id="password" type="password" placeholder="Password" title="Enter Password"  required/>
                <input class="logintextbox" id="cnfpassword" type="password" placeholder=" Confirm Password" title="Enter Password"  required/>
                <input class="logintextbox" id="adress" type="text" placeholder="Address" title="Enter your Address" required/>
                <input class="loginbtn" type="submit" value="SUBMIT" id="submit">
            </form>
        </div>
        <div id="Tradersignup">
            <form action="signin.html" method="post" id="Tradersignin">
                <input style="margin-top:20px;" class="logintextbox" type="text" placeholder="Name" title="Enter your Name" required/>
                <input class="logintextbox" type="email" placeholder="Email Id" title="Enter your Email ID"required/>
                <input class="logintextbox" id="#sub" type="tel" name="phone" placeholder="Phone Number" maxlength="10"  pattern="[0-9]{10}" title="Enter your mobile number" required/>
                <input class="logintextbox" type="password" placeholder="Password" title="Enter Password" required/>
                <input class="logintextbox" type="password" placeholder="Company" title="Enter Name of Company" required/>
                <input class="logintextbox" type="password" placeholder="Address" title="Enter your Address" required/>
                <input class="loginbtn" type="submit" value="SUBMIT">
            </form>
        </div>
    </div><!-- tab-content -->
</div> <!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/index.js"></script>
</body>
</html>
