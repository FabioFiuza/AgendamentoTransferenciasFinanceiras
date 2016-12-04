<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html ng-app="transferenciaFinanceira">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Transferencias financeiras</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
</head>
<body style="background: #eceff1" ng-controller="TransferenciaController">

	<div class="container">
		<div class="row">
			<div class="col 12 md7">
				<div class="card #fafafa grey lighten-5">
					<div class="card-content">
						<span class="card-title blue-text text-darken-2">Agendamento de Transferências Financeiras</span>

						<div class="row">
							<form class="col s12">
								<div class="row">
									<div class="input-field col s6">
										<input id="contaOrigem" type="text" class="validate" ng-model="transferencia.contaOrigem"> <label for="contaOrigem">Conta de origem</label>
									</div>
									<div class="input-field col s6">
										<input id="contaDestino" type="text" class="validate" ng-model="transferencia.contaDestino"> <label for="contaDestino">Conta de destino</label>
									</div>
								</div>
								<div class="row">
									<div class="input-field col s6">
										<input id="valorTransferencia" type="text" class="validate" ng-model="transferencia.valor"> <label for="valorTransferencia">Valor da transferência</label>
									</div>
									<div class="input-field col s6">
										<label for="dataAgendamento">Data do agendamento</label> <input type="text" class="datepicker" id="dataAgendamento" ng-model="transferencia.dataAgendamento">
									</div>
								</div>

								<div class="row">
									<div class="input-field col s6">
										<select id="tipoTransferencia" ng-model="transferencia.tipo" ng-options="tipo.valor as tipo.label for tipo in tiposTransferencia">
											<option value="" disabled selected>Selecione um tipo</option>
										</select> <label>Tipo de transferência</label>
									</div>
								</div>
							</form>
						</div>

					</div>
					<div class="card-action">
						<a href="#" ng-click="agendarTransferencia(transferencia)">Angedar</a>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col s12 md7">
				<div class="card #fafafa grey lighten-5">
					<div class="card-content">
						<span class="card-title blue-text text-darken-2">Agendamentos Cadastrados</span>

						<div class="row">
							<table>
								<thead>
									<tr>
										<th data-field="contaOrigem">Conta de origem</th>
										<th data-field="contaDestino">Conta Destino</th>
										<th data-field="valorTransferencia">Valor da transferência</th>
										<th data-field="taxa">Taxa</th>
										<th data-field="dataAgendamento">Data do agendamento</th>
										<th data-field="DataCadastro">Data do cadastro</th>
										<th data-field="tipoTransferencia">Tipo de transferência</th>
									</tr>
								</thead>

								<tbody>
									<tr ng-repeat="transferencia in transferencias">
										<td>{{transferencia.contaOrigem}}</td>
										<td>{{transferencia.contaDestino}}</td>
										<td>{{transferencia.valor | currency:'R$'}}</td>
										<td>{{transferencia.taxa | currency:'R$'}}</td>
										<td>{{transferencia.dataAgendamento}}</td>
										<td>{{transferencia.dataCadastro}}</td>
										<td>{{transferencia.tipo}}</td>
									</tr>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0-rc.2/angular.min.js"></script>
	<script type="text/javascript" src="<c:url value="/js/app.js"/>"></script>

	<script>
		$(document).ready(function() {
		    $('select').material_select();
		    $('.datepicker').pickadate({
		        selectMonths: true, // Creates a dropdown to control month
		        selectYears: 15, // Creates a dropdown of 15 years to control year
		        format: 'dd/mm/yyyy'
		      });
		  });
	</script>

</body>
</html>