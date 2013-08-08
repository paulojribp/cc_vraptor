$(document).ready(function () {
	Fabricante.hideNewFabricanteForm();
	Fabricante.listAll();
	
	$('#btn-salvar').click(function() {
		Fabricante.create();
	});
	
	$('#btn-cancel').click(function() {
		Fabricante.clearForm();
		Fabricante.hideNewFabricanteForm();
	});
	
	$('#btn-open-new-form').click(function() {
		Fabricante.openNewFabricanteForm();
	});
});


var Fabricante = {};

Fabricante.clearForm = function() {
	$('#codigo').removeAttr("disabled");
	$('#codigo').val('');
	$('#nome').val('');
	$('#razao').val('');
	
	$('#btn-salvar').click(function() {
		Fabricante.create();
	});
};

Fabricante.openNewFabricanteForm = function() {
	$('#form-cadastro').show();
	$('#codigo').focus();
	$('#div-btn-form').hide();
};
Fabricante.hideNewFabricanteForm = function() {
	$('#form-cadastro').hide();
	$('#div-btn-form').show();
};

Fabricante.create = function() {
	var fabricante = {
		"fabricante.codigo": $('#codigo').val(),
		"fabricante.nome": $('#nome').val(),
		"fabricante.razaoSocial": $('#razao').val()
	};
	
	$.ajax({
		url: '../fabricante/create',
		method: 'POST',
		data: fabricante, 
		success: function(data) {
			Fabricante.hideNewFabricanteForm();
			Fabricante.clearForm();
			Fabricante.listAll();
		},
		error: function(err) {
			console.log("Error");
			console.log(err);
		}
	});
	
};

Fabricante.removeLine = function(line) {
	var tr = $('tr[line='+line+']');
	var tds = tr.children();
	
	var codigo = {'codigo': + $(tds[0]).text()};
	
	$.ajax({
		url: '../fabricante/remove',
		method: 'POST',
		data: codigo,
		success: function(data) {
			console.log('Removido');
			Fabricante.listAll();
		},
		error: function(err) {
			console.log(err);
		}
	});
};

Fabricante.editLine = function(line) {
	var tr = $('tr[line='+line+']');
	var tds = tr.children();
	
	$('#codigo').val( $(tds[0]).text() );
	$('#nome').val( $(tds[1]).text() );
	$('#razao').val( $(tds[2]).text() );
	
	$('#codigo').attr("disabled", "disabled");
	Fabricante.openNewFabricanteForm();
	$('#nome').focus();
	
	$('#btn-salvar').click(function() {
		Fabricante.update();
	});
};

Fabricante.update = function() {
	var fabricante = {
		"fabricante.codigo": $('#codigo').val(),
		"fabricante.nome": $('#nome').val(),
		"fabricante.razaoSocial": $('#razao').val()
	};
	
	$.ajax({
		url: '../fabricante/update',
		method: 'POST',
		data: fabricante,
		success: function(data) {
			console.log('Editado');
			Fabricante.clearForm();
			Fabricante.hideNewFabricanteForm();
			Fabricante.listAll();
		},
		error: function(err) {
			console.log(err);
		}
	});
};

Fabricante.listAll = function() {
	$("#fabricantes-list tr[line]").remove();
	
	$.ajax({
		url: '../fabricante/list',
		method: 'GET',
		success: function(data) {
			var lista = data.list;
			var fabricantes = $("#fabricantes-list tr:last");
			
			for (var x = 0, size = lista.length; x < size; x++) {
				var tr = "<tr line='"+x+"'>";
				var td1 = "<td class='text-right' style='padding-right: 10px;'>" + lista[x].codigo + "</td>";
				var td2 = "<td>" + lista[x].nome + "</td>";
				var td3 = "<td>" + lista[x].razaoSocial + "</td>";
				var td4 = "<td class='text-center'> <span onclick='Fabricante.editLine("+ x +");' class='icon-edit' style='cursor: pointer;'></span> </td>";
				var td5 = "<td class='text-center'> <span onclick='Fabricante.removeLine("+ x +");' class='icon-trash' style='cursor: pointer;'></span> </td>";
				tr += td1 + td2 + td3 + td4 + td5 + "</tr>";
				
				fabricantes.after(tr);
			}
		},
		error: function(err) {
			console.log(err);
		}
	});
};
