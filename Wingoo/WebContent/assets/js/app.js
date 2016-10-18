var app = angular.module("wingoo", []);

/*CONTROLLER EXAMINADOR*/
angular.module("wingoo").controller('examinadorController', function($scope, $http){
	
	var vm = $scope;
	
	vm.app = "Wingoo";
	
	 $http.get("listExaminador")
	    .then(function(response) {
	        vm.examinadores = response.data;
	        console.log(vm.examinadores);
	    });
	 
	 vm.idmodal = null;
		vm.passa_id = function(id){
			vm.idmodal = id;
			console.log(vm.idmodal);
			console.log(id);
		};
});

/*CONTROLLER EXAMINADOR MORTO*/
angular.module("wingoo").controller('examinadorControllerMorto', function($scope, $http){
	
	var vm = $scope;
	
	vm.app = "Wingoo";
	
	 $http.get("listExaminadorMorto")
	    .then(function(response) {
	        vm.examinadoresmortos = response.data;
	        console.log(vm.examinadoresmortos);
	    });
	 
	 vm.idmodal = null;
		vm.passa_id = function(id){
			vm.idmodal = id;
			console.log(vm.idmodal);
			console.log(id);
		};
});

/*CONTROLLER PROFESSOR*/
angular.module("wingoo").controller('professorController', function($scope, $http){
	
	var vm = $scope;
	
	vm.app = "Wingoo";
	
	 $http.get("listProfessor")
	    .then(function(response) {
	        vm.professores = response.data;
	        console.log(response);
	        console.log(vm.professores);
	    });
	 
	 vm.idmodal = null;
		vm.passa_id = function(id){
			vm.idmodal = id;
			console.log(vm.idmodal);
			console.log(id);
		};
});

/*CONTROLLER PROFESSOR MORTO*/
angular.module("wingoo").controller('professorControllerMorto', function($scope, $http){
	
	var vm = $scope;
	
	vm.app = "Wingoo";
	
	 $http.get("listProfessorMorto")
	    .then(function(response) {
	        vm.professores = response.data;
	        console.log(vm.professores);
	    });
	 
	 vm.idmodal = null;
		vm.passa_id = function(id){
			vm.idmodal = id;
			console.log(vm.idmodal);
			console.log(id);
		};
});

/*CONTROLLER ATRIBUIR CRÉDITOS*/
angular.module("wingoo").controller('atribuirCreditoController', function($scope){
	
	var vm = $scope;
	
	vm.app = "Wingoo";
	
	vm.creditos = parseInt(0);
	
	vm.adicionar = function(creditosinput) {
		
		if (creditosinput == null){
			 setTimeout(function() {
			        toastr.options = {
			            closeButton: true,
			            progressBar: true,
			            showMethod: 'fadeIn',
			            hideMethod: 'fadeOut',
			            timeOut: 3000
			        };
			        toastr.warning('Insira um valor.');
			    }, 0);
		} else {
			vm.creditos += parseInt(creditosinput);
		}
	};
	
	vm.remover = function(creditosinput) {
		
		if (creditosinput == null){
		    setTimeout(function() {
		        toastr.options = {
		            closeButton: true,
		            progressBar: true,
		            showMethod: 'fadeIn',
		            hideMethod: 'fadeOut',
		            timeOut: 3000
		        };
		        toastr.warning('Insira um valor.');
		    }, 0);
		}else{

			vm.creditos -= parseInt(creditosinput);
		};
	};
	
	
	
	
});

