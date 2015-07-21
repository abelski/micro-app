<!DOCTYPE html>
<html lang="en" ng-app="mainApp">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="abelski@tut.by">

    <title>CITANDA</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="js/angular.min.js"></script>
    <script src="js/main-app.js"></script>

</head>

<body>

<div id="wrapper" ng-controller="MainController">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">CITANDA {{activeClient.authorities}}</a>
        </div>

        <app-menu/>
    </nav>


    <div id="page-wrapper">
        <div class="panel">


            <div class="row">
                <tender-find/>
            </div>

            <div class="row">
                <div class="panel-body">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#TenderModal"
                            ng-show="activeClient.authorities.indexOf('ROLE_CONSUMER')>-1"
                            ng-click="action='CREATE'; activeTender={}">
                        Create
                    </button>
                </div>
                <div class="row">
                    <offer-modal/>
                </div>
                <div class="row">
                    <tender-modal/>
                </div>

            </div>

            <div class="row">
                <div id="col-lg-12">

                    <div class="col-lg-4" ng-repeat="tender in tenders ">
                        <tender-card tender="tender"/>
                    </div>

                </div>
            </div>


            <!-- /#wrapper -->

            <!-- jQuery Version 1.11.0 -->
            <script src="js/jquery-1.11.0.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="js/bootstrap.min.js"></script>

            <!-- Metis Menu Plugin JavaScript -->
            <script src="js/plugins/metisMenu/metisMenu.min.js"></script>

            <!-- Custom Theme JavaScript -->
            <script src="js/sb-admin-2.js"></script>


        </div>
    </div>
</div>
</body>

</html>

