package br.com.abps.AvaliacaoAPIRest.model;

import java.util.Objects;

import jakarta.persistence.*;

	
	@Entity
	public class Contato {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private Integer tipoContato; // 0 para Telefone, 1 para Celular

	    @Column(nullable = false)
	    private String contato;

	    @ManyToOne
	    @JoinColumn(name = "pessoa_id", nullable = false)
	    private Pessoa pessoa;

	    public Contato() {}

		public Contato(Long id, Integer tipoContato, String contato, Pessoa pessoa) {
			super();
			this.id = id;
			this.tipoContato = tipoContato;
			this.contato = contato;
			this.pessoa = pessoa;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Integer getTipoContato() {
			return tipoContato;
		}

		public void setTipoContato(Integer tipoContato) {
			this.tipoContato = tipoContato;
		}

		public String getContato() {
			return contato;
		}

		public void setContato(String contato) {
			this.contato = contato;
		}

		public Pessoa getPessoa() {
			return pessoa;
		}

		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Contato other = (Contato) obj;
			return Objects.equals(id, other.id);
		}
	    
		 @Override
		    public String toString() {
		        return "[id = " 		+ this.id + ", " +
		               "tipoContato = " + this.tipoContato + ", " +
		               "contato = " 	+ this.contato + ", " +
		               "pessoa = " 		+ this.pessoa.getId() + "]";
		    }

}
