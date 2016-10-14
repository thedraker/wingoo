<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        
        <!-- Title -->
        <title>Admin | Cadastro de Professores</title>
        
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta charset="UTF-8">
        <meta name="description" content="Admin Dashboard Template" />
        <meta name="keywords" content="admin,dashboard" />
        <meta name="author" content="Steelcoders" />
        
        <!-- Styles -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
        <link href="assets/plugins/pace-master/themes/blue/pace-theme-flash.css" rel="stylesheet"/>
        <link href="assets/plugins/uniform/css/uniform.default.min.css" rel="stylesheet"/>
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/fontawesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/line-icons/simple-line-icons.css" rel="stylesheet" type="text/css"/>	
        <link href="assets/plugins/offcanvasmenueffects/css/menu_cornerbox.css" rel="stylesheet" type="text/css"/>	
        <link href="assets/plugins/waves/waves.min.css" rel="stylesheet" type="text/css"/>	
        <link href="assets/plugins/switchery/switchery.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/3d-bold-navigation/css/style.css" rel="stylesheet" type="text/css"/>	
        <link href="assets/plugins/slidepushmenus/css/component.css" rel="stylesheet" type="text/css"/>
        
        <!-- Theme Styles -->
        <link href="assets/css/modern.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/themes/white.css" class="theme-color" rel="stylesheet" type="text/css"/>
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>
        
        <script src="assets/plugins/3d-bold-navigation/js/modernizr.js"></script>
        <script src="assets/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>
        <script src="assets/js/angular.min.js"></script>
        <script src="assets/js/angular-locale_pt-br.js"></script>
        <script src="assets/js/angular-route.min.js"></script>
        <script src="assets/js/app.js"></script>
        <script src="assets/js/cep-webservice.js"></script>
        <script src="assets/js/global.js"></script>
        <script src="assets/js/cpf.js"></script>
        <script src="assets/js/mask.js"></script>
        
        
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        
    </head>
    <body class="page-header-fixed" ng-app="wingoo">
        <div class="overlay"></div>
        <div class="menu-wrap">
            <nav class="profile-menu">
                <div class="profile"><img src="assets/images/avatar1.png" width="52" alt="David Green"/><span>Luiz Carlos</span></div>
                <div class="profile-menu-list">
                    <a href="#"><i class="fa fa-star"></i><span>Favorites</span></a>
                    <a href="#"><i class="fa fa-bell"></i><span>Alerts</span></a>
                    <a href="#"><i class="fa fa-envelope"></i><span>Messages</span></a>
                    <a href="#"><i class="fa fa-comment"></i><span>Comments</span></a>
                </div>
            </nav>
            <button class="close-button" id="close-button">Close Menu</button>
        </div>
        <form class="search-form" action="#" method="GET">
            <div class="input-group">
                <input type="text" name="search" class="form-control search-input" placeholder="Search...">
                <span class="input-group-btn">
                    <button class="btn btn-default close-search waves-effect waves-button waves-classic" type="button"><i class="fa fa-times"></i></button>
                </span>
            </div><!-- Input Group -->
        </form><!-- Search Form -->
        <main class="page-content content-wrap">
            <!-- NAVBAR-->
            <c:import url="../../navbar-adm.jsp"></c:import>
            <!-- SIDEBAR -->
            <c:import url="../../sidebar-adm.jsp"></c:import>
            
            <!-- HOME -->
            <div class="page-inner">
                <div id="main-wrapper">
                    <div class="panel panel-white">
                                <div class="panel-body">
                                	<h2 style="text-align:center; display:block;">Cadastro de Professor</h2>
                                    <form class="form-cad-exm" action="addProfessor" enctype="multipart/form-data" method="post">
                                        <div class="row">
									<div class="col-lg-12">
										<p>
											<input type="text" name="nome" class="form-control"
												placeholder="Nome*" />
										</p>
										<p>
											<input type="email" name="email" class="form-control"
												placeholder="Email*" />
										</p>
											<input type="text" name="cpf" class="form-control"
												placeholder="CPF*" onblur="javascript: validarCPF(this.value);" onkeypress="javascript: mascara(this, cpf_mask);"  maxlength="14"/>
										</p>
										<div class="row">
											<div class="col-md-4">
												<p>
													<input type="text" name="cep" class="form-control"
														placeholder="CEP*" maxlength="9"
														onblur="pesquisacep(this.value);" onkeyup="maskIt(this,event,'#####-###')" id="cep" value="" />
												</p>
											</div>
											<div class="col-md-8">
												<p>
													<input type="text" name="endereco" class="form-control"
														placeholder="Endereço*" type="text" id="rua" />
												</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<p>
													<input type="text" name="numero" class="form-control"
														placeholder="Número*" id="numero" />
												</p>
											</div>
											<div class="col-md-8">
												<p>
													<input type="text" name="complemento" class="form-control"
														placeholder="Complemento" />
												</p>
											</div>
										</div>

										<p>
											<input type="text" name="bairro" class="form-control"
												placeholder="Bairro*" id="bairro" />
										</p>

										<div class="row">
											<div class="col-md-8">
												<p>
													<input type="text" name="cidade" class="form-control"
														placeholder="Cidade*" id="cidade" />
												</p>
											</div>
											<div class="col-md-4">
												<p>
													<select class="form-control" name="estado" required id="uf">
														<option>UF*</option>
														<option>AC</option>
														<option>AL</option>
														<option>AP</option>
														<option>AM</option>
														<option>BA</option>
														<option>CE</option>
														<option>DF</option>
														<option>ES</option>
														<option>GO</option>
														<option>MA</option>
														<option>MT</option>
														<option>MS</option>
														<option>MG</option>
														<option>PR</option>
														<option>PB</option>
														<option>PA</option>
														<option>PE</option>
														<option>PI</option>
														<option>RJ</option>
														<option>RN</option>
														<option>RS</option>
														<option>RO</option>
														<option>RR</option>
														<option>SC</option>
														<option>SE</option>
														<option>SP</option>
														<option>TO</option>
													</select>
												</p>
											</div>
										</div>

										<p>
											<input type="text" name="telefone" class="form-control"
												placeholder="DDD + Telefone*" onkeyup="maskIt(this,event,'(##) ####-####')" maxlength="14"/>
										</p>
										<p>
											<input type="text" name="disciplina" class="form-control"
												placeholder="Disciplina*" />
										</p>
										<p>
											<input type="hidden" name="tipo" value="Professor">
										</p>
										<p>
											<input type="hidden" name="status" value="Vivo">
										</p>
										<p>
											<input type="text" name="login" class="form-control"
												placeholder="Login*" />
										</p>
										<p>
											<input type="text" name="senha" class="form-control"
												placeholder="Senha*" />
										</p>
										<p>
										<div class="input-group">
                							<label class="input-group-btn">
                    							<span class="btn btn-primary">
                       Procurar&hellip; <input type="file" id="input-1" name="arquivo" style="display: none;" multiple accept="image/*" onchange="readURL(this);">
												</span>
                							</label>
                						<input type="text" class="form-control" readonly>
            							</div>
										<p>
										<img id="blah" src="#" style="margin: 0 auto">
										</p>
										<p>
											<label class="label label-info">*Campos obrigatórios</label>
										</p>

										<button type="submit" class="btn btn-primary">Cadastrar</button>
									</div>
									
                                    </form>
                                </div>
                            </div>
                </div><!-- Main Wrapper -->
           
           <!-- FOOTER -->
         <c:import url="../../footer.jsp"></c:import>
                

            </div><!-- Page Inner -->
        </main><!-- Page Content -->
        
        <!-- MEGA MENU HIPER INSANO -->
         <c:import url="../../mega-menu.jsp"></c:import>
        
	

        <!-- Javascripts -->
        <script src="assets/plugins/jquery/jquery-2.1.3.min.js"></script>
        <script src="assets/plugins/jquery-ui/jquery-ui.min.js"></script>
        <script src="assets/plugins/pace-master/pace.min.js"></script>
        <script src="assets/plugins/jquery-blockui/jquery.blockui.js"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="assets/plugins/switchery/switchery.min.js"></script>
        <script src="assets/plugins/uniform/jquery.uniform.min.js"></script>
        <script src="assets/plugins/offcanvasmenueffects/js/classie.js"></script>
        <script src="assets/plugins/offcanvasmenueffects/js/main.js"></script>
        <script src="assets/plugins/waves/waves.min.js"></script>
        <script src="assets/plugins/3d-bold-navigation/js/main.js"></script>
        <script src="assets/js/modern.min.js"></script>
        
    </body>
</html>