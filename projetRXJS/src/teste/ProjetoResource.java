package teste;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/projeto") 
public class ProjetoResource {
	Projeto projeto;
	List<Projeto> lp;
	
	@Path("{nome}/{desc}/{id}") 
	@POST
	@Consumes("text/xml") 
	@Produces("text/plain")
	public List insere (String nome, String desc,int id){
		this.projeto.setNome(nome);
		this.projeto.setDesc(desc);
		this.projeto.setId(id);

		if(this.lp == null )
		{
			this.lp = new ArrayList<Projeto>();
			lp.add(projeto);
		}else
		{
			lp.add(projeto);
		}

		return lp;

	}

	@Path("{id}") 
	@DELETE 
	@Produces("text/plain")
	public String remove (@PathParam("id") int id){
		
		String nomeProjeto = null;
		
		for(int i = 0 ; i < this.lp.size(); i++){
			if(this.lp.get(i).getId() == id ){
				nomeProjeto = this.lp.get(i).getNome();
				this.lp.remove(i);
			}
		}

		return nomeProjeto + lp.size();

	}
	
	@GET
	@Produces("text/xml")
	public List<Projeto> busca (){
		return lp;
	}
	
	@Path("{id}/{nome}") 
	@PUT 
	@Consumes("text/xml") 
	@Produces("text/plain")
	public String alterar(int id, String nome) {
		
		String nomeAntigo = null;
		this.projeto.setId(id);
		this.projeto.setNome(nome);
		
		for(int i = 0 ; i < lp.size(); i++)
		{
			if(lp.get(i).getId() == id )
			{
				nomeAntigo = lp.get(i).getNome();
				lp.get(i).setNome(nome);
			}
		}

		return "O nome do projeto " + nomeAntigo + " foi alterado para " + nome;
	}	
}
