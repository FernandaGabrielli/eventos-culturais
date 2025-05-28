package br.recife.recentro.eventos_culturais.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String local;
    private LocalDate data;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Evento() {}

    public Evento(String nome, String descricao, String local, LocalDate data, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.data = data;
        this.categoria = categoria;
    }
    

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
