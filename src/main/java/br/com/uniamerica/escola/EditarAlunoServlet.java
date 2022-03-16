package br.com.uniamerica.escola;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditarAlunoServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	
	public void doPost(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse
	) throws IOException {
		
		int index = Integer.valueOf(httpServletRequest.getParameter("index"));
		
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.findByIndex(index);
		
		
		PrintWriter printWriter = httpServletResponse.getWriter();
		printWriter.println(formularioEdicao(aluno, index));
		
	}
	
	public String formularioEdicao(Aluno aluno, int index) {
		
		String html = "";
		
	    html += "    <div style='justify-content: center; display: flex;'>";
		
		html += "		<form action='salvarAluno' method='post'";
		html += "				style='width: 300px;";
		html += "					border: 1px solid #009a84;";
		html += "					padding: 15px;";
		html += "					border-radius: 10px 10px 10px 10px;'>";
		
		html += "			<h1 style='text-align: center; color: #009a84;'>Editar Aluno</h1>";
		
		html += "			<hr> <br />";
		
		html += "			<input type='hidden' name='index' value='"+ index +"' >" ;
				
		html += "			<label style='color: #009a84'>Nome: </label><br />";
		html += "			<input type='text' name='nome' value='" + aluno.getNome() + "' style='width: 100%'>";
		
		html += "			<br /><br />";
		
		html += "			<label style='color: #009a84'>Turma: </label> <br />";
		html += "			<input type='text' name='turma' value='" + aluno.getTurma() + "' style='width: 100%'>";
		
		html += "			<br /><br /><br />";
		
		
		html += "			<div style='width: 100%;'>";
		html += "				<div style='width: 50%; float: left;'>";
		
		html += "					<a href='listarAluno.html' style='";
		html += "							background: #009a84;";
		html += "						    font-size: 16px;";
		html += "						    color: white;";
		html += "						    width: 100%;";
		html += "						    text-align: center;";
		html += "						    padding: 10px 10px 10px 10px;";
		html += "						    text-decoration: auto;";
		html += "						    border-radius: 10px 10px 10px 10px;'>";
		html += "						Listar Alunos";
		html += "					</a>";
		
		html += "				</div>";
		html += "				<div style='width: 50%; float: right;'>";
		html += "					<input type='submit' value='Editar'";
		html += "						style='";
		html += "							    background: #009a84;";
		html += "							    font-size: 16px;";
		html += "							    color: white;";
		html += "							    width: 100%;";
		html += "							    text-align: center;";
		html += "							    padding: 8px 10px 8px 10px;";
		html += "							    text-decoration: auto;";
		html += "							    border-radius: 10px 10px 10px 10px;";
		html += "							    margin-top: -10px;'>";
		html += "				</div>";	
		html += "			</div>";
		
		html += "		</form>";
		html += "	</div>";
		
		return html;
	}

}
