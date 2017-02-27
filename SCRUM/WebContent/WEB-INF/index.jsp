<%@page import="metier.Editeur"%>
<%@page import="metier.Categorie"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Accueil</title>
        <link type="text/css" rel="stylesheet"
              href="<c:url value="/include/style.css"/>" />
        <link type="text/css" rel="stylesheet"
              href="<c:url value="/css/bootstrap.min.css"/>" />
        <link type="text/css" rel="stylesheet"
              href="<c:url value="/css/shop-homepage.css"/>" />
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">

                    <a class="navbar-brand" href="#">Accueil</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse"
                     id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="#">A Propos</a></li>
                        <li><a href="#">Services</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <div class="col-md-3">
                    <p class="lead">6t’aimeJouer</p>

                    <div class="list-group">
                        <c:forEach items="${categories}" var="categories">
                            <a href="#" class="list-group-item">
                                <c:out value="${categories.getNom()} " />
                            </a>
                        </c:forEach>
                    </div>

                    <div class="list-group">
                        <c:forEach items="${editeurs}" var="editeurs">
                            <a href="#" class="list-group-item">
                                <c:out value="${editeurs.getNom()} " />
                            </a>
                        </c:forEach>
                    </div>
                </div>


                <div class="col-md-9">

                    <form id="recherche" method="get"
                          action="<c:url value="/recherche"/>">

                        <div class="top-row inner-addon right-addon">
                            <div class="field-wrap"
                                 style="margin-left: 30%; margin-bottom: 20px;">
                                <label> Rechercher</label> <i class="glyphicon glyphicon-search"></i>
                                <input name="recherche" type="text" required autocomplete="on">

                            </div>
                            <button class="btn" type="submit">Rechercher</button>
                        </div>


                    </form>

                    <div class="row">
                        <c:forEach items="${listeResultats}" var="listeResultats">
                            <div class="col-sm-6 col-lg-6 col-md-6">
                                <div class="thumbnail">
                                    <div class="embed-responsive embed-responsive-4by3">
                                        <iframe class="embed-responsive-item" src="<c:out value="${listeResultats.getVideo()} " />"></iframe>
                                    </div>
                                    <div class="caption">
                                        <h4 class="pull-right">${listeResultats.getPrix()}€</h4>
                                        <h4>
                                            <a href="#"><c:out value="${listeResultats.getNom()} " /></a>
                                        </h4>
                                        <p>${listeResultats.getDescription()}</p>
                                    </div>
                                    <div class="ratings">
                                        <p class="pull-right">15 reviews</p>
                                        <p>
                                            <span class="glyphicon glyphicon-star"></span> <span
                                                class="glyphicon glyphicon-star"></span> <span
                                                class="glyphicon glyphicon-star"></span> <span
                                                class="glyphicon glyphicon-star"></span> <span
                                                class="glyphicon glyphicon-star"></span>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>

                </div>

            </div>

        </div>

        <!-- /.container -->

        <div class="container">

            <hr>

            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Your Website 2014</p>
                    </div>
                </div>
            </footer>

        </div>
    <!-- /form -->

    <script
    src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="<c:url value="/include/index.js"/>"></script>

    <script src="<c:url value="/js/jquery.js"/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">

				<a class="navbar-brand" href="#">Accueil</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">A Propos</a></li>
					<li><a href="#">Services</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-md-3">
				<p class="lead">6t’aimeJouer</p>
				<div class="list-group">
					<a href="#" class="list-group-item">RPG</a> <a href="#"
						class="list-group-item">Action</a> <a href="#"
						class="list-group-item">Aventure</a> <a href="#"
						class="list-group-item">FPS</a> <a href="#"
						class="list-group-item">Indépendant</a>
				</div>

				<div class="list-group">
					<a href="#" class="list-group-item">Windows</a> <a href="#"
						class="list-group-item">Mac</a> <a href="#"
						class="list-group-item">Linux</a>
				</div>
			</div>


			<div class="col-md-9">

				<form id="recherche" method="get"
					action="<c:url value="/recherche"/>">

					<div class="top-row inner-addon right-addon">
						<div class="field-wrap"
							style="margin-left: 30%; margin-bottom: 20px;">
							<label> Rechercher</label> <i class="glyphicon glyphicon-search"></i>
							<input name="recherche" type="text" required autocomplete="on">

						</div>
						<button class="btn" type="submit">Rechercher</button>
					</div>


				</form>

				<div class="row">
					<c:forEach items="${listeResultats}" var="listeResultats">
						<div class="col-sm-6 col-lg-6 col-md-6">
							<div class="thumbnail">
								<div class="embed-responsive embed-responsive-4by3">
									<iframe class="embed-responsive-item" src="<c:out value="${listeResultats.getVideo()} " />"></iframe>
								</div>
								<div class="caption">
									<h4 class="pull-right">${listeResultats.getPrix()}€</h4>
									<h4>
									
										<a href="<c:url value="/fiche?recherche=${listeResultats.getId_jeu()}"/>"><c:out value="${listeResultats.getNom()} " /></a>
									</h4>
									<p>${listeResultats.getDescription()}</p>
								</div>
								<div class="ratings">
									<p class="pull-right">15 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
					
					</div>

				</div>

			</div>

		</div>

	<!-- /.container -->

	<div class="container">

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /form -->

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="<c:url value="/include/index.js"/>"></script>

	<script src="<c:url value="/js/jquery.js"/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
>>>>>>> fiche jeu

</body>

</html>
