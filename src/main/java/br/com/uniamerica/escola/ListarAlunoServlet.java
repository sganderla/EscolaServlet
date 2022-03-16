package br.com.uniamerica.escola;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarAlunoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {

		PrintWriter printWriter = httpServletResponse.getWriter();
		printWriter.println(corpoTable(AlunoDAO.alunos));

	}

	public String corpoTable(List<Aluno> alunos) {

		String html = "";

		html += "<div style='height: 100%; justify-content: center; display: flex;'>";
		html += "	<div style='width: 800px;'>";
		html += "		<h1 style='text-align: center; color: #009a84;'> Lista de Alunos </h1>";

		html += "		<a href='cadastrarAluno.html' " + "style='float: right; " + "background: #009a84; "
				+ "font-size: 24px; " + "color: white; " + "text-align: center; " + "padding: 5px 11px 5px 10px; "
				+ "text-decoration: auto; " + "border-radius: 100px 100px 100px 100px; " + "margin-top: -60px;'> "
				+ "Cadastrar Alunos" + "</a>";

		html += "		<hr>";
		html += "		<table border='1' style='width: 100%'>";
		html += "			<tr style='background: #009a84; color: white;'>";
		html += "				<th>ID</th>";
		html += "				<th>Nome</th>";
		html += "				<th>Turma</th>";
		html += "				<th>Opcao</th>";
		html += "			</tr>";

		html += elementosTabela(alunos);

		html += "		</table>";
		html += "	</div>";
		html += "</div>";

		return html;
	}

	public String elementosTabela(List<Aluno> alunos) {

		String html = "";

		for (int i = 0; i < alunos.size(); i++) {

			html += "<tr style='color: #009a84;'>";
			html += "	<th>" + i + "</th>";
			html += "	<th>" + alunos.get(i).getNome() + "</th>";
			html += "	<th>" + alunos.get(i).getTurma() + "</th>";
			html += "	<th style='width: 150px'>";

			html += "		<form action='editarAluno' method='post' style='width: 50%; float: left; margin-top: 14px;'>";
			html += "			<input type='hidden' name='index' value='" + i + "'>";
			html += "			<input type='submit' value='Editar' style='background: #9a8400; color: white;'>";
			html += "		</form>";

			html += "		<form action='excluirAluno' method='post' style='width: 50%; float: right; margin-top: 14px;'>";
			html += "			<input type='hidden' name='index' value='" + i + "'>";
			html += "			<input type='submit' value='Excluir' style='background: #9a0016; color: white;'>";
			html += "		</form>";

			html += "	</th>";
			html += "</tr>";
		}

		return html;
	}

}
