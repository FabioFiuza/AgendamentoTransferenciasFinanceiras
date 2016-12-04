var angular = angular.module('transferenciaFinanceira', []);

angular.controller('TransferenciaController', function ($scope, $http) {	
	
	$scope.transferencia = {dataAgendamento: ""};
	$scope.transferencias = [];
	
	$scope.agendarTransferencia = function(transferencia) {
		setCalendarioValor(transferencia);
				
		$http.post('/transferencia/agendar', transferencia).then(function(data) {
			carregarListaTransferencias();
			resetSelectTipoTransferencia();
			delete $scope.transferencia;
	    });		
	}
	
	var setCalendarioValor = function (transferencia) {
		$(function () {
			$scope.transferencia.dataAgendamento = $('#dataAgendamento').val();
		});
	}
	
	var carregarListaTransferencias = function () {
		$http.get('/transferencia/listar').then(function(response) {
			$scope.transferencias = response.data.transferencias; 
	    });
	}
	
	var carregarTiposDeTransferencia = function () {
		$scope.tiposTransferencia = [
			{label: 'A', valor: 'A'},
			{label: 'B', valor: 'B'},
			{label: 'C', valor: 'C'},
			{label: 'D', valor: 'D'}
		];
	}
	
	var resetSelectTipoTransferencia = function () {
		$(function () {
			$('#tipoTransferencia').val("");
			$('#tipoTransferencia').material_select();
		});
	}
	
	carregarTiposDeTransferencia();
	carregarListaTransferencias();
	
});