<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/jsp/cabecalho.jsp"%>

<script src="../js/fabricante.js"></script>

<div class="container" id="container">
	<div class="container-fluid main">
		<div class="row-fluid">

			<div class="span12">
				<div class="well" id="form-cadastro">
					<form>
						<fieldset>
							<legend>Manter Fabricante</legend>
							
							<div class="row">
								<label class="span2">Código</label>
								<label class="span3">Nome</label>
								<label class="span3">Razão Social</label>
							</div>
							<div class="row">
								<span class="span2">
									<input type="text" id="codigo" class="input-mini" maxlength="10" />
								</span>
								<span class="span3">
									<input type="text" id="nome" class="input-medium" />
								</span>
								<span class="span3">
									<input type="text" id="razao" class="input-medium" />
								</span>
								<span class="span3">
									<button type="button" id="btn-cancel" class="btn">Cancelar</button>
									<button type="button" id="btn-salvar" class="btn btn-primary">Salvar</button>
								</span>
							</div>
						</fieldset>
					</form>
				</div>

				<div class="well" id="div-btn-form">
					<button type="button" id="btn-open-new-form" class="btn btn-primary">Novo +</button>
				</div>
				
				<div class="well">
					<h3>Fabricantes Cadastrados</h3>
					<table id="fabricantes-list" class="table-list">
						<thead>
							<tr>
								<th>Código</th>
								<th>Nome</th>
								<th>Razão Social</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						
					</table>
				</div>
			</div>
		</div>
	</div>
	<hr>

	<footer>
		<p>&copy; Crud Comentado VRaptor3 - by Paulo Alves Júnior 2013</p>
	</footer>
</div>

<script src="../js/vendor/bootstrap.min.js"></script>

</body>
</html>