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

