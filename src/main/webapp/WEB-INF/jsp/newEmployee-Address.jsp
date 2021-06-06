<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!--This tag is used for using spring mvc form tags-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang ="en">
    <head>
        
        <!--All required meta tags-->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <!--Title logo-->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/srynergylogo.png">

        <!--Title Name-->
        <title>Synergy Automation And Instrumentation : New Employee - Address</title>
        
        <!-- All styles -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        
        
        <!--Css Code for dashboard-->
        <style>
            
            body 
            {
                margin-top: 50px;
            }
            
            html, body, #wrapper, #page-wrapper {height: 100%; overflow: hidden;}
            #wrapper 
            {
                padding-left: 0;    
            }
            #page-wrapper 
            {
                width: 100%;        
                padding: 0;
                background-color: #fff;
            }
            @media(min-width:768px) 
            {
                #wrapper 
                
                {
                    padding-left: 225px;
                }
                #page-wrapper 
                {
                    padding: 22px 10px;
                }
            }
            
            /* Top Navigation */
            .top-nav 
            {
                padding: 0 15px;
            }
            .top-nav>li 
            {
                display: inline-block;
                float: left;
            }
            .top-nav>li>a 
            {
                padding-top: 20px;
                padding-bottom: 20px;
                line-height: 20px;
                color: #fff;
            }
            .top-nav>li>a:hover,
            .top-nav>li>a:focus,
            .top-nav>.open>a,
            .top-nav>.open>a:hover,
            .top-nav>.open>a:focus 
            {
                color: #fff;
                background-color: #1a242f;
            }
            .top-nav>.open>.dropdown-menu 
            {
                float: left;
                position: absolute;
                margin-top: 0;
                
                border: 1px solid rgba(0,0,0,.15);
                border-top-left-radius: 0;
                border-top-right-radius: 0;
                background-color: #fff;
                -webkit-box-shadow: 0 6px 12px rgba(0,0,0,.175);
                box-shadow: 0 6px 12px rgba(0,0,0,.175);
            }
            .top-nav>.open>.dropdown-menu>li>a 
            {
                white-space: normal;
            }
            
            /* Side Navigation */
            @media(min-width:768px) 
            {
                .side-nav {
                    position: fixed;
                    top: 60px;
                    left: 225px;
                    width: 225px;
                    margin-left: -225px;
                    border: none;
                    border-radius: 0;
                    border-top: 1px rgba(0,0,0,.5) solid;
                    overflow-y: auto;
                    background-color: #222;
                    
                    /*background-color: #5A6B7D;*/
                    bottom: 0;
                    overflow-x: hidden;
                    padding-bottom: 40px;
                }
                .side-nav>li>a 
                {
                    width: 225px;
                    border-bottom: 1px rgba(0,0,0,.3) solid;
                }
                .side-nav li a:hover,
                .side-nav li a:focus 
                {
                    outline: none;
                    background-color: #1a242f !important;
                }
            }
            .side-nav>li>ul 
            {
                padding: 0;
                border-bottom: 1px rgba(0,0,0,.3) solid;
            }
            .side-nav>li>ul>li>a 
            {
                display: block;
                padding: 10px 15px 10px 38px;
                text-decoration: none;
                
                /*color: #999;*/
                color: #fff;    
            }
            .side-nav>li>ul>li>a:hover 
            {
                color: #fff;
            }
            .navbar .nav > li > a > .label 
            {
              -webkit-border-radius: 50%;
              -moz-border-radius: 50%;
              border-radius: 50%;
              position: absolute;
              top: 14px;
              right: 6px;
              font-size: 10px;
              font-weight: normal;
              min-width: 15px;
              min-height: 15px;
              line-height: 1.0em;
              text-align: center;
              padding: 2px;
            }
            .navbar .nav > li > a:hover > .label 
            {
              top: 10px;
            }
            .navbar-brand 
            {
                padding: 5px 15px;
                width: 50px;
            }
            .navbar-brand>img
            {
                width: 50px;
            }
            
            /*for form*/
            
            #success_message{ display: none;}
            .well
            {
                padding: 7px;
            }
            
            
            
        </style>
        
        <!--JavaScript code for this dashboard page-->
        <script>
            
            $(function()
            {
                $('[data-toggle="tooltip"]').tooltip();
                $(".side-nav .collapse").on("hide.bs.collapse", function() 
                {                   
                    $(this).prev().find(".fa").eq(1).removeClass("fa-angle-right").addClass("fa-angle-down");
                });
                $('.side-nav .collapse').on("show.bs.collapse", function() 
                {                        
                    $(this).prev().find(".fa").eq(1).removeClass("fa-angle-down").addClass("fa-angle-right");        
                });
            });
            
            
              $(document).ready(function() {
            $('#contact_form').bootstrapValidator({
                // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    p-state: {
                        validators: {
                                stringLength: {
                                min: 2,
                            },
                                notEmpty: {
                                message: 'Please enter your State'
                            }
                        }
                    },
                    p-district: {
                        validators: {
                                stringLength: {
                                min: 2,
                            },
                                notEmpty: {
                                message: 'Please enter your District'
                            }
                        }
                    },
                    p-municipality: {
                        validators: {
                            notEmpty: {
                                message: 'Please enter your Municipality'
                            }
                        }
                    },
                    p-ward: {
                        validators: {
                            notEmpty: {
                                message: 'Please enter your Merital Ward'
                            }
                        }
                    },
                     p-tole: {
                        validators: {
                            notEmpty: {
                                message: 'Please enter your tole'
                            }
                        }
                    },
                    t-state: {
                        validators: {
                                stringLength: {
                                min: 2,
                            },
                                notEmpty: {
                                message: 'Please enter your State'
                            }
                        }
                    },
                    t-district: {
                        validators: {
                                stringLength: {
                                min: 2,
                            },
                                notEmpty: {
                                message: 'Please enter your District'
                            }
                        }
                    },
                    t-municipality: {
                        validators: {
                            notEmpty: {
                                message: 'Please enter your Municipality'
                            }
                        }
                    },
                    t-ward: {
                        validators: {
                            notEmpty: {
                                message: 'Please enter your Merital Ward'
                            }
                        }
                    },
                     t-tole: {
                        validators: {
                            notEmpty: {
                                message: 'Please enter your tole'
                            }
                        }
                    },
                     
                    
                        }
                    }
                })
        });
            
        </script>
        
    </head>
    <body>
        
        <div id="throbber" style="display:none; min-height: 120px;"></div>
        <div id="noty-holder"></div>
        <div id="wrapper">
            
            <!--Navigation-->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                
                 <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    
                    <!--Logo part-->
                    <a class="navbar-brand" href="dashboard">
                        <img src="${pageContext.request.contextPath}/resources/images/srynergylogo.png" alt="LOGO">
                    </a>
                </div>
                    
                    
                 
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">
                    <li>
                        <script>function display_ct6() {
                            var x = new Date()
                            var ampm = x.getHours( ) >= 12 ? ' PM' : ' AM';
                            hours = x.getHours( ) % 12;
                            hours = hours ? hours : 12;
                            var x1=x.getMonth() + 1+ "/" + x.getDate() + "/" + x.getFullYear(); 
                            x1 = x1 + " - " +  hours + ":" +  x.getMinutes() + ":" +  x.getSeconds() + ":" + ampm;
                            document.getElementById('ct6').innerHTML = x1;
                            display_c6();
                             }
                             function display_c6(){
                            var refresh=1000; // Refresh rate in milli seconds
                            mytime=setTimeout('display_ct6()',refresh)
                            }
                            display_c6()
                        </script>
                        <span id='ct6' style="background-color: #222222; color: #fff; margin-right: 412px; font-size: x-large"></span>
                    </li>
                    
                    <li><a href="#" data-placement="bottom" data-toggle="tooltip" data-original-title="Search"><i class="fa fas fa-search"></i>
                        </a></li>
                    <li><a href="#" data-placement="bottom" data-toggle="tooltip" data-original-title="Status"><i class="fa fa-bar-chart-o"></i>
                        </a>
                    </li>            
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.username}<b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="editprofile"><i class="fa fa-fw fa-user"></i> Edit Profile</a></li>
                            <li><a href="changepassword"><i class="fa fa-fw fa-cog"></i> Change Password</a></li>
                            <li class="divider"></li>
                            <li><a href="logout"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
                        
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                       <li>
                            <a href="users"><i class="fa fas fa-user"></i> Users</a>
                        </li>
                        <li>
                            <a href="employees"><i class="fa fas fa-users"></i> Employees</a>
                        </li>
                        <li>
                            <a href="personalInformation"><i class="fa fas fa-info-circle"></i> Personal Information</a>
                        </li>
                        <li>
                            <a href="jobInformation"><i class="fa fas fa-info"></i> Job Information</a>
                        </li>
                        <li>
                            <a href="payroll"><i class="fa fab fa-paypal"></i> Payroll</a>
                        </li>
                        <li>
                            <a href="leaves"><i class="fa fas fa-bed"></i> Leaves</a>
                        </li>
                        <li>
                            <a href="time"><i class="fa fas fa-history"></i> Time</a>
                        </li>
                        <li>
                            <a href="report"><i class="fa far fa-file"></i> Report</a>
                        </li>
                        
                    </ul>
                </div>
            </nav> 
               <!--Side dashboard which display other functions layout-->
            <div id="page-wrapper">
                <div class="container-fluid">
                    
                    <div class="row" id="main" >
                        <div class="col-sm-12 col-md-12 well" id="content">
                            <div class="row">
                                <h2><b> </b></h2>
                            </div>
                            
                    <div class="container">

                    <fieldset>

                    
                    
                    <form:form class="well form-horizontal" method="POST" modelAttribute="newAddress" action="newAddress"  id="contact_form">
                    <!-- Text input-->
                    
                    <!-- Form Name -->
                    <Form:legend><center><h2><b>Employee - Address Form</b></h2></center></Form:legend><br>
                    
                    
                    
                <div class="col-sm-12 col-md-6 well" id="content">
                        <h6>Permanent Address</h6>
                    <div class="form-group">
                      <label class="col-md-4 control-label">State</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="p-state" name="permaAddress.state" path="permaAddress.state" placeholder="State" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>
                        
                    <div class="form-group">
                      <label class="col-md-4 control-label">District</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="p-district" name="permaAddress.district" path="permaAddress.district" placeholder="District" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label class="col-md-4 control-label">Municipality</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="p-municipality" name="permaAddress.municipality" path="permaAddress.municipality" placeholder="Municipality" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>
                        
                    <div class="form-group">
                      <label class="col-md-4 control-label">Ward</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="p-ward" name="permaAddress.wardNo" placeholder="Ward" path="permaAddress.wardNo" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>
                        
                    <div class="form-group">
                      <label class="col-md-4 control-label">Tole</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="p-tole" name="permaAddress.tole" path="permaAddress.tole" placeholder="Tole" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label class="col-md-4 control-label">House Number</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="p-houseno" name="permaAddress.houseNo" path="permaAddress.houseNo" placeholder="House Number" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>
                     
                </div>
                    
                    
                    
                    <div class="col-sm-12 col-md-6 well" id="content">
                         <h6>Temporary Address</h6>
                    
                        <div class="form-group">
                      <label class="col-md-4 control-label">State</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="t-state" name="tempAddress.state" path="tempAddress.state" placeholder="State" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>
                        
                    <div class="form-group">
                      <label class="col-md-4 control-label">District</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="t-district" name="tempAddress.district" path="tempAddress.district" placeholder="District" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label class="col-md-4 control-label">Municipality</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="t-municipality" name="tempAddress.municipality" path="tempAddress.municipality" placeholder="Municipality" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>
                        
                    <div class="form-group">
                      <label class="col-md-4 control-label">Ward</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="t-ward" name="tempAddress.wardNo" path="tempAddress.wardNo" placeholder="Ward" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>
                        
                    <div class="form-group">
                      <label class="col-md-4 control-label">Tole</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="t-tole" name="tempAddress.tole" path="tempAddress.tole" placeholder="Tole" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label class="col-md-4 control-label">House Number</label>  
                      <div class="col-md-6 inputGroupContainer">
                      <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="t-houseno" name="tempAddress.houseNo" path="tempAddress.houseNo" placeholder="House Number" class="form-control"  type="text"/>
                        </div>
                      </div>
                    </div>

                    
                      
                    </fieldset>
                      
                    <div class="form-group">
                      <label class="col-md-4 control-label"></label>
                      <div class="col-md-4"><br>
                          <center><span>
                            <button class = "btn btn-success" type="submit" value="Next">NEXT</button>
                        </span></center>
                      </div>
                    </div>
                      
                        </form:form>
                        </div><!-- /.container -->
                           
                            
                            
                        </div>
                        
                        
                    </div>
                </div>
            </div>     
        </div>
          
    </body>
</html>

